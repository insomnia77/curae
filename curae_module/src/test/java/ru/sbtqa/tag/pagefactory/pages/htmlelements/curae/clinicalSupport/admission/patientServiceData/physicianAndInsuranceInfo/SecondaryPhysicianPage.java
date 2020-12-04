package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientServiceData.physicianAndInsuranceInfo;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import ru.sbtqa.tag.pagefactory.*;
import ru.sbtqa.tag.pagefactory.annotations.*;
import ru.sbtqa.tag.pagefactory.environment.*;
import ru.sbtqa.tag.pagefactory.web.utils.*;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "SecondaryPhysicianPage")
public class SecondaryPhysicianPage extends HTMLPage{

    @ElementTitle(value = "Secondary Physician")
    @FindBy(xpath = "//input[@aria-label=\"Secondary Physician\"]")
    private WebElement secondaryPhysician;

    @ElementTitle(value = "Successfully Verified")
    @FindBy(xpath = "//md-select[@ng-model=\"vm.event.secondaryPhysicianVerified\"]")
    private WebElement successfullyVerified;

    @ElementTitle(value = "UPDATE")
    @FindBy(xpath = "//md-sidenav[not(contains(@class, 'md-closed'))]//button[(contains(@ng-click, 'secondaryPhysicianForm'))]")
    private WebElement update;

    public SecondaryPhysicianPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
        WebDriverWait wait = new WebDriverWait(Environment.getDriverService().getDriver(),30);
    //    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clinicalSupportXpath)));
    //    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(clinicalSupportXpath)));
    }

}

