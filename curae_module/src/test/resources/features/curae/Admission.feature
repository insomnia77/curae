#language = en
Feature: admission


  Background:
    * user is on the page "LoginPage"
    * user fills the field "User Name" with value "test.qa@cvhcare.com"
    * user fills the field "Password" with value "password"
    * user clicks the button "Log in"
    #todo: add polling loader
    * user waits "5" seconds

  @admission
  Scenario Outline: admission
    #TODO: fragment with creating patient
    * user performs "createPatient" scenario
      | searchByName   | firstName   | lastName   | middleName   |
      | <searchByName> | <firstName> | <lastName> | <middleName> |
    * user is on the page "HomePage"
    * user clicks the button "Administration"
    * user is on the page "AdministrationPage"
    * user clicks the button "Clinical Support"
    * user is on the page "ClinicalSupportPage"
    * user clicks the button "Admission"
    * user is on the page "AdmissionPage"
    * user clicks the button "In Processing"
    * user is on the page "AdmissionPage"
    * user clicks the button "search button"
    * user fills the field "search bar" with value "<searchValue>"



    Examples:
      | searchByName | firstName | lastName      | middleName | searchValue |
      | 123          | test1     | Test lastname | A          | test7       |



