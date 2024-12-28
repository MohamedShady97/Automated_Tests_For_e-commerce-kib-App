package app.e_commerce.kib.testcases;

import app.e_commerce.kib.base.BaseTest;
import app.e_commerce.kib.pages.P01_HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_AddProduct extends BaseTest {

    @Test
    public void AddProduct() throws InterruptedException {

        String productName = "oppo phone";
        String description = "This is the description of the oppo phone";
        String price       = "5000";
        String filePath    = System.getProperty("user.dir")+ "/src/main/resources/oppo.jpg";

        P01_HomePage HomePage = new P01_HomePage(driver);
        boolean isProductAdded = HomePage.clickAddProductIcon()
                                         .uploadFile(filePath)
                                         .enterProductDetails(productName, description, price)
                                         .clickSubmitButton()
                                         .isProductDisplayed(productName);

        Assert.assertTrue(isProductAdded, "The product was not added successfully.");

    }

}
