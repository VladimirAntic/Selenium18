import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium6 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wordpress.com/");

        Cookie cookie = new Cookie("wordpress_logged_in","vladimiranticqa%7C1800042176%7CjFTct5zQgONMaPY1MnHm3WjvJYGUWiaViStXO3prlTb%7C4f1703bb2fad400b819023ea82db0f2ac1028cef7b1864229b33988a737f1ccb");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

    }
}
