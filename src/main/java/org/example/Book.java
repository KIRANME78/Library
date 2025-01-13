package org.example;

public class Book extends LibraryItem implements IBorrowable, IReservable
{
    public Book(String title, String author, String ISBN, int publicationYear) {
        super(title, author, ISBN, publicationYear);
    }


    @Override
    public void displayInfo() {
        System.out.println("Book Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("ISBN: " + getISBN());
        System.out.println("Publication Year: " + getPublicationYear());
    }

    @Override
    public void borrowItem() {
        System.out.println("Book borrowed: " + getTitle());
    }

    @Override
    public void returnItem() {
        System.out.println("Book returned: " + getTitle());
    }

    @Override
    public void reserveItem() {
        System.out.println("Book reserved: " + getTitle());
    }

    @Override
    public void cancelReservation() {
        System.out.println("Book reservation canceled: " + getTitle());
    }
}
