import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import java.util.List;

public class Proba {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();


        driver.get("https://demoqa.com/books");
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        List<WebElement> userField = driver.findElements(By.cssSelector(".mr-sm-2.form-control"));
        userField.get(0).sendKeys("vlada");
        userField.get(1).sendKeys("Babaroga.11!");
        Thread.sleep(1000);

        List<WebElement> loginField = driver.findElements(By.cssSelector(".btn.btn-primary"));
        loginField.get(0).click();

        Thread.sleep(3000);
        String expiresValue = driver.manage().getCookieNamed("expires").getValue();
        String tokenValue = driver.manage().getCookieNamed("token").getValue();
        Thread.sleep(1000);
        WebElement logoutButton = driver.findElement(By.id("submit"));
        logoutButton.click();


        driver.get("https://demoqa.com/books");
        Thread.sleep(1000);

        Cookie token = new Cookie("token", tokenValue);
        Cookie expires = new Cookie("expires", expiresValue);
        Cookie userID = new Cookie("userID", "c957f763-c535-402c-8701-0fddab472cbf");
        Cookie userName = new Cookie("userName", "vlada");
        Cookie IDE = new Cookie("IDE","AHWqTUlBYSPjXIqREn8CpYLLaMEEHuVN4sm304UtaWkLdAaT-kX53CWaehgAK7BBA8s");
        driver.manage().addCookie(token);
        driver.manage().addCookie(expires);
        driver.manage().addCookie(userID);
        driver.manage().addCookie(userName);
        driver.manage().addCookie(IDE);
        driver.navigate().refresh();
        Thread.sleep(3000);
        //.get("https://demoqa.com/profile");
        //Thread.sleep(3000);


        WebElement book1 = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        book1.click();
        List<WebElement> add = driver.findElements(By.id("addNewRecordButton"));
        add.get(1).click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        List<WebElement> add1 = driver.findElements(By.id("addNewRecordButton"));
        add1.get(0).click();
        Thread.sleep(1000);
        WebElement book2 = driver.findElement(By.linkText("Designing Evolvable Web APIs with ASP.NET"));
        book2.click();
        Thread.sleep(1000);
        List<WebElement> add2 = driver.findElements(By.id("addNewRecordButton"));
        add2.get(1).click();
        driver.get("https://demoqa.com/profile");









/*
        WebElement api = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[4]/span"));

        api.click();
        WebElement authorizeButton = driver.findElement(By.cssSelector(".btn.authorize.unlocked"));
        authorizeButton.click();
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("admin");
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("Babaroga.11!");
        WebElement auth = driver.findElement(By.xpath("/html/body/div/section/div[2]/div[2]/div[2]/section/div/div/div[2]/div/div/div[2]/div[1]/form/div[2]/button[1]"));
        auth.click();
        Thread.sleep(3000);
        WebElement closeButton = driver.findElement(By.className("close-modal"));
        closeButton.click();
        driver.navigate().to("https://demoqa.com/books");

*/
    }
}
