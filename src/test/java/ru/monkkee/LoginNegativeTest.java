package ru.monkkee;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginNegativeTest {

    @Test
    public void LoginNegativeTest() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://my.monkkee.com/#/");
        WebElement userName = driver.findElement(By.name("login"));
        userName.clear();
        userName.sendKeys("username123");
        WebElement userPassword = driver.findElement(By.name("password"));
        userPassword.clear();
        userPassword.sendKeys("123456");
        userPassword.sendKeys(Keys.ENTER);
        WebElement alertSuccess =
                driver.findElement(By.cssSelector("alert alert-danger"));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(alertSuccess));

        Assert.assertTrue("verifying alert is displayed", alertSuccess.isDisplayed());
        Assert.assertEquals(alertSuccess.getText(), "Login failed", "verifying alert is correct");

        driver.quit();

    }

}
