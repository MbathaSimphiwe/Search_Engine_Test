# Library Management System

## Overview

The **Library Management System** is a Java-based application that allows users to manage a collection of books, search for books using keywords, and sort book records. It also logs user interactions for future analysis.

## Features

## 1. View All Books

- Displays a list of all available books in the library.

## 2. Search Book by Keyword

- Allows users to search for books by entering a keyword.

- The search term is logged in user_interactions.log using UserInteractionLogger.java.

## 3. Sort Books

- Books can be sorted alphabetically or by another criterion (e.g., author, year).

- Sorting functionality is handled by SortUtil.java.

## 4. Save and Load Library Data

- Library data is serialized and stored in library.ser.

- Ensures persistence between sessions.

## 5. Exit the System

- Saves the library state before exiting the application.


# How to Run

1. Open the project in IntelliJ IDEA (or any Java IDE).

2. Ensure you have Java 8+ installed.

3. Run the Main class.

4. Use the menu to interact with the system.

# Technologies Used

- Java (Core programming language)

- Serialization (for saving and loading data)

- File Handling (for logging user interactions)

# Future Improvements

- Implement a GUI using JavaFX or Swing.
- Store book data in a database instead of text files.
- Implement user authentication for library staff.
