@NJA-23981B
@uiCandidateTesting
@clearContractTemplateData
@clearIssueContractData
@ChangeSafeguardingSettingToYes

Feature: E2E Search To Accept Job Offer
  At the moment this will cover the following Journies Login as an Employer, create a job for locations and
  Publish the job Login as 2 candidates, search for jobs and apply for the same job advert
  for GIS for both (sequentially) Login as an Employer, Close the job, Shortlist the candidates
  Create interview slots and send invitations, Login as Candidates and select the slots (sequentially)
  Login as an Employer and add interview feedback and Send offer to applicant.
  Login as Candidate click Respond to Offer, Review Offer
  Select Accept Offer, add Referee details, and confirm Accept Offer

  Scenario Outline: Create, Search and Apply for the Job,ShortList,Interview and Job offer
    Given I navigate to employer login and login
    And that I have published my job advert
    And I navigate to "/candidate/search"
    And I should see "More search options" link
    When I tap on "More search options" link
    And Search criteria labels are "<label Count>"
    Then I should have the following labels displayed:
      | What?         |
      | Where?        |
      | Distance      |
      | Job reference |
      | Employer      |
      | Pay range     |
    And I should see six labels are displayed with the same size and font
    And I search for job with "job reference"
    And I should see a job count and "jobs found for" the search criterion
    And I navigate to "/candidate/jobadvert/" candidate job advert page
    And Create a candidate account and apply for the job created
      | one first | one lastname | candidate1@gmail.com | Password123$ | Password123$ |
    And I navigate to "/candidate/jobadvert/" candidate job advert page
    And Create a candidate account and apply for the job created
      | one first | one lastname | candidate2@gmail.com | Password123$ | Password123$ |
    And I navigate to employer login and login
    And I navigate to "published" page from dashboard page
    And I close the created Published Job
    And I navigate to shortlisted Page after shortlisting applicants
    And I navigate to your list of confirmed interviews page
    And I navigate to "/candidate/auth/login"
    And I login as Candidate
      | candidate1@gmail.com | Password123$ |
    And I clicked on respond to your invite button
    And I select a slot requests special requirements and confirm
    And I navigate to "/candidate/auth/login"
    And I login as Candidate
      | candidate2@gmail.com | Password123$ |
    And I clicked on respond to your invite button
    And I select a slot requests special requirements and confirm
    And I navigate to employer login and login
    And I navigate to "interviews" page from dashboard page
    And navigate to your list of confirmed interviews page after candidates chosen the slots
    And I lock interview schedule early
    When I add the Interview Feedback to all the applicants
    And I navigate to Offer the job page from interview
    And I select candidate "1" to offer job
    And I click on the continue to offer button
    And I select candidate "1" to offer job
    And I click on offer the job to selected applicant button
    And employer selects "fixed pay" radio button
    And I tap on the Continue button
    And I enter fixed pay "30000.5" with units as "a year"
    And I tap on save and continue button
    And I select offer Working pattern as "full-time"
    And I Save details and Continue to next page
    And I enter number of hours or sessions a week as "40"
    And I tap on save and continue button
    And I select upload offer letter choice as "No"
    And I tap on save and continue button
    And I tap on the Continue button
    And I tap on the Continue button
    And I tap on send offer button
    And I navigate to "/candidate/auth/login"
    And I login as Candidate
      | candidate1@gmail.com | Password123$ |
    And I navigate to Enter Referee details page
    And I enter Referee Details
    And I tap on save and continue button
    And I select "No" for add another Referee option
    And I tap on save and continue button
    And I accept offer by completing additional details
    Examples:
      | label Count |
      | 6           |







