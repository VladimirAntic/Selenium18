import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.time.Duration;

public class Selenium5 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://wordpress.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        WebElement login = driver.findElement(By.linkText("Log In"));
        login.click();
        WebElement username= driver.findElement(By.id("usernameOrEmail"));
        username.sendKeys("vladimirantic.qa@gmail.com");
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Babaroga.11");

        WebElement loginButton = driver.findElement(By.className("login__form-action"));
        loginButton.click();

        String expectedUrl= "https://wordpress.com/sites";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

    }
}
