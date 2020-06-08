package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class lab10_ex06 {
    public static void main(String[] args) throws IOException {
        FileReader in = null;
        // можно сразу записать FileReader in=null;
        FileWriter out = null;
        // можно сразу записать FileWriter out =null;
        try {
            in = new FileReader("C:\\MyFile1.txt"); // файл для чтения
            out = new FileWriter("C:\\MyFile2.txt", true);
            // файл для записи разрешено добавление
            // Данные считываются и записываются побайтно, как и для // InputStream/OutputStream
            int oneByte; // переменная, в которую считываются данные
            while ((oneByte = in.read()) != -1) {
// out.write((char)oneByte); // запись с уничтожением ранее
// существующих данных
                out.append((char) oneByte); // запись с добавлением данных в конец
                System.out.print((char) oneByte);
            }
        } catch (IOException e) {
            System.out.println("Ошибка!!!! ");
        } finally {
            in.close();
            out.close();
        }
    }
}

