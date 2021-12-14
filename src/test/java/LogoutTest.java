import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class LogoutTest extends BaseTestClass {

    @Test
    void isLogoutWorksProperly() throws InterruptedException {
        driver.navigate().to("http://34.118.91.43/shop/");
        driver.findElement(By.xpath("//*[@id=\"site-navigation\"]/div[1]/ul/li[4]/a")).click();
        driver.findElement(By.id("username")).sendKeys("shopmanager");
        driver.findElement(By.id("password")).sendKeys("MGc23z0NRR");
        driver.findElement(By.xpath("//*[@id=\"post-9\"]/div/div/form/p[3]/button")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("my-account"));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"post-9\"]/div[1]/div/div/p[1]")).getText().
                contains("Hello"));
        driver.findElement(By.xpath("//*[@id=\"post-9\"]/div[1]/div/nav/ul/li[6]/a")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"post-9\"]/div/div/h2")).isDisplayed());


    }


}
