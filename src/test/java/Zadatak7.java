import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Zadatak7 {
    public static void main(String[] args) throws InterruptedException {
        //https://www.amazon.com/
        // Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/
        // ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2
        //Testirati dodavanje knjige u korpu i da li se knjiga obrise kada obrisete kolacice*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));



        driver.get("https://imgflip.com/memegenerator");
        Thread.sleep(3000);
        WebElement uploadButton = driver.findElement(By.id("mm-show-upload"));
        uploadButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement upload =driver.findElement(By.id("mm-upload-url"));
        upload.sendKeys("C:\\Users\\Masina\\Desktop\\qa fun");








    }

}
