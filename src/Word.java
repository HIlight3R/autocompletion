import java.util.Objects;

public class Word implements Comparable<Word> {
    private final String text;
    private final int frequency;

    public Word(String text, int frequency) {
        this.text = text;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Word other) {
        if (this.frequency != other.frequency) {
            return Integer.compare(other.frequency, this.frequency); // По убыванию частоты
        }
        return this.text.compareTo(other.text); // Лексикографический порядок
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return frequency == word.frequency && text.equals(word.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, frequency);
    }

    @Override
    public String toString() {
        return text;
    }
}
