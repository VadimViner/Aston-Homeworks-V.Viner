import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {

    @Test
    public void testCalculateFactorialPositive() {
        Assert.assertEquals(FactorialCalculator.calculateFactorial(5), 120);
        Assert.assertEquals(FactorialCalculator.calculateFactorial(3), 6);
    }

    @Test
    public void testCalculateFactorialZero() {
        Assert.assertEquals(FactorialCalculator.calculateFactorial(0), 1);
    }

    @Test
    public void testCalculateFactorialNegative() {

        try {
            FactorialCalculator.calculateFactorial(-1);
            Assert.fail("Должно быть выброшено исключение для отрицательных чисел");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "Число не может быть отрицательным");
        }
    }
}
