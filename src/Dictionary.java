import java.util.Map;
import java.util.TreeMap;

public class Dictionary {
    private final TreeMap<String, Integer> words = new TreeMap<>();

    public void addWord(String word, int frequency) {
        words.put(word, frequency);
    }

    public Map<String, Integer> getWordsStartingWith(String prefix) {
        return words.tailMap(prefix).entrySet()
                .stream()
                .filter(entry -> entry.getKey().startsWith(prefix))
                .limit(10) // Оптимизация: сразу ограничить до 10 слов
                .collect(TreeMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), TreeMap::putAll);
    }
}
