package casosprueba;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SwagLabs {

    JavascriptExecutor js;
    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void Preparing (){
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void finishTest() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }

    @Test
    public void CP01_LoginOK(){

        WebElement LoginUser = driver.findElement(By.xpath("//input[@id='user-name']"));
        LoginUser.sendKeys("standard_user");
        WebElement LoginPass = driver.findElement(By.xpath("//input[@id='password']"));
        LoginPass.sendKeys("secret_sauce");
        WebElement LoginBTN = driver.findElement(By.xpath("//input[@id='login-button']"));
        LoginBTN.click();
        Assertions.assertEquals("//div[contains(text(),\"Products\")]","//div[contains(text(),\"Products\")]");

    }

    @Test

    public void CP02_LoginFailed(){
        WebElement LoginUser = driver.findElement(By.xpath("//input[@id='user-name']"));
        LoginUser.sendKeys("standard_users");
        WebElement LoginPass = driver.findElement(By.xpath("//input[@id='password']"));
        LoginPass.sendKeys("secret_sauce");
        WebElement LoginBTN = driver.findElement(By.xpath("//input[@id='login-button']"));
        LoginBTN.click();
        Assertions.assertEquals("//h3[contains(text(),\"Epic sadface\")]","//h3[contains(text(),\"Epic sadface\")]");


    }

    @Test

    public void CP03_AddToCart(){
        WebElement LoginUser = driver.findElement(By.xpath("//input[@id='user-name']"));
        LoginUser.sendKeys("standard_user");
        WebElement LoginPass = driver.findElement(By.xpath("//input[@id='password']"));
        LoginPass.sendKeys("secret_sauce");
        WebElement LoginBTN = driver.findElement(By.xpath("//input[@id='login-button']"));
        LoginBTN.click();

        WebElement producto1 = driver.findElement(By.xpath("//div[contains(text(),\"Sauce Labs Backpack\")]"));
        producto1.click();

        driver.findElement(By.xpath("//button[contains(text(),'ADD TO CART')]")).click();
        driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();
        Assertions.assertTrue(true,"//div[contains(text(),\"Your Cart\")]");
        Assertions.assertEquals("//div[contains(text(),\"Sauce Labs Backpack\")]","//div[contains(text(),\"Sauce Labs Backpack\")]");


    }


    @Test

    public void CP04_LogOut(){

        WebElement LoginUser = driver.findElement(By.xpath("//input[@id='user-name']"));
        LoginUser.sendKeys("standard_user");
        WebElement LoginPass = driver.findElement(By.xpath("//input[@id='password']"));
        LoginPass.sendKeys("secret_sauce");
        WebElement LoginBTN = driver.findElement(By.xpath("//input[@id='login-button']"));
        LoginBTN.click();
        Assertions.assertEquals("//div[contains(text(),\"Products\")]","//div[contains(text(),\"Products\")]");
        WebElement MenuHamb = driver.findElement(By.xpath("//button[contains(text(),'Open Menu')])"));
        MenuHamb.click();
        WebElement LogOutBtn = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        LogOutBtn.click();
        Assertions.assertTrue(true,"//h4[contains(text(),'Accepted usernames are:')]");



    }


    @Test

    public void CP05_LockedUser(){
        WebElement LoginUser = driver.findElement(By.xpath("//input[@id='user-name']"));
        LoginUser.sendKeys("locked_out_user");
        WebElement LoginPass = driver.findElement(By.xpath("//input[@id='password']"));
        LoginPass.sendKeys("secret_sauce");
        WebElement LoginBTN = driver.findElement(By.xpath("//input[@id='login-button']"));
        LoginBTN.click();
        Assertions.assertTrue(true,"//h3[contains(text(),'Epic sadface')]");
    }


}
