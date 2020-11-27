package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientServiceData.physicianAndInsuranceInfo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "InsuranceInfoPage")
public class InsuranceInfoPage extends HTMLPage {

    @ElementTitle(value = "SOC Date")
    @FindBy(xpath = "//input[@placeholder=\"SOC Date\"]")
    private WebElement SOCDate;

    @ElementTitle(value = "Primary Insurance")
    @FindBy(xpath = "//input[@aria-label=\"Primary Insurance\"]")
    private WebElement primaryInsurance;

    @ElementTitle(value = "DDE Verification Printed and Filed")
    @FindBy(xpath = "//md-select[@name=\"insuranceVerified\"]")
    private WebElement DDEVerificationPrintedandFiled;

    @ElementTitle(value = "Insurance Authorization Code")
    @FindBy(xpath = "//input[@ng-model=\"vm.admission.authCode\"]")
    private WebElement InsuranceAuthorizationCode;

    @ElementTitle(value = "UPDATE")
    @FindBy(xpath = "//md-sidenav[not(contains(@class, 'md-closed'))]//button[(contains(@ng-click, 'insuranceForm'))]")
    private WebElement update;

    public InsuranceInfoPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
