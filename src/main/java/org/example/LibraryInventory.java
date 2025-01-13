package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryInventory implements ILibraryInventory {
    private static LibraryInventory instance;
    private Map<String, Branch> branches;
    private List<Reservation> reservations;
    private NotificationSystem notificationSystem;
    private static final Logger logger = LoggerFactory.getLogger(LibraryInventory.class);

    private LibraryInventory() {
        this.branches = new HashMap<>();
        this.reservations = new ArrayList<>();
        this.notificationSystem = new NotificationSystem();
    }

    public static synchronized LibraryInventory getInstance() {
        if (instance == null) {
            instance = new LibraryInventory();
        }
        return instance;
    }

    @Override
    public synchronized void addBranch(Branch branch) {
        branches.put(branch.getBranchId(), branch);
        logger.info("Branch added: " + branch.getBranchName());
    }

    @Override
    public synchronized void transferBook(String ISBN, String fromBranchId, String toBranchId) {
        Branch fromBranch = branches.get(fromBranchId);
        Branch toBranch = branches.get(toBranchId);
        if (fromBranch != null && toBranch != null) {
            Book book = fromBranch.getBooks().stream().filter(b -> b.getISBN().equals(ISBN)).findFirst().orElse(null);
            if (book != null) {
                fromBranch.removeBook(book);
                toBranch.addBook(book);
                logger.info("Book transferred: " + book.getTitle() + " from " + fromBranch.getBranchName() + " to " + toBranch.getBranchName());
            } else {
                logger.warn("Book with ISBN " + ISBN + " not found in branch " + fromBranch.getBranchName());
            }
        } else {
            logger.warn("Branch not found.");
        }
    }

    @Override
    public synchronized void addReservation(Reservation reservation) {
        reservations.add(reservation);
        logger.info("Reservation added for ISBN: " + reservation.getISBN() + " by Patron: " + reservation.getPatronId());
    }

    @Override
    public synchronized void notifyAvailability(String ISBN) {
        for (Reservation reservation : reservations) {
            if (reservation.getISBN().equals(ISBN)) {
                notificationSystem.notifyObservers("Book with ISBN " + ISBN + " is now available.");
                logger.info("Notification sent to Patron: " + reservation.getPatronId() + " for ISBN: " + ISBN);
            }
        }
    }

    @Override
    public synchronized List<Book> searchBooks(String query) {
        List<Book> result = new ArrayList<>();
        for (Branch branch : branches.values()) {
            for (Book book : branch.getBooks()) {
                if (book.getTitle().contains(query) || book.getAuthor().contains(query) || book.getISBN().contains(query)) {
                    result.add(book);
                }
            }
        }
        return result;
    }

    @Override
    public synchronized void addLibraryItem(String branchId, LibraryItem item) {
        Branch branch = branches.get(branchId);
        if (branch != null) {
            if (item instanceof Book) {
                branch.addBook((Book) item);
            }
            logger.info("Item added: " + item.getTitle() + " to branch: " + branch.getBranchName());
        } else {
            logger.warn("Branch with ID " + branchId + " not found.");
        }
    }

    @Override
    public synchronized void removeBook(String branchId, String ISBN) {
        Branch branch = branches.get(branchId);
        if (branch != null) {
            Book book = branch.getBooks().stream().filter(b -> b.getISBN().equals(ISBN)).findFirst().orElse(null);
            if (book != null) {
                branch.removeBook(book);
                logger.info("Book removed: " + book.getTitle() + " from branch: " + branch.getBranchName());
            } else {
                logger.warn("Book with ISBN " + ISBN + " not found in branch " + branch.getBranchName());
            }
        } else {
            logger.warn("Branch with ID " + branchId + " not found.");
        }
    }

    @Override
    public synchronized void updateBook(String branchId, String ISBN, Book updatedBook) {
        Branch branch = branches.get(branchId);
        if (branch != null) {
            for (int i = 0; i < branch.getBooks().size(); i++) {
                if (branch.getBooks().get(i).getISBN().equals(ISBN)) {
                    branch.getBooks().set(i, updatedBook);
                    logger.info("Book updated: " + updatedBook.getTitle() + " in branch: " + branch.getBranchName());
                    return;
                }
            }
            logger.warn("Book with ISBN " + ISBN + " not found in branch " + branch.getBranchName());
        } else {
            logger.warn("Branch with ID " + branchId + " not found.");
        }
    }
}
