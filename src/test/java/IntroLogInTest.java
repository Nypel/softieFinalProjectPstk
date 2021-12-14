import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IntroLogInTest {

    static WebDriver driver;
    // Wait wait = new WebDriverWait(driver, 5000);

    @BeforeAll
    static void warmUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // wprowadź metodę wait, dlaczego webdriverWait co proponują w zamian, wyszukać,
        // najpierw utworzyć testy w jednej klasie, a potem rozić na inne klasy, np. loginTest , registrationTest itp.
        // utworzyć klasę bazową i tam przechowywać BeforeAll, tam trzeba wynieść webDrivera do klasy bazowej - BaseTestClass


    }


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


    @Test
    void shouldLoginProperlyThroughTheIconLogin() {
        driver.navigate().to("http://34.118.91.43/shop/");
        driver.findElement(By.xpath("//*[@id=\"meta-2\"]/ul/li[1]/a")).click();
        driver.findElement(By.id("user_login")).sendKeys("");
        // Log in as Admin,


    }


    @AfterAll
    static void tearDown() {
        driver.close();

    }
}



