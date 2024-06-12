package app_50_stream_io_outputstream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class OutputStream_IO {
    public static void main(String[] args) throws IOException {
        File file = Path.of("src","app_50_stream_io_outputstream", "resources", "test.txt").toFile();
        Path file_2 = Path.of("src","app_50_stream_io_outputstream", "resources", "test.txt");
        Path file_3 = Path.of("src","app_50_stream_io_outputstream", "resources", "test2.txt");
        try (
                FileOutputStream outputStream_1 = new FileOutputStream(file);
                FileWriter outputStream_2 = new FileWriter(file, true); // Задание потока через FileReader (только текст)
        ){ //для закртыия стрима,после его использования AutoClosable и избежания утечки памяти
            // загрузить строку целиком
            String text = "Test text";
            outputStream_1.write(text.getBytes());

            // запись в файл потоково
            try(BufferedWriter writer = new BufferedWriter(outputStream_2)){
                writer.newLine();
                writer.append(text);
                writer.append(System.lineSeparator()); // перевод на новую строку
            }

            // наиболее современный вариант записи
            Files.copy(file_2, file_3);
            Files.write(file_2, List.of("Hello wolrd"), StandardOpenOption.APPEND);
            Files.delete(file_3);
        }

    }
}
