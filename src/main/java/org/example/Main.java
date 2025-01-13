package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize the library inventory and patron management
        LibraryInventory libraryInventory = LibraryInventory.getInstance();
        PatronManagement patronManagement = PatronManagement.getInstance();

        // Create branches
        Branch branch1 = new Branch("1", "Central Library");
        Branch branch2 = new Branch("2", "East Branch");
        libraryInventory.addBranch(branch1);
        libraryInventory.addBranch(branch2);

        // Create books and magazines using the factory
        LibraryItem book1 = LibraryItemFactory.createLibraryItem("Book", "The Great Gatsby", "F. Scott Fitzgerald", "1234567890", 1925);
        LibraryItem book2 = LibraryItemFactory.createLibraryItem("Book", "To Kill a Mockingbird", "Harper Lee", "2345678901", 1960);
        LibraryItem book3 = LibraryItemFactory.createLibraryItem("Book", "1984", "George Orwell", "3456789012", 1949);
        LibraryItem magazine1 = LibraryItemFactory.createLibraryItem("Magazine", "National Geographic", "Various Authors", "9781426217786", 2021);

        // Add books and magazines to branches
        libraryInventory.addLibraryItem("1", book1);
        libraryInventory.addLibraryItem("1", book2);
        libraryInventory.addLibraryItem("2", book3);


        // Create patrons
        Patron patron1 = new Patron("Alice", "P001");
        Patron patron2 = new Patron("Bob", "P002");
        patronManagement.addPatron(patron1);
        patronManagement.addPatron(patron2);

        // Initialize the lending system
        LendingSystem lendingSystem = new LendingSystem(libraryInventory, patronManagement);

        // Checkout and return books
        lendingSystem.checkoutBook("1234567890", "P001", "1");
        lendingSystem.returnBook("1234567890", "P001", "1");

        // Transfer book between branches
        libraryInventory.transferBook("3456789012", "2", "1");

        // Add reservation
        Reservation reservation = new Reservation("P002", "2345678901");
        libraryInventory.addReservation(reservation);

        // Notify availability
        libraryInventory.notifyAvailability("2345678901");
        List<Book> searchResults = libraryInventory.searchBooks("The Great Gatsby");
        for (Book book : searchResults) {
            System.out.println("Found book: " + book.getTitle() + " by " + book.getAuthor());
        }

        // Recommend books
        RecommendationSystem recommendationSystem = new RecommendationSystem(patronManagement);
        List<String> recommendations = recommendationSystem.recommendBooks("P001");
        System.out.println("Recommendations for Alice: " + recommendations);
    }
}
