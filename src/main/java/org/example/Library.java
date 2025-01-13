package org.example;



public class Library {
    public static void main(String[] args)
    {
        LibraryItem book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 1925);
        LibraryItem magazine = new Magazine("National Geographic", "Various Authors", "9781426217786", 2021);

        book.displayInfo();
        magazine.displayInfo();

        if (book instanceof IBorrowable) {
            ((IBorrowable) book).borrowItem();
            ((IBorrowable) book).returnItem();
        }

        if (book instanceof IReservable) {
            ((IReservable) book).reserveItem();
            ((IReservable) book).cancelReservation();
        }

        if (magazine instanceof IBorrowable) {
            ((IBorrowable) magazine).borrowItem();
            ((IBorrowable) magazine).returnItem();
        }

        if (magazine instanceof IReservable) {
            ((IReservable) magazine).reserveItem();
            ((IReservable) magazine).cancelReservation();
        }
    }
}
