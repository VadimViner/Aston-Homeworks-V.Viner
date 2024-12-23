package org.example;  // Указываем пакет, в котором находится ваш класс

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {
        // здесь путь к драйверу
        System.setProperty("webdriver.chrome.driver", "/Users/vadimviner/Desktop/L15_nnew/src/main/resources/chromedriver");

        // Настройка ChromeOptions для использования нужного браузера - это Хром для тестов
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/vadimviner/Desktop/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");

        // Создаем драйвер с опциями
        WebDriver driver = new ChromeDriver(options);

        // Открыть гугл
        driver.get("https://www.google.com");

        // напечатать заголовок страницы
        System.out.println(driver.getTitle());

        // Закрыть драйвер
        driver.quit();
    }
}
