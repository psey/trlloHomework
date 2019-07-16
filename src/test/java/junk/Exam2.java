package junk;


public class Exam2 {
    public static void main(String[] args) {
        String s = "c:/WebServers/home/testsite/www/myfile.txt";
        String[] words = s.split("/");
        String name = words[words.length - 1];
        String substr = name.substring(0, name.length() - 4);
        System.out.println(substr);
    }

}
