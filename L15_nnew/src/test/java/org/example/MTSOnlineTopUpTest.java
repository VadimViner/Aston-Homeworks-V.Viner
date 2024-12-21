package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class MTSOnlineTopUpTest {
    private WebDriver driver;
    private static final Logger logger = Logger.getLogger(MTSOnlineTopUpTest.class.getName());

    @BeforeEach
    public void setup() {
        // путь к chromedriver
        System.setProperty("webdriver.chrome.driver", "/Users/vadimviner/Desktop/L15_nnew/src/main/resources/chromedriver");
        logger.info("WebDriver setup complete.");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by");
        logger.info("Navigating to website...");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Принять')]")));
        acceptCookiesButton.click();
        logger.info("Cookies accepted.");
    }

    @Test
    public void testBlockTitle() {
        try {
            WebElement blockTitle = driver.findElement(By.xpath("//h2[normalize-space()='Онлайн пополнение ']"));
            assertEquals("Онлайн пополнение", blockTitle.getText(), "Block title is not as expected");
            logger.info("Test passed: Block title found.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during the test", e);
        }
    }

    @Test
    public void testPaymentSystemLogos() {
        String[][] logos = {
                {"//img[@alt='Visa']", "Visa"},
                {"//img[@alt='Verified By Visa']", "Verified By Visa"},
                {"//img[@alt='MasterCard']", "MasterCard"},
                {"//img[@alt='MasterCard Secure Code']", "MasterCard Secure Code"},
                {"//img[@alt='Белкарт']", "Белкарт"}
        };

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (String[] logo : logos) {
            WebElement logoElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(logo[0])));
            assertNotNull(logoElement, "Logo not found: " + logo[1]);
            logger.info("Logo found: " + logo[1]);
        }

        logger.info("All payment system logos are present.");
    }

    @Test
    public void testMoreInfoLink() {
        WebElement moreInfoLink = driver.findElement(By.xpath("//a[normalize-space()='Подробнее о сервисе']"));
        assertNotNull(moreInfoLink, "Link 'Подробнее о сервисе' not found");

        String currentUrl = driver.getCurrentUrl();
        logger.info("Current URL: " + currentUrl);

        moreInfoLink.click();
        logger.info("Clicked on 'Подробнее о сервисе' link");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));

        String newUrl = driver.getCurrentUrl();
        logger.info("New URL: " + newUrl);

        assertNotEquals(currentUrl, newUrl, "URL did not change after clicking the link");
        logger.info("Test passed: 'Подробнее о сервисе' link works as expected.");
    }

    @Test
    public void testContinueButtonWithServicesOption() {
        // Ввод номера телефона
        WebElement phoneNumberField = driver.findElement(By.xpath("//*[@id='connection-phone']"));
        phoneNumberField.sendKeys("297777777");
        logger.info("Entered phone number: 297777777");

        // Ввод суммы
        WebElement sumField = driver.findElement(By.xpath("//*[@id='connection-sum']"));
        sumField.sendKeys("5");
        logger.info("Entered amount: 5 Rub.");

        // Ввод email
        WebElement emailField = driver.findElement(By.xpath("//*[@id='connection-email']"));
        emailField.sendKeys("vinervadim@gmail.com");
        logger.info("Entered email: vinervadim@gmail.com");

        // Нажатие кнопки "Продолжить"
        WebElement continueButton = driver.findElement(By.xpath("//*[@id='pay-connection']/button"));
        continueButton.click();
        logger.info("Clicked on 'Продолжить' button.");

        // Тест успешен как только произошел клик
        System.out.println("Test PASSED: 'Продолжить' button clicked successfully.");
        logger.info("Test PASSED: 'Продолжить' button clicked successfully.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed.");
        }
    }
}
