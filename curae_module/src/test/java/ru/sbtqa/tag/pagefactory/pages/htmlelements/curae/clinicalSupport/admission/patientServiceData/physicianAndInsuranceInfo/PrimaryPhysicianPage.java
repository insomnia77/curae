package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientServiceData.physicianAndInsuranceInfo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "PrimaryPhysicianPage")
public class PrimaryPhysicianPage extends HTMLPage {

    @ElementTitle(value = "Primary Physician")
    @FindBy(xpath = "//input[@aria-label=\"Primary Physician\"]")
    private WebElement primaryPhysician;

    @ElementTitle(value = "Successfully Verified")
    @FindBy(xpath = "//md-select[@ng-model=\"vm.event.primaryPhysicianVerified\"]")
    private WebElement successfullyVerified;

    @ElementTitle(value = "UPDATE")
    @FindBy(xpath = "//md-sidenav[not(contains(@class, 'md-closed'))]//button[(contains(@ng-click, 'primaryPhysicianForm'))]")
    private WebElement update;

    public PrimaryPhysicianPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
