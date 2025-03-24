package web.tasks;

import core.actions.WaitActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import web.pages.InventoryScreen;
import web.utils.InventoryUtils;

public class InventoryScreenTasks extends InventoryScreen {

    public WebElement getLowerPriceItem() {
        String lowerPrice = "1000000000000000";
        WebElement lowerPriceItem = null;
        for (WebElement priceBar : priceBarList) {
            WebElement priceItem = priceBar.findElement(By.className("inventory_item_price"));
            if (InventoryUtils.convertToDouble(lowerPrice) > InventoryUtils.convertToDouble(
                    InventoryUtils.removeCurrencySymbol(priceItem.getText()))) {
                lowerPrice = InventoryUtils.removeCurrencySymbol(priceItem.getText());
                lowerPriceItem = priceItem;
            }
        }
        return lowerPriceItem;
    }

    public void selectElementWithLowerPrice(){
        WebElement lowerPriceItem = getLowerPriceItem();
        String lowerPrice = InventoryUtils.removeCurrencySymbol(lowerPriceItem.getText());
        WebElement addToCardBtn = lowerPriceItem.findElement(By.xpath("//button[text()='Add to cart']"));
        addToCardBtn.click();
        WaitActions.waitForElementToBeClickable(getShoppingCartBtn(), 4);
        getShoppingCartBtn().click();
    }
}
