package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientServiceData.face2FaceChecklist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.environment.Environment;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "Face2FaceChecklistViewPage")
public class Face2FaceChecklistViewPage extends HTMLPage {
private final String EditFace2FaceChecklistXPATH = "//button[@ng-click=\"vm.openAdmissionSidebar('checklistinfo-sidenav')\"]";

    @ElementTitle(value = "Edit Face 2 Face Checklist")
    @FindBy(xpath = EditFace2FaceChecklistXPATH)
    private WebElement EditFace2FaceChecklist;


    public Face2FaceChecklistViewPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        WebDriverWait wait = new WebDriverWait(Environment.getDriverService().getDriver(),60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EditFace2FaceChecklistXPATH)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EditFace2FaceChecklistXPATH)));
        Waits.waitAndGetElements(EditFace2FaceChecklistXPATH, Waits.big_wait, Waits.pollingTime, true);
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
