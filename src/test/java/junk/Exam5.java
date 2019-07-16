package junk;

public class Exam5 {
    private int a, b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int sum() {
        return a + b;
    }

    public int max() {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }

}



