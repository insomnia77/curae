package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.blocks.NavigationBlock;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "AdmissionPage")
public class AdmissionPage extends HTMLPage {

    @ElementTitle(value = "navigationBlock")
    private NavigationBlock navigationBlock;

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

    @ElementTitle(value = "patient info")
    @FindBy(xpath = "//button[@ng-click=\"vm.openPatientInfo(admissionKey)\"]")
    private WebElement patientInfo;

    @ElementTitle(value = "first patient")
    @FindBy(xpath = "//button[@ng-click=\"vm.openPatient(admissionKey)\"]")
    private WebElement firstPatient;

    public AdmissionPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
