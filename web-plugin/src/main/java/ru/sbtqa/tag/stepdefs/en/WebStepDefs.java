package ru.sbtqa.tag.stepdefs.en;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Когда;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import ru.sbtqa.tag.pagefactory.context.PageContext;
import ru.sbtqa.tag.pagefactory.environment.Environment;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;
import ru.sbtqa.tag.pagefactory.exceptions.WaitException;
import ru.sbtqa.tag.pagefactory.web.junit.WebSetupSteps;
import ru.sbtqa.tag.pagefactory.web.junit.WebSteps;

public class WebStepDefs {

    private final WebSteps webSteps = WebSteps.getInstance();

    @Before(order = 1)
    public void initWeb() {
        WebSetupSteps.initWeb();
    }

    @After(order = 9999)
    public void disposeWeb() {
        WebSetupSteps.disposeWeb();
    }

    @And("^copy of the page is being opened in a new tab$")
    public void openCopyPage() {
        webSteps.openCopyPage();
    }

    @And("^user switches to the next tab$")
    public void switchesToNextTab() {
        webSteps.switchesToNextTab();
    }

    @And("^URL matches \"([^\"]*)\"$")
    public void urlMatches(String url) {
        webSteps.urlMatches(url);
    }

    @And("^user closes the current window and returns to \"([^\"]*)\"$")
    public void closingCurrentWin(String title) {
        webSteps.closingCurrentWin(title);
    }


    @And("^user push back in the browser$")
    public void backPage() {
        webSteps.backPage();
    }

    @And("^user navigates to url \"([^\"]*)\"$")
    public void goToUrl(String url) {
        webSteps.goToUrl(url);
    }

    @And("^user refreshes the page$")
    public void reInitPage() {
        webSteps.reInitPage();
    }


    @And("^user checks that text \"([^\"]*)\" appears on the page$")
    public void checkTextAppears(String text) throws WaitException, InterruptedException {
        webSteps.checkTextAppears(text);
    }

    @And("^user checks that text \"([^\"]*)\" is absent on the page$")
    public void checkTextIsNotPresent(String text) throws InterruptedException {
        webSteps.checkTextIsNotPresent(text);
    }

    @And("^user checks that modal window with text \"([^\"]*)\" is appears$")
    public void checkModalWindowAppears(String text) throws WaitException {
        webSteps.checkModalWindowAppears(text);
    }

    @And("^user checks that element with text \"([^\"]*)\" is present$")
    @When("^user checks that the text \"([^\"]*)\" is visible$")
    public void checkElementWithTextIsPresent(String text) {
        webSteps.checkElementWithTextIsPresent(text);
    }

    @When("^user stores the value of the field \"([^\"]*)\" in the variable \"([^\"]*)\"$")
    public void putElementValueInStash(String elementName, String variableName) throws PageException {
        webSteps.putElementValueInStash(elementName, variableName);
    }

    @When("^user waits \"([^\"]*)\" seconds$")
    public void waiting(String sec) {
        if (sec != "0") {
            try {
                Thread.sleep((int) (Double.valueOf(sec) * 1000));
            } catch (InterruptedException interrupt) {
                System.out.println("проблема со sleep потока" + interrupt);
            }
        }
    }

    @When("^user executes \"([^\"]*)\" script$")
    public void executeScript(String script) {
        JavascriptExecutor jsExec = Environment.getDriverService().getDriver();
        jsExec.executeScript(script);
    }

    @When("^user scrolls to element \"([^\"]*)\"$")
    public void userScrollsToElement(String elementName) throws PageException {
        WebElement element = Environment.getFindUtils().getElementByTitle(PageContext.getCurrentPage(), elementName);
        JavascriptExecutor js = (JavascriptExecutor) Environment.getDriverService().getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    @When("^user scrolls page down$")
    public void scrollDown() {
        JavascriptExecutor js = Environment.getDriverService().getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @When("^user scrolls page up$")
    public void scrollUp(){
        JavascriptExecutor js = Environment.getDriverService().getDriver();
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }

    @When("^breakpoint$")
    public void breakp() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException interrupt) {
            System.out.println("problem with sleep flow" + interrupt);
        }
    }
}
