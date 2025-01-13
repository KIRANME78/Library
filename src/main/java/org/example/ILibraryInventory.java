package org.example;

import java.util.List;

public interface ILibraryInventory {
   // void addBook(String branchId, Book book);

    void transferBook(String bookId, String fromBranchId, String toBranchId);

    List<Book> searchBooks(String query);

    void addLibraryItem(String branchId, LibraryItem item);

    void removeBook(String branchId, String ISBN);

    void addReservation(Reservation reservation);

    void notifyAvailability(String ISBN);

    void addBranch(Branch branch);

    void updateBook(String branchId, String ISBN, Book updatedBook);
}
