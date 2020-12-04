package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientInfo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;
import ru.sbtqa.tag.stepdefs.en.*;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "PatientBasicInfoPage")
public class PatientBasicInfoPage extends HTMLPage {

    @ElementTitle(value = "Weight")
    @FindBy(xpath = "//input[@ng-model=\"vm.patientInfo.weight\"]")
    private WebElement weight;

    @ElementTitle(value = "Height")
    @FindBy(xpath = "//input[@ng-model=\"vm.patientInfo.height\"]")
    private WebElement height;

    @ElementTitle(value = "Edit Patient Name")
    @FindBy(xpath = "//button[@ng-click=\"vm.changekey()\"]")
    private WebElement EditPatientName;

    @ElementTitle(value = "First Name")
    @FindBy(xpath = "//input[@ng-model=\"vm.editkey.firstName\"]")
    private WebElement FirstName;

    @ElementTitle(value = "Middle Name")
    @FindBy(xpath = "//input[@ng-model=\"vm.editkey.middleName\"]")
    private WebElement MiddleName;

    @ElementTitle(value = "Last Name")
    @FindBy(xpath = "//input[@name=\"lastName\"]")
    private WebElement LastName;

    @ElementTitle(value = "Gender")
    @FindBy(xpath = "//md-select[@ng-model=\"vm.editkey.gender\"]")
    private WebElement Gender;

    @ElementTitle(value = "Update Patient Name")
    @FindBy(xpath = "//button[@ng-click=\"vm.updatePatientKey(event)\"]")
    private WebElement UpdatePatientName;

    @ElementTitle(value = "Confirm!")
    @FindBy(xpath = "//button[@ng-click=\"dialog.hide()\"]")
    private WebElement Confirm;

    @ElementTitle(value = "UPDATE")
    @FindBy(xpath = "//*[@id=\"ui-admin-email\"]/md-content/md-sidenav[1]/md-content/button[2]")
    private WebElement update;

    public PatientBasicInfoPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
