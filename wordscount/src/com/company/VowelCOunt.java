package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class VowelCOunt extends Thread {

    public void vowel_count() {
        File f1 = new File("D:\\IIITG\\s3\\poem.txt");
        String[] words = null; //
        int wc = 0, vw = 0;
        try {
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                words = s.split(" ");
                for (int i = 0; i < words.length; i++) {
                    words[i].toLowerCase();
                    for (int j = 0; j < words[i].length(); j++) {
                        int ch = words[i].charAt(j);
                        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                            vw++;
                        }
                    }
                }

            }
            fr.close();
            System.out.println("Vowels: " + vw);

        } catch (IOException e) {
            System.out.println("File Not Found");
        }
    }
}