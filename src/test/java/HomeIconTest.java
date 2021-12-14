import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class HomeIconTest extends BaseTestClass {

    @Test
    void doesItCorrectlyRedirectFromTheLoginPageToTheHomePage() throws InterruptedException {
        driver.navigate().to("http://34.118.91.43/shop/");
        driver.findElement(By.xpath("//*[@id=\"site-navigation\"]/div[1]/ul/li[4]/a")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("/my-account/"));
        driver.findElement(By.xpath("//*[@id=\"site-navigation\"]/div[1]/ul/li[1]/a")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"site-navigation\"]/div[1]/ul/li[1]/a")).
                getText().contains("Home"));


    }

}
