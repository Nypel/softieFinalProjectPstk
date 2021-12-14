import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class BuyProductTest extends BaseTestClass {

    @Test
    void doesProductPurchaseIsWorkingProperly() throws InterruptedException {

        Faker faker = new Faker();
        String customerData = faker.name().firstName() + faker.name().lastName() + "op.pl";
        driver.navigate().to("http://34.118.91.43/shop/");
        driver.findElement(By.xpath("//*[@id=\"main\"]/ul/li[2]/a[2]")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"main\"]/ul/li[2]/a[3]")).isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"main\"]/ul/li[2]/a[3]")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/div[2]/div/div/a")).isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/div[2]/div/div/a")).click();
        driver.findElement(By.id("billing_first_name")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("billing_last_name")).sendKeys(faker.name().lastName());
        driver.findElement(By.id("billing_address_1")).sendKeys(faker.address().streetAddress() + "2");
        driver.findElement(By.id("billing_city")).sendKeys(faker.address().city());
        driver.findElement(By.id("billing_postcode")).sendKeys(faker.address().zipCode());
        driver.findElement(By.id("billing_phone")).sendKeys(String.valueOf(faker.number().randomNumber()));
        driver.findElement(By.id("billing_email")).sendKeys(faker.name().firstName() + "op.pl");
        Select country = new Select(driver.findElement(By.id("billing_country")));
        country.selectByVisibleText("Afghanistan");
        driver.findElement(By.id("place_order")).click();
        driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/div[2]/div/a")).click();
        driver.findElement(By.id("coupon_code")).sendKeys("JTVSD9ZZ");
        driver.findElement(By.name("apply_coupon")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"order_review\"]/table/tfoot/tr[2]/th")).
                isDisplayed());
    }
}
