package core.browser;

import core.utils.ConfigReader;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

@UtilityClass
public class Browser {

    @SneakyThrows
    public static WebDriver createWebDriver() {
        ConfigReader configReader = new ConfigReader();
        return createDriverByBrowserName(configReader.getBrowser());
    }

    public static WebDriver createDriverByBrowserName(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            return createChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            return createFirefoxDriver();
        } else {
            return createEdgeDriver();
        }
    }

    public static WebDriver createChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        return new ChromeDriver(options);
    }

    public static WebDriver createFirefoxDriver(){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--incognito");
        return new FirefoxDriver(options);
    }

    private static WebDriver createEdgeDriver() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--incognito");
        return new EdgeDriver(options);
    }
}
