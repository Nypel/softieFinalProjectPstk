import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class IncorrectLoginTest extends BaseTestClass {

    @Test
    void shouldNotLoginProperlyThroughTheIconMyAccount() {
        driver.navigate().to("http://34.118.91.43/shop/");
        driver.findElement(By.xpath("//*[@id=\"site-navigation\"]/div[1]/ul/li[4]/a")).click();
        driver.findElement(By.id("username")).sendKeys("shopmanager");
        driver.findElement(By.id("password")).sendKeys("GhTJJ");
        driver.findElement(By.xpath("//*[@id=\"post-9\"]/div/div/form/p[3]/button")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul/li"))
                .getText().contains("is incorrect."));


    }

    @Test
    void shouldNotLoginWithoutLoginValueThroughTheIconMyAccount() {
        driver.navigate().to("http://34.118.91.43/shop/");
        driver.findElement(By.xpath("//*[@id=\"site-navigation\"]/div[1]/ul/li[4]/a")).click();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("MGc23z0NRR");
        driver.findElement(By.xpath("//*[@id=\"post-9\"]/div/div/form/p[3]/button")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul/li")).
                getText().contains("Username is required."));


    }

    @Test
    void shouldNotLoginWithWrongLoginValueThroughTheIconMyAccount() {
        driver.navigate().to("http://34.118.91.43/shop/");
        driver.findElement(By.xpath("//*[@id=\"site-navigation\"]/div[1]/ul/li[4]/a")).click();
        driver.findElement(By.id("username")).sendKeys("gitguy");
        driver.findElement(By.id("password")).sendKeys("MGc23z0NRR");
        driver.findElement(By.xpath("//*[@id=\"post-9\"]/div/div/form/p[3]/button")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul/li")).
                getText().contains("is not registered on this site"));


    }


    @Test
    void shouldNotLoginWithoutLoginPasswordThroughTheIconMyAccount() {
        driver.navigate().to(" http://34.118.91.43/shop/");
        driver.findElement(By.xpath("//*[@id=\"site-navigation\"]/div[1]/ul/li[4]/a")).click();
        driver.findElement(By.id("username")).sendKeys("shopmanager");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"post-9\"]/div/div/form/p[3]/button")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul/li")).
                getText().contains("The password field is empty."));


    }

    @Test
    void shouldNotLoginWithWrongLoginPasswordThroughTheIconMyAccount() {
        driver.navigate().to("http://34.118.91.43/shop/");
        driver.findElement(By.xpath("//*[@id=\"site-navigation\"]/div[1]/ul/li[4]/a")).click();
        driver.findElement(By.id("username")).sendKeys("shopmanager");
        driver.findElement(By.id("password")).sendKeys("555ddf88");
        driver.findElement(By.xpath("//*[@id=\"post-9\"]/div/div/form/p[3]/button")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul/li")).
                getText().contains("is incorrect."));

    }
}
