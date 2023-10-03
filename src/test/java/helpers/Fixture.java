package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Fixture extends IOException {
    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeEach
    public void ChromeSetUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opts = new ChromeOptions();
        driver = new ChromeDriver(opts);
        PageFactory.initElements(driver, this);
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
             .xpath("//button[@ng-click=\"addCust()\"]")));
//        wait.until(ExpectedConditions.alertIsPresent());
//        driver.switchTo().alert().accept();
    }

//    @AfterEach
//    void exit(){
//        driver.quit();
//    }

}
