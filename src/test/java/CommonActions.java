import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.MainPage;


public class CommonActions {

    static WebDriver driver;


    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        MainPage objMainPage = new MainPage(driver);
        driver.manage().window().maximize();
        objMainPage.openSite();
        objMainPage.clickCookieButton();

    }


/**
    @BeforeEach
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        MainPage objMainPage = new MainPage(driver);
        driver.manage().window().maximize();
        objMainPage.openSite();
        objMainPage.clickCookieButton();
    }
 */


    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
