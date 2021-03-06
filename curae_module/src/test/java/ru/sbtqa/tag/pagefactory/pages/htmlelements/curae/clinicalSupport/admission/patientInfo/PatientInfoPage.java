package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientInfo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "PatientInfoPage")
public class PatientInfoPage extends HTMLPage {

    @ElementTitle(value = "Same As Contact Address")
    @FindBy(xpath = "//md-checkbox[@ng-model=\"vm.sameAsContactInfo\"]")
    private WebElement sameAsContactAddressCheckbox;

    @ElementTitle(value = "Edit Contact Info")
    @FindBy(xpath = "//button[@ng-click=\"vm.openPatientSidebar('patientcontact-sidenav')\"]")
    private WebElement editContactInfo;

    @ElementTitle(value = "Edit Basic Info")
    @FindBy(xpath = "//button[@ng-click=\"vm.openPatientSidebar('patientbasic-sidenav')\"]")
    private WebElement editBasicInfo;

    @ElementTitle(value = "Edit Primary Caregiver Info")
    @FindBy(xpath = "//button[@ng-click=\"vm.openCaregiverSidebar('patientcaregiver-sidenav', caregiver)\"]")
    private WebElement editPrimaryCaregiverInfo;

    public PatientInfoPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
