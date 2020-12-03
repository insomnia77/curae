package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientServiceData;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "PatientServiceDataPage")
public class PatientServiceDataPage extends HTMLPage {


    @ElementTitle(value = "Edit Agency")
    @FindBy(xpath = "//button[@ng-click=\"vm.openAdmissionSidebar('serviceArea-sidenav')\"]")
    private WebElement editAgency;

    @ElementTitle(value = "Expand Physician and Insurance Info")
    @FindBy(xpath = "//*[@class='md-title' and text()='Physician and Insurance Info']/parent::md-expansion-panel-collapsed/md-icon")
    private WebElement expandPhysicianandInsuranceInfo;

    @ElementTitle(value = "Expand Approval Info")
    @FindBy(xpath = "//*[@class='md-title' and text()='Approval Info']/parent::md-expansion-panel-collapsed/md-icon")
    private WebElement expandApprovalInfo;

    @ElementTitle(value = "Edit Insurance Info")
    @FindBy(xpath = "//button[@ng-click=\"vm.openAdmissionSidebar('insuranceinfo-sidenav')\"]")
    private WebElement editInsuranceInfo;

    @ElementTitle(value = "Edit Primary Physicians")
    @FindBy(xpath = "//button[@ng-click=\"vm.openAdmissionSidebar('primaryphysicianinfo-sidenav', $event)\"]")
    private WebElement editPrimaryPhysicians;

    @ElementTitle(value = "Edit Pre-Auth Info")
    @FindBy(xpath = "//button[@ng-click=\"vm.openAdmissionSidebar('preauthinfo-sidenav')\"]")
    private WebElement editPreAuthInfo;

    @ElementTitle(value = "Edit Approval Info")
    @FindBy(xpath = "//button[@ng-click=\"vm.openAdmissionSidebar('approvalinfo-sidenav')\"]")
    private WebElement editApprovalInfo;

    @ElementTitle(value = "Expand Admission Requirements")
    @FindBy(xpath = "//*[@class='md-title' and contains(text(), 'Admission Requirements')]/parent::md-expansion-panel-collapsed/md-icon")
    private WebElement ExpandAdmissionRequirements;

    @ElementTitle(value = "Edit Admission Requirements")
    @FindBy(xpath = "//button[@aria-label=\"Edit Admission Requirements\"]")
    private WebElement EditAdmissionRequirements;

    @ElementTitle(value = "Expand Special Orders")
    @FindBy(xpath = "//*[@class='md-title' and contains(text(), 'Special Orders')]/parent::md-expansion-panel-collapsed/md-icon")
    private WebElement ExpandSpecialOrders;

    @ElementTitle(value = "Expand Intake Notes")
    @FindBy(xpath = "//*[@class='md-title' and contains(text(), 'Intake Notes')]/parent::md-expansion-panel-collapsed/md-icon")
    private WebElement ExpandIntakeNotes;

    @ElementTitle(value = "Edit Intake Info")
    @FindBy(xpath = "//button[@ng-click=\"vm.openAdmissionSidebar('intakeinfo-sidenav')\"]")
    private WebElement EditIntakeInfo;

    @ElementTitle(value = "Expand Face 2 Face Checklist")
    @FindBy(xpath = "//*[@class='md-title' and contains(text(), 'Face 2 Face Checklist')]/parent::md-expansion-panel-collapsed/md-icon")
    private WebElement ExpandFace2FaceChecklist;

    @ElementTitle(value = "Edit Face 2 Face Checklist")
    @FindBy(xpath = "//button[@ng-click=\"vm.openAdmissionSidebar('checklistinfo-sidenav')\"]")
    private WebElement EditFace2FaceChecklist;

    @ElementTitle(value = "Submit")
    @FindBy(xpath = "//button[contains(text(),\"Submit\")]")
    private WebElement Submit;

    public PatientServiceDataPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
