import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogoAndSearchFieldTest extends BaseTestClass {

    @Test
    void doesHomePageContainLogoAndSearchField() throws InterruptedException {
        driver.navigate().to("http://34.118.91.43/shop/");
        WebElement logoElement = driver.findElement(By.xpath("//*[@id=\"masthead\"]/div[1]/div[1]/div/a"));
        Assertions.assertTrue(logoElement.isDisplayed());
        WebElement searchElement = driver.findElement(By.xpath("//*[@id=\"woocommerce-product-search-field-0\"]"));
        Assertions.assertTrue(searchElement.isDisplayed());
    }
}