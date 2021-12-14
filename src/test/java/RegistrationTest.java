import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class RegistrationTest extends BaseTestClass {

    @Test
    void isNewRegistrationCorrect() throws InterruptedException {
        Faker faker = new Faker();
        String uniqueData = faker.name().firstName() + faker.name().lastName();
        driver.navigate().to("http://34.118.91.43/shop/");
        driver.findElement(By.xpath("//*[@id=\"site-navigation\"]/div[1]/ul/li[4]/a")).click();
        driver.findElement(By.id("username")).sendKeys("shopmanager");
        driver.findElement(By.id("password")).sendKeys("MGc23z0NRR");
        driver.findElement(By.xpath("//*[@id=\"post-9\"]/div/div/form/p[3]/button")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("my-account"));
        driver.findElement(By.xpath("//*[@id=\"post-9\"]/div[1]/div/nav/ul/li[5]/a")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("my-account/edit-account/"));
        driver.findElement(By.id("account_first_name")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("account_last_name")).sendKeys((faker.name().lastName()));
        driver.findElement(By.name("save_account_details")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div")).
                getText().contains("Account details changed successfully."));

    }
}

