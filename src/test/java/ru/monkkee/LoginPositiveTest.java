package ru.monkkee;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPositiveTest {

    @Test
    public void LoginPositiveTest() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://my.monkkee.com/#/");
        WebElement userName = driver.findElement(By.name("login"));
        userName.clear();
        userName.sendKeys("A.Karakhanyan.IT@gmail.com");
        WebElement userPassword = driver.findElement(By.name("password"));
        userPassword.clear();
        userPassword.sendKeys("11223344aarrtt");
        userPassword.sendKeys(Keys.ENTER);
        
        WebElement logout = driver.findElement(By.id("main"));
        Assert.assertTrue("verifying logout is displayed", logout.isDisplayed());

        driver.quit();

    }

}