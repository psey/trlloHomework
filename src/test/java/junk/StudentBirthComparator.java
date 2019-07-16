package junk;

import java.util.Comparator;

public class StudentBirthComparator implements Comparator<Students> {
    @Override
    public int compare(Students o1, Students o2) {
        return Integer.compare(o1.birthYear, o2.birthYear);
    }
}
