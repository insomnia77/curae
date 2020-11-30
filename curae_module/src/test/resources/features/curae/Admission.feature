#language = en
@all
Feature: admission


  Background:
    * user is on the page "LoginPage"
    * user fills the field "User Name" with value "test.qa@cvhcare.com"
    * user fills the field "Password" with value "password"
    * user clicks the button "Log in"


  @FirstPatientNewAdmissionPatientInfo @data=$PatientContactInfo @data=$PatientBasicInfo
  Scenario Outline: FirstPatientNewAdmission
    * user performs "createPatient" scenario
      | searchByName   | firstName   | lastName   | middleName   | gender   | birthDate   | patientNumberName   | patientNumber   | patientNumberName2   | patientNumber2   | patientNumberName3   | patientNumber3   |
      | <searchByName> | <firstName> | <lastName> | <middleName> | <gender> | <birthDate> | <patientNumberName> | <patientNumber> | <patientNumberName2> | <patientNumber2> | <patientNumberName3> | <patientNumber3> |
    * ? user clicks the button "Administration"
    * user clicks element via javascript "Administration"
    * user is on the page "AdministrationPage"
    * ? user clicks the button "Clinical Support"
    * user clicks element via javascript "Clinical Support"
    * user is on the page "ClinicalSupportPage"
    * ? user clicks the button "Admission"
    * user clicks element via javascript "Admission"
    * user is on the page "AdmissionPage"
    * ? user clicks the button "In Processing"
    * user clicks element via javascript "In Processing"
    * user is on the page "AdmissionPage"
    * ? user clicks the button "search button"
    * user clicks element via javascript "search button"
    * user checks that text "Loading More Admissions" is absent on the page
    * user fills the field "search bar" with value "<searchValue>"
    * user is on the page "AdmissionPage"
    * user clicks the button "patient info"
    * user is on the page "PatientInfoPage"
    * user selects the checkbox "Same As Contact Address"
    * ? user clicks the button "Edit Contact Info"

    * user clicks element via javascript "Edit Contact Info"
    * user is on the page "PatientContactInfoPage"
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

    * ? user clicks the button "Edit Basic Info"
    * user clicks element via javascript "Edit Basic Info"
    * user is on the page "PatientBasicInfoPage"
    * user fills the field "Weight" with value "$PatientBasicInfo{Weight}"
    * user fills the field "Height" with value "$PatientBasicInfo{Height}"
    * user clicks the button "UPDATE"
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
    * user fills the field "Home Address" with value "$PatientPrimaryCaregiverInfo{Home Address}"
    * user clicks the button "UPDATE"
    * user is on the page "AdmissionPage"

    * user clicks the button "first patient"
    * user is on the page "PatientServiceDataPage"
    * user clicks the button "Edit Agency"
    * user is on the page "AgencyAndServiceAreaPage"
    * user selects in dropdown "Agency:" the value "$PatientServiceData{Agency:}"
    * user selects in dropdown "Service Area:" the value "$PatientServiceData{Service Area:}"
    * user clicks the button "UPDATE"


    Examples:
      | searchByName | firstName   | lastName        | middleName | gender | searchValue   | birthDate  | patientNumberName | patientNumber | patientNumberName2 | patientNumber2 | patientNumberName3   | patientNumber3 |
      #| 123          | test1     | Test lastname | A          | Male   | test7       | 03-10-1993 | MBI Number        | 0015          | Medicaid Number    | 0016           | Kaiser Policy Number | 0017           |
      | 123          | random name | random lastname | A          | Male   | #{~firstName} | 03-10-1993 | MBI Number        | 0015          | Medicaid Number    | 0016           | Kaiser Policy Number | 0017           |

  @FirstPatientNewAdmissionServiceData @data=$PatientServiceData
  Scenario Outline: FirstPatientNewAdmissionServiceData
    * user performs "createPatient" scenario
      | searchByName   | firstName   | lastName   | middleName   | gender   | birthDate   | patientNumberName   | patientNumber   | patientNumberName2   | patientNumber2   | patientNumberName3   | patientNumber3   |
      | <searchByName> | <firstName> | <lastName> | <middleName> | <gender> | <birthDate> | <patientNumberName> | <patientNumber> | <patientNumberName2> | <patientNumber2> | <patientNumberName3> | <patientNumber3> |
    * ? user clicks the button "Administration"
    * user clicks element via javascript "Administration"
    * user is on the page "AdministrationPage"
    * ? user clicks the button "Clinical Support"
    * user clicks element via javascript "Clinical Support"
    * user is on the page "ClinicalSupportPage"
    * ? user clicks the button "Admission"
    * user clicks element via javascript "Admission"
    * user is on the page "AdmissionPage"
    * ? user clicks the button "In Processing"
    * user clicks element via javascript "In Processing"
    * user is on the page "AdmissionPage"
    * ? user clicks the button "search button"
    * user clicks element via javascript "search button"
    * user checks that text "Loading More Admissions" is absent on the page
    * user fills the field "search bar" with value "<searchValue>"
    * user is on the page "AdmissionPage"

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
    * ? user fills the field "SOC Date" with value "$PatientServiceInsuranceInfo{SOC Date}"
    * user fills the field via javascript "SOC Date" with value "$PatientServiceInsuranceInfo{SOC Date}"
    * user fills the field "Insurance Authorization Code" with value "$PatientServiceInsuranceInfo{Insurance Authorization Code}"
    * user fill in autocomplete "Primary Insurance" the value "$PatientServiceInsuranceInfo{Primary Insurance search}" and select option "$PatientServiceInsuranceInfo{Primary Insurance select}"
    * user selects in dropdown "DDE Verification Printed and Filed" the value "$PatientServiceInsuranceInfo{DDE Verification Printed and Filed}"
    * user clicks the button "UPDATE"

    * user is on the page "PatientServiceDataPage"
    * user refreshes the page
    * user is on the page "PatientServiceDataPage"

#    * ? user clicks the button "Expand Physician and Insurance Info"
#    * user clicks element via javascript "Expand Physician and Insurance Info"
#    * user clicks element via javascript "Edit Primary Physicians"
#    * user is on the page "PrimaryPhysicianPage"
#     #TODO: test fails here - block disappearing after clicking ENTEr
#    * user fill in autocomplete "Primary Physician" the value "$PatientServicePrimaryPhysician{Primary Physician search}" and select option "$PatientServicePrimaryPhysician{Primary Physician select}"
#    * user selects in dropdown "Successfully Verified" the value "$PatientServicePrimaryPhysician{Successfully Verified}"
#    * user clicks the button "UPDATE"
#    #todo: difference with Excel, there are no Second Physician in the app


    * user clicks the button "Expand Physician and Insurance Info"
    #* user clicks element via javascript "Expand Physician and Insurance Info"
    * user is on the page "PatientServiceDataPage"
    # TODO: button disabled on this patient
    * breakpoint
    * user clicks the button "Edit Pre-Auth Info"
    * breakpoint
    * user is on the page "PreAuthInfoPage"
    * user clicks the button "Add Pre-Auth"
    * user is on the page "NewAuthPage"
    * user selects in dropdown "Discipline" the value "$PatientServicePreAuthInfoNewAuth{Discipline}"
    * user fills the field "Approved:" with value "$PatientServicePreAuthInfoNewAuth{Approved:}"
    * user clicks the button "ADD"
    * breakpoint

    Examples:
      | searchByName | firstName   | lastName        | middleName | gender | searchValue   | birthDate  | patientNumberName | patientNumber | patientNumberName2 | patientNumber2 | patientNumberName3   | patientNumber3 |
      #| 123          | test1     | Test lastname | A          | Male   | test7       | 03-10-1993 | MBI Number        | 0015          | Medicaid Number    | 0016           | Kaiser Policy Number | 0017           |
      | 123          | random name | random lastname | A          | Male   | #{~firstName} | 03-10-1993 | MBI Number        | 0015          | Medicaid Number    | 0016           | Kaiser Policy Number | 0017           |

  #workaround, with huge static waits
  @PreAuthInfoWithOutCreatingNewPatient
  Scenario: FirstPatientNewAdmissionServiceData
    * user is on the page "HomePage"
    * ? user clicks the button "Administration"
    * user clicks element via javascript "Administration"
    * user is on the page "AdministrationPage"
    * ? user clicks the button "Clinical Support"
    * user clicks element via javascript "Clinical Support"
    * user is on the page "ClinicalSupportPage"
    * ? user clicks the button "Admission"
    * user clicks element via javascript "Admission"
    * user is on the page "AdmissionPage"
    * ? user clicks the button "In Processing"
    * user clicks element via javascript "In Processing"
    * user is on the page "AdmissionPage"
    * ? user clicks the button "search button"
    * user clicks element via javascript "search button"
    * user checks that text "Loading More Admissions" is absent on the page
    * user fills the field "search bar" with value "053b21c9af2e4b6 Snowman"
    * user is on the page "AdmissionPage"

    * user clicks the button "first patient"
    * user is on the page "PatientServiceDataPage"

    * user clicks the button "Expand Physician and Insurance Info"
    * breakpoint
    * user waits "5" seconds
    * user is on the page "AdmissionPage"
    * user clicks the button "first patient"
    * user waits "7" seconds
    * user checks that text "Loading More Admissions" is absent on the page
    * user is on the page "AdmissionPage"
    * user is on the page "PatientServiceDataPage"
    * user clicks the button "Expand Physician and Insurance Info"
    * user is on the page "PatientServiceDataPage"
    * user clicks the button "Edit Pre-Auth Info"


    * user is on the page "PreAuthInfoPage"
    * user (delete all disciplines)
    * user is on the page "PreAuthInfoPage"

    * user clicks the button "Add Pre-Auth"
    * user is on the page "NewAuthPage"
    * user selects in dropdown "Discipline" the value "PT"
    * user fills the field "Approved:" with value "1"
    * user clicks the button "ADD"

    * user is on the page "PreAuthInfoPage"
    * user clicks the button "Add Pre-Auth"
    * user is on the page "NewAuthPage"
    * user selects in dropdown "Discipline" the value "RN"
    * user fills the field "Approved:" with value "1"
    * user clicks the button "ADD"

    * user is on the page "PreAuthInfoPage"
    * user clicks the button "Add Pre-Auth"
    * user is on the page "NewAuthPage"
    * user selects in dropdown "Discipline" the value "OT"
    * user fills the field "Approved:" with value "1"
    * user clicks the button "ADD"

    * user is on the page "PreAuthInfoPage"
    * user clicks the button "Add Pre-Auth"
    * user is on the page "NewAuthPage"
    * user selects in dropdown "Discipline" the value "ST"
    * user fills the field "Approved:" with value "1"
    * user clicks the button "ADD"

    * user is on the page "PreAuthInfoPage"
    * user clicks the button "Add Pre-Auth"
    * user is on the page "NewAuthPage"
    * user selects in dropdown "Discipline" the value "MSW"
    * user fills the field "Approved:" with value "1"
    * user clicks the button "ADD"

    * user is on the page "PreAuthInfoPage"
    * user clicks the button "Add Pre-Auth"
    * user is on the page "NewAuthPage"
    * user selects in dropdown "Discipline" the value "CHHA"
    * user fills the field "Approved:" with value "1"
    * user clicks the button "ADD"

    * user is on the page "PreAuthInfoPage"
    * user clicks the button "Add Pre-Auth"
    * user is on the page "NewAuthPage"
    * user selects in dropdown "Discipline" the value "RD"
    * user fills the field "Approved:" with value "1"
    * user clicks the button "ADD"

    * user is on the page "PreAuthInfoPage"
    * ? user clicks the button "UPDATE"
    * user clicks element via javascript "UPDATE"
    * breakpoint


  @FirstPatientNewAdmissionApprovalInfo @data=$PatientServiceData
  Scenario Outline: FirstPatientNewAdmissionServiceData
    * user performs "createPatient" scenario
      | searchByName   | firstName   | lastName   | middleName   | gender   | birthDate   | patientNumberName   | patientNumber   | patientNumberName2   | patientNumber2   | patientNumberName3   | patientNumber3   |
      | <searchByName> | <firstName> | <lastName> | <middleName> | <gender> | <birthDate> | <patientNumberName> | <patientNumber> | <patientNumberName2> | <patientNumber2> | <patientNumberName3> | <patientNumber3> |
    * ? user clicks the button "Administration"
    * user clicks element via javascript "Administration"
    * user is on the page "AdministrationPage"
    * ? user clicks the button "Clinical Support"
    * user clicks element via javascript "Clinical Support"
    * user is on the page "ClinicalSupportPage"
    * ? user clicks the button "Admission"
    * user clicks element via javascript "Admission"
    * user is on the page "AdmissionPage"
    * ? user clicks the button "In Processing"
    * user clicks element via javascript "In Processing"
    * user is on the page "AdmissionPage"
    * ? user clicks the button "search button"
    * user clicks element via javascript "search button"
    * user checks that text "Loading More Admissions" is absent on the page
    * user fills the field "search bar" with value "<searchValue>"
    * user is on the page "AdmissionPage"

    * user clicks the button "first patient"
    * user is on the page "PatientServiceDataPage"
    * user clicks the button "Edit Agency"
    * user is on the page "AgencyAndServiceAreaPage"
    * user selects in dropdown "Agency:" the value "$PatientServiceData{Agency:}"
    * user selects in dropdown "Service Area:" the value "$PatientServiceData{Service Area:}"
    * user clicks the button "UPDATE"
    * user checks that text "Update" is absent on the page
    #todo: need to investigate, if you remove this double click on update next update in Approval info will not work
    #* user clicks element via javascript "UPDATE"


    * user is on the page "PatientServiceDataPage"
    * ? user clicks the button "Approval Info"
    * user clicks element via javascript "Expand Approval Info"
    * user clicks element via javascript "Edit Approval Info"
    * user is on the page "ApprovalInfoPage"
    * user fills the field "Date" with value "03-10-2022"
    * user selects in dropdown "Transfer Status Assigned" the value "Kaiser Transfer"
    * user selects in dropdown "Admission Category" the value "Relationship Admit"
    * user selects in dropdown "Patient Discharge Status" the value "Patient is at Home"
    * breakpoint
    * user selects in dropdown "Special Program" the value "None"
    * user selects in dropdown "Special Program" the value "COVID"
    * user selects in dropdown "Special Program" the value "SNP"
    #todo
    * breakpoint

    Examples:
      | searchByName | firstName   | lastName        | middleName | gender | searchValue   | birthDate  | patientNumberName | patientNumber | patientNumberName2 | patientNumber2 | patientNumberName3   | patientNumber3 |
      #| 123          | test1     | Test lastname | A          | Male   | test7       | 03-10-1993 | MBI Number        | 0015          | Medicaid Number    | 0016           | Kaiser Policy Number | 0017           |
      | 123          | random name | random lastname | A          | Male   | #{~firstName} | 03-10-1993 | MBI Number        | 0015          | Medicaid Number    | 0016           | Kaiser Policy Number | 0017           |

