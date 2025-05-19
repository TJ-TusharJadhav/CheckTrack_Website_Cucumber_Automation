package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebScrollUtils {

    private static WebDriver driver;
    
    // Initialize with your WebDriver instance
    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public enum ScrollDirection {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    // Basic JavaScript scroll methods
    public static void scrollByPixels(int x, int y) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public static void scrollToTop() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
    }

    public static void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Directional scroll with ratio (0.0 to 1.0)
    public static void scroll(ScrollDirection direction, double scrollRatio) {
        if (scrollRatio < 0 || scrollRatio > 1) {
            throw new IllegalArgumentException("Scroll ratio must be between 0 and 1");
        }

        long windowHeight = (Long) ((JavascriptExecutor) driver).executeScript("return window.innerHeight");
        long windowWidth = (Long) ((JavascriptExecutor) driver).executeScript("return window.innerWidth");
        long scrollDistance = (long) (windowHeight * scrollRatio);

        switch (direction) {
            case UP:
                scrollByPixels(0, (int) -scrollDistance);
                break;
            case DOWN:
                scrollByPixels(0, (int) scrollDistance);
                break;
            case LEFT:
                scrollByPixels((int) -scrollDistance, 0);
                break;
            case RIGHT:
                scrollByPixels((int) scrollDistance, 0);
                break;
        }
    }

    // Scroll until element is visible and click it
    public static void scrollAndClick(By locator) {
        WebElement element = driver.findElement(locator);
        scrollToElement(element);
        element.click();
    }

    // Scroll through a list to find and click an element with specific attribute value
    public static void scrollFindAndClick(By listItems, String attribute, String value) {
        for (WebElement item : driver.findElements(listItems)) {
            if (value.equalsIgnoreCase(item.getAttribute(attribute))) {
                scrollToElement(item);
                item.click();
                return;
            }
        }
        throw new RuntimeException("Element with " + attribute + "='" + value + "' not found");
    }

    // Smooth scroll using Actions (simulates human-like scrolling)
    public static void smoothScroll(ScrollDirection direction, int iterations) {
        Actions actions = new Actions(driver);
        int scrollAmount = 100; // pixels per scroll step

        for (int i = 0; i < iterations; i++) {
            if (direction == ScrollDirection.DOWN) {
                actions.scrollByAmount(0, scrollAmount).perform();
            } else if (direction == ScrollDirection.UP) {
                actions.scrollByAmount(0, -scrollAmount).perform();
            } else if (direction == ScrollDirection.LEFT) {
                actions.scrollByAmount(-scrollAmount, 0).perform();
            } else if (direction == ScrollDirection.RIGHT) {
                actions.scrollByAmount(scrollAmount, 0).perform();
            }
            
            try {
                Thread.sleep(100); // small delay between scroll steps
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}