package AutomationExercise;

import baseClass.TestBaseClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

import java.nio.file.Files;
import java.nio.file.Path;

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
        screenShotWebElement(isVisibleLoginAccount);


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
        screenShotWebElement(isDisplayedLoggedinUser);

        //9. Click 'Logout' button
        driver.findElement(By.xpath("//a[@href='/logout']")).click();



        //10. Verify that user is navigated to login page
        WebElement loginPageText=driver.findElement(By.xpath("//h2[.='Login to your account']"));
        screenShotWebElement(loginPageText);
        String loginPageText1=loginPageText.getText();

        Assert.assertEquals(loginPageText1,"Login to your account");


    }
}
