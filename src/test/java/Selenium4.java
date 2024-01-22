import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selenium4 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        String expectedUrl="https://demoqa.com/text-box";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);


                WebElement username = driver.findElement(By.id("userName"));
                username.sendKeys("Vladimir");
                WebElement password = driver.findElement(By.id("userEmail"));
                password.sendKeys("antic@gmail.com");

        WebElement address = driver.findElement(By.id("currentAddress"));
        password.sendKeys("Sunset boulevard");

                WebElement button = driver.findElement(By.id("submit"));
                button.click();


        WebElement output = driver.findElement(By.id("output"));

        Assert.assertTrue(output.isDisplayed());



    }
}
