package Excercise1;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
1. Napisz funkcyjną implementację silni, czyli taką, która wykorzystuje Stream.
    -> zaczynamy od 1 zwiększamy cały czas, aż dojdziemy do limitu
 */
public class Excercise1 {
    public static void main(String[] args) {
        int value = 10;
        int resolut = factorialByStream(value);
        System.out.println(resolut);
    }

    private static int factorialByStream(int value) {
        return IntStream.iterate(1, element -> element + 1)
                .limit(value) // 10,9,8,7,6,5,4,3,2,1
                .reduce((left, right) -> left * right)
                .orElse(0);
    }
}
