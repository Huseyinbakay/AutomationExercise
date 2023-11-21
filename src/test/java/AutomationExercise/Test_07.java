package AutomationExercise;

import baseClass.TestBaseClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Test_07 extends TestBaseClass {

    @Test
    public void test07() {

     //   1. Launch browser
     //   2. Navigate to url 'http://automationexercise.com'




     //   3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());

     //   4. Click on 'Test Cases' button
        driver.findElement(By.xpath("//a[.=' Test Cases']")).click();

     //  5. Verify user is navigated to test cases page successfully

        Assert.assertTrue(driver.findElement(By.tagName("//b")).isDisplayed());








    }

}
