package AutomationExercise;

import baseClass.TestBaseClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Test_09 extends TestBaseClass {


    @Test
    public void test_09() {

//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
//        3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());


//        4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();


//        5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed());


//        6. Enter product name in search input and click search button
        driver.findElement(By.id("search_product")).sendKeys("Fancy Green Top", Keys.ENTER);
        driver.findElement(By.id("submit_search")).click();

//        7. Verify 'SEARCHED PRODUCTS' is visible

      Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed());


//        8. Verify all the products related to search are v
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='ecommerce website products']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Rs. 700']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[.='Fancy Green Top']")).isDisplayed());

  }
}
