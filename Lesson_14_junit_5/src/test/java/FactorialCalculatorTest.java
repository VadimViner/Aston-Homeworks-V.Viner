import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialCalculatorTest {

    @Test
    public void testFactorialOfNegativeNumber() {
        // Проверка выбрасывания исключения для отрицательного числа
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.calculateFactorial(-1);
        });
        // Ожидаемое сообщение об ошибке
        assertEquals("Число не может быть отрицательным", exception.getMessage());
    }

    @Test
    public void testFactorialOfZero() {
        // Факториал 0 равен 1
        assertEquals(1, FactorialCalculator.calculateFactorial(0));
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        // Факториал числа 5: 5! = 5 * 4 * 3 * 2 * 1 = 120
        assertEquals(120, FactorialCalculator.calculateFactorial(5));
    }

    @Test
    public void testFactorialOfLargeNumber() {
        // Проверка для большого числа, например, для 20
        assertEquals(2432902008176640000L, FactorialCalculator.calculateFactorial(20));
    }
}
