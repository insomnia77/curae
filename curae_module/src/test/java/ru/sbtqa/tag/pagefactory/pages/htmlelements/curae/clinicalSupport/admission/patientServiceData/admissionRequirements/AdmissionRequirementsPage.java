package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientServiceData.admissionRequirements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "AdmissionRequirementsPage")
public class AdmissionRequirementsPage extends HTMLPage {

    @ElementTitle(value = "pageBody")
    @FindBy(xpath = "//body")
    private WebElement pageBody;

    @ElementTitle(value = "Referral Contact")
    @FindBy(xpath = "//input[@aria-label=\"Referral Contact\"]")
    private WebElement ReferralContact;

    @ElementTitle(value = "Referral Account")
    @FindBy(xpath = "//input[@aria-label=\"Referral Account\"]")
    private WebElement ReferralAccount;

    @ElementTitle(value = "Home Health Orders")
    @FindBy(xpath = "//md-select[@name=\"homeHealthOrders\"]")
    private WebElement HomeHealthOrders;

    @ElementTitle(value = "Skilled Nursing")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Skilled Nursing\"]")
    private WebElement SkilledNursing;

    @ElementTitle(value = "Physical Therapy")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Physical Therapy\"]\n")
    private WebElement PhysicalTherapy;

    @ElementTitle(value = "Occupational Therapy")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Occupational Therapy\"]")
    private WebElement OccupationalTherapy;

    @ElementTitle(value = "Speech Therapy")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Speech Therapy\"]")
    private WebElement SpeechTherapy;

    @ElementTitle(value = "Registered Dietician")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Registered Dietician\"]")
    private WebElement RegisteredDietician;

    @ElementTitle(value = "Medical Social Services")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Medical Social Services\"]")
    private WebElement MedicalSocialServices;

    @ElementTitle(value = "Certified Home Health Aide")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Certified Home Health Aide\"]")
    private WebElement CertifiedHomeHealthAide;


    @ElementTitle(value = "UPDATE")
    @FindBy(xpath = "//md-sidenav[not(contains(@class, 'md-closed'))]//button[(contains(@ng-click, 'admissionRequirementsForm'))]")
    private WebElement update;


    public AdmissionRequirementsPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
