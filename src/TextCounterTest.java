import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.File;


public class TextCounterTest {

    CustomFileReader customFileReader;
    TextCounter textCounter;


    /*
    * Initialize the application data before commencing tests
    *
    * param - none
    * return - none
    *
    *
     */

    @Before
    public void initializeFiles(){
        customFileReader = new CustomFileReader(new File("./files/input1.txt"));
        textCounter = new TextCounter();
        customFileReader.readTextFromFile(textCounter);
    }



    @Test
    public void topWordOfFileOne(){
        assertEquals(145, textCounter.getMostFrequentWords().get(0).getCount());
    }

    @Test
    public void lastWordOfFileOne(){
        assertEquals(34, textCounter.getMostFrequentWords().get(9).getCount());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void indexOutOfBounds(){

        textCounter.getMostFrequentWords().get(11).getCount();
    }
    


}
