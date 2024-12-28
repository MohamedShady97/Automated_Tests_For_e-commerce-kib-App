package app.e_commerce.kib.base;
import app.e_commerce.kib.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver ;

    public WebDriver driverInitializer(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        return driver ;
    }

    @BeforeMethod
    public void setup() {
        driver =new BaseTest().driverInitializer();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

