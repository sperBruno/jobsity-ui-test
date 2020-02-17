package step_definitions;

import com.womenshop.pages.SocialiveDashboard;
import com.womenshop.pages.SocialivePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Login {
    private SocialivePage socialivePage;
    private SocialiveDashboard socialiveDashboard;
    @Given("^I navigate to Socialive Page$")
    public void iNavigateToSocialivePage() {
        socialivePage = new SocialivePage();
        socialivePage.navigateToSocialive();
    }

    @When("^I insert \"([^\"]*)\" in the user field$")
    public void iInsertInTheUserField(String username) throws Throwable {
        socialivePage.setUsername(username);
    }

    @And("^I insert \"([^\"]*)\" in the password field$")
    public void iInsertInThePasswordField(String password) throws Throwable {
        socialivePage.setPassword(password);
    }

    @And("^I click on the login button$")
    public void iClickOnTheLoginButton() {
        socialiveDashboard = socialivePage.clickLoginButton();
    }

    @Then("^Socialive Dashboard is displayed$")
    public void socialiveDashboardIsDisplayed() {
        Assert.assertTrue("The user navbar is not displayed", socialiveDashboard.isUserNavBarDisplayed());

    }
}
