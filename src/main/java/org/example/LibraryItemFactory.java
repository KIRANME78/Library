package org.example;

public class LibraryItemFactory {

    public static LibraryItem createLibraryItem(String type, String title, String author, String ISBN, int publicationYear) {
        if (type.equalsIgnoreCase("Book")) {
            return new Book(title, author, ISBN, publicationYear);
        } else if (type.equalsIgnoreCase("Magazine")) {
            return new Magazine(title, author, ISBN, publicationYear);
        }
        return null;
    }
}
