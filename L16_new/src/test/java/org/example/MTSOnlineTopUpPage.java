package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MTSOnlineTopUpPage {
    private WebDriver driver;
    public MTSOnlineTopUpPage(WebDriver driver) {
        this.driver = driver;
    }
    // Метод для принятия cookies
    public void acceptCookies() {
        WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[contains(text(), 'Принять')]"));
        acceptCookiesButton.click();
    }
    // Метод для получения заголовка блока
    public String getBlockTitle() {
        WebElement blockTitle = driver.findElement(By.xpath("//h2[normalize-space()='Онлайн пополнение ']"));
        return blockTitle.getText();
    }
    // Метод для получения текущего URL
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    // Метод для клика по ссылке "Подробнее о сервисе"
    public void clickMoreInfoLink() {
        WebElement moreInfoLink = driver.findElement(By.xpath("//a[normalize-space()='Подробнее о сервисе']"));
        moreInfoLink.click();
    }

    // Метод для заполнения формы
    public void fillForm(String phoneNumber, String amount, String email) {
        WebElement phoneNumberField = driver.findElement(By.xpath("//*[@id='connection-phone']"));
        phoneNumberField.sendKeys(phoneNumber);
        WebElement sumField = driver.findElement(By.xpath("//*[@id='connection-sum']"));
        sumField.sendKeys(amount);
        WebElement emailField = driver.findElement(By.xpath("//*[@id='connection-email']"));
        emailField.sendKeys(email);
    }

    // Метод для клика по кнопке "Продолжить"
    public void clickContinueButton() {
        WebElement continueButton = driver.findElement(By.xpath("//*[@id='pay-connection']/button"));
        continueButton.click();
    }

    // Метод для проверки плейсхолдеров
    public void checkPlaceholders() {
        WebElement phoneField = driver.findElement(By.xpath("//*[@id='connection-phone']"));
        String phonePlaceholder = phoneField.getAttribute("placeholder");
        assertEquals("Номер телефона", phonePlaceholder, "Placeholder for phone number is incorrect");

        WebElement sumField = driver.findElement(By.xpath("//*[@id='connection-sum']"));
        String sumPlaceholder = sumField.getAttribute("placeholder");
        assertEquals("Сумма", sumPlaceholder, "Placeholder for amount is incorrect");

        WebElement emailField = driver.findElement(By.xpath("//*[@id='connection-email']"));
        String emailPlaceholder = emailField.getAttribute("placeholder");
        assertEquals("E-mail для отправки чека", emailPlaceholder, "Placeholder for email is incorrect");
    }

    public void checkPlaceholdersForHomeInternet() {
        WebElement phoneField = driver.findElement(By.xpath("//*[@id='internet-phone']"));
        String phonePlaceholder = phoneField.getAttribute("placeholder");
        assertEquals("Номер абонента", phonePlaceholder, "Placeholder for phone number is incorrect");
        WebElement sumField = driver.findElement(By.xpath("//*[@id='internet-sum']"));
        String sumPlaceholder = sumField.getAttribute("placeholder");
        assertEquals("Сумма", sumPlaceholder, "Placeholder for amount is incorrect");
        WebElement emailField = driver.findElement(By.xpath("//*[@id='internet-email']"));
        String emailPlaceholder = emailField.getAttribute("placeholder");
        assertEquals("E-mail для отправки чека", emailPlaceholder, "Placeholder for email is incorrect");
    }

    public void selectHomeInternetOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Ожидаем, пока выпадающее меню станет доступным
        WebElement dropdownButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button")));
        dropdownButton.click();  // Открываем выпадающее меню

        // Ожидаем, пока опция "Домашний интернет" станет доступной
        WebElement homeInternetOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p")));
        homeInternetOption.click();  // Выбираем "Домашний интернет"
    }

    public void checkPlaceholdersForInstalment() {
        WebElement accountField = driver.findElement(By.xpath("//*[@id='score-instalment']"));
        String accountPlaceholder = accountField.getAttribute("placeholder");
        assertEquals("Номер счета на 44", accountPlaceholder, "Placeholder for account number is incorrect");

        WebElement sumField = driver.findElement(By.xpath("//*[@id='instalment-sum']"));
        String sumPlaceholder = sumField.getAttribute("placeholder");
        assertEquals("Сумма", sumPlaceholder, "Placeholder for amount is incorrect");

        WebElement emailField = driver.findElement(By.xpath("//*[@id='instalment-email']"));
        String emailPlaceholder = emailField.getAttribute("placeholder");
        assertEquals("E-mail для отправки чека", emailPlaceholder, "Placeholder for email is incorrect");
    }
    public void selectInstalmentOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Ожидаем, пока выпадающее меню станет доступным
        WebElement dropdownButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button")));
        dropdownButton.click(); // Открываем выпадающее меню

        // Ожидаем, пока опция "Рассрочка" станет доступной
        WebElement instalmentOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p")));
        instalmentOption.click(); // Выбираем "Рассрочка"
    }
    public void checkPlaceholdersForArrears() {
        // Проверяем плейсхолдер поля "Номер счета на 2073"
        WebElement accountNumberField = driver.findElement(By.xpath("//*[@id='score-arrears']"));
        String accountNumberPlaceholder = accountNumberField.getAttribute("placeholder");
        assertEquals("Номер счета на 2073", accountNumberPlaceholder, "Placeholder for account number is incorrect");

        // Проверяем плейсхолдер поля "Сумма"
        WebElement sumField = driver.findElement(By.xpath("//*[@id='arrears-sum']"));
        String sumPlaceholder = sumField.getAttribute("placeholder");
        assertEquals("Сумма", sumPlaceholder, "Placeholder for amount is incorrect");

        // Проверяем плейсхолдер поля "E-mail для отправки чека"
        WebElement emailField = driver.findElement(By.xpath("//*[@id='arrears-email']"));
        String emailPlaceholder = emailField.getAttribute("placeholder");
        assertEquals("E-mail для отправки чека", emailPlaceholder, "Placeholder for email is incorrect");
    }

    public void selectArrearsOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Ожидаем, пока выпадающее меню станет доступным
        WebElement dropdownButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button")));
        dropdownButton.click(); // Открываем выпадающее меню

        // Ожидаем, пока опция "Задолженность" станет доступной
        WebElement arrearsOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p")));
        arrearsOption.click(); // Выбираем "Задолженность"
    }
}
