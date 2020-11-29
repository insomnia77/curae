package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientServiceData.physicianAndInsuranceInfo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.environment.Environment;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import java.util.List;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "PreAuthInfoPage")
public class PreAuthInfoPage extends HTMLPage {

    @ElementTitle(value = "Add Pre-Auth")
    @FindBy(xpath = "//button[@ng-click=\"vm.addPreAuthDialog()\"]")
    private WebElement addPreAuth;

    @ElementTitle(value = "UPDATE")
    @FindBy(xpath = "//md-sidenav[not(contains(@class, 'md-closed'))]//button[(contains(@ng-click, 'vm.addAuth()'))]")
    private WebElement update;

    public PreAuthInfoPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

    @ActionTitle("delete all disciplines")
    public void deleteAll() {
        Waits.waitForPageToLoad();
        List<WebElement> deletes = Waits.waitAndGetElements("//button[@aria-label='Delete']", Waits.big_wait, Waits.pollingTime, true);
        if (deletes.size() != 0) {
            Waits.waitForPageToLoad();
            JavascriptExecutor js = Environment.getDriverService().getDriver();
            removal(deletes, js);
            confirmation(js);
            deleteAll();
        }

    }

    private void confirmation(JavascriptExecutor js) {
        Waits.waitForPageToLoad();
        try {
            Waits.waitAndGetElements("//button[@aria-label='Confirm']", Waits.big_wait, Waits.pollingTime, true).get(0).click();
        } catch (org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.ElementClickInterceptedException | java.lang.IndexOutOfBoundsException e) {
            List<WebElement> confirmations = Waits.waitAndGetElements("//button[@aria-label='Confirm']", Waits.big_wait, Waits.pollingTime, true);
            if (confirmations.size() != 0) {
                js.executeScript("arguments[0].click();",confirmations.get(0));
            }
        }
        Waits.waitForPageToLoad();
        Waits.waitNotElementsLite("//button[@aria-label='Confirm']", Waits.big_wait, Waits.pollingTime, 1);
    }

    private void removal(List<WebElement> deletes, JavascriptExecutor js) {
        try {
            deletes.get(0).click();
        } catch (org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.ElementClickInterceptedException e)
        {
            deletes = Waits.waitAndGetElements("//button[@aria-label='Delete']", Waits.big_wait, Waits.pollingTime, true);
            if (deletes.size() != 0) {
                js.executeScript("arguments[0].click();", deletes.get(0));
            }
        }
    }

}
