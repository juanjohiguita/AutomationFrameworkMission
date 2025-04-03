package core.pages.basePage;

import core.browser.Browser;
import core.utils.ConfigReader;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Slf4j
@Getter
public abstract class BaseScreen {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    protected BaseScreen() {
        WebDriver driver = getDriver();
        if (driver == null) {
            driver = Browser.createWebDriver();
            setDriver(driver);
        }
        try {
            PageFactory.initElements(getDriver(), this);
        } catch (Exception e) {
            log.error("Error while initializing page elements: {}", e.getMessage());
        }
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void closeDriver() {
        WebDriver driver = getDriver();
        if(driver != null) {
            driver.close();
        }
        driverThreadLocal.remove();
    }

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
        ConfigReader configReader = new ConfigReader();
        openPageByUrl(configReader.getUrl());
    }

    public static void openPageByUrl(String url) {
        driverThreadLocal.get().get(url);
    }
}
