package web.stepsdefinitions;

import io.cucumber.java.en.When;
import web.tasks.CheckoutOverviewTasks;

public class CheckoutOverviewStepsDefinition {

    CheckoutOverviewTasks checkoutOverviewTasks = new CheckoutOverviewTasks();

    @When("I finish the checkout information")
    public void iFinishTheCheckoutInformation() {
        checkoutOverviewTasks.finishCheckoutOverview();
    }
}
