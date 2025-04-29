import java.util.HashMap;
import java.util.Map;

public class Words {
    public static void main(String[] arg) {
        String[] newWords = {"Яблоко", "Кресло", "Кресло", "Картина", "Стрела", "Кассета", "Рука", "Круг", "Кресло", "Солнце", "Кассета", "Кошка", "Катана", "Стрела", "Милан"};

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : newWords) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Количество повторений каждого слова:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}