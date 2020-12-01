package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientServiceData.approvalInfo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "ApprovalInfoPage")
public class ApprovalInfoPage extends HTMLPage {

    @ElementTitle(value = "pageBody")
    @FindBy(xpath = "//body")
    private WebElement pageBody;

    @ElementTitle(value = "Date")
    @FindBy(xpath = "//input[@placeholder=\"Referral Date\"]")
    private WebElement Date;

    @ElementTitle(value = "Transfer Status Assigned")
    @FindBy(xpath = "//md-select[@ng-model=\"vm.admission.admissionTransferStatus\"]")
    private WebElement transferStatusAssigned;

    @ElementTitle(value = "Admission Category")
    @FindBy(xpath = "//md-select[@ng-model=\"vm.admission.admissionCategory\"]")
    private WebElement AdmissionCategory;

    @ElementTitle(value = "Patient Discharge Status")
    @FindBy(xpath = "//md-select[@ng-model=\"vm.admission.patientDischargeStatus\"]")
    private WebElement PatientDischargeStatus;

    @ElementTitle(value = "Special Program")
    @FindBy(xpath = "//md-select[@ng-model=\"vm.admission.specialProgram\"]")
    private WebElement specialProgram;

    @ElementTitle(value = "Admission Source")
    @FindBy(xpath = "//md-select[@ng-model=\"vm.admission.admissionSource\"]")
    private WebElement AdmissionSource;

    @ElementTitle(value = "Emergency Triage Code")
    @FindBy(xpath = "//md-select[@ng-model=\"vm.admission.emergencyTriageCode\"]")
    private WebElement EmergencyTriageCode;

    @ElementTitle(value = "Approving Manager")
    @FindBy(xpath = "//input[@aria-label=\"Approving Manager\"]")
    private WebElement ApprovingManager;

    @ElementTitle(value = "UPDATE")
    @FindBy(xpath = "//md-sidenav[not(contains(@class, 'md-closed'))]//button[(contains(@ng-click, 'approvalForm'))]")
    private WebElement update;

    @ActionTitle("unselect all special programs")
    public void unselectAllSpecialPrograms() {
        specialProgram.click();
        WebElement option = Waits.waitAndGetElements("((//md-option/div[text()='" + "None" + "'])[last()] | (//span[text()='" + "None" + "']/parent::div/parent::md-option)[last()])[last()]", Waits.medium_wait, Waits.pollingTime, true).get(0);
        if(option.getAttribute("aria-selected").equals("false"))
        {
            option.click();
        }
    }

    public ApprovalInfoPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
