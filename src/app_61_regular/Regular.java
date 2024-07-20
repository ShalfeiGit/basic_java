package app_61_regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular {
    public static void main(String[] args) {
        // Примеры Regexp (полное совпадение)
        // ^ - начало строки
        String text_1 = "Valya";
        Pattern pattern_1 = Pattern.compile("^Valya"); //первый вариант реализации pattern
        Matcher matcher_1 = pattern_1.matcher(text_1);
        System.out.println("matcher_1: " + matcher_1.matches());

        // $ - конец строки
        String text_2 = "Valya";
        boolean matcher_2 = Pattern.matches("Valya$", text_2);
        System.out.println("matcher_2: " + matcher_2);

        //. - любой символ
        String text_3 = "Valya";
        Pattern pattern_3 = Pattern.compile("Va.ya");
        Matcher matcher_3 = pattern_3.matcher(text_3);
        System.out.println("matcher_3: " + matcher_3.matches());

        // \\d - цифровой символ
        String text_4 = "1";
        Pattern pattern_4 = Pattern.compile("\\d");
        Matcher matcher_4 = pattern_4.matcher(text_4);
        System.out.println("matcher_4: " + matcher_4.matches());

        // \\D - не цифровой символ
        String text_5 = "V";
        Pattern pattern_5 = Pattern.compile("\\D");
        Matcher matcher_5 = pattern_5.matcher(text_5);
        System.out.println("matcher_5: " + matcher_5.matches());

        // \\s - любой пробельный символ
        String text_6 = " ";
        Pattern pattern_6 = Pattern.compile("\\s");
        Matcher matcher_6 = pattern_6.matcher(text_6);
        System.out.println("matcher_6: " + matcher_6.matches());

        // \\S - любой не пробельный символ
        String text_7 = "V";
        Pattern pattern_7 = Pattern.compile("\\S");
        Matcher matcher_7 = pattern_7.matcher(text_7);
        System.out.println("matcher_7: " + matcher_7.matches());

        // \\w - любой буквенный или цифровой символ
        String text_8 = "V";
        Pattern pattern_8 = Pattern.compile("\\w");
        Matcher matcher_8 = pattern_8.matcher(text_8);
        System.out.println("matcher_8: " + matcher_8.matches());

        // \\W - любой не буквенный или цифровой символ
        String text_9 = " ";
        Pattern pattern_9 = Pattern.compile("\\W");
        Matcher matcher_9 = pattern_9.matcher(text_9);
        System.out.println("matcher_9: " + matcher_9.matches());

        // + - один или более
        String text_10 = "Valya";
        Pattern pattern_10 = Pattern.compile("\\w+");
        Matcher matcher_10 = pattern_10.matcher(text_10);
        System.out.println("matcher_10: " + matcher_10.matches());

        // * - ноль или более
        String text_11 = "Valya";
        Pattern pattern_11 = Pattern.compile("\\w*");
        Matcher matcher_11 = pattern_11.matcher(text_11);
        System.out.println("matcher_11: " + matcher_11.matches());

        //? - ноль или один
        String text_12 = "Valya";
        Pattern pattern_12 = Pattern.compile("Val?ya");
        Matcher matcher_12 = pattern_12.matcher(text_12);
        System.out.println("matcher_12: " + matcher_12.matches());

        //{n} - ровнео n раз
        String text_13 = "Vallya";
        Pattern pattern_13 = Pattern.compile("Val{2}ya");
        Matcher matcher_13 = pattern_13.matcher(text_13);
        System.out.println("matcher_13: " + matcher_13.matches());

        // {n,m} - от n до m раз
        String text_14 = "Valllya";
        Pattern pattern_14 = Pattern.compile("Val{2,3}ya");
        Matcher matcher_14 = pattern_14.matcher(text_14);
        System.out.println("matcher_14: " + matcher_14.matches());

        // {n,} - от n до бесконечности
        String text_15 = "Valllllya";
        Pattern pattern_15 = Pattern.compile("Val{2,}ya");
        Matcher matcher_15 = pattern_15.matcher(text_15);
        System.out.println("matcher_15: " + matcher_15.matches());

        // (a|b) - a или b
        String text_16 = "Valya";
        Pattern pattern_16 = Pattern.compile("V(a|b)lya");
        Matcher matcher_16 = pattern_16.matcher(text_16);
        System.out.println("matcher_16: " + matcher_16.matches());

        // [Vv] - V или v,
        String text_17 = "Valya";
        Pattern pattern_17 = Pattern.compile("[Vv]alya");
        Matcher matcher_17 = pattern_17.matcher(text_17);
        System.out.println("matcher_17: " + matcher_17.matches());

        // [A-z,0-9] - указанный диапазон
        String text_18 = "Valya";
        Pattern pattern_18 = Pattern.compile("[Vv]alya");
        Matcher matcher_18 = pattern_18.matcher(text_18);
        System.out.println("matcher_18: " + matcher_18.matches());

        // [A-z,0-9] - указанный диапазон
        String text_19 = "Valya";
        Pattern pattern_19 = Pattern.compile("[Vv]alya");
        Matcher matcher_19 = pattern_19.matcher(text_19);
        System.out.println("matcher_19: " + matcher_19.matches());

        // ^ - начало строки
        String text_20 = "Valya";
        Pattern pattern_20 = Pattern.compile("^Valya");
        Matcher matcher_20 = pattern_20.matcher(text_20);
        System.out.println("matcher_20: " + matcher_20.matches());

        // $ - конец строки
        String text_21 = "Valya";
        Pattern pattern_21 = Pattern.compile("Valya$");
        Matcher matcher_21 = pattern_21.matcher(text_21);
        System.out.println("matcher_21: " + matcher_21.matches());

        // () - группа строки
        String text_22 = "Valya";
        Pattern pattern_22 = Pattern.compile("(V)(?<code>a)ly\\2"); // \\2 дубликат того что на втором
        Matcher matcher_22 = pattern_22.matcher(text_22);
        while(matcher_22.find()){
            System.out.println("matcher_22: " + matcher_22.group(1));
            System.out.println("matcher_22: " + matcher_22.group("code"));
            System.out.println("matcher_22: " + matcher_22.group(2));
        }

        // замена подстрок
        String text_23 = "Valya";
        Pattern pattern_23 = Pattern.compile("(V)(a)l(ya)"); //
        Matcher matcher_23 = pattern_23.matcher(text_23);
        StringBuilder stringBuilder = new StringBuilder();
        while(matcher_23.find()){
           matcher_23.appendReplacement(stringBuilder, "$1$2n$3");
        }
        System.out.println(stringBuilder);

        // замена подстрок
        String text_24 = "Valya abc Valya";
        String text_25 = "Valya abc Valya";
        String regexp1 = "(V.+)(.+a)"; //жадный квантификатор
        String regexp2 = "(V.+?)(.+?ya)"; //не жадный квантификатор
        System.out.println(text_24.replaceAll(regexp1, "$2"));
        System.out.println(text_25.replaceAll(regexp2, "$2"));


    }
}
