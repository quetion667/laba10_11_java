package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class lab10_ex03 {
    public static void readAllByArray(InputStream in) throws IOException {
        // считывание по 3 символов
        byte[] buff = new byte[3];

        while(true) {
            int count = in.read(buff);
            if (count != -1) // типа, конец файла
            {
                System.out.println("количество = " + count + ", buff = " + Arrays.toString(buff) + ", str = " + new String(buff, 0, count, "cp1251"));
            }
            else break;
        }
    }

    public static void main(String[] args) throws IOException {
        String fileName = "C:\\lab10_2.txt";
        FileInputStream inFile = null; //чтобы не ограничивать область видимости

        try {
            inFile = new FileInputStream(fileName);
            readAllByArray(inFile);
        } catch (IOException e) {
            System.out.println("ошибка файла" + fileName + e);
        } finally { //корректное закрытие потока
            if (inFile != null) {
                try {
                    inFile.close();
                }
                catch (IOException ignore) {
                    //nop
                }
                }
            }

        }

}
