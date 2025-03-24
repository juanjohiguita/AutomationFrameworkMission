package web.pages;

import core.pages.basePage.BaseScreen;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CheckoutOverviewScreen extends BaseScreen {

    @FindBy(id = "finish")
    private WebElement finishBtn;

}
