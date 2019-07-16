package junk;

import java.util.ArrayList;
import java.util.List;

public class Exam4 {
    public static void main(String[] args) {
        String[] words = {"myAwsomePhrase", "iLoveJustinBieber", "captainJackSparrow"};
        List<String> snakeCase = new ArrayList<>();
        for (String item : words) {
            item = item.replaceAll("(.+?)([A-Z])", "$1_$2").toLowerCase();
            snakeCase.add(item);

        }

        for (String item : snakeCase) {
            System.out.println(item);
        }

    }
}
