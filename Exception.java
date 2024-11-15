class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}

class Main {
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
            System.out.println("Сумма элементов: " + processArray(validArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            // Вызов метода с массивом неправильного размера
            System.out.println("Сумма элементов: " + processArray(invalidSizeArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            // Вызов метода с массивом с некорректными данными
            System.out.println("Сумма элементов: " + processArray(invalidDataArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверка размера массива
        if (array.length != 4) {
            throw new MyArraySizeException("Ожидается массив размером 4x4, но получен " + array.length + "x" + array[0].length);
        }
        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException("Ожидается массив размером 4x4, но одна из строк имеет длину " + row.length);
            }
        }

        int sum = 0;
        // Обработка данных массива
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Некорректные данные в ячейке [" + i + "][" + j + "]: \"" + array[i][j] + "\"");
                }
            }
        }
        return sum;
    }
}
