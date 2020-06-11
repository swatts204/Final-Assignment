package org.launchcode.demo.models;

import java.util.ArrayList;

public class SneakerData {

    public static ArrayList<Sneaker> findByColumnAndValue(String column, String value, Iterable<Sneaker> allSneakers) {
        ArrayList<Sneaker> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")) {
            return (ArrayList<Sneaker>) allSneakers;
        }
        if (column.equals("all")) {
            results = findByValue(value, allSneakers);
            return results;
        }
        for (Sneaker sneaker : allSneakers) {

            String aValue = getFieldValue(sneaker, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(sneaker);
            }
        }
        return results;
    }

    public static String getFieldValue(Sneaker sneaker, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = sneaker.getName();
        } else if (fieldName.equals("designer")){
            theValue = sneaker.getDesigner();
        } else {
            theValue = sneaker.getReleaseDate();
        }
        return theValue;
    }
    public static ArrayList<Sneaker> findByValue(String value,Iterable<Sneaker> allSneakers) {
        String lower_val = value.toLowerCase();
        ArrayList<Sneaker> results = new ArrayList<>();

        for (Sneaker sneaker : allSneakers) {
            if (sneaker.getName().toLowerCase().contains(lower_val)){
                results.add(sneaker);
            }else if (sneaker.getDesigner().toLowerCase().contains(lower_val)){
                results.add(sneaker);
            }else if (sneaker.getReleaseDate().toLowerCase().contains(lower_val)){
                results.add(sneaker);
            }else if (sneaker.toString().toLowerCase().contains(lower_val)){
                results.add(sneaker);
            }

        }
        return results;
    }
}