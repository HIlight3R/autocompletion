import java.util.PriorityQueue;

public class AutoComplete {
    private final Dictionary dictionary;

    public AutoComplete(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public String[] getSuggestions(String prefix) {
        PriorityQueue<Word> topWords = new PriorityQueue<>();
        dictionary.getWordsStartingWith(prefix).forEach((word, frequency) -> topWords.add(new Word(word, frequency)));

        String[] suggestions = new String[Math.min(10, topWords.size())];
        int i = 0;
        while (!topWords.isEmpty() && i < 10) {
            suggestions[i++] = topWords.poll().toString();
        }
        return suggestions;
    }
}
