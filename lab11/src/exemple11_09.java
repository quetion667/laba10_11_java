package com.company;

import java.io.*;
import java.util.Scanner;


public class exemple17_09 {
    public static void main(String[] args) {
        try {
            File folder = new File("C:\\prog\\11\\My");
            if (!folder.exists())
                folder.mkdir();
            File f1 = new File("C:\\prog\\11\\My\\rec_RAF.txt");
            File f2 = new File("C:\\prog\\11\\My\\rec_RAF2.txt");
            if (!f1.exists())
                f1.createNewFile();
            if (!f2.exists())
                f2.createNewFile();
            RandomAccessFile rf = new RandomAccessFile(f1, "rw");
            RandomAccessFile rf2 = new RandomAccessFile(f2, "rw");
            long fSize = rf.length();
            long fSize2 = rf2.length();
            Scanner sc = new Scanner(System.in, "UTF-8");
            System.out.print("Введите количество фильмов для записи в файл\n" + "=> ");
            int kol = sc.nextInt();
            sc.nextLine();
            String fam, doljnost,janr,cena;
            int oklad;

            for (int i = 0; i < kol; i++) {

                System.out.print("Введите его страну => ");
                doljnost = sc.next();
                rf.writeUTF(doljnost);
                for (int j = 0; j < 20 - doljnost.length(); j++)
                    rf.writeByte(1);
                if (doljnost == "rus"){

                    rf2.writeUTF(doljnost);
                    for (int j = 0; j < 20 - doljnost.length(); j++)
                        rf2.writeByte(1);

                }
                System.out.print("Название " + (i + 1) + " Фильма => ");
                fam = sc.next();
                rf.seek(rf.length());
                rf.writeUTF(fam);
                for (int j = 0; j < 20 - fam.length(); j++)
                    rf.writeByte(1);
                if (doljnost == "rus"){

                    rf2.writeUTF(fam);
                    for (int j = 0; j < 20 - fam.length(); j++)
                        rf2.writeByte(1);

                }





                System.out.print("Введите его год выпуска => ");
                oklad = sc.nextInt();
                sc.nextLine();
                rf.writeInt(oklad);
                if (doljnost == "rus"){

                    rf2.writeUTF(String.valueOf(oklad));


                }


                System.out.print("Введите его жанр => ");
                janr = sc.next();
                rf.writeUTF(janr);
                for (int j = 0; j < 20 - janr.length(); j++)
                    rf.writeByte(1);
                if (doljnost == "rus"){

                    rf2.writeUTF(janr);
                    for (int j = 0; j < 20 - janr.length(); j++)
                        rf.writeByte(1);

                }


                System.out.print("Введите его цену => ");
                cena = sc.next();
                rf.writeUTF(cena);
                for (int j = 0; j < 20 - cena.length(); j++)
                    rf.writeByte(1);
                if (doljnost == "rus"){

                    rf2.writeUTF(cena);
                    for (int j = 0; j < 20 - cena.length(); j++)
                        rf.writeByte(1);

                }


            }

            rf.close();
            rf2.close();

            rf = new RandomAccessFile(f1, "r");
            rf.seek(0);
            rf2 = new RandomAccessFile(f2, "r");
            rf2.seek(0);
            System.out.println("Информация о фильмах");
            System.out.println("Название \t\t год \t\t страна \t\t Жанр \t\t цена");
            for (int i = 0; i < kol; i++) {
                fam = rf.readUTF();
                for (int j = 0; j < 20 - fam.length(); j++)
                    rf.readByte();
                doljnost = rf.readUTF();
                for (int j = 0; j < 20 - doljnost.length(); j++)
                    rf.readByte();

                oklad = rf.readInt();

                janr = rf.readUTF();
                for (int j = 0; j < 20 - janr.length(); j++)
                    rf.readByte();

                cena = rf.readUTF();
                for (int j = 0; j < 20 - cena.length(); j++)
                    rf.readByte();

                System.out.println(fam + "\t\t\t" + doljnost + "\t\t\t" + oklad + "\t\t\t" + janr + "\t\t\t" + cena);

            }
            rf.close();
            rf2.close();
        } catch (IOException e) {
            System.out.println("End of file " + e);
        }
    }
}
