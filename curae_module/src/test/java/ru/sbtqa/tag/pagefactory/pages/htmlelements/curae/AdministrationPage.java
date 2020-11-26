package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae;

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

@PageEntry(title = "AdministrationPage")
public class AdministrationPage extends HTMLPage {
    private final String clinicalSupportXpath = "//button[@aria-label=\"Clinical Support\" and @ng-click=\"vm.go(entry.state)\"]";


    @ElementTitle(value = "Clinical Support")
    @FindBy(xpath = clinicalSupportXpath)
    private WebElement clinicalSupport;


    public AdministrationPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
        WebDriverWait wait = new WebDriverWait(Environment.getDriverService().getDriver(),30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clinicalSupportXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(clinicalSupportXpath)));
    }

}
