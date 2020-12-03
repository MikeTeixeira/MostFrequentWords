import java.util.*;

public class TextCounter {

    // Used to keep track of the number of words that get added to the mostFrequentWords list
    private final int numberOfWordsToCount = 10;

    //Sorts the text by most frequently seen words
    private PriorityQueue<Word> maxHeapWordTextCounter;

    //Holds all words seen for quick get/put operations
    private Map<String, Word> frequencyWordMap;

    //Holds the top frequent words
    private ArrayList<Word> mostFrequentWords;


    public TextCounter(){
       maxHeapWordTextCounter = new PriorityQueue<>((wordOne, wordTwo) -> Integer.compare(wordTwo.getCount(), wordOne.getCount()));
       frequencyWordMap = new HashMap<>();
       mostFrequentWords = new ArrayList<>();
    }


    /*
     *  Print the top 10 most frequently used words
     *
     * @param - none
     * @return - void
     */

    public void printTenMostFrequent() {
        for(TextCounter textCounter : mostFrequentWords){
            System.out.println(textCounter);
        }
    }

    /*
     *  Remove the top 10 most frequently used words and store them in the mostFrequentWords List
     *
     * @param - none
     * @return - void
     */

    public void storeMostFrequentInList() {
        while(mostFrequentWords.size() < numberOfWordsToCount && maxHeapWordTextCounter.size() > 0)
            mostFrequentWords.add(maxHeapWordTextCounter.poll());
    }


    /*
     *  Iterate through all of the words in a single line and store their frequency in a Map
     *
     * @param String[] words - line of words read from the text file
     * @return -  void
     */

    public void storeInFrequencyMap(String[] words) {
        Arrays.stream(words).forEach(word -> {
            if (word.length() == 0)
                return;

            Word wordToUpdate = frequencyWordMap.getOrDefault(word, new Word(word, 0));
            wordToUpdate.setCount(wordToUpdate.getCount() + 1);
            frequencyWordMap.put(wordToUpdate.getWord(), wordToUpdate);
        });

    }
    /*
     *  Iterate through the Map Entries and add each one to the Max Heap. Lastly,
     *  call storeMostFrequentInList()
     *
     * @param - none
     * @return - void
     */

    public void sortByMaxHeap() {
        for(Map.Entry<String, Word> entry : frequencyWordMap.entrySet())
            maxHeapWordTextCounter.add(entry.getValue());

        storeMostFrequentInList();
    }

    public PriorityQueue<Word> getMaxHeapWordTextCounter() {
        return maxHeapWordTextCounter;
    }

    public ArrayList<Word> getMostFrequentWords() {
        return mostFrequentWords;
    }
}
