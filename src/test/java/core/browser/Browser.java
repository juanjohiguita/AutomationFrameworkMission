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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


@UtilityClass
public class Browser {

    @SneakyThrows
    public static WebDriver createWebDriver() {
        ConfigReader configReader = new ConfigReader();
        String browser = "chrome";
        return createDriver(browser);
    }

    private static WebDriver createDriver(String browser) {
        if(isRemoteExecution()) {
            return createRemoteWebDriver(browser);
        } else {
            return createLocalWebDriver(browser);
        }
    }

    private boolean isRemoteExecution() {
        //TO-DO INDENTIFY IF IS REMOTE
        return true;
    }

    private WebDriver createRemoteWebDriver(String browser) {
        String url = "http://selenium-1:4444/wd/hub";
        //String url = "http://localhost:4444/wd/hub"; esto para ejecucion local con
        try {
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                return new RemoteWebDriver(new URL(url), options);
            } else if (browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--incognito");
                return new RemoteWebDriver(new URL(url), options);
            } else {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--incognito");
                return new RemoteWebDriver(new URL(url), options);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Selenium Grid URL", e);
        }
    }

    private WebDriver createLocalWebDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            return createChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            return createFirefoxDriver();
        } else {
            return createEdgeDriver();
        }
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
