package step_definitions;


import com.womenshop.pages.*;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;


public class SummerDressesStepdefs {
    private static final Logger LOGGER = Logger.getLogger(SummerDressesStepdefs.class.getSimpleName());
    private WomenShop womenShop;
    private DressesPage dressesPage;
    private ItemPage itemPage;
    private CartPage cartPage;
    private ItemsPanel itemsPanel;


    @Given("^I navigate to Women Online Shop Page$")
    public void navigateToWomenShopPage() {
        LOGGER.info("Navigating to Women SHop page");
        this.womenShop = new WomenShop();
    }

    @Given("I navigate to Summer Dresses page")
    public void iNavigateToSummerDressesPage() {
        LOGGER.info("Navigate to SummerDresses PAge");
        this.dressesPage = this.womenShop.navigateToDressesTab();
        this.dressesPage.clickSummerDressOption();
    }

    @And("^I filter \"([^\"]*)\" size$")
    public void iFilterSize(String size) {
        this.dressesPage.getCatalogBox().setSize(size);
        LOGGER.info("I filter " + size + " size");
    }

    @And("^I filter \"([^\"]*)\" color$")
    public void iFilterColor(String color) {
        this.dressesPage.getCatalogBox().setColor(color);
        LOGGER.info("I filter " + color + " color");
    }

    @When("^I sort by \"([^\"]*)\" dropdown$")
    public void iSortByDropdown(String option) {
        this.dressesPage.selectSortBy(option);
        LOGGER.info("I sorted by " + option);

    }

    @Then("^I verify that \"([^\"]*)\" is displayed with a price of \"([^\"]*)\"")
    public void iVerifyThatIsDisplayedWithAPriceOf$(String dress, String price) {
        this.dressesPage.getItemsPanel().isItemPresent(dress);
        this.dressesPage.getItemsPanel().itemsList();
        boolean actual = this.dressesPage.getItemsPanel().itemExistsWithPrice(dress, price);
        Assert.assertTrue("Dress is not  displayed " + dress + " with price " + price, actual);
        LOGGER.info("Dress is displayed " + dress + " with price " + price);
    }

    @And("I verify that listed items have asscendant ordering by price")
    public void iVerifyThatListedItemsHaveAsscendantOrderingByPrice() {
        boolean actual = this.dressesPage.getItemsPanel().itemsAreInAscendantOrder();
        Assert.assertTrue("items list are not in ascendant order: ", actual);
        LOGGER.info("Validate that items list are in ascendant order");
    }

    public WomenShop getWomenShop() {
        LOGGER.info("Get Women Shop");
        return this.womenShop;
    }

    @After("@CloseWomenShop")
    public void tearDown() {
        LOGGER.info("Close Women Shop");
        this.womenShop.closeWindows();
    }

    @When("^I select \"([^\"]*)\" item$")
    public void iSelectItem(String item) throws Throwable {
        LOGGER.info("Select item: " + item);
        itemPage = this.dressesPage.getItemsPanel().selectItem(item);

    }

    @And("^I click on add cart$")
    public void iClickOnAddCart() {

        itemPage.clickAddToCartButton();
    }

    @And("^I click on proceed to cart$")
    public void iClickOnProceedToCart() {
        cartPage = itemPage.clickProceedButton();
    }

    @Then("^I see the \"([^\"]*)\" item on the cart list$")
    public void iSeeTheItemOnTheCartList(String item) throws Throwable {
        cartPage.isItemPresent(item);
    }

    @When("^I search \"([^\"]*)\" item$")
    public void iSearchItem(String item) throws Throwable {
        itemsPanel = this.womenShop.searchItem(item);
    }

    @Then("^I see the \"([^\"]*)\" word appears on the items list$")
    public void iSeeTheWordAppearsOnTheItemsList(String item) throws Throwable {
        Assert.assertTrue("Searched items contains elements not searched", itemsPanel.itemsContainsWord(item));
    }

    @When("^I see the online shop logo$")
    public void iSeeTheOnlineShopLogo() {
       this.womenShop.logoIconIsDisplayed();
    }

    @Then("^Navigation bar is displayed$")
    public void navigationBarIsDisplayed() {
        this.womenShop.navigationBarIsDisplayed();
    }

    @And("^Search button is displayed$")
    public void searchButtonIsDisplayed() {
        this.womenShop.searchItemIsDisplayed();
    }

    @And("^items panel is displayed$")
    public void itemsPanelIsDisplayed() {
        this.womenShop.itemsPanelIsDisplayed();
    }

    @And("^Cart Dropdown is displayed$")
    public void cartDropdownIsDisplayed() {
        this.womenShop.cartDropdownIsDisplayed();
    }

    @And("^User Info Bar is displayed$")
    public void userInfoBarIsDisplayed() {
        this.womenShop.userInfoBarIsDisplayed();
    }
}
