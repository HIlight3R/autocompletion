import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создание словаря
        Dictionary dictionary = new Dictionary();

        // Чтение слов из словаря
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String word = input[0];
            int frequency = Integer.parseInt(input[1]);
            dictionary.addWord(word, frequency);
        }

        // Создание авто-дополнения
        AutoComplete autoComplete = new AutoComplete(dictionary);

        // Чтение запросов
        int m = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String prefix = scanner.nextLine();
            String[] suggestions = autoComplete.getSuggestions(prefix);

            for (String suggestion : suggestions) {
                result.append(suggestion).append('\n');
            }
            result.append('\n');
        }

        // Вывод результата
        System.out.print(result);
    }
}
