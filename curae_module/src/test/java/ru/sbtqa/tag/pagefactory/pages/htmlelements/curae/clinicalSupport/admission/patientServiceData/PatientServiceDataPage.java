package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientServiceData;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "PatientServiceDataPage")
public class PatientServiceDataPage extends HTMLPage {


    @ElementTitle(value = "Edit Agency")
    @FindBy(xpath = "//button[@ng-click=\"vm.openAdmissionSidebar('serviceArea-sidenav')\"]")
    private WebElement editAgency;


    public PatientServiceDataPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
