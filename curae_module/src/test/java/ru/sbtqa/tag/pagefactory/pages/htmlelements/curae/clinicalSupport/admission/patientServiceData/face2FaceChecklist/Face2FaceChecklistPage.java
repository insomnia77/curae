package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientServiceData.face2FaceChecklist;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.environment.Environment;
import ru.sbtqa.tag.pagefactory.find.HtmlFindUtils;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "Face2FaceChecklistPage")
public class Face2FaceChecklistPage extends HTMLPage {
    private final String DateSentMdXPATH = "//md-datepicker[@ng-model=\"vm.checklist.dateFaceToFaceSentToMD\"]//input";

    @ElementTitle(value = "Edit Face 2 Face Checklist")
    @FindBy(xpath = "//button[@ng-click=\"vm.openAdmissionSidebar('checklistinfo-sidenav')\"]")
    private WebElement EditFace2FaceChecklist;

    @ElementTitle(value = "Face 2 face sent to MD")
    @FindBy(xpath = "//md-select[@ng-model=\"vm.checklist.faceToFaceSentToMD\"]")
    private WebElement Face2facesenttoMD;

    @ElementTitle(value = "Date Sent Md")
    @FindBy(xpath = DateSentMdXPATH)
    private WebElement DateSentMd;

    @ElementTitle(value = "Face 2 Face Status on Admit Processing")
    @FindBy(xpath = "//md-select[@ng-model=\"vm.checklist.faceToFaceStatus\"]")
    private WebElement Face2FaceStatusonAdmitProcessing;

    @ElementTitle(value = "Appointment Set with PCP")
    @FindBy(xpath = "//md-select[@ng-model=\"vm.checklist.appointmentSetwithPCP\"]")
    private WebElement AppointmentSetwithPCP;

    @ElementTitle(value = "PCP Appointment Date")
    @FindBy(xpath = "//md-datepicker[@ng-model=\"vm.checklist.pcpAppointmentDate\"]//input")
    private WebElement PCPAppointmentDate;

    @ElementTitle(value = "UPDATE")
    @FindBy(xpath = "//button[@ng-click=\"vm.updateAdmissionCheckList()\"]")
    private WebElement update;

    public Face2FaceChecklistPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        try {
            WebDriverWait wait = new WebDriverWait(Environment.getDriverService().getDriver(), 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DateSentMdXPATH)));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DateSentMdXPATH)));
            Waits.waitAndGetElements(DateSentMdXPATH, Waits.big_wait, Waits.pollingTime, true);
        } catch (Exception e)
        {
            WebElement element = Waits.waitAndGetElements(DateSentMdXPATH, Waits.big_wait, Waits.pollingTime, true).get(0);
            JavascriptExecutor js = Environment.getDriverService().getDriver();
            js.executeScript("arguments[0].click();", element);
        }
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
