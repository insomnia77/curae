package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientInfo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "PatientPrimaryCareGiverInfoPage")
public class PatientPrimaryCareGiverInfoPage extends HTMLPage {

    @ElementTitle(value = "Name")
    @FindBy(xpath = "//input[@ng-model=\"vm.event.editCaregiver.name\"]")
    private WebElement name;

    @ElementTitle(value = "Relationship")
    @FindBy(xpath = "//md-select[@name=\"caregiverRelationship\"]")
    private WebElement relationship;

    @ElementTitle(value = "Phone Number")
    @FindBy(xpath = "//input[@ng-model=\"vm.event.editCaregiver.phoneNumber\"]")
    private WebElement phoneNumber;

    @ElementTitle(value = "Mobile Number")
    @FindBy(xpath = "//input[@ng-model=\"vm.event.editCaregiver.mobileNumber\"]")
    private WebElement mobileNumber;

    @ElementTitle(value = "Work Number")
    @FindBy(xpath = "//input[@ng-model=\"vm.event.editCaregiver.workNumber\"]")
    private WebElement workNumber;

    @ElementTitle(value = "Home Address")
    @FindBy(xpath = "//input[@ng-model=\"vm.event.editCaregiver.homeAddress\"]")
    private WebElement homeAddress;

    @ElementTitle(value = "UPDATE")
    @FindBy(xpath = "//md-sidenav[not(contains(@class, 'md-closed'))]//button[@ng-click='vm.updatePatientInfo()' and not(@ng-disabled)]")
    private WebElement update;

    public PatientPrimaryCareGiverInfoPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
