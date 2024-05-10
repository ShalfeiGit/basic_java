package app_19_stringbuilder_and_stringbuffer;

public class StringBuilderAndStringBuffer {
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder("abc");
        StringBuilder s2 = new StringBuilder();
        StringBuilder s3 = new StringBuilder(new StringBuilder("123"));
        StringBuffer s4 = new StringBuffer(); // потокобезопасный аналог StringBuilder (NB! локальные переменные также потокобезопасные)
        System.out.println(s1.insert(0, "s1: "));
        System.out.println(s2.insert(0, "s2: "));
        System.out.println(s3.insert(0, "s3: "));
        System.out.println(s4.insert(0, "s4: "));
        s1.append('d');
        System.out.println(s1.append(" - updated s1"));
    }
}
