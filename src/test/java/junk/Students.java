package junk;

public class Students implements Comparable {
    public String surname;
    public String name;
    public int birthYear;
    public int course;
    public int group;
    public int math;
    public int geography;

    public Students() {
    }

    public Students(String surname, String name, int birthYear, int course, int group, int math, int geography) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.course = course;
        this.group = group;
        this.math = math;
        this.geography = geography;
    }

    @Override
    public String toString() {
        return "Students{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", course=" + course +
                ", group=" + group +
                ", math=" + math +
                ", geography=" + geography +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Students s = (Students) o;
        return (group < s.group) ? -1 : ((group == s.group) ? 0 : 1);
    }
}
