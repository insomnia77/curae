#language: en
Feature: createPatient

  @fragment
  Scenario: createPatient
    * user is on the page "HomePage"
    * user clicks the button "Administration"
    * user is on the page "AdministrationPage"
    * user clicks the button "Clinical Support"
    * user is on the page "ClinicalSupportPage"
    * user clicks the button "Admission"
    * user is on the page "AdmissionPage"
    * user clicks the button "New Patient"
    * user is on the page "AdmissionPage"
    * user fills the field "Search by patient name" with value "<searchByName>"
    * user is on the page "AdmissionPage"
    * user fills the field "Patient first name" with value "<firstName>"
    * user fills the field "Patient last name" with value "<lastName>"
    * user fills the field "Patient middle name" with value "<middleName>"
    * user selects in "Patient gender" the value "<gender>"