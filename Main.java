import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {
        // Указываем путь к драйверу
        System.setProperty("webdriver.chrome.driver", "/Users/Users/vadimviner/Desktop/L15_nnew/src/main/resources/chromedriver");

        // Настроим ChromeOptions для использования нужного браузера
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/vadimviner/Desktop/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");

        // Создаем драйвер с опциями
        WebDriver driver = new ChromeDriver(options);

        // Открываем сайт
        driver.get("https://www.google.com");

        // Печатаем заголовок страницы
        System.out.println(driver.getTitle());

        // Закрываем драйвер
        driver.quit();
    }
}
