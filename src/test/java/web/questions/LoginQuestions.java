package web.questions;

import core.actions.WaitActions;
import io.qameta.allure.Allure;
import org.testng.Assert;
import web.pages.LoginScreen;

public class LoginQuestions extends LoginScreen {

    public void verifyErrorMessageIsDisplayed() {
        Allure.step("Verify Error message is displayed");
        WaitActions.waitForElementToBeVisible(getErrorMessage(), 2);
        Assert.assertEquals(getErrorMessage().getText(), "Epic sadface: Username and password do not match any user in this service");
    }
}
