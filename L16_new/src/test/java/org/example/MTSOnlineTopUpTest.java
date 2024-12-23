package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class MTSOnlineTopUpTest {
    private WebDriver driver;
    private MTSOnlineTopUpPage mtsPage;
    private static final Logger logger = Logger.getLogger(MTSOnlineTopUpTest.class.getName());

    @BeforeEach
    public void setup() {
        // Путь к chromedriver
        System.setProperty("webdriver.chrome.driver", "/Users/vadimviner/Desktop/L16_new/src/main/resources/chromedriver");
        logger.info("WebDriver setup complete.");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by");
        logger.info("Navigating to website...");
        mtsPage = new MTSOnlineTopUpPage(driver);
        mtsPage.acceptCookies();
        logger.info("Cookies accepted.");
    }

    @Test
    public void testBlockTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Онлайн пополнение ']")));
            String blockTitle = mtsPage.getBlockTitle();
            assertEquals("Онлайн пополнение", blockTitle, "Block title is not as expected");
            logger.info("Test passed: Block title found.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during the test", e);
        }
    }

    @Test
    public void testPaymentSystemLogos() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='payment-systems']")));
            logger.info("Payment system logos are visible.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during the test", e);
        }
    }

    @Test
    public void testMoreInfoLink() {
        String currentUrl = mtsPage.getCurrentUrl();
        logger.info("Current URL: " + currentUrl);

        mtsPage.clickMoreInfoLink();
        logger.info("Clicked on 'Подробнее о сервисе' link");

        String newUrl = driver.getCurrentUrl();
        logger.info("New URL: " + newUrl);

        assertNotEquals(currentUrl, newUrl, "URL did not change after clicking the link");
        logger.info("Test passed: 'Подробнее о сервисе' link works as expected.");
    }


    @Test
    public void testContinueButtonWithServicesOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Заполнение формы
        mtsPage.fillForm("297777777", "5", "vinervadim@gmail.com");
        logger.info("Form filled with phone, amount, and email.");

        // Нажатие на кнопку "Продолжить"
        mtsPage.clickContinueButton();
        logger.info("Clicked on 'Продолжить' button.");

        // Переключаемся на iframe, где содержится новое окно
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[8]/div/iframe")));
        driver.switchTo().frame(iframe);
        logger.info("Switched to iframe.");

        // поиск элементов в фрейме
        try {
            // Проверка суммы
            WebElement amountElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/span[1]")));
            String amount = amountElement.getText();
            assertEquals("5.00 BYN", amount, "Amount is not displayed correctly on the button");

            // Проверка номера телефона
            WebElement phoneNumberElement = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span"));
            String phoneNumber = phoneNumberElement.getText();
            assertTrue(phoneNumber.contains("375297777777"), "Phone number is not displayed correctly");

            // Проверка плейсхолдера для "Номер карты"
            WebElement cardNumberPlaceholder = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/label"));
            assertEquals("\u041D\u043E\u043C\u0435\u0440 \u043A\u0430\u0440\u0442\u044B", cardNumberPlaceholder.getText(), "Placeholder for card number is incorrect");

            // Проверка наличия иконок платёжных систем
            WebElement paymentIcons = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]"));
            assertTrue(paymentIcons.isDisplayed(), "Payment system icons are not displayed");

            // Проверка иконки Visa
            WebElement visaIcon = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[1]"));
            assertTrue(visaIcon.isDisplayed(), "Visa icon is not displayed");

            // Проверка иконки Mastercard
            WebElement mastercardIcon = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[2]"));
            assertTrue(mastercardIcon.isDisplayed(), "Mastercard icon is not displayed");

            // Проверка иконки Belkart
            WebElement belkartIcon = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[3]"));
            assertTrue(belkartIcon.isDisplayed(), "Belkart icon is not displayed");

            // Проверка динамического изменения иконок Мир
            WebElement mirIcon;
            for (int attempt = 0; attempt < 2; attempt++) { // Попробуем проверить иконки "Мир" дважды
                mirIcon = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div/img[1]"));
                assertTrue(mirIcon.isDisplayed(), "Mir icon is not displayed at attempt " + (attempt + 1));

                logger.info("Mir icon validated (attempt " + (attempt + 1) + "): " + mirIcon.getAttribute("src"));

                // Ждём смены иконки (имитация ожидания)
                Thread.sleep(2000);
            }

            logger.info("Test passed: All elements inside the iframe are validated.");

        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during iframe element validation", e);
            fail("Error occurred during iframe element validation.");
        }

        // Возвращаемся в основной документ
        driver.switchTo().defaultContent();
        logger.info("Switched back to the main content.");
    }


    @Test
    public void testPlaceholdersInEmptyFields() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='connection-phone']")));
            mtsPage.checkPlaceholders();
            logger.info("Test passed: All placeholders are correct.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during the test", e);
        }
    }

    @Test
    public void testPlaceholdersForHomeInternet() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button")));
            mtsPage.selectHomeInternetOption();
            mtsPage.checkPlaceholdersForHomeInternet();
            logger.info("Test passed: All placeholders for 'Домашний интернет' are correct.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during the test", e);
        }
    }

    @Test
    public void testPlaceholdersForInstalment() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button")));
            mtsPage.selectInstalmentOption();
            mtsPage.checkPlaceholdersForInstalment();
            logger.info("Test passed: All placeholders for 'Рассрочка' are correct.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during the test", e);
        }
    }

    @Test
    public void testPlaceholdersForArrears() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button")));
            mtsPage.selectArrearsOption();
            mtsPage.checkPlaceholdersForArrears();
            logger.info("Test passed: All placeholders for 'Задолженность' are correct.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during the test", e);
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed.");
        }
    }
}
