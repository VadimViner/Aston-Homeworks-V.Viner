import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {

    @Test
    public void testFactorialOfNegativeNumber() {
        // Проверка выбрасывания исключения для отрицательного числа
        try {
            FactorialCalculator.calculateFactorial(-1);
            Assert.fail("Ожидалось исключение IllegalArgumentException");
        } catch (IllegalArgumentException exception) {
            // Ожидаемое сообщение об ошибке
            Assert.assertEquals(exception.getMessage(), "Число не может быть отрицательным");
        }
    }

    @Test
    public void testFactorialOfZero() {
        // Факториал 0 равен 1
        Assert.assertEquals(FactorialCalculator.calculateFactorial(0), 1);
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        // Факториал числа 5: 5! = 5 * 4 * 3 * 2 * 1 = 120
        Assert.assertEquals(FactorialCalculator.calculateFactorial(5), 120);
    }

    @Test
    public void testFactorialOfLargeNumber() {
        // Проверка для большого числа, например, для 20
        Assert.assertEquals(FactorialCalculator.calculateFactorial(20), 2432902008176640000L);
    }
}
