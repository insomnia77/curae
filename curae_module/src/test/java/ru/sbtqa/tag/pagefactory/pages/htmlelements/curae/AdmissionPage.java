package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "AdmissionPage")
public class AdmissionPage extends HTMLPage {

    @ElementTitle(value = "In Processing")
    @FindBy(xpath = "(//*[@role='tablist']//*[text()='In Processing'])[1]")
    private WebElement admission;

    @ElementTitle(value = "search button")
    @FindBy(xpath = "//button[@ng-click=\"vm.filterShow = false\"]")
    private WebElement searchButton;

    @ElementTitle(value = "search bar")
    @FindBy(xpath = "//input[@ng-model=\"vm.patientSearch\"]")
    private WebElement searchBar;

    public AdmissionPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
