package com.company;

import java.io.*;

public class laba10_ex12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("MyFile1.txt"), "UTF-8"));
            bw = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("MyFile2.txt"), "UTF-8"));
            bw.write("первая строка");
            bw.newLine();
            String s;
            int kol1 = 0;
            int kol2 = 0;
            int p =1;
            char[] sogl = {'й','Й','Ц','ц','К','к','н','Н','г','Г','Ш','ш','щ','Щ','з','З','х','Х','Ф','ф','в','В','п','П','Р','р','л','Л','д','Д','Ж','ж','Ч','ч','С','с','М','м','Т','т','б','Б'};
            int i = -2;
            while ((s = br.readLine()) != null) {
                s +=" +";
                for (String j: s.split(" ", 0)){

                    for (int v = 0; v<= 41; v++){



                        i = j.indexOf("+");
                        if (i==0 && p<2){
                            System.out.println("|вторая строка|");
                            bw.newLine();
                            bw.write("|вторая строка|");
                            bw.newLine();


                            kol2=kol1;


                            p++;
                        }
                        i = j.indexOf(sogl[v]);
                        if (i ==0) {
                            kol1++;
//                               System.out.println(kol1);

                            System.out.println(j);
                            bw.write("Взято и строчки "+p+" |"+j);
                            bw.newLine();
                        }
                    }
                }

            }
            System.out.println("из первой взято = "+kol2);
            bw.write("из первой взято = "+kol2);
            bw.newLine();
            System.out.println("из второго взято = "+(kol1-kol2));
            bw.write("из второго взято = "+(kol1-kol2));
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Ошибка");
        } finally {
            br.close();
            bw.flush();
            bw.close();
        }
    }
}
