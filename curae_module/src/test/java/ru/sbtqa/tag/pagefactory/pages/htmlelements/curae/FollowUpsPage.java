package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.environment.Environment;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "FollowUpsPage")
public class FollowUpsPage extends HTMLPage {

    @ElementTitle(value = "search icon")
    @FindBy(xpath = "//button[@ng-click=\"vm.searchFilter()\"]")
    private WebElement searchIcon;

    @ElementTitle(value = "search input")
    @FindBy(xpath = "//*[@id=\"inputField\"]")
    private WebElement searchInput;

    @ElementTitle(value = "first patient in list")
    @FindBy(xpath = "//md-list-item/div/button")
    private WebElement firstPatientInList;

    public FollowUpsPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

    @ActionTitle("search patient")
    public void searchPatient(String patientNumber) {
        WebElement searchIcon = Waits.waitAndGetElements("//button[@ng-click=\"vm.searchFilter()\"]", Waits.medium_wait, Waits.pollingTime, true).get(0);
        JavascriptExecutor js = Environment.getDriverService().getDriver();
        js.executeScript("arguments[0].click();", searchIcon);
        Waits.waitForPageToLoad();
        WebElement searchInput = Waits.waitAndGetElements("//*[@id=\"inputField\"]", Waits.medium_wait, Waits.pollingTime).get(0);
        searchInput.sendKeys(patientNumber);
        Waits.waitAndGetElements("//md-list-item/div/button", Waits.medium_wait, Waits.pollingTime, true).get(0);
        searchInput.sendKeys(Keys.ENTER);
        Waits.waitForPageToLoad();
    }

}
