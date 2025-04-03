package core.hooks;

import core.listeners.TestListener;
import core.pages.basePage.BaseScreen;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import core.browser.Browser;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;

@Slf4j
@Listeners(TestListener.class)
public class Hooks {

    @Before(order = 0)
    public void initDriver() {
        BaseScreen.setDriver(Browser.createWebDriver());
    }

    @After(order = 2)
    public void assertAll() {
        //SoftAssertManager.getSoftAssert().assertAll();
    }

    @After(order = 0)
    public void closeDriver() {
        BaseScreen.closeDriver();
    }

}
