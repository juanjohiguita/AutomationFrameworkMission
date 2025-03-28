package core.runner;

import core.listeners.TestListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"api/stepdefinitions", "web/stepdefinitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:reports/tests/cucumber/cucumber-pretty.html",
                "testng:reports/tests/cucumber/testng/cucumber.xml",
                "json:reports/tests/cucumber/json/cucumberTestReport.json"
        },
        tags = "@this"
)

@Listeners(TestListener.class)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
