import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak2 {
    public static void main(String[] args) {
        //Zadatak 2
//Otvoriti browser i jos 5 tabova
//Na svakom tabu otvoriti URL po zelji
//Zatvoriti sve tabove osim onog gde je otvoren Google

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));
        driver.get("https://www.baeldung.com/selenium-webdriver-get-vs-navigate#:%20%20%20%20%20%20%20%20//%20~:text=And%20because%20it's%20just%20an,driver.");
        driver.switchTo().window(listaTabova.get(2));
        driver.get("https://app.slack.com/client/T066QTPDYFJ/C0661R54R27/thread/C0661R54R27-1705087085.115439");
        driver.switchTo().window(listaTabova.get(3));
        driver.get("https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager");
        driver.switchTo().window(listaTabova.get(4));
        driver.get("https://drive.google.com/drive/folders/1LexoYao_zh-51rvBIWi3kCkgivxMTZkk");

        driver.close();
        driver.switchTo().window(listaTabova.get(3));
        driver.close();
        driver.switchTo().window(listaTabova.get(2));
        driver.close();
        driver.switchTo().window(listaTabova.get(1));
        System.out.println(driver.getCurrentUrl());
    }
}
