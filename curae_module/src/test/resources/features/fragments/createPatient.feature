#language: en
Feature: createPatient

  @fragment
  Scenario: createPatient
    * user is on the page "HomePage"
    * user clicks the button "Administration"
    * user is on the page "AdministrationPage"
    * ? user clicks the button "Clinical Support"
    * user clicks element via javascript "Clinical Support"
    * user is on the page "ClinicalSupportPage"
    * ? user clicks the button "Admission"
    * user clicks element via javascript "Admission"
    * user is on the page "AdmissionPage"
    * ? user clicks the button "New Patient"
    * user clicks element via javascript "New Patient"
    * user is on the page "CreatePatientPopupPage"
    * user checks that text "New Admission" appears on the page
    #* user fills the field "Search by patient name" with value "<searchByName>"
    * user fills the field via javascript "Search by patient name" with value "<searchByName>"
    * user clicks the button "pageBody"
    * user is on the page "CreatePatientPopupPage"
    * stores the value "<firstName>" in a variable "~firstName"
    * user fills the field "Patient first name" with value "#{~firstName}"
    * stores the value "<lastName>" in a variable "~lastName"
    * user fills the field "Patient last name" with value "#{~lastName}"
    * user fills the field "Patient middle name" with value "<middleName>"
    * user selects in dropdown "Patient gender" the value "<gender>"
    * user fills the field "Birth Date" with value "<birthDate>"
    * user clicks the button "add button"
    * user is on the page "CreatePatientPopupPage"
    * user selects in dropdown "Patient Number Name" the value "<patientNumberName>"
    * user fills the field "Patient Numbers" with value "<patientNumber>"

    * user clicks the button "add button"
    * user is on the page "CreatePatientPopupPage"
    #* breakpoint
   # * user selects in dropdown "Patient Number Name 2" the value "<patientNumberName2>"
    * user fills the field "Patient Numbers 2" with value "<patientNumber2>"

    * user clicks the button "add button"
    * user is on the page "CreatePatientPopupPage"
   # * user selects in dropdown "Patient Number Name 3" the value "<patientNumberName3>"
    * user fills the field "Patient Numbers 3" with value "<patientNumber3>"

    * user clicks the button "CONFIRM"

    * user is on the page "AdmissionPage"
    * user clicks element via javascript "navigationBlock->Home"
    * user is on the page "HomePage"