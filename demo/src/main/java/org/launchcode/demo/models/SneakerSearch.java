package org.launchcode.demo.models;

import java.util.ArrayList;

public class SneakerSearch {

    public static ArrayList<Sneaker> findByValue(String value, Iterable<Sneaker> allSneakers) {
        String lower_val = value.toLowerCase();
        ArrayList<Sneaker> results = new ArrayList<>();

        for (Sneaker sneaker : allSneakers) {

            if (sneaker.getName().toLowerCase().contains(lower_val)) {
                results.add(sneaker);
            } else if (sneaker.getDesigner().toLowerCase().contains(lower_val)) {
                results.add(sneaker);
            } else if (sneaker.getReleaseDate().toLowerCase().contains(lower_val)) {
                results.add(sneaker);
            }


        }
        return results;

    }
}