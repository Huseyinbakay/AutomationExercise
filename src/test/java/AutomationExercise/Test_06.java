package AutomationExercise;

import baseClass.TestBaseClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test_06 extends TestBaseClass {


    @Test
    public void contactUs() {

//2. Navigate to url 'http://automationexercise.com'


        // Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());


        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();

        //5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouchElement=driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]"));

        Assert.assertTrue(getInTouchElement.isDisplayed());

        //6. Enter name, email, subject and message

        driver.findElement(By.name("name")).sendKeys("BlossomDeckow", Keys.TAB);
        driver.findElement(By.name("email")).sendKeys("bertram.stoltenberg@gmail.com",Keys.TAB);
        driver.findElement(By.name("subject")).sendKeys("asdfghjk",Keys.TAB);
        driver.findElement(By.id("message")).sendKeys("asdfghjklşi.çömnbvcxzxcvbnmöç.işlkıuytrewszxcvbhjköm");





        WebElement uploadElement=driver.findElement(By.name("upload_file"));
        String ortak="\\Desktop\\hepsi geldi.png";
        String home=System.getProperty("user.home");

        String dynamic=home+ortak;

        uploadElement.sendKeys(dynamic);


        driver.findElement(By.name("submit")).click();

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();




      //  WebElement successfully=driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='status alert alert-success']")));


        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement successfuly=driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        Assert.assertTrue(successfuly.isDisplayed());



        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());















    }
}
