package AutomationExercise;

import baseClass.TestBaseClass;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Test_02 extends TestBaseClass {

    Faker faker =new Faker();
    String firstName=faker.name().firstName();
    String lastName=faker.name().lastName();
    String emaill=faker.internet().emailAddress();
    String password=faker.internet().password();

    @Test
    public void testCase_02() {



        // Click on 'Signup / Login' button
        WebElement webElement=driver.findElement(By.xpath("//a[@href='/login']"));
        webElement.click();


        WebElement name=driver.findElement(By.xpath("//input[@type='text']"));

        name.sendKeys(firstName+lastName);



        System.out.println("emaill = " + emaill);
        WebElement email=driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys(emaill);

        //Click 'Signup' button
        driver.findElement(By.xpath("//button[.='Signup']")).click();



        driver.findElement(By.id("password")).sendKeys(password);

        WebElement days=driver.findElement(By.id("days"));
        WebElement months=driver.findElement(By.id("months"));
        WebElement years=driver.findElement(By.id("years"));


        Select selectDay =new Select(days);

        Select selectMonth =new Select(months);

        Select selectYear =new Select(years);

        int day= faker.number().numberBetween(1,31);
        String dayStr=day+"";
        selectDay.selectByValue(dayStr);

        int month= faker.number().numberBetween(0,12);

        selectMonth.selectByIndex(month);



        int yearss= faker.number().numberBetween(0,122);

        selectYear.selectByIndex(yearss);



        //. Select checkbox 'Sign up for our newsletter!'
        WebElement cBox1=driver.findElement(By.id("newsletter"));
        if (!cBox1.isSelected()){

            cBox1.click();
        }



        //Select checkbox "Receive special offers from our partners!"
        WebElement cBox2=driver.findElement(By.id("optin"));

        if (!cBox2.isSelected()){

            cBox2.click();
        }

        //Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

        WebElement fist=driver.findElement(By.id("first_name"));
        fist.sendKeys(firstName,Keys.TAB);

        Actions actions=new Actions(driver);
        actions.scrollToElement(driver.findElement(By.id("address2"))).perform();

        WebElement last=driver.findElement(By.id("last_name"));
        last.sendKeys(lastName,Keys.TAB);

        WebElement company=driver.findElement(By.id("company"));


        company.sendKeys(faker.company().bs(),Keys.TAB);

        WebElement adress1=driver.findElement(By.id("address1"));

        adress1.sendKeys(faker.address().fullAddress(),Keys.TAB);

        WebElement address2=driver.findElement(By.id("address2"));
        address2.sendKeys(faker.address().fullAddress(),Keys.TAB);

        WebElement countr=driver.findElement(By.id("country"));
        int count=faker.number().numberBetween(0,7);

        Select select=new Select(countr);
        select.selectByIndex(count);

        WebElement state=driver.findElement(By.id("state"));
        state.sendKeys(faker.address().state(),Keys.TAB);

        WebElement city=driver.findElement(By.id("city"));
        city.sendKeys(faker.address().city());


        WebElement zipcode=driver.findElement(By.id("zipcode"));
        zipcode.sendKeys(faker.address().zipCode(),Keys.TAB);



        WebElement mobileNumber=driver.findElement(By.id("mobile_number"));
        mobileNumber.sendKeys(faker.phoneNumber().cellPhone());




        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[.='Create Account']")).click();

        driver.findElement(By.xpath("//a[.='Continue']")).click();

        driver.findElement(By.xpath("//a[@href='/logout']")).click();

        driver.navigate().refresh();

        driver.findElement(By.xpath("//a[@style='color: orange;']")).click();


       //Hesabı silmeyi test için önce bir hesap olusturmam gerekiyor.Yukarıda bu adımları tamamladım



       //TEST_02 BU AŞAMADA BAŞLIYOR
        // Verify that home page is visible successfully
       // Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());


        //Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();


        //5. Verify 'Login to your account' is visible
        WebElement isVisibleLoginAccount=driver.findElement(By.xpath("//h2[.='Login to your account']"));
        Assert.assertTrue(isVisibleLoginAccount.isDisplayed());


        //6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys(emaill, Keys.TAB);
        //bertram.stoltenberg@gmail.com
        //
        driver.findElement(By.name("password")).sendKeys(password);


        //7. Click 'login' button
        driver.findElement(By.xpath("//button[.='Login']")).click();



        // 8. Verify that 'Logged in as username' is visible
        WebElement isDisplayedLoggedinUser=driver.findElement(By.xpath("(//a)[11]"));
        Assert.assertTrue(isDisplayedLoggedinUser.isDisplayed());


        //9. Click 'Delete Account' button

        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();




        //10. Verify that 'ACCOUNT DELETED!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b[.='Account Deleted!']")).isDisplayed());

        screenShotWebElement(driver.findElement(By.xpath("//b[.='Account Deleted!']")));


    }
}
