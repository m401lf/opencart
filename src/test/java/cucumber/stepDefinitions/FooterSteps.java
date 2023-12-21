package cucumber.stepDefinitions;

import Pages.BasePage;
import TestComponents.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;


public class FooterSteps extends TestBase {
    BasePage page = PageFactory.initElements(driver, BasePage.class);

    @When("^I click the Terms and Conditions link in the bottom footer$")
    public void i_click_the_Terms_and_Conditions_link_in_the_bottom_footer() throws Throwable {
        page.clickTermsAndConditionsLink();
    }

    @When("^I click the candidate Terms and Conditions link in the bottom footer$")
    public void i_click_the_candidate_Terms_and_Conditions_link_in_the_bottom_footer() throws Throwable {
        page.clickCanTermsAndConditionsLink();
    }

    @When("^the Terms and Conditions are displayed in new tab$")
    public void the_Terms_and_Conditions_are_displayed_in_new_tab() throws Throwable {
        //NavigateToNewTab.navigateToNewTab();
    }

    @When("^I click the privacy policy link in the bottom footer$")
    public void i_click_the_privacy_policy_link_in_the_bottom_footer() throws Throwable {
        page.clickPrivacyPolicyLink();
    }

    @When("^I click the candidate privacy policy link in the bottom footer$")
    public void i_click_the_candidate_privacy_policy_link_in_the_bottom_footer() throws Throwable {
        page.clickCandidatePrivacyPolicyLink();
    }


    @When("^the Privacy Policy is displayed in new tab$")
    public void the_Privacy_Policy_is_displayed_in_new_tab() throws Throwable {
        //NavigateToNewTab.navigateToNewTab();
    }

    @When("^I click the cookies link in the bottom footer$")
    public void i_click_the_cookies_link_in_the_bottom_footer() throws Throwable {
        page.clickCookiesLink();
    }


    @When("^the cookies is displayed in new tab$")
    public void the_cookies_is_displayed_in_new_tab() throws Throwable {
        //NavigateToNewTab.navigateToNewTab();
    }

    @And("^the link should be labelled google analytics\"([^\"]*)\"$")
    public void the_link_should_be_labelled_google_analytics(String linkText) throws Throwable {
        //page.assertGoogleAnalyticsLinkIsDisplayed();
    }

    @And("^the link should be labelled essential cookies\"([^\"]*)\"$")
    public void the_link_should_be_labelled_essential_cookies(String linkText) throws Throwable {
        //page.assertEssentialCookiesLinkIsDisplayed();

    }


    @And("^the link should be labelled privacy policy\"([^\"]*)\"$")
    public void the_link_should_be_labelled_privacy_policy(String linkText) throws Throwable {
        page.assertPolicyPrivacyLinkIsDisplayed();

    }

    @And("^the button should be labelled use google analytics radio button\"([^\"]*)\"$")
    public void the_button_should_be_labelled_use_google_analytics_radio_button(String button) throws Throwable {
        page.assertUseGoogleAnalyticsRadioButtonIsDisplayed();

    }

    @And("^the button should be labelled save \"([^\"]*)\"$")
    public void the_button_should_be_labelled_save(String button) throws Throwable {
        page.assertSaveRadioButtonIsDisplayed();
    }

//	========== Scenario 2===============

    @Given("^I have previously selected Use Google Analytics cookies$")
    public void i_have_previously_selected_use_google_analytics_cookies() {
        page.clickOnUseGoogleAnalyticsCookiesButton();

    }

    @Then("^the page needs to load with the previously selected cookie option of \"([^\"]*)\"$")
    public void the_page_needs_to_load_with_the_previously_selected_cookie_option_of(String preference) throws Throwable {
        page.assertOnCorrectCookiesPreference(preference);
    }

    @Then("^the candidate cookie page needs to load with the previously selected cookie option of \"([^\"]*)\"$")
    public void the_candidate_cookie_page_needs_to_load_with_the_previously_selected_cookie_option_of(String preference) throws Throwable {
        page.assertOnCorrectCandidateCookiesPreference(preference);
    }

    @Then("^the page needs to load with the default cookie option of \"([^\"]*)\"$")
    public void the_page_needs_to_load_with_the_default_cookie_option_of(String preference) throws Throwable {
        page.assertOnCorrectDefaultCookiesPreference(preference);
    }

    @Then("^the candidate cookie page needs to load with the default cookie option of \"([^\"]*)\"$")
    public void the_candidate_cookie_page_needs_to_load_with_the_default_cookie_option_of(String preference) throws Throwable {
        page.assertOnCorrectDefaultCandidateCookiesPreference(preference);
    }

    @When("I click on the save button on the cookies page")
    public void i_click_on_the_save_button_on_the_cookies_page() {
        page.clickOnTheSaveButton();
    }

    @When("they click the Find out more about Google Analytics cookies link")
    public void they_click_the_Find_out_more_about_Google_Analytics_cookies_link() {
        page.clickOnFindOutMoreGoogleAnalyticsCookiesLink();
    }

    @Then("the section will expand showing the GA cookie details")
    public void the_section_will_expand_showing_the_GA_cookie_details() {
        //page.assertExpandableLinkGoogleAnalyticsDetails();
    }

    @Then("the section will expand showing the GA cookie details for candidate")
    public void the_section_will_expand_showing_the_GA_cookie_details_candidate() {
        //page.assertCandidateExpandableLinkGoogleAnalyticsDetails();
    }

    @When("they click the Find out more about essential cookies link")
    public void they_click_the_Find_out_more_about_essential_cookies_link() {
        page.clickOnFindOutMoreAboutEssentialCookiesLink();
    }

    @Then("the section will expand showing the essential cookie details")
    public void the_section_will_expand_showing_the_essential_cookie_details() {
        //page.assertExpandableLinkEssentialCookiesDetails();
    }

    @Then("the section will expand showing the essential cookie details for candidate")
    public void the_section_will_expand_showing_the_essential_cookie_details_for_candidate() {
        //page.assertCandidateExpandableLinkEssentialCookiesDetails();
    }

    @Then("the find more about how to manage cookies will open on a new window")
    public void the_find_more_about_how_to_manage_cookie_will_open_on_a_new_window() throws Exception {
        //page.assertManageCookiesPage();
    }

}

