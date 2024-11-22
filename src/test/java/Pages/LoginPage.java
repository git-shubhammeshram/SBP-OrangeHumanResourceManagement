package Pages;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage extends TestBase {

    public String loginToApplication(String username, String password) {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        return driver.getCurrentUrl();
    }

    public String loginToApplicationWithInvalidUserData(String username, String password) {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        return driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();
    }


    public String logoutToApplication() {
        driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
        List<WebElement> list = driver.findElements(By.xpath("//a[@class='oxd-userdropdown-link']"));
        for (WebElement li : list)
            System.out.println(li.getText());
        list.get(3).click();
        return driver.getCurrentUrl();
    }
}
