import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak5 {
    public static void main(String[] args) {
        //login logout

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
        WebElement practice = driver.findElement(By.id("menu-item-20"));
        practice.click();

        driver.findElement(By.xpath("/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a"))
                .click();
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");

        WebElement button = driver.findElement(By.id("submit"));
        button.click();
        WebElement logOutButton = driver.findElement(By.className("wp-block-group"));

        logOutButton.click();

        String expectedUrl = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

        WebElement login = driver.findElement(By.id("login"));

        Assert.assertTrue(login.isDisplayed());

        WebElement user = driver.findElement(By.id("username"));

        Assert.assertTrue(user.isDisplayed());

    }
}
