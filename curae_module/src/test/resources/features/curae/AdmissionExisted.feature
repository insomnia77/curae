#language = en
@all
Feature: admissionExisted


  Background:
    * user is on the page "LoginPage"
    * user fills the field "User Name" with value "test.qa@cvhcare.com"
    * user fills the field "Password" with value "password"
    * user clicks the button "Log in"

@ExistingPatientCreating

Scenario Outline: ExistingPatientCreating
  * user performs "createPatient" scenario
    | searchByName   | firstName   | lastName   | middleName   | gender   | birthDate   | patientNumberName   | patientNumber   | patientNumberName2   | patientNumber2   | patientNumberName3   | patientNumber3   |
    | <searchByName> | <firstName> | <lastName> | <middleName> | <gender> | <birthDate> | <patientNumberName> | <patientNumber> | <patientNumberName2> | <patientNumber2> | <patientNumberName3> | <patientNumber3> |

  * user checks value in "Message about existing" contains "already exists"
  * user performs "goToHomePage" scenario

  Examples:
    | searchByName | firstName   | lastName        | middleName | gender | searchValue   | birthDate  | patientNumberName | patientNumber | patientNumberName2 | patientNumber2 | patientNumberName3   | patientNumber3 |
      #| 123          | test1     | Test lastname | A          | Male   | test7       | 03-10-1993 | MBI Number        | 0015          | Medicaid Number    | 0016           | Kaiser Policy Number | 0017           |
    | 123          | {~firstName} | random lastname | A          | Male   | #{~firstName} | 03-10-1993 | MBI Number        | 0015          | Medicaid Number    | 0016           | Kaiser Policy Number | 0017           |
