import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Domaci3 {

        //Koristeci Anotacije - Ulogujte se na demoqa(https://demoqa.com/
        // -> Book Store Application) preko cookies-a, dodati dve knjige na svoj nalog,
        // zatim se izlogovati brisanjem cookies-a.
        //Ulogovati se ponovo preko log-in forme i potvrditi da se knjige i dalje nalaze na nalogu
        WebDriver driver;
          String userName = "vlada";
          String password = "Babaroga.11!";
          String expiresValue, tokenValue;
          WebElement logoutButton;
          WebElement loginButton;
          @BeforeClass
          public void setUp() throws InterruptedException {
              WebDriverManager.chromedriver().setup();
              driver = new ChromeDriver();
              driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
              driver.manage().window().maximize();
              Thread.sleep(2000);
              driver.get("https://demoqa.com/books");
              Thread.sleep(2000);
              loginButton = driver.findElement(By.id("login"));
              loginButton.click();
              List<WebElement> userField = driver.findElements(By.cssSelector(".mr-sm-2.form-control"));
              userField.get(0).sendKeys(userName);
              userField.get(1).sendKeys(password);
              Thread.sleep(2000);
              List<WebElement> loginField = driver.findElements(By.cssSelector(".btn.btn-primary"));
              loginField.get(0).click();
              Thread.sleep(3000);
              expiresValue = driver.manage().getCookieNamed("expires").getValue();
              tokenValue = driver.manage().getCookieNamed("token").getValue();
              Thread.sleep(2000);
              logoutButton = driver.findElement(By.id("submit"));
              logoutButton.click();

          }
    @BeforeMethod
    public void pageSetUp() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://demoqa.com/books");
        Thread.sleep(2000);
    }
    @Test(priority = 10)
    public void loginWhitToken() throws InterruptedException {
        Cookie token = new Cookie("token", tokenValue);
        Cookie expires = new Cookie("expires", expiresValue);
        Cookie userID = new Cookie("userID", "c957f763-c535-402c-8701-0fddab472cbf");
        Cookie userName = new Cookie("userName","vlada");
        Cookie IDE = new Cookie("IDE","AHWqTUlBYSPjXIqREn8CpYLLaMEEHuVN4sm304UtaWkLdAaT-kX53CWaehgAK7BBA8s");
        driver.manage().addCookie(token);
        driver.manage().addCookie(expires);
        driver.manage().addCookie(userID);
        driver.manage().addCookie(userName);
        driver.manage().addCookie(IDE);
        driver.navigate().refresh();
        Thread.sleep(3000);
        logoutButton = driver.findElement(By.id("submit"));
        Assert.assertTrue(logoutButton.isDisplayed());
        WebElement userNammeValue = driver.findElement(By.id("userName-value"));
        Assert.assertTrue(userNammeValue.isDisplayed());

          }
          @Test(priority = 20)
    public void dodavanjeKnjiga() throws InterruptedException {
              WebElement book1 = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
              book1.click();
              List<WebElement> add = driver.findElements(By.id("addNewRecordButton"));
              add.get(1).click();
              Thread.sleep(2000);
              try{
              WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
              wait.until((ExpectedConditions.alertIsPresent()));
              Alert alert = driver.switchTo().alert();
              alert.accept();}
              catch (Exception e){
                  System.out.println(e);
              }
              driver.navigate().refresh();
              Thread.sleep(2000);
              List<WebElement> add1 = driver.findElements(By.id("addNewRecordButton"));
              add1.get(0).click();
              Thread.sleep(2000);
              WebElement book2 = driver.findElement(By.linkText("Designing Evolvable Web APIs with ASP.NET"));
              book2.click();
              Thread.sleep(2000);
              List<WebElement> add2 = driver.findElements(By.id("addNewRecordButton"));
              add2.get(1).click();
              driver.get("https://demoqa.com/profile");
              WebElement addedBook1 = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
              Assert.assertTrue(addedBook1.isDisplayed());
              WebElement addedBook2 = driver.findElement(By.linkText("Designing Evolvable Web APIs with ASP.NET"));
              Assert.assertTrue(addedBook2.isDisplayed());
              driver.manage().deleteAllCookies();
          }
          @Test(priority = 30)
    public void logovanjePrekoLoginFormeIProvera() throws InterruptedException {
              loginButton = driver.findElement(By.id("login"));
              loginButton.click();
              List<WebElement> userField = driver.findElements(By.cssSelector(".mr-sm-2.form-control"));
              userField.get(0).sendKeys(userName);
              userField.get(1).sendKeys(password);
              Thread.sleep(2000);
              List<WebElement> loginField = driver.findElements(By.cssSelector(".btn.btn-primary"));
              loginField.get(0).click();
              Thread.sleep(3000);
              driver.get("https://demoqa.com/profile");
              WebElement addedBook1 = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
              Assert.assertTrue(addedBook1.isDisplayed());
              WebElement addedBook2 = driver.findElement(By.linkText("Designing Evolvable Web APIs with ASP.NET"));
              Assert.assertTrue(addedBook2.isDisplayed());
              driver.manage().deleteAllCookies();

          }




}
