package app_49_stream_io_inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class InputStream_IO {
    public static void main(String[] args) throws IOException { // inputstream предназначен для работы с любым потоком байт
        File file = Path.of("src","app_49_stream_io_inputstream", "resources", "test.txt").toFile();
        try (FileInputStream inputStream_1 = new FileInputStream(file); FileInputStream inputStream_2 = new FileInputStream(file);){ //для закртыия стрима,после его использования AutoClosable и избежания утечки памяти
            // считать файл целиком
            byte[] bytes_1 = inputStream_1.readAllBytes();
            String text_1 = new String(bytes_1);
            System.out.println(text_1);

            // считать файл побайтово
            byte[] bytes_2 = new byte[inputStream_2.available()];
            int count = 0;
            byte current;
            while ((current = (byte) inputStream_2.read())!= -1){
                bytes_2[count] = current;
                count++;
            }
            String text_2 = new String(bytes_2);
            System.out.println(text_2);
        }

    }

}
