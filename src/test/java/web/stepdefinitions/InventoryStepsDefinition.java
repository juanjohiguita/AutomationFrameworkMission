package web.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.questions.InventoryQuestions;
import web.tasks.InventoryScreenTasks;

public class InventoryStepsDefinition {
    InventoryScreenTasks inventoryPageTasks = new InventoryScreenTasks();
    InventoryQuestions inventoryQuestions = new InventoryQuestions();


    @Then("The inventory page is displayed")
    public void iGetTheInventory (){
        inventoryQuestions.validatePageIsDisplayed();
    }

    @When("I select the item with the lower price")
    public void iPurchaseTheItemWithTheLowerPrice() {
        inventoryPageTasks.selectElementWithLowerPrice();
    }
}
