package app.e_commerce.kib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class P03_EditProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By titleInputLocator   = By.cssSelector("input[name=\"title\"]");
    private By submitButtonLocator = By.cssSelector("[type=\"submit\"]");

    public P03_EditProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public P03_EditProductPage updateTitle(String newTitle) throws InterruptedException {
        Thread.sleep(5000);
        WebElement titleInput = driver.findElement(titleInputLocator);
        titleInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        titleInput.sendKeys(Keys.BACK_SPACE);
        titleInput.clear();
        titleInput.sendKeys(newTitle);
        return this;
    }

    public P01_HomePage submitChanges() {
        driver.findElement(submitButtonLocator).click();
        return new P01_HomePage(driver);
    }

}
