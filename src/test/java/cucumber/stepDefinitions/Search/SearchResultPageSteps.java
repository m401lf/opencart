/*
package cucumber.stepDefinitions.Search;

import Pages.SearchResultPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import webdriverutilities.WebDrv;


public class SearchResultPageSteps {

    SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);

    @Then("^I can see the search result for \"([^\"]*)\"$")
    public void i_can_see_the_search_result_for_published_job(String searchResult) throws InterruptedException {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        CandidateJobAdvertPage candidateJobAdvertPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), CandidateJobAdvertPage.class);
        switch (searchResult.toLowerCase()) {
            case "job title":
                //Benjamin Azeta
                //searchResultPage.waitForTheSearchResult();
                searchResultPage.assertJobTitles();
                break;
            case "job reference":
                searchResultPage.clickJobTitle();
                //candidateJobAdvertPage.assertCorrectJobReference();
                break;
            case "postcode":
                searchResultPage.assertEmployerPostcode();
                break;
            case "town or city":
                searchResultPage.assertForTownOrCity();
                break;
            default:
                throw new IllegalArgumentException("search result not found for: " + searchResult);
        }

    }

    @And("^I filter the search result for working pattern \"([^\"]*)\"$")
    public void i_filter_the_search_result_for_working_pattern(String workingPattern) throws Exception {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.filterWorkingPatternJobs(workingPattern);
    }

    @Then("^I can see search result for \"([^\"]*)\" filter")
    public void i_can_see_search_result_for_working_pattern_filter(String workingPattern) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertForWorkingPattern(workingPattern);
    }

    @And("^I filter the search result for contract type \"([^\"]*)\"$")
    public void i_filter_the_search_result_for_contract_type(String contractType) throws Exception {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.filterContractTypeJobs(contractType);
    }

    @Then("I can see the search result for {string} filter")
    public void i_can_see_the_search_result_for_filter(String contractType) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertForContractType(contractType);
    }

    @And("I filter the search result for covid related")
    public void i_filter_the_search_result_for_covid_related() {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.filterCovidJobs();
    }

    @Then("I can see the search result for covid jobs")
    public void i_can_see_the_search_result_for_covid_jobs() {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertCovidJobResult();
    }

    @And("^I can filter for the pay range jobs with \"([^\"]*)\"")
    public void i_can_filter_for_the_pay_range_jobs_with(String payRange) throws Exception {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.filterPayRangeJobs(payRange);
    }

    @Then("^I can see the jobs in search result for \"([^\"]*)\" and \"([^\"]*)\"")
    public void i_can_see_the_jobs_in_search_result_for_minimum_and_maximum(String minSalary, String maxSalary) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertPayRange(minSalary, maxSalary);
    }

    @And("^I can filter the \"([^\"]*)\" jobs in search result")
    public void i_can_filter_the_pay_band_jobs_in_search_result(String paySchemeBand) throws Exception {
        searchResultPage.filterPayBandJobs(paySchemeBand);
    }

    @Then("^I can see the \"([^\"]*)\" jobs in search result")
    public void i_can_see_the_pay_band_jobs_in_search_result(String paySchemeBand) {
        searchResultPage.clickJobTitle();
        CandidateJobAdvertPage candidateJobAdvertPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), CandidateJobAdvertPage.class);
        candidateJobAdvertPage.assertForPaySchemeBand(paySchemeBand);
    }
    @Then("^I can see the jobs in search result")
    public void i_can_see_the_job_in_search_result() {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertJobTitle();
    }

    @And("I save the search")
    public void i_save_the_search() throws InterruptedException {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.clickSaveThisSearch();
    }

    @And("I save the job from search result")
    public void i_save_the_job_from_search_result() {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.clickSaveThisJob();

    }
    @Then("I can see {string} job found in search result")
    public void i_can_see_one_result_found_in_search_result(String jobCount) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertOneResultFound(jobCount);
    }
    @Then("I should see {string} in search result")
    public void i_can_see_result_found_in_search_resultS(String noResult) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertNoResultFound(noResult);
    }
    @Then("I can see {string} and or search instead {string} in search result")
    public void iCanSeeAndOrSearchInsteadInSearchResult(String jobTitle, String phraseSuggester) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertJobName(jobTitle);
        searchResultPage.assertPhraseSuggester(phraseSuggester);
    }
    @Then("I can see {string} in search result for {string}")
    public void iCanSeeSearchResultFor(String noResult, String jobTitle) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertNoResultFound(noResult);
        searchResultPage.assertJobTitleNames(jobTitle);
    }
    @Then("I can see no job advert found {string} jobs found for {string} at all locations")
    public void iCanSeeJobsFoundForAtAllLocations(String jobCount, String jobTitle) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertJobCount(jobCount);
        searchResultPage.assertJobName(jobTitle);
    }
    @Then("I can see jobs found for {string} at all locations")
    public void iCanSeeSomeSearchJobsFoundForAtAllLocations(String jobTitle) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);;
        searchResultPage.assertJobName(jobTitle);
    }
    @And("I can see {string} jobs found for {string}")
    public void iCanSeeJobsFoundForAtAllVacanciesAtAllLocations(String jobCount, String vacanciesLocations) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertJobCount(jobCount);
        searchResultPage.assertForVacanciesLocations(vacanciesLocations);
    }
    @And("I can see {string} in the search result page")
    public void iCanSeeSearchResultInSearchResultPage(String searchResult) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertSearchResult(searchResult);

    }

    @Then("I should see {string} and We are unable to match {string} to a place or postcode in search result")
    public void iShouldSeeAndWeAreUnableToMatchToAPlaceOrPostcodeInSearchResult(String noLocation, String postCodeTownCity) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertNoLocationFound(noLocation);
        searchResultPage.assertUnableToMatchPlacePostcode(postCodeTownCity);
    }

    @Then("I should not see jobs found for {string} at all locations")
    public void iShouldNotSeeJobsFoundForAtAllLocation(String postCodeTownCity) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertPostCodeTownCity(postCodeTownCity);
    }
    @Then("I should see {string} in search result heading")
    public void i_should_see_location_not_found_in_search_result_heading(String noLocation) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertNoLocationFound(noLocation);
    }
    @Then("I should see {string} in the search result")
    public void i_should_see_in_search_result(String noLocation) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertNoLocationFound(noLocation);
        searchResultPage.assertSimilarLocation();
    }
    @And("I can see {string} for {string}")
    public void iCanSeeWeAreUnableToMatchToAPlaceOrPostcode(String couldNotFindAnExactMatch,String postCodeTownCity) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertForWeCouldNotFindAnExactMatch(postCodeTownCity);
        searchResultPage.assertForCouldNotFindAnExactMatchMsg(couldNotFindAnExactMatch);
    }
    @And("I can see We are unable to match {string} to a place or postcode or location")
    public void iCanSeeWeAreUnableToMatchToLocation(String location) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertUnableToMatchLocation(location);
    }
    @Then("I should see the search result for inputted data")
    public void i_can_should_search_results_for_inputted_data() {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertJobTitle();
    }
    @Then("I should see job count {string}")
    public void iShouldSeeJobCount(String allVacanciesAtAllLocations) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertAllVacanciesAtAllLocations(allVacanciesAtAllLocations);
    }
    @When("I can see the search result for inputted data")
    public void i_can_see_the_search_result_for_inputted_data() {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertJobTitle();;
    }
    @Then("I should see result found in search result page")
    public void i_should_see_result_found_in_search_result_page() {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertResultFound();
    }
    @Then("I should see a job count and {string} the search criterion")
    public void i_should_see_a_job_count_and_the_search_criterion(String jobFoundFor) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertJobCountJobFoundFor(jobFoundFor);
    }
    @Then("I should see a {string} jobs found for All vacancies within {string} of {string}")
    public void iShouldSeeAJobCountJobsFoundForAllVacanciesWithinOf(String jobCount, String postCodeTownCity, String distance) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);;
        searchResultPage.assertJobsCount(jobCount);
        searchResultPage.assertDistance(distance);
        searchResultPage.assertPostCodeTownCity(postCodeTownCity);
    }
    @Then("I should see jobs found for All vacancies within {string} of {string}")
    public void iShouldSeeJobsFoundForAllVacanciesWithinOf(String postCodeTownCity, String distanceMileage) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);;
        searchResultPage.assertPostCodeTownCity(postCodeTownCity);
        searchResultPage.assertDistance(distanceMileage);
    }
    @Then("I should see jobs found for {string} of {string} in the search result page")
    public void iShouldSeeJobsFoundForOfInTheSearchResultPage(String mileage, String postCodeTownCity) throws InterruptedException {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertForCityPlacePostcode(postCodeTownCity);
        searchResultPage.assertForMileage(mileage);

    }
    @Then("I can see a job count and jobs found for '{string} at all locations'")
    public void iCanSeeAJobCountAnd(String jobTitle) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);;
        searchResultPage.assertJobName(jobTitle);
    }

    @Then("I can see Did you mean .... for or search instead {string}")
    public void iCanSeeInSearchResultDidYouMeanJobTitleOrSearchInsteadInSearchResult(String phraseSuggester) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertPhraseSuggester(phraseSuggester);
    }
    @And("I should see {string} in the search result page")
    public void iShouldSeeInTheSearchResultPage(String noResultFoundTxt) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertForNoResultFound(noResultFoundTxt);
    }

    @Then("I should see job count and {string} {string}")
    public void i_should_see_a_job_count_and_for_vacancies_at_all_locations(String jobsFoundForTxt, String vacanciesAtAllLocations) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertJobsFoundFor(jobsFoundForTxt);
        searchResultPage.assertForVacanciesAtAllLocations(vacanciesAtAllLocations);
    }
    @Then("I should see zero job count and {string} {string}")
    public void i_should_see_zero_job_count_and_for_vacancies_at_all_locations(String jobsFoundForTxt, String vacanciesAtAllLocations) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertJobsFoundFor(jobsFoundForTxt);
        searchResultPage.assertForVacanciesAtAllLocations(vacanciesAtAllLocations);
    }
    @Then("I should see a job count and jobs found for the search criterion")
    public void i_should_see_a_job_count_and_jobs_found_for_the_search_criterion() {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertJobCountAndJobFoundFor();
    }
    @Then("I should see {string} {string} 'All vacancies at all locations'")
    public void assertJobCountAndAllVacanciesAtAllLocations(String jobCount, String jobsFoundForTxt) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertJobsCount(jobCount);
        searchResultPage.assertJobsFoundFor(jobsFoundForTxt);
    }
    @Then("I should see job count {string} {string}")
    public void iShouldSee(String jobsFoundForTxt, String allVacanciesAtAllLocations) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertJobsFoundFor(jobsFoundForTxt);
        searchResultPage.assertAllVacanciesAtAllLocations(allVacanciesAtAllLocations);
    }
    @Then("I should see job count {string} {string} within {string} of {string}")
    public void iShouldSeeWithinOf(String jobsFoundForTxt, String jobTitleName, String milesCount, String locationName) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertJobsFoundFor(jobsFoundForTxt);
        searchResultPage.assertJobTitleName(jobTitleName);
        searchResultPage.assertLocationName(locationName);
    }

    @Then("I should see job count {string} All vacancies within 5 miles of {string}")
    public void iShouldSeeJobCountAllVacanciesWithinOf(String jobsFoundForTxt, String location) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertJobsFoundFor(jobsFoundForTxt);
        searchResultPage.assertLocationName(location);
    }
    @Then("I should see job count {string} {string} at all locations")
    public void iShouldJobCountAtAllLocations(String jobsFoundForTxt, String jobTitleName) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertJobsFoundFor(jobsFoundForTxt);
        searchResultPage.assertJobTitleName(jobTitleName);
    }
    @Then("I should see {string} {string} {string} within {string} of {string}")
    public void iShouldSeeWithinOf(String jobCount, String jobsFoundForTxt, String jobTitleName, String milesCount, String locationName) throws InterruptedException {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertJobsCount(jobCount);
        searchResultPage.assertJobsFoundFor(jobsFoundForTxt);
        searchResultPage.assertJobTitleName(jobTitleName);
        searchResultPage.assertMilesCount(milesCount);
        searchResultPage.assertLocationName(locationName);
    }
    @Then("I should see a {string} jobs found for job title as {string} within {string} of {string}")
    public void iShouldSeeAWithinOf( String jobCount,String jobTitleName , String mileage, String locationName) throws InterruptedException {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertJobsCount(jobCount);
        searchResultPage.assertJobTitleName(jobTitleName);
        searchResultPage.assertMileage(mileage);
        searchResultPage.assertLocation(locationName);
    }
    @Then("I should see jobs found for {string} at all locations")
    public void iShouldSeeJobsFoundForAtAllLocations(String jobTitleName) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertJobTitleName(jobTitleName);
    }

    @And("I should see {string} {string} {string}")
    public void iShouldSee( String jobCount, String jobsFoundForTxt, String allVacanciesAtAllLocations) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertJobsCount(jobCount);
        searchResultPage.assertJobsFoundFor(jobsFoundForTxt);
        searchResultPage.assertAllVacanciesAtAllLocations(allVacanciesAtAllLocations);
    }

    @And("I should see {string} in the search page")
    public void iShouldSeeInTheSearchPage(String noLocation) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertNoLocationFound(noLocation);
    }

    @And("I should see Did you mean can enter or search instead {string} in search result")
    public void iShouldSeeDidYouMeanCanEnterOrSearchInsteadInSearchResult(String phraseSuggester) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertPhraseSuggester(phraseSuggester);
    }


    @Then("I can see {string} job found for All vacancies at all locations!")
    public void iShouldSeeJobFoundForAllVacanciesAtAllLocations(String jobCount) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertForJobsCount(jobCount);

    }

      @Then("I should see {string} label")
    public void iShouldSee(String closingDate) throws Throwable {
          SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
          searchResultPage.assertClosingDate(closingDate);


    }

    @And("I should see {string} message")
    public void iCanSeeMessage(String jobNowClosed) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertJobNowClosed(jobNowClosed);

    }

    @And("I should see job advert status message:")
    public void iCanSeeJobAdvertStatusMessage(DataTable jobNowClosedMsg) {
        SearchResultPage searchResultPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), SearchResultPage.class);
        searchResultPage.assertForJobNowClosed(jobNowClosedMsg);

    }

}
*/
