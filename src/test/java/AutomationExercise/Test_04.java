package AutomationExercise;

import baseClass.TestBaseClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Test_04 extends TestBaseClass {


    @Test
    public void test_04() {


        //Navigate to url 'http://automationexercise.com'


        // Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());


        //Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();


        //5. Verify 'Login to your account' is visible
        WebElement isVisibleLoginAccount=driver.findElement(By.xpath("//h2[.='Login to your account']"));
        Assert.assertTrue(isVisibleLoginAccount.isDisplayed());


        //6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("rosita.price@gmail.com", Keys.TAB);
        //bertram.stoltenberg@gmail.com
        //
        driver.findElement(By.name("password")).sendKeys("4uk7tcew1tuw");


        //7. Click 'login' button
        driver.findElement(By.xpath("//button[.='Login']")).click();



        // 8. Verify that 'Logged in as username' is visible
        WebElement isDisplayedLoggedinUser=driver.findElement(By.xpath("(//a)[11]"));
        Assert.assertTrue(isDisplayedLoggedinUser.isDisplayed());


        //9. Click 'Logout' button
        driver.findElement(By.xpath("//a[@href='/logout']")).click();



        //10. Verify that user is navigated to login page
        String loginPageText=driver.findElement(By.xpath("//h2[.='Login to your account']")).getText();

        Assert.assertEquals(loginPageText,"Login to your account");


    }
}
