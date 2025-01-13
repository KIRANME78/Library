package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LendingSystem {
    private LibraryInventory libraryInventory;
    private PatronManagement patronManagement;
    private static final Logger logger = LoggerFactory.getLogger(LendingSystem.class);

    public LendingSystem(LibraryInventory libraryInventory, PatronManagement patronManagement) {
        this.libraryInventory = libraryInventory;
        this.patronManagement = patronManagement;
    }

    public synchronized void checkoutBook(String ISBN, String patronId, String branchId) {
        Book book = libraryInventory.searchBooks(ISBN).stream().findFirst().orElse(null);
        if (book == null) {
            logger.warn("Book with ISBN " + ISBN + " not found in inventory.");
            return;
        }

        Patron patron = patronManagement.getPatron(patronId);
        if (patron == null) {
            logger.warn("Patron with ID " + patronId + " not found.");
            return;
        }

        patron.addBorrowedBook(book);
        libraryInventory.removeBook(branchId, ISBN);
        logger.info("Book checked out: " + book.getTitle() + " by Patron: " + patron.getName());
    }

    public synchronized void returnBook(String ISBN, String patronId, String branchId) {
        Patron patron = patronManagement.getPatron(patronId);
        if (patron == null) {
            logger.warn("Patron with ID " + patronId + " not found.");
            return;
        }

        Book book = patron.getBorrowingHistory().stream().filter(b -> b.getISBN().equals(ISBN)).findFirst().orElse(null);
        if (book == null) {
            logger.warn("Book with ISBN " + ISBN + " not found in patron's borrowing history.");
            return;
        }

        libraryInventory.addLibraryItem(branchId, book);
        patron.returnBorrowedBook(book);
        logger.info("Book returned: " + book.getTitle() + " by Patron: " + patron.getName());
    }
}
