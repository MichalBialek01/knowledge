package org.example;

import java.util.ArrayList;

public class FindingAndDeletingWrongData {
    public static void findWrongData(ArrayList<Film> films){
        int counter = 0;
        for (Film film : films) {
            if (film.getRating().isEmpty()) {
                counter++;
            }
        }
    }
    public static void removeWrongDataFunctional(ArrayList<Film> films){
        films.removeIf(element -> element.getRating().isEmpty());
    }


}
