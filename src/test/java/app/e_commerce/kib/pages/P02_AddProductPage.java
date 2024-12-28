package app.e_commerce.kib.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class P02_AddProductPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private By fileInput        = By.xpath("//label[contains(@class, 'media-uploader')]/input[@type='file']");
    private By titleField       = By.name("title");
    private By descriptionField = By.cssSelector("input[name='description']");
    private By priceField       = By.name("price");
    private By submitButton     = By.xpath("//button[text()='Create Product']");


    public P02_AddProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public P02_AddProductPage uploadFile(String filePath) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(fileInput).sendKeys(filePath);
        return this;
    }

    public P02_AddProductPage enterProductDetails(String title, String description, String price) {
        driver.findElement(titleField).sendKeys(title);
        driver.findElement(descriptionField).sendKeys(description);
        driver.findElement(priceField).sendKeys(price);
        return this;
    }

    public P01_HomePage clickSubmitButton() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(submitButton).click();
        return new P01_HomePage(driver);
    }


}
