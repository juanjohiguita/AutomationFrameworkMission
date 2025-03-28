package web.questions;

import io.qameta.allure.Allure;
import org.testng.Assert;
import web.pages.InventoryScreen;

public class InventoryQuestions extends InventoryScreen {

    public void validatePageIsDisplayed() {
        Allure.step("Validate Inventory Page is displayed");
        Assert.assertTrue(getInventoryContainer().isDisplayed());
    }
}
