package web.pages;

import core.pages.basePage.BaseScreen;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class InventoryScreen extends BaseScreen {

    @FindBy(id = "inventory_container")
    protected WebElement inventoryContainer;

    @FindBy(id = "shopping_cart_container")
    protected WebElement shoppingCartBtn;

    @FindBy(className = "pricebar")
    protected List<WebElement> priceBarList;

}
