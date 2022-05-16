package autotest.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class SetupDriverExamples {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        //chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("user-agent=Googlebot/2.1 (+https://www.google.com/bot.html)");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.google.com");

        driver.manage().window().setSize(new Dimension(320, 800));
        driver.manage().window().maximize();


        driver.switchTo().newWindow(WindowType.TAB);

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://ya.ru");

    }
}
