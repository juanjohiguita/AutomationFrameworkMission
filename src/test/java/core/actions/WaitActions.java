package core.actions;

import core.pages.basePage.BaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class WaitActions {

    /**
     * Set a implicit time with a specific time
     * @param seconds time to do the implicit wait
     */
    public static void implicitWait(int seconds){
        BaseScreen.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    /**
     * Waits until the element is visible
     * @param webElement element to check the parameter
     * @param seconds time to wait
     */
    public static void waitForElementToBeVisible(WebElement webElement, int seconds) {
        WebDriverWait wait = new WebDriverWait(BaseScreen.getDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * Waits until the element is clickable
     * @param webElement element to check the parameter
     * @param seconds time to wait
     */
    public static void waitForElementToBeClickable(WebElement webElement, int seconds) {
        WebDriverWait wait = new WebDriverWait(BaseScreen.getDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Waits until the element is not visible
     * @param webElement element to check the parameter
     * @param seconds time to wait
     */
    public static void waitForElementToDisappear(WebElement webElement, int seconds) {
        WebDriverWait wait = new WebDriverWait(BaseScreen.getDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    /**
     * Waits until the element is not present in the DOM (not is required that the element is visible)
     * @param locator element locator to check the parameter
     * @param seconds time to wait
     */
    public static void waitForElementToBePresent(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(BaseScreen.getDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Waits until changes in the text for a WebElement
     * @param webElement element to check the parameter
     * @param oldText text that is expected change
     * @param seconds time to wait
     */
    public static void waitForTextToBeChanged(WebElement webElement, String oldText, int seconds) {
        WebDriverWait wait = new WebDriverWait(BaseScreen.getDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, oldText));
    }
}
