package Excercise5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/*
        Jeżeli podpowiem, że String posiada metodę .chars(), która generuje IntStream, spróbuj
        zaimplementować sprawdzanie, czy słowo/zdanie jest palindromem, przy wykorzystaniu Streamów
 */
public class Excercise5 {
    public static void main(String[] args) {
        String sentence = "A to idiota";
        String preparedSentene = sentence.replace(" ","").toLowerCase();

        System.out.println(preparedSentene);
        chechIsPalindrome(sentence);

    }

    private static boolean chechIsPalindrome(String sentence) { //atoidiota //
        String reversed = sentence.chars()
                .mapToObj(character -> String.valueOf((char) character))
                .reduce("", (ch1, ch2) -> ch1 + ch2);
        return sentence.equals(reversed);
    }
}
