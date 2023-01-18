package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class wordscount extends Thread {

    public void word_count() {
        File f1 = new File("D:\\IIITG\\s3\\poem.txt");
        String[] words = null; //
        int wc = 0, vw = 0;
        try {
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                words = s.split(" ");
                if (words.length != 1)
                    wc = wc + words.length;

            }
            fr.close();
            System.out.println("Words: " + wc);

        } catch (IOException e) {
            System.out.println("File Not Found");
        }
    }
}