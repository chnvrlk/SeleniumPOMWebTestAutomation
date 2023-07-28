package org.example.base;

import org.example.utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {


    WebDriver driver;
    public Properties prop;
    public Properties dataProp;

    public BaseClass() {
        prop = new Properties();
        File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\org\\example\\config\\config.properties");

        dataProp= new Properties();
        File dataPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\org\\example\\testdata\\testdata.properties");

        try{

            FileInputStream dataFis = new FileInputStream(dataPropFile);
            dataProp.load(dataFis);

        } catch (Throwable e ){
            e.printStackTrace();
        }

        try{
            FileInputStream fis = new FileInputStream(propFile);
            prop.load(fis);

            FileInputStream dataFis = new FileInputStream(dataPropFile);
            dataProp.load(dataFis);

        } catch (Throwable e ){
            e.printStackTrace();
        }

    }

    public WebDriver initializeBrowserAndOpenApplicationURL(String browser){

        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }
        else if(browser.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
        }else{
            System.out.println("Entered invalid browser Name!");
            throw new NullPointerException();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
        driver.get(prop.getProperty("url"));

        return driver;

    }
}
