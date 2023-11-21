package AutomationExercise;

import baseClass.TestBaseClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Test_05 extends TestBaseClass {


    @Test
    public void test_case_5() {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");


        // Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());


        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();


       // 5. Verify 'New User Signup!' is visible
        WebElement newUserIsDisplayed=driver.findElement(By.xpath("//h2[.='New User Signup!']"));
        Assert.assertTrue(newUserIsDisplayed.isDisplayed());

        //6. Enter name and already registered email address
        //7. Click 'Signup' button
        driver.findElement(By.name("name")).sendKeys("BlossomDeckow", Keys.TAB);

        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("bertram.stoltenberg@gmail.com",Keys.ENTER);


       // 8. Verify error 'Email Address already exist!' is visible

       WebElement dispAlreadyexist=driver.findElement(By.xpath("//p[.='Email Address already exist!']"));
       Assert.assertTrue(dispAlreadyexist.isDisplayed());







    }
}
