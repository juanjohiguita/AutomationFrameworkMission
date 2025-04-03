package web.stepdefinitions;

import core.utils.UserFileReader;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import lombok.NoArgsConstructor;
import web.questions.LoginQuestions;
import web.tasks.LoginTasks;

import static core.utils.TestContextManager.getTestContext;

@NoArgsConstructor
public class LoginStepsDefinition {
    LoginTasks loginTasks = new LoginTasks();
    LoginQuestions loginQuestions = new LoginQuestions();

    @When("I fill login with valid credentials")
    public void iFillLoginWithValidCredentials() {
        String userId = "validUser";
        UserFileReader.Account account = UserFileReader.getAccountById(userId);
        loginTasks.fillLogin(account.getUsername(), account.getPassword());
        getTestContext().set("username", account.getUsername());
    }

    @When("I fill login with invalid credentials")
    public void iFillLoginWithInvalidCredentials() {
        String userId = "invalidUser";
        UserFileReader.Account account = UserFileReader.getAccountById(userId);
        loginTasks.fillLogin(account.getUsername(), account.getPassword());
        getTestContext().set("username", account.getUsername());
    }

    @When("I expect a error message")
    public void iExpectErrorMessage() {
        String username = getTestContext().get("username");
        Allure.addAttachment("USERNAME:", username);
        loginQuestions.verifyErrorMessageIsDisplayed();
    }
}
