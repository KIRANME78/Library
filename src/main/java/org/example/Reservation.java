package org.example;

public class Reservation {
    private String patronId;
    private String ISBN;

    public Reservation(String patronId, String ISBN) {
        this.patronId = patronId;
        this.ISBN = ISBN;
    }

    // Getters and Setters
    public String getPatronId() { return patronId; }
    public void setPatronId(String patronId) { this.patronId = patronId; }

    public String getISBN() { return ISBN; }
    public void setISBN(String ISBN) { this.ISBN = ISBN; }
}
