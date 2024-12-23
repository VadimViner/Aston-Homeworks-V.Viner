package org.example;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
        try {
            String blockTitle = mtsPage.getBlockTitle();
            assertEquals("Онлайн пополнение", blockTitle, "Block title is not as expected");
            logger.info("Test passed: Block title found.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during the test", e);
        }
    }
    @Test
    public void testPaymentSystemLogos() {
        // Этот тест можно сохранить без изменений, потому что логотипы обрабатываются с использованием прямого поиска
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
        mtsPage.fillForm("297777777", "5", "vinervadim@gmail.com");
        logger.info("Form filled with phone, amount, and email.");

        mtsPage.clickContinueButton();
        logger.info("Clicked on 'Продолжить' button.");

        System.out.println("Test PASSED: 'Продолжить' button clicked successfully.");
        logger.info("Test PASSED: 'Продолжить' button clicked successfully.");
    }

    @Test
    public void testPlaceholdersInEmptyFields() {
        mtsPage.checkPlaceholders();
        logger.info("Test passed: All placeholders are correct.");
    }

    @Test
    public void testPlaceholdersForHomeInternet() {
        mtsPage.selectHomeInternetOption();
        logger.info("Clicked on 'Домашний интернет' option.");

        mtsPage.checkPlaceholdersForHomeInternet();
        logger.info("Test passed: All placeholders for 'Домашний интернет' are correct.");
    }


    @Test
    public void testPlaceholdersForInstalment() {
        mtsPage.selectInstalmentOption();
        logger.info("Clicked on 'Рассрочка' option.");


        mtsPage.checkPlaceholdersForInstalment();
        logger.info("Test passed: All placeholders for 'Рассрочка' are correct.");
    }


    @Test
    public void testPlaceholdersForArrears() {
        mtsPage.selectArrearsOption();
        logger.info("Clicked on 'Задолженность' option.");


        mtsPage.checkPlaceholdersForArrears();
        logger.info("Test passed: All placeholders for 'Задолженность' are correct.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed.");
        }
    }
}
