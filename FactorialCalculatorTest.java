import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialCalculatorTest {

    @Test
    public void testCalculateFactorial() {
        // Тестирование метода calculateFactorial
        assertEquals(1, FactorialCalculator.calculateFactorial(0));
        assertEquals(120, FactorialCalculator.calculateFactorial(5));
        assertEquals(720, FactorialCalculator.calculateFactorial(6));
    }
}
