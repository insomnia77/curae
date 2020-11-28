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

    @ElementTitle(value = "Edit Insurance Info")
    @FindBy(xpath = "//button[@ng-click=\"vm.openAdmissionSidebar('insuranceinfo-sidenav')\"]")
    private WebElement editInsuranceInfo;

    @ElementTitle(value = "Edit Primary Physicians")
    @FindBy(xpath = "//button[@ng-click=\"vm.openAdmissionSidebar('primaryphysicianinfo-sidenav', $event)\"]")
    private WebElement editPrimaryPhysicians;

    @ElementTitle(value = "Edit Pre-Auth Info")
    @FindBy(xpath = "//button[@ng-click=\"vm.openAdmissionSidebar('preauthinfo-sidenav')\"]")
    private WebElement editPreAuthInfo;

    public PatientServiceDataPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
