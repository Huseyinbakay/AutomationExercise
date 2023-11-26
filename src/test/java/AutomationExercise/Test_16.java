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

public class Test_16 extends TestBaseClass {



    //TESTTE HESABI SİLME İŞLEMİ DE TEST EDİLDİĞ İÇİN ÖNCELİKLE REGİSTER ADIMLARI UYGULANMALI

    Faker faker=new Faker();

    String firstName=faker.name().firstName();
    String lastName=faker.name().lastName();
    String emaill=faker.internet().emailAddress();
    String password=faker.internet().password();

    @Test
    public void test16() {





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

        driver.findElement(By.xpath("(//a[@href='/'])[2]")).click();


//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
//        3. Verify that home page is visible successfully
        // Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());





        //Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();



//        5. Fill email, password and click 'Login' button

        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys(emaill, Keys.TAB);

        driver.findElement(By.name("password")).sendKeys(password);

        driver.findElement(By.xpath("//button[.='Login']")).click();

//        6. Verify 'Logged in as username' at top
        String actualGetText=  driver.findElement(By.xpath("//li[10]")).getText();
        String expectedText="Logged in as "+firstName+lastName;
        Assert.assertEquals(expectedText,actualGetText);

        Actions actions1=new Actions(driver);


        for (int i = 0; i <1 ; i++) {

            actions1.sendKeys(Keys.PAGE_DOWN).perform();

        }
//        7. Add products to cart
        int index=faker.number().numberBetween(1,5);

        actions1.scrollToElement(driver.findElement(By.xpath("(//h2[.='Rs. 400'])[1]"))).perform();

        driver.findElement(By.xpath("(//a[@data-product-id='"+index+"'])[1]")).click();
       driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
         //  8. Click 'Cart' button
        actions.sendKeys(Keys.UP).perform();
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();

//        9. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("(//table//tr//td[2])[1]")).isDisplayed());


//        10. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[.='Proceed To Checkout']")).click();

//        11. Verify Address Details and Review Your Order

        //(//li[@class='address_address1 address_address2'])[1]

        String ortakAdresDelivery=driver.findElement(By.id("address_delivery")).getText().substring(21);
        String ortakAdresShipp=driver.findElement(By.id("address_invoice")).getText().substring(20);

        Assert.assertEquals(ortakAdresShipp,ortakAdresDelivery);

//        12. Enter description in comment text area and click 'Place Order'
        WebElement webElementPlaceOrder=driver.findElement(By.xpath("//a[@href='/payment']"));

        actions.scrollToElement(webElementPlaceOrder).perform();
        driver.findElement(By.name("message")).sendKeys("Acil kargolayabilir misiniz?");
        webElementPlaceOrder.click();

//        13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.name("name_on_card")).sendKeys(faker.name().fullName(),Keys.TAB);
        driver.findElement(By.name("card_number")).sendKeys("1234567891234567",Keys.TAB);
        driver.findElement(By.name("cvc")).sendKeys(""+faker.number().numberBetween(100,999),Keys.TAB);
        driver.findElement(By.name("expiry_month")).sendKeys(faker.number().numberBetween(1,12)+"",Keys.TAB);

        driver.findElement(By.name("expiry_year")).sendKeys(faker.number().numberBetween(1950,2035)+"",Keys.TAB);

//        14. Click 'Pay and Confirm Order' button
        driver.findElement(By.id("submit")).click();

//        15. Verify success message 'Your order has been placed successfully!'

       String alertMessage=driver.findElement(By.xpath("(//div[@class='alert-success alert'])[1]")).getText();
        String expectedTextAlert="'Your order has been placed successfully!'";
        //Assert.assertEquals(expectedTextAlert,alertMessage);
//        16. Click 'Delete Account' button
           driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

//        17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
       String deletedMessage= driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
       Assert.assertEquals("ACCOUNT DELETED!",deletedMessage);
       driver.findElement(By.xpath("//a[.='Continue']")).click();






    }
}
