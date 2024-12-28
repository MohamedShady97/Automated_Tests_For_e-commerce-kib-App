package app.e_commerce.kib.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class P01_HomePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private By addProductIcon       = By.cssSelector("svg[class='cursor-pointer h-7 w-7']");
    private By editButtonLocator    = By.xpath("//a[@href='/edit/oppo-phone']");
    private By productListLocator   = By.cssSelector(".sc-kpDqfm");
    private By productNameLocator   = By.cssSelector("div[class=\"sc-jXbUNg eZFFTp flex flex-col p-4\"]");
    private By searchBoxLocator     = By.xpath("//input[@placeholder='Search for products ...']");
    private By searchResultsLocator = By.xpath("//div[contains(@class, 'cursor-pointer')]");
    private By deleteButtonLocator  = By.xpath("//div[contains(@class, 'sc-jXbUNg')]//div[text()=\"oppo phone updated\"]//..//button[contains(@class, 'sc-jEACwC')]");
    private By productLocator       = By.xpath("//div[contains(text(),'oppo phone updated')]");


    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public P02_AddProductPage clickAddProductIcon() {
        driver.findElement(addProductIcon).click();
        return new P02_AddProductPage(driver);
    }
    public P03_EditProductPage clickEditButton(String productName) throws InterruptedException {
        isProductDisplayed(productName);
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(editButtonLocator));
        editButton.click();
        return new P03_EditProductPage(driver);
    }


    public boolean isProductDisplayed(String productName) throws InterruptedException {
        Thread.sleep(3000);
        boolean flag = false; // element is found
        JavascriptExecutor js = (JavascriptExecutor) driver;
        while (flag!=true) {
            // Scroll down
            js.executeScript("window.scrollBy(0, 5000);");
            // Wait for the products to load
            try {
                Thread.sleep(1000); // Small delay to allow content to load
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            List<WebElement> productList = wait.until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(productListLocator));

            for (WebElement product : productList) {
                String displayedProductName = product.getText();
                if (displayedProductName.equals(productName)) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public P01_HomePage enterSearchQuery(String productName) throws InterruptedException {
        WebElement searchBox = driver.findElement(searchBoxLocator);
        searchBox.clear(); // Clear any previous input
        searchBox.sendKeys(productName);
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        return this;
    }

    public List<WebElement> getSearchResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultsLocator));
        return driver.findElements(searchResultsLocator);
    }

    public boolean verifySingleSearchResult(String expectedProductName) {
        List<WebElement> searchResults = getSearchResults();

        if (searchResults.size() == 1) {
            String displayedProductName = searchResults.get(0).getText();
            return displayedProductName.equals(expectedProductName);
        }
        return false;
    }

    public boolean verifyResultsContainKeyword(String keyword) {
        List<WebElement> searchResults = getSearchResults();
        for (WebElement result : searchResults) {
            String productName = result.getText().trim();
            if (!productName.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Mismatch: Product '" + productName + "' does not contain the keyword '" + keyword + "'.");
                return false;
            }
        }
        return true;
    }

    public P01_HomePage clickDeleteButton() throws InterruptedException {
        String productName = "oppo phone updated";
        P01_HomePage homePage = new P01_HomePage(driver);
        homePage.isProductDisplayed(productName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator));
        driver.findElement(deleteButtonLocator).click();
        return this;
    }

    public boolean verifyproductisdeleted(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(productLocator));
        boolean isDeleted = driver.findElements(productLocator).isEmpty();
        return isDeleted;
    }
}
