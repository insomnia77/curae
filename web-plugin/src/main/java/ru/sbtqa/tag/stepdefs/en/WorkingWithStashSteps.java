package ru.sbtqa.tag.stepdefs.en;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sbtqa.tag.datajack.Stash;
import ru.sbtqa.tag.pagefactory.context.PageContext;
import ru.sbtqa.tag.pagefactory.environment.Environment;
import ru.sbtqa.tag.pagefactory.exceptions.AllureNonCriticalError;
import ru.sbtqa.tag.qautils.errors.AutotestError;

import java.util.List;

public class WorkingWithStashSteps {

    private static final Logger LOG = LoggerFactory.getLogger(WorkingWithStashSteps.class);

    @Given("^failed step$")
    public void fail() {
        throw new AutotestError("It's error");
    }

    @Given("^test non critical user error$")
    public void fail_non_critical() {
        throw new AllureNonCriticalError("It's non critical error");
    }

    @Given("^stores the value \"([^\"]*)\" in a variable \"([^\"]*)\"$")
    public void putInStash(String value, String key) {
       if(!value.equals("не изменяем предыдущее запомненное значение")) {
           Stash.put(key, value);
       }
    }

    @Then("^check action list parameters \\((.*?)\\)$")
    public void checkAction(String action, List<String> list) throws NoSuchMethodException {
        Environment.getReflection().executeMethodByTitle(PageContext.getCurrentPage(), action, list);
    }

    @Then("^check step list parameters$")
    public void checkStep(List<String> elementName) {
        LOG.info("Check is correct!");
    }
}
