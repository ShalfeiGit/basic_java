package app_48_stream_io_file;

import java.io.File;
import java.io.IOException;

public class File_IO {
    public static void main(String[] args) throws IOException {

        File file_1 = new File("C:\\Work\\resume\\basic_java\\src\\app_48_stream_io_file\\resources\\test.txt");
        File file_2 = new File("src\\app_48_stream_io_file\\resources");
        File file_3 = new File("C:\\Work\\resume\\basic_java\\src\\app_48_stream_io_file\\resources\\test.txt");

        System.out.println(file_2.mkdir());
        System.out.println(file_1.createNewFile());
        System.out.println(file_1.exists());
        System.out.println(file_1.isFile());
        System.out.println(file_2.isDirectory());
        System.out.println(file_1.getName());
        System.out.println(file_2.getParent());
        System.out.println(file_2.getAbsolutePath());
        System.out.println(file_1.length());
        System.out.println(file_2.list());
        System.out.println(file_1.canExecute());
        System.out.println(file_1.canWrite());
        System.out.println(file_1.canRead());
        System.out.println(file_1.compareTo(file_3));
    }
}
