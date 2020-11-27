package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientInfo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "PatientContactInfoPage")
public class PatientContactInfoPage extends HTMLPage {

    @ElementTitle(value = "Address")
    @FindBy(xpath = "//input[@ng-model=\"vm.patientInfo.address.address\"]")
    private WebElement address;

    @ElementTitle(value = "City")
    @FindBy(xpath = "//input[@ng-model=\"vm.patientInfo.address.city\"]")
    private WebElement city;

    @ElementTitle(value = "County")
    @FindBy(xpath = "//input[@ng-model=\"vm.patientInfo.address.county\"]")
    private WebElement county;

    @ElementTitle(value = "State")
    @FindBy(xpath = "//input[@aria-label=\"State\"]")
    private WebElement state;

    @ElementTitle(value = "Zip Code")
    @FindBy(xpath = "//input[@ng-model=\"vm.patientInfo.address.zipcode\"]")
    private WebElement zipCode;

    @ElementTitle(value = "Primary Contact Phone Number")
    @FindBy(xpath = "//input[@name='primaryContactPhoneNumber']")
    private WebElement primaryContactPhoneNumber;

    @ElementTitle(value = "Primary Contact Note")
    @FindBy(xpath = "//input[@name=\"primaryContactNote\"]")
    private WebElement primaryContactNote;

    @ElementTitle(value = "Secondary Contact Phone Number")
    @FindBy(xpath = "//input[@name='secondaryContactPhoneNumber']")
    private WebElement secondaryContactPhoneNumber;

    @ElementTitle(value = "Secondary Contact Note")
    @FindBy(xpath = "//input[@name='secondaryContactNote']")
    private WebElement secondaryContactNote;

    @ElementTitle(value = "UPDATE")
    @FindBy(xpath = "//md-sidenav[@md-component-id='patientcontact-sidenav']//button")
    private WebElement update;

    public PatientContactInfoPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
