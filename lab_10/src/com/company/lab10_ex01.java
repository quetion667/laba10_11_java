package com.company;

import java.io.File;

public class lab10_ex01 {
    public static void main(String[] args) {
        try {
            // Создание файла в текущей папке
            File f1=new File("MyFile1.txt");
            f1.createNewFile();
            if (f1.exists()) {

                System.out.println("Создан!!!!");
                System.out.println("Полный путь1: "+ f1.getAbsolutePath());
            }
// Создание файла на диске
            File f2 = new File("C:\\Lab10\\MyFile2.txt");
            System.out.println( "Полный путь 2: "+ f2.getAbsolutePath());
// Создание нескольких вложенных папок
            File f3=new File("C:\\Papka1\\Papka2\\Papka3");
            f3.mkdirs();
            System.out.println("Полный путь 3: "+ f3.getAbsolutePath());
        }
        catch (Exception e)
        {
            System.out.println("Ошибка!!! "+e);
        }
    }

}
