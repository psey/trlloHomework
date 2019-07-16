package junk;

import java.util.Comparator;

public class StudentSurnameComporator implements Comparator<Students> {
    @Override
    public int compare(Students o1, Students o2) {
        return o1.surname.compareTo(o2.surname);
    }
}
