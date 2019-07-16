package junk;

public class Exam3 {
    public static void main(String[] args) {
        String s = "Это ##тестовый пример## для задачи ##на## строки";
        //String[] words = s.split(" ");
        String k = s.replaceAll(" ##", " <");
        String d = k.replaceAll("## ", "> ");
        System.out.println(d);

    }
}
