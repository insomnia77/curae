package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "CreatePatientPopupPage")
public class CreatePatientPopupPage extends HTMLPage {

    @ElementTitle(value = "pageBody")
    @FindBy(xpath = "//md-toolbar//span[text()='New Admission']")
    private WebElement pageBody;

    @ElementTitle(value = "Search by patient name")
    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchByPatientName;

    @ElementTitle(value = "Patient first name")
    @FindBy(xpath = "//input[@ng-model=\"vm.newpatient.firstName\"]")
    private WebElement patientFirstName;

    @ElementTitle(value = "Patient last name")
    @FindBy(xpath = "//input[@ng-model=\"vm.newpatient.lastName\"]")
    private WebElement patientLastName;

    @ElementTitle(value = "Patient middle name")
    @FindBy(xpath = "//input[@ng-model=\"vm.newpatient.middleName\"]")
    private WebElement patientMiddleName;

    @ElementTitle(value = "Patient gender")
    @FindBy(xpath = "//md-select[@ng-model=\"vm.newpatient.gender\"]")
    private WebElement patientGender;

    @ElementTitle(value = "Birth Date")
    @FindBy(xpath = "//md-datepicker[@ng-model=\"vm.newpatient.birthday\"]/div[1]/input")
    private WebElement birthDate;

    @ElementTitle(value = "add button")
    @FindBy(xpath = "//button[@ng-click=\"vm.addOnePatientNumber()\"]")
    private WebElement addButton;

    @ElementTitle(value = "Patient Number Name")
    @FindBy(xpath = "(//md-select[@name=\"patientInsurance\"])[1]")
    private WebElement patientNumberNameDropDown;

    @ElementTitle(value = "Patient Number Name 2")
    @FindBy(xpath = "(//md-select[@name=\"patientInsurance\"])[2]")
    private WebElement patientNumberNameDropDown2;

    @ElementTitle(value = "Patient Number Name 3")
    @FindBy(xpath = "(//md-select[@name=\"patientInsurance\"])[3]")
    private WebElement patientNumberNameDropDown3;

    @ElementTitle(value = "Patient Numbers")
    @FindBy(xpath = "(//input[@ng-model=\"patientNumber.number\"])[1]")
    private WebElement patientNumbers;

    @ElementTitle(value = "Patient Numbers 2")
    @FindBy(xpath = "(//input[@ng-model=\"patientNumber.number\"])[2]")
    private WebElement patientNumbers2;

    @ElementTitle(value = "Patient Numbers 3")
    @FindBy(xpath = "(//input[@ng-model=\"patientNumber.number\"])[3]")
    private WebElement patientNumbers3;

    @ElementTitle(value = "CONFIRM")
    @FindBy(xpath = "//button[@ng-click=\"vm.addNewClick()\"]")
    private WebElement confirm;

    @ElementTitle(value = "Message about existing")
    @FindBy(xpath = "//div[@ng-if=\"::!dialog.mdHtmlContent\"]/p")
    private WebElement messageExistingPatient;

    public CreatePatientPopupPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
