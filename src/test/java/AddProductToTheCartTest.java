import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AddProductToTheCartTest extends BaseTestClass {


    @Test
    void doesItCorrectlyAddProductToCartWithSearchingByPriceFromTheLowToHigh() throws InterruptedException {
        driver.navigate().to("http://34.118.91.43/shop/");
        driver.findElement(By.name("orderby")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/form/select/option[5]")).
                getText().contains("low to high"));
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/form/select/option[5]")).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/ul/li[1]/a[2]")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"main\"]/ul/li[1]/a[3]")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"main\"]/ul/li[1]/a[3]")).
                getText().contains("View cart"));
        driver.findElement(By.xpath("//*[@id=\"main\"]/ul/li[1]/a[3]")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"post-7\"]/div[1]/div/form/table/tbody/tr[1]/td[1]/a")).
                isDisplayed());

    }
}
