package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "ComplianceAndQualityPage")
public class ComplianceAndQualityPage extends HTMLPage {

    @ElementTitle(value = "Follow Ups")
    @FindBy(xpath = "//button[@ng-click=\"vm.go(entry.state)\" and @aria-label=\"Follow Ups\"]")
    private WebElement followUps;


    public ComplianceAndQualityPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
