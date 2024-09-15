package Excercise2;
/*
    Wykorzystując Streamy, na podanej tablicy liter wykonaj następujące operacje (w podanej kolejności):
    ◦ zamień wszystkie litery na wielką literę,
    ◦ pozbądź się litery 'X',
    ◦ posortuj malejąco,
    ◦ zwróć wynik jako jeden String
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Excercise2 {
    public static void main(String[] args) {
        String[] letters = {"z", "x", "a", "j", "a", "v", "x", "k", "a", "x"};
        String resoult = stringOperators(letters);
        System.out.println("----------------");
        System.out.println(resoult);
    }

    private static String stringOperators(String[] letters) {
        String resoutl = Arrays.stream(letters)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .filter(element -> !element.equals("X"))
                .peek(System.out::print)
                .sorted(Comparator.reverseOrder())
                //.sorted((left, right) -> right.compareTo(left))
                .peek(System.out::print)
                .collect(Collectors.joining());
        return  resoutl;
    }
}
