/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filecomparator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * MWatkins Nov 20, 2013
 */
public class FileComparator { public static final String filea = "shipperdata.txt";
    public static final String fileb = "ustor.txt";
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
        //checkFiles();
        checkASubsetB();

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
    private static void checkASubsetB(){
        int tot = 0;
        int totInv = 0;
        for(int i=0;i<file1.size();i++){
            boolean found = false;
            for(int j=0;j<file2.size();j++){
                if(file1.get(i).compareToIgnoreCase(file2.get(j))==0){
                    found = true;
                }
            }
            if(!found){
                System.out.println(filea + " entry \"" + file1.get(i) + "\" could not be found in " + fileb);
                totInv++;
            } else {
               tot++; 
            }
        }
        System.out.println("Total matches: " + tot + "; Total non-matches: " + totInv + ";");
        System.out.println(filea + " size: " + file1.size() + "; " + fileb + " size: " + file2.size() +";");
    }
}
