import java.io.File;

public class WordCountDriver {


    public static void main(String[] args) {

            CustomFileReader customFileReader = new CustomFileReader(new File("./files/input1.txt"));
            TextCounter textCounter = new TextCounter();
            customFileReader.readTextFromFile(textCounter);
            textCounter.printTenMostFrequent();
    }
}
