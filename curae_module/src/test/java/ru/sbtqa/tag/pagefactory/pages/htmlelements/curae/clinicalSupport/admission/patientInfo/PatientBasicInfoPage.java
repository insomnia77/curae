package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientInfo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "PatientBasicInfoPage")
public class PatientBasicInfoPage extends HTMLPage {

    @ElementTitle(value = "Weight")
    @FindBy(xpath = "//input[@ng-model=\"vm.patientInfo.weight\"]")
    private WebElement weight;

    @ElementTitle(value = "Height")
    @FindBy(xpath = "//input[@ng-model=\"vm.patientInfo.height\"]")
    private WebElement height;

    @ElementTitle(value = "UPDATE")
    @FindBy(xpath = "//*[@id=\"ui-admin-email\"]/md-content/md-sidenav[1]/md-content/button[2]")
    private WebElement update;

    public PatientBasicInfoPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
