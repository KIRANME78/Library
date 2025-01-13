package org.example;

import java.util.ArrayList;
import java.util.List;

public class RecommendationSystem {
    private PatronManagement patronManagement;

    public RecommendationSystem(PatronManagement patronManagement) {
        this.patronManagement = patronManagement;
    }

    public List<String> recommendBooks(String patronId) {
        List<String> recommendations = new ArrayList<>();

        // Add some dummy recommendations for demonstration purposes
        recommendations.add("The Catcher in the Rye by J.D. Salinger");
        recommendations.add("Pride and Prejudice by Jane Austen");
        recommendations.add("The Hobbit by J.R.R. Tolkien");

        return recommendations;
    }
}
