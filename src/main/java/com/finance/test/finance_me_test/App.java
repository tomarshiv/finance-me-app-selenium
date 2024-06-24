package com.finance.test.finance_me_test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
  	  //load driver
        WebDriverManager.chromedriver().setup();
        
        //setup configuration
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        System.out.println("Scripted Executing");
        driver.get("http://3.80.76.142:8081/contact.html");
        
        //load application
        driver.findElement(By.name("Name")).sendKeys("khushboo");
        driver.findElement(By.name("Phone Number")).sendKeys("9876554434");
        driver.findElement(By.name("Email")).sendKeys("ss193@gmaill.com");
        driver.findElement(By.name("Message")).sendKeys("Hello");
        
        //submit button to form
     
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/a")).click(); 
        System.out.println("Application login");
        
        
        //response get
         
        String response =driver.findElement(By.id("message")).getText();
//       String response= driver.findElement(By.xpath("//*[@id=\"message\"]")).getText();
         System.out.println(response);
        System.out.println("shivani tomar");
     
        
        
        
        //take screenshot
        
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        
        File scrFile =scrShot.getScreenshotAs(OutputType.FILE);
        
        File destFile = new File("test-report.jpg");
        
        FileUtils.copyFile(scrFile, destFile);
        

        //validate response
        driver.quit();
     	
   
    }
}
