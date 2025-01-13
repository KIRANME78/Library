package org.example;

public class Magazine extends LibraryItem implements IBorrowable, IReservable {
    public Magazine(String title, String author, String ISBN, int publicationYear) {
        super(title, author, ISBN, publicationYear);
    }


    @Override
    public void displayInfo() {
        System.out.println("Magazine Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("ISBN: " + getISBN());
        System.out.println("Publication Year: " + getPublicationYear());
    }

    @Override
    public void borrowItem() {
        System.out.println("Magazine borrowed: " + getTitle());
    }

    @Override
    public void returnItem() {
        System.out.println("Magazine returned: " + getTitle());
    }

    @Override
    public void reserveItem() {
        System.out.println("Magazine reserved: " + getTitle());
    }

    @Override
    public void cancelReservation() {
        System.out.println("Magazine reservation canceled: " + getTitle());
    }
}
