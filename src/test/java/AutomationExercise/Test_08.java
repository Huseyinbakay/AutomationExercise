package AutomationExercise;

import baseClass.TestBaseClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Test_08 extends TestBaseClass {


    @Test
    public void test_08() {

     //       1. Launch browser
    //        2. Navigate to url 'http://automationexercise.com'


    //        3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());


    //        4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();


    //        5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed());

    //        6. The products list is visible
        Assert.assertTrue(driver.findElement(By.className("features_items")).isDisplayed());

    //        7. Click on 'View Product' of first product

        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();

    //        9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Blue Top']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[.='Category: Women > Tops']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[.='Rs. 500']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//b[.='Availability:']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//b[.='Condition:']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//b[.='Brand:']")).isDisplayed());






    }
}
