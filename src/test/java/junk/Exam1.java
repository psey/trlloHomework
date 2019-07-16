package junk;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exam1 {
    public static void main(String[] args) {
        String[] strArray = {"1", "2", "3", "4", "1", "1", "1"};
        Set<String> mySet = new HashSet<>(Arrays.asList(strArray));
        System.out.println(mySet.size());
    }


}
