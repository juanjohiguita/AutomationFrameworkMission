package web.pages;

import core.pages.basePage.BaseScreen;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CartScreen extends BaseScreen {

    @FindBy(id = "checkout")
    private WebElement checkoutBtn;
}
