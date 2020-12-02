package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientServiceData.intakeNotes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "IntakeInfoPage")
public class IntakeInfoPage extends HTMLPage {

    @ElementTitle(value = "Intake Notes")
    @FindBy(xpath = "//textarea[@ng-model=\"vm.admission.intakeNotes\"]")
    private WebElement IntakeNotes;

    @ElementTitle(value = "Miscellaneous")
    @FindBy(xpath = "//textarea[@ng-model=\"vm.admission.miscellaneous\"]")
    private WebElement Miscellaneous;

    @ElementTitle(value = "UPDATE")
    @FindBy(xpath = "//button[@ng-click=\"vm.updateAdmission('update','intakeForm')\"]")
    private WebElement update;

    public IntakeInfoPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
