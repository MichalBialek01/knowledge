package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

class DataService {
    private String csvFilePath = "C:\\Users\\DELL\\Desktop\\FilanProject\\TestForFramework\\src\\main\\java\\org\\example\\Example\\data\\example.csv";

    public ArrayList<Film> readFromCSV(ArrayList<Film> arrayList) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line="";
            br.readLine(); // Pomija nagłówek jeśli istnieje
            for (int i = 0; i < arrayList.size(); i++) {
                String[] values = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                if (values.length >= 2) {
                    int id = Integer.parseInt(values[0]);
                    String filmTitle = values[1].replaceAll("^\"|\"$", "");
                    Optional<Integer> rating = values.length == 3 && !values[2].isEmpty() ?
                            Optional.of((int) Math.round(Double.parseDouble(values[2]))) :
                            Optional.empty();
                    arrayList.add(new Film(id, filmTitle, rating));
                }
            }
            //Usunięcie elementów powtarzających się
//            arrayList.removeIf(element -> element.getRating().isEmpty());
            return arrayList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}