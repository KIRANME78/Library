package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatronManagement implements IPatronManagement {
    private static PatronManagement instance;
    private Map<String, Patron> patrons;
    private static final Logger logger = LoggerFactory.getLogger(PatronManagement.class);

    private PatronManagement() {
        this.patrons = new HashMap<>();
    }

    public static synchronized PatronManagement getInstance() {
        if (instance == null) {
            instance = new PatronManagement();
        }
        return instance;
    }

    @Override
    public synchronized void addPatron(Patron patron) {
        patrons.put(patron.getPatronId(), patron);
        logger.info("Patron added: " + patron.getName());
    }

    @Override
    public synchronized Patron getPatron(String patronId) {
        return patrons.get(patronId);
    }

    @Override
    public synchronized void updatePatron(String patronId, Patron updatedPatron) {
        if (patrons.containsKey(patronId)) {
            patrons.put(patronId, updatedPatron);
            logger.info("Patron updated: " + updatedPatron.getName());
        } else {
            logger.warn("Patron with ID " + patronId + " not found.");
        }
    }

    @Override
    public synchronized List<Patron> getAllPatrons() {
        return new ArrayList<>(patrons.values());
    }
}
