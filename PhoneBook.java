import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> phoneBook;
    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }
    public void add(String lastName, String phoneNumber) {
        phoneBook.putIfAbsent(lastName, new ArrayList<>());
        phoneBook.get(lastName).add(phoneNumber);
        System.out.println(lastName + ": [" + phoneNumber + "]");
    }

    public List<String> get(String lastName) {
        return phoneBook.getOrDefault(lastName, Collections.singletonList("Нет записей"));
    }

    public void printAll() {
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            String lastName = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(lastName + ": " + phoneNumbers);
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Борисов", "111-11-11");
        phoneBook.add("Порш", "222-22-22");
        phoneBook.add("Стерн", "333-33-33");
        phoneBook.add("Стерн", "444-44-44");
        phoneBook.add("Борисов", "555-55-55");

        phoneBook.printAll();
    }
}