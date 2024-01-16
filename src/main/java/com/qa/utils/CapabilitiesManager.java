package com.qa.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.qa.utils.TestUtils.driver;


public class CapabilitiesManager {

    public void goToWebPOS() throws InterruptedException {
//        setup();
        Thread.sleep(3000);
        try
        {
            if(driver.findElement(By.xpath("//span[contains(.,'Continue Without Plugin')]/..")).isDisplayed())
            {
                driver.findElement(By.xpath("//span[contains(.,'Continue Without Plugin')]/..")).click();
            }
        }
        catch(Exception fd)
        {

        }
        Thread.sleep(2000);
        //Clear the text from the user name text box
        driver.findElement(By.xpath("//input[@name='email']")).clear();
        //Enter the user name
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("basicautotest@mail.com");
        //Clear the password from the password text box
        driver.findElement(By.xpath("//input[@name='password']")).clear();
        //Enter the password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("welcome123");
        Thread.sleep(5000);
        //Click the login button
        driver.findElement(By.xpath("//ion-button[@type='submit']")).click();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Thread.sleep(20000);
    }


    public void setup() throws InterruptedException, AWTException {

        //Call the chrome driver
        System.setProperty("webdriver.chrome.driver","C:\\Automation\\WebPos\\Automation Driver\\chromedriver-win64 - 120 Version\\chromedriver.exe");
        //Open the Chrome window
        driver = new ChromeDriver();
        //Wait for 30 seconds
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Maximize the Firefox window
        driver.manage().window().maximize();
        //launch the URL
        Thread.sleep(5000);
        //Launch the URL
        driver.get("https://staging-webpos-india.lingapos.com/");
        Thread.sleep(8000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        //Set Size of the Browser
//        int width = 600;
//        int height = 400;
//        Dimension dimension = new Dimension(width, height);
//        driver.manage().window().setSize(dimension);
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_SUBTRACT);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_SUBTRACT);
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_SUBTRACT);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_SUBTRACT);
        Thread.sleep(4000);
        try
        {
            if(driver.findElement(By.xpath("//span[contains(.,'Continue Without Plugin')]/..")).isDisplayed())
            {
                driver.findElement(By.xpath("//span[contains(.,'Continue Without Plugin')]/..")).click();
            }
        }
        catch(Exception fd)
        {

        }
        Thread.sleep(5000);
        //Clear the text from the user name text box
        driver.findElement(By.xpath("//input[@name='email']")).clear();
        //Enter the user name
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("basicautotest@mail.com");
        //Clear the password from the password text box
        driver.findElement(By.xpath("//input[@name='password']")).clear();
        //Enter the password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("welcome123");
        Thread.sleep(5000);
        //Click the login button
        driver.findElement(By.xpath("//ion-button[@type='submit']")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(20000);

    }


}
