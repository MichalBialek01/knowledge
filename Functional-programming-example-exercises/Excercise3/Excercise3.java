package Excercise3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
        Znajdź drugi najmniejszy element w liście poniżej:
        List<Integer> numbers = Arrays.asList(1, 5, 16, 18, 2, 5, 2, 6, 2, 1, 6, 1, 23, 64, 34);
 */
public class Excercise3 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 5, 16, 18, 2, 5, 2, 6, 2, 1, 6, 1, 23, 64, 34);
        Integer resoult = secondLowestElement(numbers);
        System.out.println(resoult);
    }

    private static Integer secondLowestElement(List<Integer> numbers) {
        return numbers.stream()
                .sorted(Comparator.naturalOrder())
                .distinct()
                .skip(1)
                .findFirst()
                .orElse(0);
    }
}
