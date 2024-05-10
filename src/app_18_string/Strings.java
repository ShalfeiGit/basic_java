package app_18_string;

import java.util.Locale;

public class Strings {
    public static void main(String[] args) {
        var s1 = new String(new char[]{'1', '2', '3'});
        System.out.println(s1);

        var s2 = s1.charAt(1);
        System.out.println(s2);

        var s3 = s1.compareTo("12"); // -1 0 1 .compareIgnoreCase - игнорит регистр при сравнении
        System.out.println(s3);

        var s4 = s1.concat("4");
        System.out.println(s4);

        var s5 = s1.contains("4");
        System.out.println(s5);

        var s6 = s1.endsWith("3");
        System.out.println(s6);

        var s7 = s1.equals("123"); // equalsIgnoreCase
        System.out.println(s7);

        var s8 = String.format("a = %d, b = %d, c = %s", 1, 2, "3"); // %s - string, %d - int, long ..., %f - float, double ..., %b - boolean, %c - char, %t - date,  %% - символ %, можно и более глубоко настроить https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html
        System.out.println(s8);

        var s9 = s1.getBytes();
        System.out.println(s9[0]);

        var s10 = s1.indexOf("3 ");
        System.out.println(s10);

        var s11 = s1.isBlank();
        System.out.println(s11);

        var s12 = s1.isEmpty();
        System.out.println(s12);

        var s13 = s1.join("-", s8, s1);
        System.out.println(s13);

        var s14 = s13.lastIndexOf(s1);
        System.out.println(s14);

        var s15 = s1.length();
        System.out.println(s15);

        var s16 = s1.lines(); // возращает стримы строк
        System.out.println(s16);

        var s17 = s13.matches("(.*)" +  s1 +  "(.*)"); // возращает стримы строк
        System.out.println(s17);

        var s18 = s13.replace('1', '9');
        System.out.println(s18);

        var s19 = s13.split(",");
        System.out.println(s19[0]);

        var s20 = s13.startsWith(s1);
        System.out.println(s20);

        var s21 = s13.substring(7, 19);
        System.out.println(s21);

        var s22 = s1.toCharArray();
        System.out.println(s22[1]);

        var s23 = s13.toUpperCase();
        System.out.println(s23);

        var s24 = new String(" " + s1 + " ").trim();
        System.out.println(s24);

        var s25 = String.valueOf(true);
        System.out.println(s25);
    }
}
