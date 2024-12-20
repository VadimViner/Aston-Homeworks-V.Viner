import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {

    @Test
    public void testFactorialOfNegativeNumber() {

        try {
            FactorialCalculator.calculateFactorial(-1);
            Assert.fail("Ожидалось исключение IllegalArgumentException");
        } catch (IllegalArgumentException exception) {

            Assert.assertEquals(exception.getMessage(), "Число не может быть отрицательным");
        }
    }

    @Test
    public void testFactorialOfZero() {
        Assert.assertEquals(FactorialCalculator.calculateFactorial(0), 1);
    }

    @Test
    public void testFactorialOfPositiveNumber() {

        Assert.assertEquals(FactorialCalculator.calculateFactorial(5), 120);
    }

    @Test
    public void testFactorialOfLargeNumber() {

        Assert.assertEquals(FactorialCalculator.calculateFactorial(20), 2432902008176640000L);
    }
}
