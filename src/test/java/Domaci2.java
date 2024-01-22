import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Domaci2 {
    public static void main(String[] args) {
        //neuspesno logovanje
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
        WebElement practice = driver.findElement(By.id("menu-item-20"));
        practice.click();

        driver.findElement(By.xpath("/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a"))
                .click();
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student1");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");

        WebElement button = driver.findElement(By.id("submit"));
        button.click();

        WebElement error = driver.findElement(By.id("error"));

        Assert.assertTrue(error.isDisplayed());

        WebElement show = driver.findElement(By.className("show"));
        Assert.assertTrue(show.isDisplayed());


    }
}
