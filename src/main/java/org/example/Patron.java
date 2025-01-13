package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Patron implements Observer {
    private String name;
    private String patronId;
    private List<Book> borrowingHistory;
    private static final Logger logger = LoggerFactory.getLogger(Patron.class);

    public Patron(String name, String patronId) {
        this.name = name;
        this.patronId = patronId;
        this.borrowingHistory = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPatronId() { return patronId; }
    public void setPatronId(String patronId) { this.patronId = patronId; }

    public List<Book> getBorrowingHistory() { return borrowingHistory; }

    public synchronized void addBorrowedBook(Book book) {
        this.borrowingHistory.add(book);
        logger.info("Book borrowed: " + book.getTitle() + " by Patron: " + name);
    }

    public synchronized void returnBorrowedBook(Book book) {
        this.borrowingHistory.remove(book);
        logger.info("Book returned: " + book.getTitle() + " by Patron: " + name);
    }


    public void update(String message) {
        // Implementation for update method
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
