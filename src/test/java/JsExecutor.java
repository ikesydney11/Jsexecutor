import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class JsExecutor {
    static ExtentReports extent = new ExtentReports();
    static ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html");
     @Test
    public void setUp() {
        extent.attachReporter(spark);
        extent.setSystemInfo("Author", "Ikechukwu");

        ExtentTest test = extent.createTest("Automation Tab Test")
                .assignCategory("Smoke Test")
                .assignDevice("Firefox");
        WebDriver driver = new FirefoxDriver();
        test.info("Browser started");
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
            driver.get("https://www.browserstack.com");
            test.info("Navigated to browserstack.com");
            WebElement automation = driver.findElement(By.id("menu-ite-91794"));
            automation.click();
            test.pass("Clicked on Automation menu item");

        } catch (Exception e) {
            test.fail("Test failed: " + e.getMessage());
        } finally {
            driver.quit();
            test.info("Browser closed");
            extent.flush();
        }
}
}
