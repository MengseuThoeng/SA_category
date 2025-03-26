package ite.istad.category;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UICategoryTest {

    @LocalServerPort
    private int port;

    private WebDriver driver;
    private String baseUrl;

    @BeforeEach
    public void setUp() {
        // Set up ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "http://localhost:" + port;
    }

    @Test
    public void category_BadRequest() {
        try {
            // Navigate to the "Add Category" page
            driver.get(baseUrl + "/categories/new");

            // Use JavaScript to submit the form, bypassing client-side validation
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.querySelector('form').submit();");

            // Print the page source for debugging
            System.out.println("Page source after form submission:");
            System.out.println(driver.getPageSource());

            // Wait for the validation error message to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Increased timeout to 10 seconds
            WebElement errorMessage = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.className("error-message"))
            );

            // Assert that the error message is displayed and contains the expected text
            assertTrue(errorMessage.isDisplayed(), "Validation error message should be displayed");
            assertTrue(errorMessage.getText().contains("Category name cannot be empty"), "Error message should indicate that the name cannot be empty");
        } catch (Exception e) {
            // Take a screenshot if the test fails
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshot, new File("screenshot-failure.png"));
                System.out.println("Screenshot saved as screenshot-failure.png");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            throw e; // Re-throw the exception to fail the test
        }
    }

    @AfterEach
    public void tearDown() {
        // Clean up by quitting the driver
        if (driver != null) {
            driver.quit();
        }
    }
}