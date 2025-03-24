package web.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import core.pages.basePage.BaseScreen;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginScreen extends BaseScreen {

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    @FindBy(id = "login-button")
    private WebElement loginBtn;
}
