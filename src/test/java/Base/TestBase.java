package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBase {

    public String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    public static WebDriver driver;

    public void initialization(){
         driver = new ChromeDriver();

         driver.manage().window().maximize();
         driver.get(baseUrl);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }
}
