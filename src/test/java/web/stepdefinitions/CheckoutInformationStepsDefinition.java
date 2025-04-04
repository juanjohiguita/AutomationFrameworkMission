package web.stepdefinitions;

import io.cucumber.java.en.Then;
import lombok.NoArgsConstructor;
import web.tasks.CheckoutInformationScreenTasks;

public class CheckoutInformationStepsDefinition {
    CheckoutInformationScreenTasks checkoutInformationPageTasks = new CheckoutInformationScreenTasks();

    public CheckoutInformationStepsDefinition(){

    }

    @Then("I fill the checkout information")
    public void iFillTheCheckoutInformation() {
        checkoutInformationPageTasks.getFirstName().sendKeys("firstName");
        checkoutInformationPageTasks.getLastName().sendKeys("lastName");
        checkoutInformationPageTasks.getPostalCode().sendKeys("postalCode");
        checkoutInformationPageTasks.getContinueBtn().click();
    }
}
