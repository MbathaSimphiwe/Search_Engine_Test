
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private Library library;
    private UserInteractionLogger logger = new UserInteractionLogger();
    private LibrarySerializer serializer = new LibrarySerializer();  // Added serializer

    public LibraryMenu(Library library) {
        this.library = library;

        // Load the library data when the program starts
        List<Book> books = serializer.loadLibrary("src/resources/data/library.ser");
        if (books != null) {
            library.setBooks(books);
            System.out.println("Library loaded successfully.");
        } else {
            System.out.println("No saved library found. Loading default books.");
            library.loadBooks("src/resources/data/books.txt");
        }
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Library Menu:");
            System.out.println("1. View All Books");
            System.out.println("2. Search Book by Keyword");
            System.out.println("3. Sort Books");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    library.viewAllBooks();
                    logger.logViewAllBooks();
                    break;
                case 2:
                    System.out.print("Enter search keyword: ");
                    String keyword = scanner.nextLine();
                    Book foundBook = library.searchBookByKeyword(keyword);
                    if (foundBook != null) {
                        System.out.println("Found Book: " + foundBook);
                    } else {
                        System.out.println("No books found with the given keyword.");
                    }
                    logger.logSearch(keyword);
                    break;
                case 3:
                    System.out.println("Choose sorting criteria: ");
                    System.out.println("1. Sort by Title");
                    System.out.println("2. Sort by Author");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Comparator<Book> comparator = null;
                    if (sortChoice == 1) {
                        comparator = Comparator.comparing(Book::getTitle);
                    } else if (sortChoice == 2) {
                        comparator = Comparator.comparing(Book::getAuthor);
                    }
                    if (comparator != null) {
                        SortUtil.quickSort(library.getBooks(), comparator, 0, library.getBooks().size() - 1);
                        System.out.println("Books sorted.");
                        logger.logSort(sortChoice == 1 ? "Title" : "Author");
                    }
                    break;
                case 4:
                    serializer.saveLibrary(library.getBooks(), "src/resources/data/library.ser");
                    System.out.println("Library data saved.");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

}
