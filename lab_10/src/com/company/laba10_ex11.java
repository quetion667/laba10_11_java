package com.company;

import java.io.*;

public class laba10_ex11 {
    public static void main(String[] var0) throws IOException {
        BufferedReader var1 = null;
        BufferedWriter var2 = null;

        try {
            var1 = new BufferedReader(new InputStreamReader(new FileInputStream("MyFile1.txt"), "UTF-8"));
            var2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("MyFile2.txt"), "UTF-8"));
            int var3 = 0;

            String var4;
            while((var4 = var1.readLine()) != null) {
                ++var3;
                boolean var5 = true;
                if (var3 != 1) {
                    int var11 = var4.indexOf(45);
                    if (var11 != 0) {
                        System.out.println(var3 + ": " + var4);
                        var2.write(var3 + ": " + var4);
                        var2.newLine();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Исключение" +e );
        } finally {
            var1.close();
            var2.flush();
            var2.close();
        }

    }
}
