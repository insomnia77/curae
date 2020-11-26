package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "AdmissionPage")
public class AdmissionPage extends HTMLPage {

    @ElementTitle(value = "In Processing")
    @FindBy(xpath = "(//*[@role='tablist']//*[text()='In Processing'])[1]")
    private WebElement admission;

    @ElementTitle(value = "search button")
    @FindBy(xpath = "//button[@ng-click=\"vm.filterShow = false\"]")
    private WebElement searchButton;

    @ElementTitle(value = "search bar")
    @FindBy(xpath = "//input[@ng-model=\"vm.patientSearch\"]")
    private WebElement searchBar;

    @ElementTitle(value = "New Patient")
    @FindBy(xpath = "//div[@ng-show=\"vm.filterShow\"]//button[@ng-click=\"vm.newAdmissionClick($event)\"]")
    private WebElement newPatient;

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

    public AdmissionPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
