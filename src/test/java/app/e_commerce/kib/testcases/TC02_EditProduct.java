package app.e_commerce.kib.testcases;

import app.e_commerce.kib.base.BaseTest;
import app.e_commerce.kib.pages.P01_HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_EditProduct extends BaseTest {
    @Test
    public void EditProduct() throws InterruptedException {
        String oldTitle = "oppo phone";
        String newTitle = "oppo phone updated";

        P01_HomePage HomePage = new P01_HomePage(driver);
        boolean isProductUpdated=HomePage
                                .clickEditButton(oldTitle)
                                .updateTitle(newTitle)
                                .submitChanges()
                                .isProductDisplayed(newTitle);

        Assert.assertTrue(isProductUpdated, "Title update failed!");
        System.out.println("The product was updated successfully!");
    }

    }
