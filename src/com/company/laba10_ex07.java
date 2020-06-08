package com.company;

import java.io.*;

public class laba10_ex07 {
    public static void main(String[] var0) throws IOException {
        BufferedReader br = null;
        BufferedWriter out = null;

        try {
            FileReader fr = new FileReader("C:\\MyFile1.txt");
            br = new BufferedReader(fr, 1024);
            out = new BufferedWriter(new FileWriter("C:\\MyFile2.txt"));
            int lineCount = 0;

            String s;
            while ((s = br.readLine()) != null) {
                lineCount++;
                System.out.println(lineCount + ":" + s);
                out.write(s);
                out.newLine();
            }
        } catch (IOException e) {
            System.out.println("error");
        }
        finally
        {
            br.close();
            out.flush();
            out.close();
        }
    }
}

