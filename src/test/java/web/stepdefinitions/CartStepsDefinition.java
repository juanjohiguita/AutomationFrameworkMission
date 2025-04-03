package web.stepdefinitions;

import core.actions.WaitActions;
import io.cucumber.java.en.Then;
import lombok.NoArgsConstructor;
import web.tasks.CartScreenTasks;

@NoArgsConstructor
public class CartStepsDefinition {
    CartScreenTasks cartTasks = new CartScreenTasks();

    @Then("I click on checkout button")
    public void iClickOnCheckoutButton() {
        WaitActions.waitForElementToBeVisible(cartTasks.getCheckoutBtn(), 4);
        cartTasks.getCheckoutBtn().click();
    }
}
