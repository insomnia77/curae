package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientServiceData.physicianAndInsuranceInfo;

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

@PageEntry(title = "NewAuthPage")
public class NewAuthPage extends HTMLPage {
private final String addXPATH = "//button[@ng-click=\"vm.addApprove()\"]";

    @ElementTitle(value = "Discipline")
    @FindBy(xpath = "//md-select[@ng-model=\"vm.item.discipline\"]")
    private WebElement Discipline;

    @ElementTitle(value = "Approved:")
    @FindBy(xpath = "//input[@ng-model=\"vm.item.approved\"]")
    private WebElement approved;

    @ElementTitle(value = "ADD")
    @FindBy(xpath = addXPATH)
    private WebElement add;

    public NewAuthPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        WebDriverWait wait = new WebDriverWait(Environment.getDriverService().getDriver(),30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addXPATH)));
        Waits.waitAndGetElements(addXPATH, Waits.big_wait, Waits.pollingTime);
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
