package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "HomePage")
public class HomePage extends HTMLPage {

    @ElementTitle(value = "Account Management")
    @FindBy(xpath = "//button[@aria-label=\"Account Management\"]")
    private WebElement accountManagement;

    @ElementTitle(value = "Compliance & Quality")
    @FindBy(xpath = "//button[@ng-click=\"vm.go(entry.state)\" and @aria-label=\"Compliance & Quality\"]")
    private WebElement complianceQuality;

    @ElementTitle(value = "Administration")
    @FindBy(xpath = "//button[@ng-click=\"vm.go(entry.state)\" and @aria-label=\"Administration\"]")
    private WebElement Administration;

    public HomePage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.waitNotElementsLite("//md-progress-circular[@role='progressbar']", Waits.big_wait, Waits.MinPollingTime, 1);
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
