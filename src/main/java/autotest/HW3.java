package autotest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HW3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://saas.profilum.ru/login");

        driver.findElement(By.xpath("//input[@id='email']"))
                .sendKeys("testPu37YO@2022.ru");
        driver.findElement(By.xpath("//input[@id='password']"))
                .sendKeys("MaOY4v");
        driver.findElement(By.xpath("//div[@class='w-center-content']"))
                .click();
        driver.findElement(By.xpath("//div[@class='user-name']"))
                .click();
        driver.findElement(By.xpath("//a[@class='exit w-inline-block']"))
                .click();
        driver.quit();
    }
}
