package web.questions;

import org.testng.Assert;
import web.pages.InventoryScreen;

public class InventoryQuestions extends InventoryScreen {

    public void validatePageIsDisplayed() {
        Assert.assertTrue(getInventoryContainer().isDisplayed());
    }
}
