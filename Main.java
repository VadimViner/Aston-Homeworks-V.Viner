public class Main {
    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"}
        };

        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "пять", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            // Вызов метода с корректным массивом
            System.out.println("Сумма элементов: " + ArrayProcessor.processArray(validArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            // Вызов метода с массивом неправильного размера
            System.out.println("Сумма элементов: " + ArrayProcessor.processArray(invalidSizeArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            // Вызов метода с массивом с некорректными данными
            System.out.println("Сумма элементов: " + ArrayProcessor.processArray(invalidDataArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
