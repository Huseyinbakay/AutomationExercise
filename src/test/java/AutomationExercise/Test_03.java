package AutomationExercise;

import baseClass.TestBaseClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Test_03 extends TestBaseClass {

    @Test
    public void test_03() {


        //Navigate to url 'http://automationexercise.com'


        // Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());


        //Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();


        //5. Verify 'Login to your account' is visible
        WebElement isVisibleLoginAccount=driver.findElement(By.xpath("//h2[.='Login to your account']"));
        Assert.assertTrue(isVisibleLoginAccount.isDisplayed());


        //6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("bertram.stoltenberg@gmail.com", Keys.TAB);
        //bertram.stoltenberg@gmail.com
        //
        driver.findElement(By.name("password")).sendKeys("r25g6b3q0ty4r5m");


        //7. Click 'login' button
        driver.findElement(By.xpath("//button[.='Login']")).click();



       // 8. Verify error 'Your email or password is incorrect!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//p[.='Your email or password is incorrect!']")).isDisplayed());


    }
}
