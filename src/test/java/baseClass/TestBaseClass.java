package baseClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import freemarker.template.DefaultArrayAdapter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBaseClass {

   protected WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.automationexercise.com/");

    }


    public void screenShotWebElement(WebElement webElement){


        String date=DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());

        String path="src\\test\\java\\screenShots\\"+date+"AutomationExercise.jpeg";

        try {
            Files.write(Path.of(path),webElement.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


     public void homePageScreenShot(){

         String date=DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());

         String path="src\\test\\java\\screenShots\\"+date+"AutomationExercise.jpeg";

         TakesScreenshot ts= (TakesScreenshot) driver;
         try {
             Files.write(Path.of(path),ts.getScreenshotAs(OutputType.BYTES));
         } catch (IOException e) {
             throw new RuntimeException(e);
         }


     }


    }

