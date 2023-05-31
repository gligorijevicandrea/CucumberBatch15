package Utils;

import StepDefinitions.PageInitializer;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.DOMConfiguration;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class CommonMethods extends PageInitializer {

    public static WebDriver driver;
    public static void openBrowserLaunchApplication(){

        ConfigReader.readProperties();


        String browserType=ConfigReader.getPropertyValue("browserType");
        switch (browserType){
            case "Chrome":

                ChromeOptions options = new ChromeOptions();

                options.addArguments("--no-sandbox");
                options.addArguments("--remote-allow-origins=*");
                if(ConfigReader.getPropertyValue("Headless").equals("true")){
                    options.addArguments("--headless=new");
                }

                driver = new ChromeDriver(options);
                break;
            case "Firefox":
                driver=new FirefoxDriver();
                break;
            case "IE":
                driver=new InternetExplorerDriver();
                break;
            default:
                driver=new EdgeDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Constants.WAIT_TIME));
        initializePageObjects(); // this will initialize all the pages we have in our page
                                // PageInitializer class along with the launching of application

        // to configure the File and pattern it has
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("This is the beginning of my Test case");
        Log.info("My test case is executing right now");
        Log.warning("My test case might have some trivial issues");
    }

    public static void closeBrowser(){
        Log.info("This test case is about to get completed");
        Log.endTestCase("This test case is finished");
        driver.close();
    }


    public static void doClick(WebElement element){
        element.click();
    }

    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }


    public static Select clickOnDropdown(WebElement element){

        Select select=new Select(element);
        return select;

    }

    public static void selectByValue(WebElement element, String value){

        clickOnDropdown(element).selectByValue(value);
    }


    public static void selectByVisibleText(WebElement element, String text){

        clickOnDropdown(element).selectByVisibleText(text);
    }


    public static void selectByIndex(WebElement element, int index){

        clickOnDropdown(element).selectByIndex(index);
    }


    public static void selectByOptions(WebElement element, String text){

       List<WebElement> options= clickOnDropdown(element).getOptions();
       for( WebElement option:options){

         String ddlOptionText= option.getText();

         if (ddlOptionText.equals(text)){
             option.click();
         }

       }

    }

  // ===================SCREENSHOT===========================

    public static byte[] takeScreenshot(String imageName){
        // this casts the webDriver instance 'driver' to TakesScreenshot Interface
        TakesScreenshot ts=(TakesScreenshot)driver;

       byte[] picBytes= ts.getScreenshotAs(OutputType.BYTES); // screenshots are storing in size of byte array

        // This captures the screenshots and stores it as a file in the sourceFile variable
       File sourcePath= ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourcePath, new File(Constants.SCREENSHOT_FILEPATH+imageName+getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png")); //surround the error with try catch
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return picBytes;
    }


    public static String getTimeStamp(String pattern){

        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        return sdf.format(date);
    }


}
