package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.environment.*;
import ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.blocks.NavigationBlock;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import java.util.List;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "AdmissionPage")
public class AdmissionPage extends HTMLPage {
   private final String inProcessingXPATH = "(//*[@role='tablist']//*[text()='In Processing'])[1]";

    @ElementTitle(value = "navigationBlock")
    private NavigationBlock navigationBlock;

    @ElementTitle(value = "In Processing")
    @FindBy(xpath = inProcessingXPATH)
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

    @ActionTitle("waits that patients list smaller than 3")
    public void searchPatient() {
        int timeoutCount = 0;
        Waits.waitForPageToLoad();
        List<WebElement> elements = Waits.waitAndGetElements("//*[@infinite-scroll='vm.reddit.nextPage()']//md-list/md-list-item", Waits.big_wait, Waits.pollingTime);
        if (!(timeoutCount < 6 && elements.size() > 0 && elements.size() < 4)) {
            timeoutCount++;
            searchPatient();
        }
    }

    public AdmissionPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
        WebDriverWait wait = new WebDriverWait(Environment.getDriverService().getDriver(),30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inProcessingXPATH)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inProcessingXPATH)));
    }

}
