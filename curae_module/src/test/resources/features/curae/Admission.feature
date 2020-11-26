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
    * user performs "createPatient" scenario
      | searchByName   | firstName   | lastName   | middleName   | gender   | birthDate   | patientNumberName   | patientNumber   | patientNumberName2   | patientNumber2   | patientNumberName3   | patientNumber3   |
      | <searchByName> | <firstName> | <lastName> | <middleName> | <gender> | <birthDate> | <patientNumberName> | <patientNumber> | <patientNumberName2> | <patientNumber2> | <patientNumberName3> | <patientNumber3> |
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
    * user is on the page "AdmissionPage"
    * user clicks the button "patient info"
    * user is on the page "PatientInfoPage"
    * user selects the checkbox "Same As Contact Address"
    * user clicks the button "Edit Contact Info"

    Examples:
      | searchByName | firstName | lastName      | middleName | gender | searchValue | birthDate  | patientNumberName | patientNumber | patientNumberName2 | patientNumber2 | patientNumberName3   | patientNumber3 |
      | 123          | test1     | Test lastname | A          | Male   | test7       | 03-10-1993 | MBI Number        | 0015          | Medicaid Number    | 0016           | Kaiser Policy Number | 0017           |




