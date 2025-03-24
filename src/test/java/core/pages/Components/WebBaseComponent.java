package core.pages.Components;

import core.pages.basePage.BaseScreen;
import org.openqa.selenium.support.PageFactory;

public class WebBaseComponent extends BaseScreen {

    protected WebBaseComponent() {
        super();
        PageFactory.initElements(getDriver(), this);
    }
}
