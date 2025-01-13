package org.example;

import java.util.List;

public interface IPatronManagement {
    void addPatron(Patron patron);

    Patron getPatron(String patronId);

    void updatePatron(String patronId, Patron updatedPatron);

    List<Patron> getAllPatrons();
}
