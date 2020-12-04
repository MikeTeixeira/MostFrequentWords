package com.mostfrequentwords;

import com.mostfrequentwords.TextCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CustomFileReader {


    private File file;
    private Scanner scanner;

    public CustomFileReader(File file){
        this.file = file;
    }


    /*
     *  Reads all text incoming from the file line by line. Calls the storeInFrequency method during each iteration
     *  to place the incoming words into the Map. Lastly, sorts all of the words in the Map from most frequent to least
     *
     * @param - textCounter object that contains
     * @return void
     */
    public void readTextFromFile(TextCounter textCounter){
        try {

            if(!file.exists())
                throw new FileNotFoundException("File not found.");

            if(!file.getName().endsWith(".txt"))
                throw new FileNotFoundException("File provided does not end with .txt");

            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] words = data.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ");
                textCounter.storeInFrequencyMap(words);
            }

            textCounter.sortByMaxHeap();

            scanner.close();

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
