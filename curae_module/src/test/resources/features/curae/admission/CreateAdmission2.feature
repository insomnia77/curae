#language = en
@all
Feature: admission


  Background:
    * user is on the page "LoginPage"
    * user fills the field "User Name" with value "test.qa@cvhcare.com"
    * user fills the field "Password" with value "password"
    * user clicks the button "Log in"


  @CreateAdmission2
  Scenario Outline: CreateAdmission2
    * user performs "createPatient" scenario
    * user performs "goToHomePage" scenario
      | searchByName   | firstName   | lastName   | middleName   | gender   | birthDate   | patientNumberName   | patientNumber   | patientNumberName2   | patientNumber2   | patientNumberName3   | patientNumber3   |
      | <searchByName> | <firstName> | <lastName> | <middleName> | <gender> | <birthDate> | <patientNumberName> | <patientNumber> | <patientNumberName2> | <patientNumber2> | <patientNumberName3> | <patientNumber3> |
    * ? user clicks the button "Administration"
    * user clicks element via javascript "Administration"
    * user is on the page "AdministrationPage"
    * ? user clicks the button "Clinical Support"
    * user clicks element via javascript "Clinical Support"
    * user is on the page "ClinicalSupportPage"
    * ? user clicks the button "Admission"
    * user trying to click element via javascript "Admission"
    * user is on the page "AdmissionPage"
    * ? user clicks the button "In Processing"
    * user clicks element via javascript "In Processing"
    * user is on the page "AdmissionPage"
    * ? user clicks the button "search button"
    * user clicks element via javascript "search button"
    * user checks that text "Loading More Admissions" is absent on the page
    * user fills the field via javascript "search bar" with value "<searchValue>"
    * user is on the page "AdmissionPage"
    * user clicks the button "patient info"
    * user is on the page "PatientInfoPage"
    * user selects the checkbox "Same As Contact Address"
    * ? user clicks the button "Edit Contact Info"

    * user clicks element via javascript "Edit Contact Info"
    * user is on the page "PatientContactInfoPage"
    ## TODO: Address field is not filled out sometimes and made a problem
    * user scrolls page up
    * user fills the field "Address" with value "$PatientContactInfo{address}"
    * user fills the field "City" with value "$PatientContactInfo{city}"
    * user fills the field "County" with value "$PatientContactInfo{county}"
    * user fills the field "State" with value "$PatientContactInfo{state}"
    * user fills the field "Zip Code" with value "$PatientContactInfo{zip}"
    * user scrolls to element "UPDATE"
    * user fills the field "Primary Contact Phone Number" with value "$PatientContactInfo{Contact Num}"
    * user fills the field "Primary Contact Note" with value "$PatientContactInfo{Contact Note}"
    * user fills the field "Secondary Contact Phone Number" with value "$PatientContactInfo{Contact Num2}"
    * user fills the field "Secondary Contact Note" with value "$PatientContactInfo{Contact Note2}"
    * user clicks the button "UPDATE"

    * user is on the page "PatientInfoPage"
      #todo:
    # problem with finding element after updating previous window. Add a row above
    #* user checks that element with text "Same As Contact Address" is present
   # * user selects the checkbox "Same As Contact Address"

    ##############

    * ? user clicks the button "Edit Basic Info"
    * user clicks element via javascript "Edit Basic Info"
    * user is on the page "PatientBasicInfoPage"
    * user clicks element via javascript "Edit Patient Name"
    * user is on the page "PatientBasicInfoPage"
    * user fills the field "First Name" with value "Editedname"
    * user fills the field "Middle Name" with value "Z"
    * user selects in dropdown "Gender" the value "Female"
    * user clicks the button "Update Patient Name"
    * user is on the page "PatientBasicInfoPage"
    * user clicks the button "Confirm!"
    * user is on the page "PatientBasicInfoPage"
    * user clicks element via javascript "Edit Patient Name"
    * user is on the page "PatientBasicInfoPage"
    * user fills the field "Weight" with value "70"
    * user is on the page "PatientBasicInfoPage"
    * user fills the field via javascript "Height" with value "175"
    * ? user clicks the button "UPDATE"
    * user clicks element via javascript "UPDATE"
    * user is on the page "PatientInfoPage"
    * ? user clicks the button "Edit Primary Caregiver Info"
    * user clicks element via javascript "Edit Primary Caregiver Info"
    * user is on the page "PatientPrimaryCareGiverInfoPage"
    * user fills the field "Name" with value "$PatientPrimaryCaregiverInfo{Name}"
    * user selects in dropdown "Relationship" the value "$PatientPrimaryCaregiverInfo{Relationship}"
    * user fills the field "Phone Number" with value "$PatientPrimaryCaregiverInfo{Phone Number}"
    * user scrolls to element "UPDATE"
    * user fills the field "Mobile Number" with value "$PatientPrimaryCaregiverInfo{Mobile Number}"
    * user fills the field "Work Number" with value "$PatientPrimaryCaregiverInfo{Work Number}"
  #  * user fills the field "Home Address" with value "$PatientPrimaryCaregiverInfo{Home Address}"
    * user clicks the button "UPDATE"

    * user is on the page "AdmissionPage"
    * user checks that text "Loading More Admissions" is absent on the page
    * user (waits that patients list smaller than 3)
    * user clicks the button "first patient"
    * user is on the page "PatientServiceDataPage"
    * user clicks the button "Edit Agency"
    * user is on the page "AgencyAndServiceAreaPage"
    * user selects in dropdown "Agency:" the value "$PatientServiceData{Agency:}"
    * user selects in dropdown "Service Area:" the value "$PatientServiceData{Service Area:}"
    * user clicks the button "UPDATE"

    * user is on the page "PatientServiceDataPage"
    * ? user clicks the button "Expand Physician and Insurance Info"
    * user clicks element via javascript "Expand Physician and Insurance Info"
    #* ? user clicks the button "Edit Insurance Info"
    * user clicks element via javascript "Edit Insurance Info"
    * user is on the page "InsuranceInfoPage"
    * user fills the field "SOC Date" with value "$PatientServiceInsuranceInfo{SOC Date}"
#    * ? user fills the field via javascript "SOC Date" with value "$PatientServiceInsuranceInfo{SOC Date}"
    * user fills the field "Insurance Authorization Code" with value "$PatientServiceInsuranceInfo{Insurance Authorization Code}"
    * user fill in autocomplete "Primary Insurance" the value "$PatientServiceInsuranceInfo{Primary Insurance search}" and select option "$PatientServiceInsuranceInfo{Primary Insurance select}"
    * user selects in dropdown "DDE Verification Printed and Filed" the value "$PatientServiceInsuranceInfo{DDE Verification Printed and Filed}"
    * user clicks the button "UPDATE"

    * user is on the page "PatientServiceDataPage"
    * user clicks the button "Edit Primary Physicians"
  #  * user clicks element via javascript "Edit Primary Physicians"
    * user is on the page "PrimaryPhysicianPage"
     #TODO: test fails here - block disappearing after clicking ENTEr
    # I commented Enter action during autocomplete
    * user fill in autocomplete "Primary Physician" the value "$PatientServicePhysician{Primary Physician search}" and select option "$PatientServicePhysician{Primary Physician select}"
    * user selects in dropdown "Successfully Verified" the value "$PatientServicePhysician{Successfully Verified}"
    * user clicks the button "UPDATE"

    #todo:  Second Physician
 #   * user is on the page "PatientServiceDataPage"
    #* user clicks the button "Edit Secondary Physicians"
  #  * user clicks element via javascript "Edit Secondary Physicians"
  #  * user is on the page "SecondaryPhysicianPage"
  #  * user fill in autocomplete "Secondary Physician" the value "$PatientServicePhysician{Secondary Physician search}" and select option "$PatientServicePhysician{Secondary Physician select}"
  #  * user selects in dropdown "Successfully Verified2" the value "$PatientServicePhysician{Successfully Verified2}"

    * user is on the page "PatientServiceDataPage"
    # TODO: button disabled on this patient
    * user clicks the button "Edit Pre-Auth Info"
    * user is on the page "PreAuthInfoPage"
    * user clicks the button "Add Pre-Auth"
    * user is on the page "NewAuthPage"
    * user selects in dropdown "Discipline" the value "$PatientServicePreAuthInfoNewAuth{DisciplinePT}"
    * user fills the field "Approved:" with value "$PatientServicePreAuthInfoNewAuth{Approved:}"
    * user clicks the button "ADD"
    * user is on the page "PreAuthInfoPage"
    * user clicks the button "Add Pre-Auth"
    * breakpoint
    * user is on the page "NewAuthPage"
    * user selects in dropdown "Discipline" the value "$PatientServicePreAuthInfoNewAuth{DisciplineRN}"
    * user fills the field "Approved:" with value "$PatientServicePreAuthInfoNewAuth{Approved:}"
    * user clicks the button "ADD"
    * user is on the page "PreAuthInfoPage"
    * user clicks the button "Add Pre-Auth"
    * user is on the page "NewAuthPage"
    * user selects in dropdown "Discipline" the value "$PatientServicePreAuthInfoNewAuth{DisciplineOT}"
    * user fills the field "Approved:" with value "$PatientServicePreAuthInfoNewAuth{Approved:}"
    * user clicks the button "ADD"
    * user is on the page "PreAuthInfoPage"
    * user clicks the button "Add Pre-Auth"
    * user is on the page "NewAuthPage"
    * user selects in dropdown "Discipline" the value "$PatientServicePreAuthInfoNewAuth{DisciplineST}"
    * user fills the field "Approved:" with value "$PatientServicePreAuthInfoNewAuth{Approved:}"
    * user clicks the button "ADD"
    * user is on the page "PreAuthInfoPage"
    * user clicks the button "Add Pre-Auth"
    * user is on the page "NewAuthPage"
    * user selects in dropdown "Discipline" the value "$PatientServicePreAuthInfoNewAuth{DisciplineOT}"
    * user fills the field "Approved:" with value "$PatientServicePreAuthInfoNewAuth{Approved:}"
    * user clicks the button "ADD"
    * user is on the page "PreAuthInfoPage"
    * user clicks the button "Add Pre-Auth"
    * user is on the page "NewAuthPage"
    * user selects in dropdown "Discipline" the value "$PatientServicePreAuthInfoNewAuth{DisciplineMSW}"
    * user fills the field "Approved:" with value "$PatientServicePreAuthInfoNewAuth{Approved:}"
    * user clicks the button "ADD"
    * user is on the page "PreAuthInfoPage"
    * user clicks the button "Add Pre-Auth"
    * user is on the page "NewAuthPage"
    * user selects in dropdown "Discipline" the value "$PatientServicePreAuthInfoNewAuth{DisciplineCHHA}"
    * user fills the field "Approved:" with value "$PatientServicePreAuthInfoNewAuth{Approved:}"
    * user clicks the button "ADD"
    * user is on the page "PreAuthInfoPage"
    * user clicks the button "Add Pre-Auth"
    * user is on the page "NewAuthPage"
    * user selects in dropdown "Discipline" the value "$PatientServicePreAuthInfoNewAuth{DisciplineRD}"
    * user fills the field "Approved:" with value "$PatientServicePreAuthInfoNewAuth{Approved:}"
    * user clicks the button "ADD"
    * user is on the page "PreAuthInfoPage"
    * user scrolls to element "UPDATE"
    * user is on the page "PreAuthInfoPage"
    * ? user clicks the button "UPDATE"
    * user clicks element via javascript "UPDATE"
    * user checks that text "Discipline" is absent on the page

    * user is on the page "PatientServiceDataPage"
    * ? user clicks the button "Approval Info"
    * user clicks element via javascript "Expand Approval Info"
    * user clicks element via javascript "Edit Approval Info"
    * user is on the page "ApprovalInfoPage"

    * user clears field "Date"
    * user fills the field via javascript "Date" with value "03-10-2017"
    * user is on the page "ApprovalInfoPage"
    * user selects in dropdown "Transfer Status Assigned" the value "Kaiser Transfer"
    * user selects in dropdown "Admission Category" the value "Relationship Admit"
    * user selects in dropdown "Patient Discharge Status" the value "Patient is at Home"
    * user (unselect all special programs)
    * user clicks the button "pageBody"
    * user performs "selectAllSpecialPrograms" scenario
    * user is on the page "ApprovalInfoPage"
    * user selects in dropdown "Admission Source" the value "Community"
    * user selects in dropdown "Emergency Triage Code" the value "Emergent"
    * ? user clicks the button "UPDATE"
    * user clicks element via javascript "UPDATE"

    * user is on the page "PatientServiceDataPage"
    * user clicks the button "Expand Special Orders"

    * user is on the page "LabDrawPage"
    * user clicks element via javascript "Not Ordered"
    * user is on the page "DMEPage"
    * user clicks element via javascript "Not Ordered"
    * user is on the page "WoundCarePage"
    * user clicks element via javascript "Not Ordered"
    * user is on the page "UrinaryDevicePage"
    * user clicks element via javascript "Not Ordered"
    * user is on the page "IVInfusionPage"
    * user clicks element via javascript "Not Ordered"
    * user is on the page "EnteralFeedingPage"
    * user clicks element via javascript "Not Ordered"
    * user is on the page "OstomyPage"
    * user clicks element via javascript "Not Ordered"
    * user is on the page "TracheostomyPage"
    * user clicks element via javascript "Not Ordered"
    * user is on the page "PatientServiceDataPage"
    * user clicks element via javascript "Save"
    * user is on the page "PatientServiceDataPage"
    * user clicks the button "Submit"
* breakpoint

    Examples:
      | searchByName | firstName   | lastName        | middleName | gender | searchValue   | birthDate  | patientNumberName | patientNumber | patientNumberName2 | patientNumber2 | patientNumberName3   | patientNumber3 |
      #| 123          | test1     | Test lastname | A          | Male   | test7       | 03-10-1993 | MBI Number        | 0015          | Medicaid Number    | 0016           | Kaiser Policy Number | 0017           |
      | 123          | random name | random lastname | A          | Male   | #{~firstName} | 03-10-1993 | MBI Number        | 0015          | Medicaid Number    | 0016           | Kaiser Policy Number | 0017           |

