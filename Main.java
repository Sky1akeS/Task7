import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Main {
    @VisibleForTesting
    public static void main(String[] args) {
        String searchText = "Монитор";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sky\\IdeaProjects\\FirstTest\\browserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();

        String searchFieldXpath = "//input[@name='search']";
        WebElement serchElement = driver.findElement(By.xpath(searchFieldXpath));
        serchElement.sendKeys("Монитор");
        serchElement.sendKeys(Keys.ENTER);
        WebElement firstProductElement = driver.findElement(By.cssSelector("Монитор"));
        String actualText = firstProductElement.getText();
        Assert.assertTrue(actualText.contains(searchText));
        driver.quit();

    }
}
