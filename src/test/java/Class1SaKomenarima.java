import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class1SaKomenarima {

    public static void main(String[] args) {
/*
        //Stari nacin kako smo ucitavali chrome driver
        //Morali smo chromedriver.exe file da skinemo i smestimo u odredjen folder
        //Nakon toga komanda setProperty bi citala taj fajl
        //Postojao je problem kod odredjenih operativnih sistema gde je antivirus brisao ovaj fajl
        //i testovi bi padali jer fajl vise ne postoji pa ste morali da podesavate 'exception' za fajl

        //System.setProperty("webdrive.chrome.driver", "driver-lib\\chromedriver.exe"); --deprecated

        //Ovu komandu koristimo da podesimo chromedriver iz biblioteke koju smo uneli u pom fajl
        //Na pocetku klase mozete videti:
        //import io.github.bonigarcia.wdm.WebDriverManager;
        //gde se jasno vidi iz koje biblioteke se izvlaci komanda
        //To je ona treca biblioteka koju smo ubacili u pom fajl
        //Kada setujemo chromedriver potrebno je da napravimo objekat sa kojim cemo raditi
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Komanda navigate().to() nam otvara zeljeni URL
        //Obratite paznju koju URL ubacujete
        //Ako link NIJE podvucen kao u ovom primeru, onda znaci da link nije validan
        driver.navigate().to("https://www.google.com/");
        //Sledeca komanda je za povecanje prozora u kom radimo
        //Slicna komanda je manage().window().fullscreen()
        driver.manage().window().maximize();

        //Drugi nacin kako da odete na zeljeni URL je preko get() metode
        driver.get("https://www.youtube.com");

        //Razlike izmedju navigate i get mozete naci na narednom linku:
        //https://www.baeldung.com/selenium-webdriver-get-vs-navigate#:
        // ~:text=And%20because%20it's%20just%20an,driver.

        //Komanda za stampanje trenutno URL-a
        //Imajte u vidu da URL moze da se razlikuje od unetog iz prethodnog koraka
        System.out.println(driver.getCurrentUrl());


 */
    }
}