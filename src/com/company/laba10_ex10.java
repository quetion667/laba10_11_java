package com.company;

import java.io.*;

public class laba10_ex10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        PrintWriter out=null;
        try {
            // Создание потоков
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("MyFile1.txt"),"cp1251"));
            out = new PrintWriter("MyFile2.txt","cp1251");
            // Переписывание информации из одного файла в другой
            int lineCount = 0; String s;
            while ((s = br.readLine()) != null) {
                lineCount++;
                out.println(lineCount + ": " + s);
            }
        }
        catch (IOException e)
        { System.out.println("Ошибка !!!!!!!!"); }
        finally{
            br.close();
            out.flush();
            out.close();
        }}
}
