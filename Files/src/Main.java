
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Create the library menu that will manage user interactions
        LibraryMenu libraryMenu = new LibraryMenu(library);

        // Display the menu and handle user input
        libraryMenu.displayMenu();
    }
}
