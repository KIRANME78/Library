package org.example;

public abstract class LibraryItem {
    private String title;
    private String author;
    private String ISBN;
    private int publicationYear;

    public LibraryItem(String title, String author, String ISBN, int publicationYear) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getPublicationYear() {
        return publicationYear;
    }



    public abstract void displayInfo();
}
