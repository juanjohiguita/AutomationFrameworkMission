package web.stepdefinitions;

import io.cucumber.java.en.When;
import lombok.NoArgsConstructor;
import web.tasks.CheckoutOverviewTasks;

public class CheckoutOverviewStepsDefinition {

    CheckoutOverviewTasks checkoutOverviewTasks = new CheckoutOverviewTasks();

    public CheckoutOverviewStepsDefinition(){

    }

    @When("I finish the checkout information")
    public void iFinishTheCheckoutInformation() {
        checkoutOverviewTasks.finishCheckoutOverview();
    }
}
