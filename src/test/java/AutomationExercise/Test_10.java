package AutomationExercise;

import baseClass.TestBaseClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Test_10 extends TestBaseClass {



    @Test
    public void test_10() {


//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
//        3. Verify that home page is visible successfully

        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());


//        4. Scroll down to footer
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();

//        5. Verify text 'SUBSCRIPTION'
        WebElement sub=driver.findElement(By.xpath("//h2[.='Subscription']"));
        actions.scrollToElement(sub).perform();
        Assert.assertEquals("","SUBSCRIPTION",driver.findElement(By.xpath("//h2[.='Subscription']")).getText());

//        6. Enter email address in input and click arrow button
        driver.findElement(By.id("susbscribe_email")).sendKeys("rosita.price@gmail.com");
        driver.findElement(By.cssSelector("#subscribe")).click();

//        7. Verify success message 'You have been successfully subscribed!' is visible
        Assert.assertTrue(driver.findElement(By.id("success-subscribe")).isDisplayed());



    }
}
