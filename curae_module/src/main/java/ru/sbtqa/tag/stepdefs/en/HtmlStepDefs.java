package ru.sbtqa.tag.stepdefs.en;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.context.PageContext;
import ru.sbtqa.tag.pagefactory.environment.Environment;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;
import ru.sbtqa.tag.pagefactory.find.HtmlFindUtils;
import ru.sbtqa.tag.pagefactory.html.junit.HtmlSetupSteps;
import ru.sbtqa.tag.pagefactory.html.junit.HtmlSteps;
import ru.sbtqa.tag.pagefactory.web.utils.Converter;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import java.util.List;
import java.util.stream.Collectors;

import static ru.sbtqa.tag.pagefactory.web.utils.ElementUtils.getWebElementValue;

public class HtmlStepDefs {

    private final HtmlSteps htmlSteps = HtmlSteps.getInstance();

    @Before(order = 2)
    public void initHtml() {
        HtmlSetupSteps.initHtml();
    }

    @And("^user in block \"([^\"]*)\" \\(([^)]*)\\)$")
    public void actionInBlock(String block, String action) throws NoSuchMethodException {
        htmlSteps.actionInBlock(block, action);
    }

    @And("^user in block \"([^\"]*)\" \\(([^)]*)\\) with the parameters of table$")
    public void actionInBlock(String block, String action, Object dataTable) throws NoSuchMethodException {
        htmlSteps.actionInBlock(block, action, dataTable);
    }

    @And("^user in block \"([^\"]*)\" \\(([^)]*)\\) with a parameter \"([^\"]*)\"$")
    public void actionInBlock(String block, String action, String param) throws NoSuchMethodException {
        htmlSteps.actionInBlock(block, action, param);
    }

    @And("^user in block \"([^\"]*)\" \\(([^)]*)\\) with the parameters \"([^\"]*)\" \"([^\"]*)\"$")
    public void actionInBlock(String block, String action, String param1, String param2) throws NoSuchMethodException {
        htmlSteps.actionInBlock(block, action, param1, param2);
    }

    @And("^user in list \"([^\"]*)\" finds the value element \"([^\"]*)\"$")
    public void find(String listTitle, String value) throws PageException {
        htmlSteps.find(listTitle, value);
    }

    @And("^user clicks element via javascript \"([^\"]*)\"$")
    public void JavaScriptClick(String elementName) throws PageException {
        Page currentPage = PageContext.getCurrentPage();
        WebElement element = ((HtmlFindUtils) Environment.getFindUtils()).find(elementName, false);
        JavascriptExecutor js = Environment.getDriverService().getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    @And("^user trying to click element via javascript \"([^\"]*)\"$")
    public void tryJavaScriptClick(String elementName) throws PageException {
        try {
            WebElement element = ((HtmlFindUtils) Environment.getFindUtils()).find(elementName, false);
            JavascriptExecutor js = Environment.getDriverService().getDriver();
            js.executeScript("arguments[0].click();", element);
            System.out.println("C помощью JavaScript удалось сделать клик на " + elementName);
        } catch (Exception e) {
            System.out.println("C помощью JavaScript не удалось сделать клик на " + elementName);
        }
    }

    @And("^user trying to click element \"([^\"]*)\"$")
    public void tryClick(String elementName) throws PageException {
        try {
            WebElement element = ((HtmlFindUtils) Environment.getFindUtils()).find(elementName, true);
            WebDriver webDriver = Environment.getDriverService().getDriver();
            Actions builder = new Actions(webDriver);
            builder.moveToElement(element).perform();
            element.click();
            System.out.println("удалось сделать клик на " + elementName);
        } catch (Exception e) {
            System.out.println("не удалось сделать клик на " + elementName);
        }
    }

    @And("^user clears field \"([^\"]*)\"$")
    public void clear(String elementName) throws PageException {
        WebElement element = ((HtmlFindUtils) Environment.getFindUtils()).find(elementName, true);
        element.clear();
        Waits.waitForPageToLoad();
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.BACK_SPACE);
        JavascriptExecutor jsExec = Environment.getDriverService().getDriver();
        jsExec.executeScript("arguments[0].setAttribute('value', '')", element);
        Waits.waitForPageToLoad();
        element.clear();
    }


    @When("^user fills the field via javascript \"([^\"]*)\"(?: with value)?$")
    @And("^user fills the field via javascript \"([^\"]*)\" (?:with value )?\"([^\"]*)\"$")
    public void setValueJavascript(String elementTitle, String value) throws Exception {
        if (!value.equals("~не заполняется")) {
            Converter converter = new Converter();
            WebElement webElement = ((HtmlFindUtils) Environment.getFindUtils()).find(elementTitle);
            try {
                Waits.wait.until(ExpectedConditions.elementToBeClickable(webElement));
                webElement.click();
            } catch (Exception e) {
                System.out.println("Во время заполнения не удалось сделать клик на элемент с названием " + elementTitle);
            }
            JavascriptExecutor executor = Environment.getDriverService().getDriver();
            executor.executeScript("arguments[0].value='" + converter.transform(value) + "'", webElement);
            Waits.wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            webElement.sendKeys(converter.transform(value));
        }
    }

    @When("^user fills the telephone only javascript \"([^\"]*)\"(?: with value)?$")
    @And("^user fills the telephone only javascript \"([^\"]*)\" (?:with value )?\"([^\"]*)\"$")
    public void setValueFullJavascript(String elementTitle, String value) throws PageException {
        if (!value.equals("~не заполняется")) {
            Converter converter = new Converter();
            WebDriver webDriver = Environment.getDriverService().getDriver();
            WebElement webElement = ((HtmlFindUtils) Environment.getFindUtils()).find(elementTitle);
            Waits.wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            Waits.waitPollingTime(3);
            Waits.wait.until(ExpectedConditions.elementToBeClickable(webElement));
            Actions actions = new Actions(webDriver);
            value = converter.transform(value);
            for (int i = 0; i < value.length(); i++) {
                Waits.waitPollingTime(0.5);
                String sendVal = String.valueOf(value.charAt(i));
                actions.sendKeys(webElement, sendVal).release().perform();
                Waits.waitPollingTime(0.5);
                actions.sendKeys(webElement, Keys.ARROW_RIGHT).release().perform();
            }

            Waits.waitPollingTime(3);
        }
    }


    @And("^user checks in the element \"([^\"]*)\" number value \"([^\"]*)\"$")
    public void checkValueIsEqual(String elementTitle, String text) throws PageException {
        WebElement webElement = ((HtmlFindUtils) Environment.getFindUtils()).find(elementTitle);
        Waits.wait.until(ExpectedConditions.visibilityOf(webElement));
        String value = getWebElementValue(webElement);
        System.out.println("текущее значение в элементе = " + value);
        Assert.assertEquals(value.replaceAll("[^0-9-]", ""), text.replaceAll("[^0-9-]", ""));
    }


    @And("^user clicks element via javascript111 \"([^\"]*)\"$")
    public void JavaScriptClic1k(String elementName) throws PageException {
        WebElement element = ((HtmlFindUtils) Environment.getFindUtils()).find(elementName, false);
        JavascriptExecutor js = Environment.getDriverService().getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    @And("^user selects in dropdown \"([^\"]*)\" the value \"([^\"]*)\"$")
    public void select(String elementTitle, String option) throws PageException { WebElement element = ((HtmlFindUtils) Environment.getFindUtils()).find(elementTitle, true);
        element.click();
        Waits.waitForPageToLoad();
        JavascriptExecutor js = Environment.getDriverService().getDriver();
        try {
            Waits.waitAndGetElements("((//md-option/div[text()='" + option + "'])[last()] | (//span[text()='" + option + "']/parent::div/parent::md-option)[last()])[last()]", Waits.medium_wait, Waits.pollingTime, true).get(0).click();
        } catch (org.openqa.selenium.ElementNotInteractableException e) {
            System.out.println("Not Interactable dropdown, trying again");
            WebElement dropDown = Waits.waitAndGetElements("(//md-option/div[text()='" + option + "'])[last()] | (//span[text()='" + option + "']/parent::div/parent::md-option)[last()]", Waits.medium_wait, Waits.pollingTime, true).get(0);
            js.executeScript("arguments[0].click();", dropDown);
        }
        Waits.waitNotElementsLite("(//md-option/div[text()='" + option + "'])[last()] | (//span[text()='" + option + "']/parent::div/parent::md-option)[last()]", Waits.medium_wait, Waits.pollingTime, Waits.pollingTime);
        Waits.waitForPageToLoad();
    }

    @And("^user fill in autocomplete \"([^\"]*)\" the value \"([^\"]*)\" and select option \"([^\"]*)\"$")
    public void selectAutocomplete(String elementTitle, String value, String option) throws PageException {
        WebElement element = ((HtmlFindUtils) Environment.getFindUtils()).find(elementTitle, true);
        element.clear();
        element.click();
        element.sendKeys(value);
        element.sendKeys(Keys.ENTER);
        Waits.waitForPageToLoad();
        List<WebElement> options = Waits.waitAndGetElements("//li/md-autocomplete-parent-scope", Waits.medium_wait, Waits.pollingTime, true);
        WebElement optionElement = options.stream().filter(w -> w.getText().equals(option))
                .collect(Collectors.toList()).get(0);
        optionElement.click();
        Waits.waitNotElementsLite("//li/md-autocomplete-parent-scope", Waits.medium_wait, Waits.pollingTime, Waits.pollingTime);
    }

}
