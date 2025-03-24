package web.stepsdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import web.questions.InventoryQuestions;
import web.tasks.InventoryScreenTasks;

public class InventoryStepsDefinition {
    InventoryScreenTasks inventoryPageTasks = new InventoryScreenTasks();
    InventoryQuestions inventoryQuestions = new InventoryQuestions();


    @Then("The inventory page is displayed")
    public void iGetTheInventory (){
        inventoryQuestions.validatePageIsDisplayed();
        Allure.step("Validate Inventory Page is displayed");
    }

    @When("I select the item with the lower price")
    public void iPurchaseTheItemWithTheLowerPrice() {
        inventoryPageTasks.selectElementWithLowerPrice();
    }
}
