package app.e_commerce.kib.testcases;

import app.e_commerce.kib.base.BaseTest;
import app.e_commerce.kib.pages.P01_HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_DeleteProduct extends BaseTest {

    @Test
    public void Delete_product() throws InterruptedException {

        P01_HomePage p01HomePage = new P01_HomePage(driver);
        boolean productIsdeleted = p01HomePage.clickDeleteButton()
                                              .verifyproductisdeleted();

        Assert.assertTrue(productIsdeleted);
    }

}
