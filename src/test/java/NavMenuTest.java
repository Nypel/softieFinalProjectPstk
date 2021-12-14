import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class NavMenuTest extends BaseTestClass {

    @Test
    void doesCartIconRedirectToTheCartPage() throws InterruptedException {
        driver.navigate().to("http://34.118.91.43/shop/");
        driver.findElement(By.xpath("//*[@id=\"site-navigation\"]/div[1]/ul/li[2]/a")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/p[1]")).getText().
                contains("Your cart is currently empty."));


    }


    @Test
    void doesMyAccountIconRedirectToTheMyAccount() throws InterruptedException {
        driver.navigate().to("http://34.118.91.43/shop/");
        driver.findElement(By.xpath("//*[@id=\"site-navigation\"]/div[1]/ul/li[4]/a")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("my-account/"));


    }

    @Test
    void doesOurTeamIconRedirectToTheOurTeam() throws InterruptedException {
        driver.navigate().to("http://34.118.91.43/shop/");
        driver.findElement(By.xpath("//*[@id=\"site-navigation\"]/div[1]/ul/li[5]/a")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"post-2\"]/header/h1")).
                getText().contains("Our Team"));

    }
}
