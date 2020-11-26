package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "CreatePatientPopupPage")
public class CreatePatientPopupPage extends HTMLPage {

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
    @FindBy(xpath = "//md-select[@name=\"patientInsurance\"]")
    private WebElement patientNumberNameDropDown;

    @ElementTitle(value = "Patient Numbers")
    @FindBy(xpath = "//input[@ng-model=\"patientNumber.number\"]")
    private WebElement patientNumbers;

    @ElementTitle(value = "CONFIRM")
    @FindBy(xpath = "//button[@ng-click=\"vm.addNewClick()\"]")
    private WebElement confirm;

    public CreatePatientPopupPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
