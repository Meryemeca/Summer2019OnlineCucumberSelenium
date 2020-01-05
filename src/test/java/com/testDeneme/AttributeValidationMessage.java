package com.testDeneme;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AttributeValidationMessage {


    @Test
    public void deneme(){
        WebDriver driver = Driver.get();
        driver.get("http://zero.webappsecurity.com/login.html");
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password", Keys.ENTER);

        BrowserUtils.wait(1);
        driver.findElement(By.cssSelector("#pay_bills_tab")).click();
        BrowserUtils.wait(2);
        WebElement sel = driver.findElement(By.id("sp_payee"));
        Select select= new Select(sel);
        select.selectByVisibleText("Sprint");
        BrowserUtils.wait(2);
        WebElement selt = driver.findElement(By.id("sp_account"));
        Select sel2 =new Select(selt);
        sel2.selectByVisibleText("Savings");
        driver.findElement(By.id("sp_date")).sendKeys("2020-01-13");
        driver.findElement(By.id("sp_description")).sendKeys("sss");
        driver.findElement(By.id("pay_saved_payees")).click();
        BrowserUtils.wait(5);

        //driver.findElement(By.id("tf_amount")).getAttribute("validationMessage")

        //If the input element has the attribute 'required' then it will display "Please fill in this field.".
        // So all you have to do is find the element, using findElement() then use getAttribute('required').
        // If getAttribute returns NULL then the attribute does not exist. Otherwise, it should return the String "true".



        Assert.assertEquals("true", driver.findElement(By.id("sp_amount")).getAttribute("required"));
        Assert.assertEquals("Please fill out this field.", driver.findElement(By.id("sp_amount")).getAttribute("validationMessage"));

        // Assert.assertTrue();
        // System.out.println(result);


    }

}
