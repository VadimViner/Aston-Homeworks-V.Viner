public class FactorialCalculator {

    // Метод для вычисления факториала числа
    public static long calculateFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Число не может быть отрицательным");
        }
        if (number == 0) {
            return 1;  // Факториал 0 равен 1
        }
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        // Пример использования
        System.out.println("Факториал числа 5: " + calculateFactorial(5));
    }
}
