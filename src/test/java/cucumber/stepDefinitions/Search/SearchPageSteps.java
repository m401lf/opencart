package cucumber.stepDefinitions.Search;


public class SearchPageSteps {

    /*@And("^I search for job with \"([^\"]*)\"$")
    public void i_search_for_published_jobs_as(String searchKeyword) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.searchForJobs(searchKeyword);
    }

    @And("^I search for jobs with \"([^\"]*)\"$")
    public void i_search_for_job_with_and(String string) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.candidateSearchForJobs(string);
    }

    @And("I search for the same closed job with {string}")
    public void iSearchForTheSameClosedJobWith(String jobRef) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.searchForJobs(jobRef);
    }

    @And("I search for jobs by What? with {string}")
    public void i_search_for_jobs_by_What_with(String jobTitle) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.searchForJobsByWhat(jobTitle);
    }

    @And("I search for jobs by Where? with {string}")
    public void i_search_for_jobs_by_here_ith(String postCodeTownCity) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.searchForJobsByWhere(postCodeTownCity);
    }

    @And("I enter the first four letters in Where? {string} field")
    public void i_enter_the_first_four_letters_in_where_field(String townCity) throws InterruptedException {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.inputCityOrTown(townCity.trim());
    }

    @And("I can see the auto-suggestion dropdown list is displayed")
    public void i_can_see_the_auto_suggestion_dropdown_is_displayed() throws InterruptedException {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.assertAutoSuggestionDropdownListIsDisplayed();
    }

    @When("I search by selecting an option {string} from the auto suggested dropdown list")
    public void i_search_by_selecting_an_option_from_the_auto_suggested_dropdown_list(String cityPlacePostcode) throws InterruptedException {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.selectLocationText(cityPlacePostcode);
        searchPage.clickSearch();
    }

    @And("I search with an Employer {string}")
    public void i_search_for_jobs_by_employer_with(String employerName) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.searchForJobsByEmployer(employerName);
    }

    @And("I search with job reference {string}")
    public void i_search_for_jobs_by_job_reference_with(String jobRef) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.searchForJobsByJobRef(jobRef);
    }

    @Then("I clear employer code data")
    public void i_clear_employer_code_data() throws SQLException, IOException {
        AdminUIClearDownHelper.clearEmployerUserAndEmployerTestData(AdminUITestData.MULTI_ORG_EMPLOYER_CODE);
        SetUpHelper.clearVacancyAndJobAdvertdata();
    }

    @Then("the correct search page content is displayed")
    public void the_correct_search_page_content_is_displayed() {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.assertSearchPageContent();
    }

    @And("I navigate to search result page")
    public void i_navigate_to_search_result_page() {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.navigateToSearchResultPage();
    }

    @Then("I should see {string} link")
    public void i_should_see_link(String moreSearchOptions) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.assertMoreSearchOption(moreSearchOptions);
    }

    @When("I tap on {string} link")
    public void i_tap_and_link(String moreSearchOptions) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.assertMoreSearchOption(moreSearchOptions);
        searchPage.tapMoreSearchOptions();


    }

    @Then("I should see six labels are displayed with the same size and font")
    public void i_should_see_labels_are_displayed_with_the_same_size_and_font() {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.assertSearchLabels();
    }

    @Then("I should see {int} labels are displayed with the same size and font")
    public void i_should_see_six_labels_are_displayed_with_the_same_size_and_font(Integer labelCount) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.assertSearchLabelsCount(labelCount);
    }
    @Then("Search criteria labels are {string}")
    public void i_should_see_labels_to_be_six(String labelCount) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
            searchPage.assertForLabelCount(labelCount);
    }

    @Then("I can see {int} labels")
    public void i_should_see_six_labels(Integer labelCount) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.assertLabelCount(labelCount);
    }

    @And("I should have the following labels displayed:")
    public void i_should_see_labels_are_displayed(DataTable labels) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.assertInputLabel(labels);
    }

    @Then("I can see inputted data retained in the search criteria boxes")
    public void i_can_see_inputted_data_retained_in_the_search_criteria_boxes() {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.assertInputtedDataAdditionalSearchFields();
    }
    @Then("I can see inputted data {string} and {string} retained in the search criteria boxes")
    public void i_can_see_inputted_data_jobreference_and_employer_retained_in_the_search_criteria_boxes(String jobRef, String empl) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.assertInputtedDataJobRefAndEmpl(jobRef, empl);
    }
    @And("I inputted invalid Job reference {string} in the input field")
    public void i_inputted_invalid_jobreference_and_employer_input_boxes(String jobRef) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.inputDataInJobRef(jobRef);
    }

    @And("I input Job reference {string} and Employer {string} input fields")
    public void i_input_job_reference_and_employer_input_boxes(String jobRef, String emp) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.inputDataInJobRefAndEmployer(jobRef, emp);
    }
    @Then("I can see {string} link")
    public void i_can_see_and(String fewSearchOptions) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.assertFewerSearchOptions(fewSearchOptions);
    }
    @And("I select pay range {string}")
    public void i_select_a_pay_range(String payRange) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.selectPayRange(payRange);
    }
    @When("I can see labels {string} and {string}")
    public void i_can_see_what_and_where_and(String what, String where) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.assertWhatWhereLabels(what, where);
    }
    @Given("I can see labels {string}, {string} and {string}")
    public void i_can_see_labels_what_where_and_distance(String what, String where, String distance) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.assertWhatWhereDistanceLabels(what, where, distance);
    }
    @When("I tap the ‘Search’ button")
    public void i_tap_the_search_button() throws InterruptedException {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.clickSearch();
    }
    @Then("I should see three fields {string}, {string} and {string}")
    public void i_should_see_jobreference_employer_and_payrang_fields(String jobReference, String employer, String payBand) throws Throwable {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.assertAdditionalSearchBoxes(jobReference, employer, payBand);
    }

    @Then("I should not see three fields Job reference, Employer and Pay range")
    public void i_should_not_see_three_fields_job_reference_employer_and_pay_range() {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.assertJobReferenceEmployerAndPayRangelabelsNotDisplayed();
    }

    @When("I can see Clear filters and Search buttons")
    public void i_can_see_clear_filters_and_search_buttons() {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.assertClearFilters();
        searchPage.assertSearch();
    }

    @When("I can see {string} next to search button")
    public void i_can_see_clearFilters_buttons(String clearFilterBtn ) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.assertForClearFilters(clearFilterBtn);

    }

    @When("I should see {string} button")
    public void i_can_see_search_buttons(String searchButton) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.assertForSearchBtn(searchButton);

    }

    @Then("I can see Clear filters button coloured white with letters in black font")
    public void i_can_see_clear_filters_button_coloured_white_with_letters_in_black_font() {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.assertClearFilterBgColor();
    }

    @Then("I can see search button letters in white font")
    public void i_can_see_search_button_letters_in_white_font() {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.assertSearchColor();
    }

    @Then("I should see Clear filter and Search below the Pay range field")
    public void i_should_see_clear_filter_and_search_below_the_pay_range_field() {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.assertClearFilters();
        searchPage.assertSearch();
    }

    @Then("I should see Clear filter and Search below the Employer field")
    public void i_should_see_clear_filter_and_search_below_the_employer_field() {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.assertClearFilters();
        searchPage.assertSearch();
    }

    @When("I click the Clear filters button")
    public void i_click_the_clear_filters_button() {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.clickClearFilters();
    }

    @When("I click the Search button")
    public void i_click_the_search_button() throws InterruptedException {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.clickSearch();
    }

    @When("I tap on Fewer search options link")
    public void i_tap_on_and_link() {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.tapOnFewerSearchOptionsLink();
    }

    @When("I tap on the Search button")
    public void i_tap_on_the_search_button() {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.clickSearch();
    }

    @And("I search for job with {string} in What and Where {string} fields")
    public void i_search_for_job_with_in_what_and_where_fields(String what, String where) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.inputDataInWhatAndWhereFields(what, where);
    }

    @And("I search for job with what? {string} and where? {string} fields")
    public void i_search_for_job_with_in_what_and_where_fields_only(String what, String where) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.inputDataInWhatAndWhereFields(what, where);
    }

    @And("I search for job with What? {string}, Where? {string} Distance {string} and employer {string} fields")
    public void i_search_for_job_with_in_what_where_distance_and_employer_fields(String what, String where, String distanc, String empl) throws InterruptedException {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.inputDataInWhatWhereDistanceEmployerFields(what, where, distanc, empl);
        searchPage.clickSearch();
    }

    @And("I search for job with What? {string}, Where? {string} and Distance {string} fields")
    public void i_search_for_job_with_in_what_where_and_distance_fields(String what, String where, String distance) throws InterruptedException {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.inputDataInWhatWhereAndDistanceFields(what, where, distance);
        searchPage.clickSearch();
    }

    @When("I should see {string} by default for pay range option")
    public void i_should_see_please_select_by_default_for_pay_range_option(String pleaseSelect) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.assertPleaseSelect(pleaseSelect);
    }

    @When("I tap Search button")
    public void i_tap_to_search_button() {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.clickSearch();
    }

    @When("I search Employer {string} input boxes")
    public void i_entered_employer_input_boxes(String employerName) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.inputEmployer(employerName);
    }

    @And("I search with Job reference {string} and Employer {string}")
    public void iInputtedInvalidJobReferenceAndEmployerInputfields(String jobRef, String empl) {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.enterJobRefAndEmployerField(jobRef, empl);
        searchPage.clickSearch();

    }

    @And("I tap on the Clear filters button")
    public void i_tap_on_clear_filter_button() {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.clickClearFilters();
    }

    @Then("I select a {string} options")
    public void i_select_a_options(String payRangeOption) throws Exception {
        SearchPage searchPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchPage.class);
        searchPage.selectPayRangeOptions(payRangeOption);
    }*/

}