package com.mostfrequentwords.test;

import com.mostfrequentwords.CustomFileReader;
import com.mostfrequentwords.TextCounter;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.File;


public class TextCounterTest {

    CustomFileReader customFileReader;
    TextCounter textCounter;


    /*
    * Retrieve the most frequent word in the list
    *
    * @param - none
    * @return - none
    *
     */

    @Test
    public void mostFrequentWordOfFileOne(){
        customFileReader = new CustomFileReader(new File("./files/input1.txt"));
        textCounter = new TextCounter();
        customFileReader.readTextFromFile(textCounter);
        assertEquals(145, textCounter.getMostFrequentWords().get(0).getCount());
    }

    /*
     * Retrieve the last frequent word in the list
     *
     * @param - none
     * @return - none
     *
     */
    @Test
    public void tenthFrequentWordOfFileOne(){
        customFileReader = new CustomFileReader(new File("./files/input1.txt"));
        textCounter = new TextCounter();
        customFileReader.readTextFromFile(textCounter);
        assertEquals(34, textCounter.getMostFrequentWords().get(9).getCount());
    }

    /*
     * The list size is set to a final int value of 10. Produces IndexOutOfBounds
     *
     * @param - none
     * @return - none
     *
     */

    @Test(expected = IndexOutOfBoundsException.class)
    public void wordIndexOutOfBounds(){
        customFileReader = new CustomFileReader(new File("./files/input1.txt"));
        textCounter = new TextCounter();
        customFileReader.readTextFromFile(textCounter);

        textCounter.getMostFrequentWords().get(11);
    }

    /*
     * Provided file does not exist. Should produce File not found.
     *
     * param - none
     * return - none
     *
     */
    @Test
    public void fileNotFound(){
        customFileReader = new CustomFileReader(new File(""));
        textCounter = new TextCounter();
        customFileReader.readTextFromFile(textCounter);

        assertEquals("File not found.", System.getLogger("File not found.").getName());
    }

    /*
     * Provided file exists but not in .txt
     *
     * param - none
     * return - none
     *
     */

    @Test
    public void fileNotTxtFormat(){
        customFileReader = new CustomFileReader(new File("./files/input.pdf"));
        textCounter = new TextCounter();
        customFileReader.readTextFromFile(textCounter);

        assertEquals("File provided does not end with .txt", System.getLogger("File provided does not end with .txt").getName());
    }
    


}
