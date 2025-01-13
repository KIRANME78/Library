package org.example;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String branchId;
    private String branchName;
    private List<Book> books;

    public Branch(String branchId, String branchName) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.books = new ArrayList<>();
    }

    // Getters and Setters
    public String getBranchId() { return branchId; }
    public void setBranchId(String branchId) { this.branchId = branchId; }

    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }

    public List<Book> getBooks() { return books; }
    public void addBook(Book book) { this.books.add(book); }
    public void removeBook(Book book) { this.books.remove(book); }
}
