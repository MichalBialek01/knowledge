package Excercise4;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/*
        Znajdź drugą największą wartość w liście poniżej:
        List<Integer> numbers = Arrays.asList(1, 5, 16, 18, 2, 5, 2, 6, 2, 1, 6, 1, 23, 64, 34);
 */
public class Excercise4 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 5, 16, 18, 2, 5, 2, 6, 2, 1, 6, 1, 23, 64, 34);
        Optional<Integer> resoult = secondHighestElement(numbers);
        System.out.println(resoult);
    }

    private static Optional<Integer> secondHighestElement(List<Integer> numbers) {
            return Optional.of(numbers.stream()
                    .sorted(Comparator.reverseOrder())
                    .distinct()
                    .skip(1)
                    .findFirst()
                    .orElse(0));
    }

}
