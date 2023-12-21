package cucumber.stepDefinitions.Search;

import io.cucumber.java.en.And;

public class SaveSearchAlertsPageSteps {

    @And("I select new job email alerts as {string}")
    public void i_select_new_job_email_alerts_ss(String preference) {
        /*SavedSearchAlertsPage savedSearchAlertsPage  = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SavedSearchAlertsPage.class);
        savedSearchAlertsPage.chooseEmailPreference(preference);*/
    }
}
