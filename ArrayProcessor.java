public class ArrayProcessor {
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
