package steps;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckPriceTest {
    private WebDriver driver;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/chromedriver90.exe");
        driver = new ChromeDriver();
        //js = (JavascriptExecutor) driver;
    }
    @After
    public void tearDown() {
        //driver.quit();
    }
    @Test
    public void checkPrice() {
        driver.get("https://www.alibris.com/");
        driver.manage().window().setSize(new Dimension(1563, 878));
        driver.findElement(By.id("searchBox")).click();
        driver.findElement(By.id("searchBox")).sendKeys("the art of software testing");
        driver.findElement(By.id("sbSubmit")).click();
        driver.findElement(By.linkText("The Art of Software Testing")).click();
        System.out.println(driver.findElement(By.cssSelector(".product-container:nth-child(1) .price > p")).getText());
        assertThat(driver.findElement(By.cssSelector(".product-container:nth-child(1) .price > p")).getText(), is("C$2,470.25"));
    }
}