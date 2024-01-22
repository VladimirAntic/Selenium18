import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Domaci1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/text-box");



        WebElement username = driver.findElement(By.id("userName"));
        username.sendKeys("Vladimir");
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("antic@gmail.com");

        WebElement address = driver.findElement(By.id("currentAddress"));
        address.sendKeys("Sunset boulevard");

        WebElement button = driver.findElement(By.id("submit"));
        button.click();

        String expectedUrl="https://demoqa.com/text-box";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);


        WebElement output = driver.findElement(By.id("output"));

        Assert.assertTrue(output.isDisplayed());



    }
}
