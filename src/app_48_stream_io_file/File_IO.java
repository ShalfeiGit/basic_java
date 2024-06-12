package app_48_stream_io_file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class File_IO {
    public static void main(String[] args) throws IOException {


        File file_1 = new File("C:\\Work\\resume\\basic_java\\src\\app_48_stream_io_file\\resources\\test1.txt");
        File file_2 = new File("C:\\Work\\resume\\basic_java\\src\\app_48_stream_io_file\\resources\\test.txt");
        File file_3 = new File(String.join(File.separator, "C:", "Work", "resume", "basic_java", "src", "app_48_stream_io_file", "resources"));

        System.out.println(file_1.exists());
        System.out.println(file_1.isFile());
        System.out.println(file_1.isDirectory());
        System.out.println(file_2.createNewFile());
        System.out.println(file_3.mkdir());
        System.out.println(file_2.getParent());
        System.out.println(file_2.getName());
        System.out.println(file_2.length());
        System.out.println(file_2.canExecute()); // права доступа exective canRead, canWrite
        System.out.println(file_2.compareTo(file_1));
        System.out.println(file_2.delete());
        Arrays.asList(file_3.list()).stream().forEach(System.out::println); // получение списка файлов
    }
}
