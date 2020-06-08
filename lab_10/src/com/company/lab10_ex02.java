package com.company;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class lab10_ex02 {
    public static void readAllByte(InputStream in) throws IOException {
        while (true) {
            int oneByte = in.read();
            if (oneByte != -1) {
                System.out.print((char) oneByte);
            }
            else
            {
                System.out.println("\n" + "end");
                break;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        try {
            // С потоком связан файл
            InputStream inFile = new FileInputStream("C:/lab10_2.txt"); // файл предварительно заполнен
            readAllByte(inFile);
            System.out.print("\n\n\n");
            inFile.close();
            // С потоком связана страница
            InputStream inUrl = (new URL("http://cat.rtf.urfu.ru/")).openStream();
            readAllByte(inUrl);
            System.out.print("\n\n\n");
            inUrl.close();
            // С потоком связан массив
            ByteArrayInputStream inArray = new ByteArrayInputStream(new byte[]{7, 9, 3, 7, 4});
            readAllByte(inArray);
            System.out.print("\n\n\n");
            inArray.close();
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e);
        }

        }
}
//





