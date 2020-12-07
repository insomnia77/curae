#language = en
@all
Feature: admission


  Background:
    * user is on the page "LoginPage"
    * user fills the field "User Name" with value "test.qa@cvhcare.com"
    * user fills the field "Password" with value "password"
    * user clicks the button "Log in"

 #1
  @FirstPatientNewAdmissionPatientInfo @data=$PatientContactInfo @data=$PatientBasicInfo
  Scenario Outline: FirstPatientNewAdmission
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
    * user checks that text "Loading More Admissions" is absent on the page
    * user (waits that patients list smaller than 3)
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

    #2
  @FirstPatientNewAdmissionServiceData @data=$PatientServiceData
  Scenario Outline: FirstPatientNewAdmissionServiceData
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
    * ? user clicks element via javascript "Admission"
    * user is on the page "AdmissionPage"
    * ? user clicks the button "In Processing"
    * user clicks element via javascript "In Processing"
    * user is on the page "AdmissionPage"
    * ? user clicks the button "search button"
    * user clicks element via javascript "search button"
    * user checks that text "Loading More Admissions" is absent on the page
    * user fills the field "search bar" with value "<searchValue>"
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
    * ? user fills the field "SOC Date" with value "$PatientServiceInsuranceInfo{SOC Date}"
    * user fills the field via javascript "SOC Date" with value "$PatientServiceInsuranceInfo{SOC Date}"
    * user fills the field "Insurance Authorization Code" with value "$PatientServiceInsuranceInfo{Insurance Authorization Code}"
    * user fill in autocomplete "Primary Insurance" the value "$PatientServiceInsuranceInfo{Primary Insurance search}" and select option "$PatientServiceInsuranceInfo{Primary Insurance select}"
    * user selects in dropdown "DDE Verification Printed and Filed" the value "$PatientServiceInsuranceInfo{DDE Verification Printed and Filed}"
    * user clicks the button "UPDATE"

    * user is on the page "PatientServiceDataPage"
    * user refreshes the page
    * user is on the page "PatientServiceDataPage"

    #TODO: need to uncomment when defect with ENTER will be fixed
#    * ? user clicks the button "Expand Physician and Insurance Info"
#    * user clicks element via javascript "Expand Physician and Insurance Info"
#    * user clicks element via javascript "Edit Primary Physicians"
#    * user is on the page "PrimaryPhysicianPage"
#     #TODO: test fails here - block disappearing after clicking ENTEr
#    * user fill in autocomplete "Primary Physician" the value "$PatientServicePrimaryPhysician{Primary Physician search}" and select option "$PatientServicePrimaryPhysician{Primary Physician select}"
#    * user selects in dropdown "Successfully Verified" the value "$PatientServicePrimaryPhysician{Successfully Verified}"
#    #* user clicks the button "UPDATE"
#    * breakpoint
#     * user performs "executeUPDATE" scenario
#      | pageName             |
#      | PrimaryPhysicianPage |
#    #todo: difference with Excel, there are no Second Physician in the app


    * user clicks the button "Expand Physician and Insurance Info"
    #* user clicks element via javascript "Expand Physician and Insurance Info"
    * user is on the page "PatientServiceDataPage"
    * user clicks the button "Edit Pre-Auth Info"
    * user is on the page "PreAuthInfoPage"
    * user clicks the button "Add Pre-Auth"
    * user is on the page "NewAuthPage"
    * user selects in dropdown "Discipline" the value "$PatientServicePreAuthInfoNewAuth{DisciplineST}"
    * user is on the page "NewAuthPage"
    * user fills the field via javascript "Approved:" with value "$PatientServicePreAuthInfoNewAuth{Approved:}"
    * user is on the page "NewAuthPage"
    * user clicks element via javascript "ADD"
    * breakpoint
    * user is on the page "PreAuthInfoPage"
    * user performs "executeUPDATE" scenario
      | pageName        |
      | PreAuthInfoPage |
    * breakpoint

    Examples:
      | searchByName | firstName   | lastName        | middleName | gender | searchValue   | birthDate  | patientNumberName | patientNumber | patientNumberName2 | patientNumber2 | patientNumberName3   | patientNumber3 |
      #| 123          | test1     | Test lastname | A          | Male   | test7       | 03-10-1993 | MBI Number        | 0015          | Medicaid Number    | 0016           | Kaiser Policy Number | 0017           |
      | 123          | random name | random lastname | A          | Male   | #{~firstName} | 03-10-1993 | MBI Number        | 0015          | Medicaid Number    | 0016           | Kaiser Policy Number | 0017           |

    #3
  #workaround, with huge static waits
  @PreAuthInfoWithOutCreatingNewPatient
  Scenario: PreAuthInfoWithOutCreatingNewPatient
    * user is on the page "HomePage"
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
    #todo Use a previous created Patient
    * user fills the field "search bar" with value "053b21c9af2e4b6 Snowman"
    * user is on the page "AdmissionPage"
    * user checks that text "Loading More Admissions" is absent on the page
    * user clicks the button "first patient"
    * user is on the page "PatientServiceDataPage"

    * user clicks the button "Expand Physician and Insurance Info"
    * breakpoint
    * user waits "5" seconds
    * user is on the page "AdmissionPage"
    * user clicks the button "first patient"
    * user waits "7" seconds
    * user checks that text "Loading More Admissions" is absent on the page
#    * user is on the page "AdmissionPage"
#    * user is on the page "PatientServiceDataPage"
#    * ? user clicks the button "Expand Physician and Insurance Info"
#    * user clicks element via javascript "search button"
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

#4
  @FirstPatientNewAdmissionApprovalInfo @data=$PatientServiceData
  Scenario Outline: FirstPatientNewAdmissionApprovalInfo
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
    * ? user clicks element via javascript "Admission"
    * user is on the page "AdmissionPage"
    * ? user clicks the button "In Processing"
    * user clicks element via javascript "In Processing"
    * user is on the page "AdmissionPage"
    * ? user clicks the button "search button"
    * user clicks element via javascript "search button"
    * user checks that text "Loading More Admissions" is absent on the page
    * user fills the field "search bar" with value "<searchValue>"
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
    * user checks that text "Update" is absent on the page

    * user is on the page "PatientServiceDataPage"
    * ? user clicks the button "Approval Info"
    * user clicks element via javascript "Expand Approval Info"
    * user clicks element via javascript "Edit Approval Info"
    * user is on the page "ApprovalInfoPage"
    #* user fills the field "Date" with value "03-10-2022"
    * user clears field "Date"
    * user fills the field via javascript "Date" with value "03-10-2022"
    * user is on the page "ApprovalInfoPage"
    * user selects in dropdown "Transfer Status Assigned" the value "Kaiser Transfer"
    * user selects in dropdown "Admission Category" the value "Relationship Admit"
    * user selects in dropdown "Patient Discharge Status" the value "Patient is at Home"
   #todo: there is defect and unselect is workaround
    * user (unselect all special programs)
    * user clicks the button "pageBody"
    * user performs "selectAllSpecialPrograms" scenario
    * user is on the page "ApprovalInfoPage"
    * user selects in dropdown "Admission Source" the value "Community"
    * user selects in dropdown "Emergency Triage Code" the value "Emergent"
    * ? user clicks the button "UPDATE"
    * user clicks element via javascript "UPDATE"


    Examples:
      | searchByName | firstName   | lastName        | middleName | gender | searchValue   | birthDate  | patientNumberName | patientNumber | patientNumberName2 | patientNumber2 | patientNumberName3   | patientNumber3 |
      | 123          | random name | random lastname | A          | Male   | #{~firstName} | 03-10-1993 | MBI Number        | 0015          | Medicaid Number    | 0016           | Kaiser Policy Number | 0017           |

    #5
  @FirstPatientNewAdmissionRequirements
  Scenario Outline: FirstPatientNewAdmissionRequirements
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
    * user checks that text "Loading More Admissions" is absent on the page
    * user (waits that patients list smaller than 3)
    * user clicks the button "first patient"
    * user is on the page "PatientServiceDataPage"

    #this block not from excel - it's for skilled nurses
    * user is on the page "PatientServiceDataPage"
    * ? user clicks the button "Expand Physician and Insurance Info"
    * user clicks element via javascript "Expand Physician and Insurance Info"
    * user clicks element via javascript "Edit Insurance Info"
    * user is on the page "InsuranceInfoPage"
    * ? user fills the field "SOC Date" with value "12-10-2020"
    * user fills the field via javascript "SOC Date" with value "12-10-2020"
    * user fills the field "Insurance Authorization Code" with value "4565464"
    * user fill in autocomplete "Primary Insurance" the value "NGS" and select option "NGS"
    * user selects in dropdown "DDE Verification Printed and Filed" the value "Yes"
    * user clicks the button "UPDATE"
    ######

    * user is on the page "PatientServiceDataPage"
    * ? user clicks the button "Expand Admission Requirements"
    * user clicks element via javascript "Expand Admission Requirements"
    * user clicks element via javascript "Edit Admission Requirements"
    * user is on the page "AdmissionRequirementsPage"
    * user fill in autocomplete "Referral Contact" the value "cheng" and select option "TINA Y.F. CHENG"
    * user is on the page "AdmissionRequirementsPage"
    * user fill in autocomplete "Referral Account" the value "norman" and select option "Norman Cheung MD"
    * user selects in dropdown "Home Health Orders" the value "Yes"
    * user selects the checkbox "Skilled Nursing"
    * user selects the checkbox "Physical Therapy"
    * user selects the checkbox "Occupational Therapy"
    * user selects the checkbox "Speech Therapy"
    * user selects the checkbox "Registered Dietician"
    * user selects the checkbox "Medical Social Services"
    * user selects the checkbox "Certified Home Health Aide"
    * breakpoint
    * ? user clicks the button "UPDATE"
    * user clicks element via javascript "UPDATE"


    Examples:
      | searchByName | firstName   | lastName        | middleName | gender | searchValue   | birthDate  | patientNumberName | patientNumber | patientNumberName2 | patientNumber2 | patientNumberName3   | patientNumber3 |
      | 123          | random name | random lastname | A          | Male   | #{~firstName} | 03-10-1993 | MBI Number        | 0015          | Medicaid Number    | 0016           | Kaiser Policy Number | 0017           |

    #6
  @FirstPatientNewSpecialOrders
  Scenario Outline: FirstPatientNewSpecialOrders
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
    * user checks that text "Loading More Admissions" is absent on the page
    * user (waits that patients list smaller than 3)
    * user clicks the button "first patient"
    * user is on the page "PatientServiceDataPage"
    * user clicks the button "Expand Special Orders"
    * user is on the page "LabDrawPage"
    * user clicks element via javascript "Ordered"
    * user clicks the button "Edit Lab Draw"
    * user is on the page "LabDrawPage"
    * user selects the checkbox "PT/INR"
    * user selects the checkbox "BMP"
    * user selects the checkbox "CMP"
    * user selects the checkbox "CBC"
    * user selects the checkbox "H&H"
    * user selects the checkbox "ESR"
    * user selects the checkbox "CRP"
    * user selects the checkbox "HA1C"
    * user selects the checkbox "UA"
    * user selects the checkbox "C&S"
    * user selects the checkbox "Others"
    * user fills the field "Special Instructions" with value "Test Instructions"
    * user clicks element via javascript "UPDATE"

    * user is on the page "DMEPage"
    * user clicks element via javascript "Ordered"
    * user clicks the button "Edit DME"
    * user is on the page "DMEPage"
    * user selects the checkbox "Cane"
    * user selects the checkbox "Font Wheel Walker"
    * user selects the checkbox "Four Wheel Walker"
    * user selects the checkbox "Crutches"
    * user selects the checkbox "Bedside Commode"
    * user selects the checkbox "Shower Chair"
    * user selects the checkbox "Tub/Transfer Bench"
    * user selects the checkbox "Wheelchair"
    * user selects the checkbox "Hospital Bed"
    * user selects the checkbox "Wheelchair Cushion"
    * user selects the checkbox "Trapeze"
    * user selects the checkbox "Elevated Toilet Seat"
    * user selects the checkbox "Grab Bars"
    * user selects the checkbox "Nebulizer"
    * user selects the checkbox "Oxygen"
    * user selects the checkbox "Hoyer Lift"
    * user fills the field "Others" with value "Test Others"
    * user clicks element via javascript "UPDATE"

    * user is on the page "WoundCarePage"
    * user clicks element via javascript "Ordered"
    * user clicks the button "Edit Wound Care"
    * user is on the page "WoundCarePage"
    * user selects the checkbox "Pressure"
    * user selects the checkbox "Stasis"
    * user selects the checkbox "Arterial"
    * user selects the checkbox "Neuropathic"
    * user selects the checkbox "Surgical"
    * user selects the checkbox "Trauma"
    * user selects the checkbox "Diabetic"
    * user selects the checkbox "Unspecified Wound"
    * user selects in dropdown "Wound Care Orders In" the value "Yes"
    * user selects in dropdown "Refer to WOCN" the value "Yes"
    * user selects in dropdown "Wound Vac Company" the value "Genedine"
    * user fills the field "Wound Description" with value "test Description"
    * user clicks element via javascript "UPDATE"

    * user is on the page "UrinaryDevicePage"
    * user clicks element via javascript "Ordered"
    * user clicks the button "Edit Urinary Device"
    * user is on the page "UrinaryDevicePage"
    * user selects in dropdown "Type" the value "Straight Catheter"
    * user fills the field "Last Change Date" with value "05-10-2017"
    * user fills the field "Size" with value "12"
    * user fills the field "Frequency" with value "twice a day"
    * user clicks element via javascript "UPDATE"

    * user is on the page "IVInfusionPage"
    * user clicks element via javascript "Ordered"
    * user clicks the button "Edit IV Infusion"
    * user is on the page "IVInfusionPage"
    * user fills the field "Last Dose 1" with value "05-10-2017"
    * user fills the field "Medication Order 1" with value "Test Med order"
    * user fills the field "Frequency and Duration Med 1" with value "Test Freq Dur 1"
    * user fills the field "Last Dose 2" with value "05-01-2017"
    * user fills the field "Medication Order 2" with value "Test Med Order 2"
    * user fills the field "Frequency and Duration Med 2" with value "Test Freq Dur med 2"
    * user selects the checkbox "PICC Line"
    * user selects the checkbox "Mid Line"
    * user selects the checkbox "Extra Jugular"
    * user selects the checkbox "Intra Jugular"
    * user selects the checkbox "Subclavian Line"
    * user selects the checkbox "Peripheral Line"
    * user selects the checkbox "X-Ray Confirmation"
    * user selects the checkbox "Fluroscopy Report"
    * user selects the checkbox "Line Insertion Information"
    * user selects the checkbox "Gravity"
    * user selects the checkbox "Dial Flow"
    * user selects the checkbox "Elastomeric Bulb"
    * user selects the checkbox "IV Pump"
    * user selects the checkbox "IV Push"
    * user selects in dropdown "Infusion Pharmacy" the value "John Muir Pharmacy"
    * user fills the field "Delivery of Supplies Information" with value "Test Dev Sup Info"
    * user clicks element via javascript "UPDATE"

    * user is on the page "EnteralFeedingPage"
    * user clicks element via javascript "Ordered"
    * user clicks the button "Edit Enteral Feeding"
    * user is on the page "EnteralFeedingPage"
    * user clicks the button "NG Tube"
    * user selects the checkbox "Formula Change"
    * user is on the page "EnteralFeedingPage"
    * user fills the field "Detail" with value "Test Details"
    * user selects the checkbox "Bolus"
    * user fills the field "cc" with value "1"
    * user fills the field "hours" with value "1"
    * user selects the checkbox "Continuous @"
    * user fills the field "cc/hours" with value "1"
    * user selects in dropdown "type" the value "Gravity"
    * user clicks the button "UPDATE"

    * user is on the page "OstomyPage"
    * user clicks element via javascript "Ordered"
    * user clicks the button "Edit Ostomy"
    * user is on the page "OstomyPage"
    * user clicks the button "Colostomy"
    * user selects the checkbox "Stoma : Red"
    * user selects the checkbox "Stoma : Pink"
    * user selects the checkbox "Stoma : Moist"
    * user selects the checkbox "Stoma : Dry"
    * user selects the checkbox "Stoma : Pale"
    * user selects the checkbox "Stoma : Swollen"
    * user selects the checkbox "Skin : Intact"
    * user selects the checkbox "Skin : Red"
    * user selects the checkbox "Skin : Pale"
    * user selects the checkbox "Skin : Swollen"
    * user selects the checkbox "Skin : Dry"
    * user selects the checkbox "Skin : Mecerated"
    * user clicks the button "Stool Consistence : Soft"
    * user clicks the button "Stool Appearance : Yellowish"
    * user clicks the button "UPDATE"

    * user is on the page "TracheostomyPage"
    * user clicks element via javascript "Ordered"
    * user clicks the button "Edit Tracheostomy"
    * user is on the page "TracheostomyPage"
    * user fills the field "Date of Tracheostomy" with value "05-05-2021"
    * user fills the field "Size" with value "21"
    * user fills the field "DME and Supply Company Name" with value "test Name"
    * user fills the field "DME Contact Person" with value "test Contact Name"
    * user fills the field "Supplies DME Contact Number" with value "433-44-3311"
    * user selects in dropdown "Billing Clearance" the value "Yes"
    * user selects the checkbox "Hospital Bed"
    * user selects the checkbox "Oxygen Concentrator"
    * user selects the checkbox "Oxygen Tank"
    * user selects the checkbox "Trach Humidifier"
    * user selects the checkbox "Trach Collar"
    * user selects the checkbox "Corrugated Tubing"
    * user selects the checkbox "Distilled Water"
    * user selects the checkbox "Condensation Drain"
    * user selects the checkbox "Trach Dressing Kits"
    * user selects the checkbox "Drain Sponges"
    * user selects the checkbox "Hydrogen Peroxide"
    * user selects the checkbox "Normal Saline"
    * user selects the checkbox "Suction Machine"
    * user selects the checkbox "Inline Suction"
    * user selects the checkbox "Suction Tip Kit"
    * user clicks the button "UPDATE"


    Examples:
      | searchByName | firstName   | lastName        | middleName | gender | searchValue   | birthDate  | patientNumberName | patientNumber | patientNumberName2 | patientNumber2 | patientNumberName3   | patientNumber3 |
      | 123          | random name | random lastname | A          | Male   | #{~firstName} | 03-10-1993 | MBI Number        | 0015          | Medicaid Number    | 0016           | Kaiser Policy Number | 0017           |

    #7
  @FirstPatientNewIntakeNoteAndFaceToFace
  Scenario Outline: FirstPatientNewSpecialOrders
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
    * user checks that text "Loading More Admissions" is absent on the page
    * user (waits that patients list smaller than 3)
    * user clicks the button "first patient"
    * user is on the page "PatientServiceDataPage"

    * user clicks the button "Expand Intake Notes"
    * user clicks the button "Edit Intake Info"
    * user is on the page "IntakeInfoPage"
    * user fills the field "Intake Notes" with value "Test Intake Note"
    * user fills the field "Miscellaneous" with value "Test Miscellaneous"
    * ? user clicks the button "UPDATE"
    * user clicks element via javascript "UPDATE"
    * user is on the page "PatientServiceDataPage"
    * user clicks element via javascript "Expand Face 2 Face Checklist"
    * user is on the page "Face2FaceChecklistViewPage"
    * ? user clicks the button "Edit Face 2 Face Checklist"
    #* user trying to click element via javascript "Edit Face 2 Face Checklist"
    * user is on the page "Face2FaceChecklistPage"
    * breakpoint
    * user selects in dropdown "Face 2 face sent to MD" the value "Faxed to MD Office"
    * breakpoint
    * user is on the page "Face2FaceChecklistPage"
    * user fills the field via javascript "Date Sent Md" with value "05-05-2021"
    * user selects in dropdown "Face 2 Face Status on Admit Processing" the value "Missing"
    * user selects in dropdown "Appointment Set with PCP" the value "Appointment set"
    * user fills the field "PCP Appointment Date" with value "05-05-2021"
    * ? user clicks the button "UPDATE"
    * user clicks element via javascript "UPDATE"
    * user is on the page "PatientServiceDataPage"
    * user verifies that element "Submit" not clickable


    Examples:
      | searchByName | firstName   | lastName        | middleName | gender | searchValue   | birthDate  | patientNumberName | patientNumber | patientNumberName2 | patientNumber2 | patientNumberName3   | patientNumber3 |
      | 123          | random name | random lastname | A          | Male   | #{~firstName} | 03-10-1993 | MBI Number        | 0015          | Medicaid Number    | 0016           | Kaiser Policy Number | 0017           |


    #TODO: submit functionality