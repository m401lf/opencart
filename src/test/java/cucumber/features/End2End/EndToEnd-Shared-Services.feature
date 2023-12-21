@EndToEnd @uiCandidateTesting @DeleteEmployerAndEmployerUser
@SmokeTest @clearContractTemplateData @clearIssueContractData
@ChangeSafeguardingSettingToYes
Feature: EndtoEnd Shared Services
  As a shared service
  I need to be able to see workload across my organisations
  So that I can prioritise work

  Background: Login as BSA Admin, create employer, add existing user, login as Employer and switch on toggle for all employers
    Given I navigate to employer login and login as a NHSBSA master admin
    And I tap on the Add employer button
    And I have selected the option
      | General medical practice |
    And I tap on the Continue button
    And I enter employer code "Z0002"
    And I tap on the Continue button
    And I enter the contact details "Michael", "Conway", "michael.conway1@nhs.net", "01914885555"
    And I tap on the Continue button
    And I entered "Brunton Walk" into the input box
    And I tap on the Continue button
    And I entered "NE7 7AD" into the postcode input box
    And I click on Find the address button
    And I have selected any of the results radio options
    And I tap on the Continue button
    And I enter the account code "999991"
    And I tap on the Continue button
    And I tap on the Continue button
    And I enter the privacy notice URL "https://www.nhs.uk/"
    And I tap on the Continue button
    And I tap on the Continue button
    And I select ESR user as "No"
    And I tap on the Continue button
    And I tap on the Continue button
    And I enter email address "admin@admin.com" on user email address page
    And I tap on the Continue button
    And I navigate to the next page after checking the user details
    And I select NHS Jobs role as "Super user"
    And I tap on the Continue button
    And I click on add existing user to organisation button
    And I navigate to employer login and login
    And I click on employer account for "Tyne Health"
    And I click on continue button on choose employer account page
    And that I have published my job advert
    And I navigate to "/candidate/jobadvert/" candidate job advert page
    And Create a candidate account and apply for the job created
      | one first | one lastname | candidate1@gmail.com | Password123$ | Password123$ |
    And I navigate to "/candidate/jobadvert/" candidate job advert page
    And Create a candidate account and apply for the job created
      | one first | one lastname | candidate2@gmail.com | Password123$ | Password123$ |
    And I navigate to employer login and login
    And I click on employer account for "Tyne Health"
    And I click on continue button on choose employer account page
    And I switch on the toggle to shows tasks for all accounts
    And I navigate to "published" page from dashboard page
    And I click on the Job title Based On Job Ref Number
    Then I should see the top right corner of the screen reads "You're viewing Tyne Health"
    And I should see the page secondary header reads "Tyne Health"
    And I navigate to previous page
    Then I should see the show all accounts toggle is switched "On"
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
    And I click on employer account for "Tyne Health"
    And I click on continue button on choose employer account page
    And I switch on the toggle to shows tasks for all accounts
    And I navigate to "interviews" page from dashboard page
    Then I should see showing tasks by type dropdown
    And I click on the Job title Based On Job Ref Number
    Then I should see the top right corner of the screen reads "You're viewing Tyne Health"
    And I should see the page secondary header reads "Tyne Health"
    And I navigate to previous page
    Then I should see the show all accounts toggle is switched "On"
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
    And I navigate to employer login and login
    And I click on employer account for "Tyne Health"
    And I click on continue button on choose employer account page
    And I switch on the toggle to shows tasks for all accounts
    And I navigate to "pre employment checks" page from dashboard page
    And I click on the applicant name based on application reference
    Then I should see the top right corner of the screen reads "You're viewing Tyne Health"
    And I navigate to previous page
    Then I should see the show all accounts toggle is switched "On"
    And I navigate to view Referee details page
    And I click on references link
    And I select applicant need a reference check as "yes"
    And I Save details and Continue to next page
    Then I should be taken to the "What you will need to know" Page
    And I navigate to next page
    Then I should be taken to the "applicant references" Page
    And I click on reference review "1"
    And I select "accept" radio button on References page
    And I Save details and Continue to next page
    And I click on send email to referee and ask for reference
    And I navigate to candidate reference
    And I select radio button "yes" on can you give reference page
    And I tap on the Continue button
    And I enter "valid" data into recent job title field
    And I Save details and Continue to next page
    And I select "No" radio on are dates correct page
    And I tap on the Continue button
    And I enter start month as "02" and start year as "2010" on enter correct dates page
    And I enter end month as "02" and end year as "2015" on enter correct dates page
    And I Save details and Continue to next page
    And I enter absence days as "12"
    And I enter absence episodes as "12"
    And I Save details and Continue to next page
    And I select "yes" radio on any warnings on record page
    And I tap on the Continue button
    And I enter "Valid" warning details
    And I Save details and Continue to next page
    And I select "Yes" radio on any investigations on record page
    And I tap on the Continue button
    And I enter "Valid" investigation details
    And I Save details and Continue to next page
    And I select "Yes" radio on DBS page
    And I tap on the Continue button
    And I select DBS level "with barred" on what was DBS level page
    And I tap on the Continue button
    And I select DBS barred with option as "Adult"
    And I tap on the Continue button
    And I enter date "01-01-2020" on when was DBS complete page
    And I Save details and Continue to next page
    And I click Declaration check box
    And I click send response on Declaration Page

  Scenario: Reference page, Accept reference, verify Audit status
    And I navigate to employer login and login
    And I click on employer account for "Tyne Health"
    And I click on continue button on choose employer account page
    And I switch on the toggle to shows tasks for all accounts
    And I navigate to "pre employment checks" page from dashboard page
    And I click on the applicant name based on application reference
    And I select Check pre-employment checklist option
    And I tap on the Continue button
    And I tap on the Continue button
    And I select pre employment checks decision as "satisfactory"
    And I tap on save and continue button
    And I tap on the Continue button
    And I enter start date of the applicant
    And I tap on save and continue button
    And I enter pay for this contract as "123456"
    And I tap on save and continue button
    And I select agreement type as "external"
    And I tap on save and continue button
    And I select create contract method as "online"
    And I tap on save and continue button
    And I click on back to your job listings on select templates page
    And I switch on the toggle to shows tasks for all accounts
    And I select the 'Manage contract templates' button
    And I click on create new template button
    And I enter what do you want to call this template name as "SYSTEM ADMIN"
    And I tap on save and continue button
    And I select agreement template type as "external secondment"
    And I tap on save and continue button
    And I tap on save and continue button
    And I enter add terms and conditions as "#ADD TERMS CONDITIONS HEADING\n##ADD TERMS CONDITIONS SUB-HEADING\n1.ADD TERMS CONDITIONS\n*ADD TERMS CONDITIONS HEADING"
    And I tap on save and continue button
    And I tap on save and continue button
    And I click on back to your contract templates button
    And I click on the Go back
    And I Sign out from my account
    And I navigate to employer login and login
    And I click on employer account for "Tyne Health"
    And I click on continue button on choose employer account page
    And I switch on the toggle to shows tasks for all accounts
    And I navigate to "contracts" page from dashboard page
    And I click on the task with Issue contracts status as "Create and issue contract"
    Then I should see the top right corner of the screen reads "You're viewing Tyne Health"
    And I navigate to previous page
    Then I should see the show all accounts toggle is switched "On"
    And I click on the task with Issue contracts status as "Create and issue contract"
    And I want to continue to the contract
    And I tap on save and continue button
    And I select contract template
    And I tap on save and continue button
    And I enter secondee prganisation as "Secondee Organisation"
    And I tap on save and continue button
    Then the page correct heading should be "Check the details of contract"
    And I tap on save and continue button
    And I click on back to your job listings on select templates page
    And I navigate to "contracts" page from dashboard page
    And I should see the Contract status of the applicants
      | one first one lastname | Contract sent |
    And I navigate to "/candidate/auth/login"
    And I login as Candidate
      | candidate1@gmail.com | Password123$ |
    And I click on view contract
    Then The page should contain download pdf link
    And I tap on the Continue button
    And I select contract option as "accept"
    And I tap on the Continue button
    And I navigate to employer login and login
    And I click on employer account for "Tyne Health"
    And I click on continue button on choose employer account page
    And I switch on the toggle to shows tasks for all accounts
    And I navigate to "contracts" page from dashboard page
    Then I should see the Contract status of the applicants
      | one first one lastname | Contract accepted |