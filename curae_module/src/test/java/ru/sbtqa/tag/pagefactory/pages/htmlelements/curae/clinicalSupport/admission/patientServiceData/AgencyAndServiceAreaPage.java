package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientServiceData;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "AgencyAndServiceAreaPage")
public class AgencyAndServiceAreaPage extends HTMLPage {

    @ElementTitle(value = "Agency:")
    @FindBy(xpath = "//md-select[@ng-model=\"vm.admission.agency\"]")
    private WebElement agency;

    @ElementTitle(value = "Service Area:")
    @FindBy(xpath = "//md-select[@ng-model=\"vm.admission.serviceArea\"]")
    private WebElement serviceArea;

    @ElementTitle(value = "UPDATE")
    @FindBy(xpath = "//md-sidenav[not(contains(@class, 'md-closed'))]//button[contains(@ng-click, 'vm.updateAdmission') and not(@ng-disabled)]")
    private WebElement update;

    public AgencyAndServiceAreaPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
