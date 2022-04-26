import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
        public static  void main(String[] args) throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.lcwaikiki.com/tr-TR/TR/");
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            WebElement element1 = driver.findElement(By.cssSelector("span[class='user-wrapper']"));
            element1.click();
            driver.findElement(By.cssSelector("a[class='login-form__link']")).click();
            driver.findElement(By.id("RegisterFormView_RegisterEmail")).sendKeys("abc12gmail.com");
            driver.findElement(By.id("RegisterFormView_Password")).sendKeys("a12");
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("a[class='button bc-blue register-button-link submit-button']")).click();
            String email_error = driver.findElement(By.id("RegisterFormView_RegisterEmail-error")).getText();
            String password_error = driver.findElement(By.id("RegisterFormView_Password-error")).getText();
            String phone_error = driver.findElement(By.id("RegisterPhoneNumberTR-error")).getText();
            System.out.println(email_error);
            System.out.println(password_error);
            System.out.println(phone_error);
            driver.quit();



        }
}
