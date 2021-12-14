import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SearchFieldTest extends BaseTestClass {

    @Test
    void doesTheSearchFieldAcceptWordInLowercase() throws InterruptedException {
        driver.navigate().to("http://34.118.91.43/");
        driver.findElement(By.name("s")).sendKeys("coin");
        driver.findElement(By.name("s")).submit();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/p")).getText().
                contains("Showing all 3 results"));


    }


    @Test
    void doesTheSearchFieldAcceptWordInUppercase() throws InterruptedException {
        driver.navigate().to("http://34.118.91.43/shop/");
        driver.findElement(By.name("s")).sendKeys("GOLD");
        driver.findElement(By.name("s")).submit();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/p")).getText().
                contains("Showing all 4 results"));


    }


    @Test
    void doesTheSearchFieldAcceptWordInUppercaseAndLowercase() throws InterruptedException {
        driver.navigate().to("http://34.118.91.43/shop/");
        driver.findElement(By.name("s")).sendKeys("CoINs");
        driver.findElement(By.name("s")).submit();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/p")).getText().
                contains("Showing all 2 results"));


    }


    @Test
    void shouldSearchFieldTakesSpecialCharacters() throws InterruptedException {
        driver.navigate().to("http://34.118.91.43/shop/");
        driver.findElement(By.name("s")).sendKeys("@#^^%&&();");
        driver.findElement(By.name("s")).submit();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"main\"]/p")).getText().
                contains("No products were found"));


    }
}
