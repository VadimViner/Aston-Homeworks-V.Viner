package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MTSOnlineTopUpTest {
    private WebDriver driver;
    private static final Logger logger = Logger.getLogger(MTSOnlineTopUpTest.class.getName());

    @BeforeEach
    public void setup() {
        try {
            WebDriverManager.chromedriver().setup();
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
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during setup", e);
        }
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
        try {
            String[][] logos = {
                    {"//img[@alt='Visa']", "Visa"},
                    {"//img[@alt='Verified By Visa']", "Verified By Visa"},
                    {"//img[@alt='MasterCard']", "MasterCard"},
                    {"//img[@alt='MasterCard Secure Code']", "MasterCard Secure Code"},
                    {"//img[@alt='бeлкapт']", "бeлкapт"}
            };

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            for (String[] logo : logos) {
                WebElement logoElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(logo[0])));
                assertNotNull(logoElement, "Logo not found: " + logo[1]);
                logger.info("Logo found: " + logo[1]);
            }

            logger.info("All payment system logos are present.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during the test", e);
            Assertions.fail("Test failed due to an exception.");
        }
    }

    @Test
    public void testMoreInfoLink() {
        try {
            // Ищем ссылку "Подробнее о сервисе"
            WebElement moreInfoLink = driver.findElement(By.xpath("//a[normalize-space()='Подробнее о сервисе']"));

            // Проверяем, что ссылка существует
            assertNotNull(moreInfoLink, "Link 'Подробнее о сервисе' not found");

            // Получаем текущий URL перед кликом
            String currentUrl = driver.getCurrentUrl();
            logger.info("Current URL: " + currentUrl);

            // Кликаем по ссылке
            moreInfoLink.click();
            logger.info("Clicked on 'Подробнее о сервисе' link");

            // Ждем, пока URL изменится
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));

            // Проверяем, что URL изменился
            String newUrl = driver.getCurrentUrl();
            logger.info("New URL: " + newUrl);

            assertNotEquals(currentUrl, newUrl, "URL did not change after clicking the link");
            logger.info("Test passed: 'Подробнее о сервисе' link works as expected.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during the test", e);
            Assertions.fail("Test failed due to an exception.");
        }
    }

    @Test
    public void testContinueButtonWithServicesOption() {
        try {
            // Заполняем поле с номером телефона
            WebElement phoneNumberField = driver.findElement(By.xpath("//input[@name='phoneNumber']"));
            phoneNumberField.sendKeys("297777777");  // Вводим номер для теста
            logger.info("Entered phone number: 297777777");

            // Выбираем вариант "Услуги связи"
            WebElement servicesOption = driver.findElement(By.xpath("//label[contains(text(), 'Услуги связи')]"));
            servicesOption.click();
            logger.info("Selected 'Услуги связи' option.");

            // Находим кнопку "Продолжить" и кликаем по ней
            WebElement continueButton = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
            continueButton.click();
            logger.info("Clicked on 'Продолжить' button.");

            // Ждем, пока появится новый элемент (следующий шаг)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement nextStepElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='next-step']")));  // Замените на реальный элемент следующего шага

            // Проверяем, что элемент следующего шага существует
            assertNotNull(nextStepElement, "Next step element is not present after clicking 'Продолжить'");
            logger.info("Test passed: 'Продолжить' button works as expected.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during the test", e);
            Assertions.fail("Test failed due to an exception.");
        }
    }

    @AfterEach
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
                logger.info("Browser closed.");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during browser shutdown", e);
        }
    }
}
