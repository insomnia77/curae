package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientServiceData.physicianAndInsuranceInfo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "NewAuthPage")
public class NewAuthPage extends HTMLPage {

    @ElementTitle(value = "Discipline")
    @FindBy(xpath = "//md-select[@ng-model=\"vm.item.discipline\"]")
    private WebElement Discipline;

    @ElementTitle(value = "Approved:")
    @FindBy(xpath = "//input[@ng-model=\"vm.item.approved\"]")
    private WebElement approved;

    @ElementTitle(value = "ADD")
    @FindBy(xpath = "//button[@ng-click=\"vm.addApprove()\"]")
    private WebElement update;

    public NewAuthPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
