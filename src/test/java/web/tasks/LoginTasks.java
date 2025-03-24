package web.tasks;

import core.actions.WaitActions;
import core.utils.UserFileReader;
import io.qameta.allure.Allure;
import web.pages.LoginScreen;

public class LoginTasks extends LoginScreen {

    public void fillLogin() {
        UserFileReader.Account account = UserFileReader.getAccountById("validUser");
        fillLogin(account.getUsername(), account.getPassword());
    }

    public void fillLogin(String username, String password) {
        Allure.step("Fill login with valid credentials");
        WaitActions.waitForElementToBeVisible(getUsername(), 5);
        getUsername().sendKeys(username);
        WaitActions.waitForElementToBeVisible(getPassword(), 5);
        getPassword().sendKeys(password);
        WaitActions.waitForElementToBeVisible(getLoginBtn(), 5);
        getLoginBtn().click();
    }
}
