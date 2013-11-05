/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkfiledifferences;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ITCoopAdmin
 */
public class Checkfiledifferences {

    public static final String filea = "onscanner.xml";
    public static final String fileb = "onnetwork.xml";
    static BufferedReader br = null;
    static ArrayList<String> file1;
    static ArrayList<String> file2;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        file1 = new ArrayList<>();
        file2 = new ArrayList<>();
        readFiles();
        checkFiles();

    }

    private static void readFiles() {

        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(filea));

            while ((sCurrentLine = br.readLine()) != null) {
                file1.add(sCurrentLine);
            }
        } catch (IOException e) {
            System.out.println("Error in " + filea + ": " + e);
        }

        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(fileb));

            while ((sCurrentLine = br.readLine()) != null) {
                file2.add(sCurrentLine);
            }
        } catch (IOException e) {
            System.out.println("Error in " + fileb + ": " + e);
        }
    }

    private static void checkFiles() {
        int tot = file2.size();
        if (file1.size() > file2.size()) {
            System.out.println(filea + " size is " + file1.size() + ", " + fileb + " size is " + file2.size());
        } else if (file2.size() > file1.size()) {
            System.out.println(filea + " size is " + file1.size() + ", " + fileb + " size is " + file2.size());
            tot = file1.size();
        }
        int correct = 0;
        for(int i=0;i<tot;i++){
            
            if(file1.get(i).compareTo(file2.get(i))!=0){
                System.out.println(i + " f1: " + file1.get(i) + " \nf2: " + file2.get(i));
            } else {
                correct++;
            }
            
        }
        System.out.println(tot + " lines analized, " + correct + " lines match");
        
    }
}
