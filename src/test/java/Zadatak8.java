import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Zadatak8 {
    WebDriver driver;
    WebElement usernameField;
    WebElement passwordField;
    WebElement submitButton;
    String validUsername, validPassword, invalidUsername, invalidPassword, loggedInUrl;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        validUsername = "sudent";
        validPassword = "Password123";
        invalidUsername = "student1";
        invalidPassword = "pppp";
        loggedInUrl = "https://practicetestautomation.com/logged-in-successfully/";
    }

        @BeforeMethod
                public void pageSetup() {
            driver.get("https://practicetestautomation.com/");
            WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
            practiceButton.click();
            WebElement linkButton = driver.findElement(By.linkText("Test Login Page"));
            linkButton.click();
            usernameField = driver.findElement(By.id("username"));
            passwordField = driver.findElement(By.id("password"));
            submitButton = driver.findElement(By.id("submit"));
        }
            @Test(priority = 10)
                    public void userCannotLogWithoutUserName(){
        passwordField.sendKeys(validPassword);
        submitButton.click();
        


            }
        }





