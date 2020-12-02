package ru.sbtqa.tag.pagefactory.web.utils;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbtqa.tag.pagefactory.environment.Environment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.logging.log4j.LogManager.getLogger;
import static ru.sbtqa.tag.pagefactory.web.drivers.WebDriverService.PROPERTIES;


public class Waits {
    public static double pollingTime = 0.5;
    public static double MinPollingTime = 0.1;
    public static int medium_wait = 10;
    public static int big_wait = 20;
    public static int maximum_wait = 60;
    public static int minimum_wait = 3;
    public static int med_wait = 3;
    public static int min_wait = 1;
    public static int huge_wait = 180;
    public static WebDriverWait wait = new WebDriverWait(Environment.getDriverService().getDriver(), medium_wait);
    private static long timeoutPeriod;
    private static long startTime;
    private static Logger log = getLogger();
    private static String NOT_FOUND_ELEMENT_ERROR_MESSAGE = "Error when getting elements. Check xpath for element";
    private static Long timeout = 100L;

    public static long Now() {
        return new Date().getTime();
    }

    public static void waitPollingTime(double pollingTime) {
        try {
            Thread.sleep((int) (pollingTime * 1000));
        } catch (InterruptedException interrupt) {
            log.error("problem with sleep flow" + interrupt);
        }
    }

    public static void waitForPageToLoad() {
        long startTime = Now();
        while (!((Now() - startTime) > 60000)) {
            JavascriptExecutor jsExec = Environment.getDriverService().getDriver();
            if (jsExec.executeScript("return document.readyState").equals("complete")) {
                break;
            }
            waitPollingTime(pollingTime);
        }
    }

    public static void addPageLoadTimeToAllure(long startTime) {
        long pageLoadTime = Now() - startTime;
        Allure.addAttachment("Time of page loading (ms): ", Long.toString(pageLoadTime));
    }


    public static void waitForPageToLoad(int sec) {
        long startTime = Now();
        while (!((Now() - startTime) > sec * 1000)) {
            JavascriptExecutor jsExec = Environment.getDriverService().getDriver();
            if (jsExec.executeScript("return document.readyState").equals("complete")) {
                break;
            }
            waitPollingTime(MinPollingTime);
        }
    }

    public static List<WebElement> waitAndGetRelativeElement(WebElement webElement, String relativeXPATH, int timeout, double pollingTime) {
        List<WebElement> elements = new ArrayList<>();
        long startTime = Now();
        while (((Now() - startTime) / 1000) < timeout) {
            try {
                elements = webElement.findElements(By.xpath(relativeXPATH));
            } catch (InvalidSelectorException e) {
                log.error(NOT_FOUND_ELEMENT_ERROR_MESSAGE);
                throw e;
            }
            if (!elements.isEmpty()) {
                return elements;
            }
            waitPollingTime(pollingTime);
        }
        return elements;
    }

    public static WebElement waitAndGetElement(By by) {
        List<WebElement> webElementList =
                waitAndGetElements(by, timeout, pollingTime, Environment.getDriverService().getDriver(), false);
        if (webElementList.size() != 1) {
            throw new Error("For locator: \"" + by + "\" elements amount is not correspond to waiting. Actual amount: " + webElementList.size());
        }
        return webElementList.get(0);
    }

    public static List<WebElement> waitAndGetElements(By by) {
        return waitAndGetElements(by, timeout, pollingTime, Environment.getDriverService().getDriver(), false);
    }

    /**
     * Waiting and getting of element
     *
     * @param by          locator of element
     * @param timeout     time of element waiting
     * @param pollingTime тtimeout of element verification
     * @return list of elements
     */
    public static List<WebElement> waitAndGetElements(By by, double timeout, double pollingTime) {
        return waitAndGetElements(by, timeout, pollingTime, Environment.getDriverService().getDriver(), false);
    }

    /**
     * Waiting and getting of element
     *
     * @param by               locator of element
     * @param timeout          time of element waiting
     * @param pollingTime      тtimeout of element verification
     * @param isFirstClickable
     * @return list of elements
     */
    public static List<WebElement> waitAndGetElements(By by, double timeout, double pollingTime, boolean isFirstClickable) {
        return waitAndGetElements(by, timeout, pollingTime, Environment.getDriverService().getDriver(), isFirstClickable);
    }

    /**
     * Waiting and getting of element
     *
     * @param by          locator of element
     * @param timeout     time of element waiting
     * @param pollingTime тtimeout of element verification
     * @param driver      WebDriver
     * @return list of elements
     */
    public static List<WebElement> waitAndGetElements(By by, double timeout, double pollingTime, WebDriver driver) {
        return waitAndGetElements(by, timeout, pollingTime, driver, false);
    }


    /**
     * Waiting and getting elements
     *
     * @param XPATH       locator of element as xPath
     * @param timeout     time of element waiting
     * @param pollingTime timeout of element verification
     * @return list of elements
     */
    public static List<WebElement> waitAndGetElements(String XPATH, double timeout, double pollingTime) {
        return waitAndGetElements(By.xpath(XPATH), timeout, pollingTime, Environment.getDriverService().getDriver(), false);
    }


    public static List<WebElement> waitAndGetElements(String XPATH, double timeout, double pollingTime, boolean isFirstClickable) {
        return waitAndGetElements(By.xpath(XPATH), timeout, pollingTime, Environment.getDriverService().getDriver(), isFirstClickable);
    }

    public static List<WebElement> waitAndGetElements(String XPATH, double timeout, double pollingTime, WebDriver driver) {
        return waitAndGetElements(By.xpath(XPATH), timeout, pollingTime, driver, false);
    }

    public static List<WebElement> waitAndGetElements(By by, double timeout, double pollingTime, WebDriver driver, boolean isFirstClickable) {
        List<WebElement> elements = new ArrayList<>();
        long startTime = Now();
        while (((Now() - startTime) / 1000) < timeout) {
            try {
                elements = driver.findElements(by);
            } catch (InvalidSelectorException e) {
                log.error(NOT_FOUND_ELEMENT_ERROR_MESSAGE);
                throw e;
            } catch (org.openqa.selenium.WebDriverException e2) {
                log.error("Problem with communication with driver - try again");
                elements = driver.findElements(by);
            }
            if (!elements.isEmpty()) {
                if (!isFirstClickable) {
                    return elements;
                } else if (isEnabled(elements.get(0))) {
                    return elements;
                }
            }
            waitPollingTime(pollingTime);
        }
        return elements;
    }


    public static List<WebElement> waitAndGetElementsWithFirstClickable(String XPATH, double timeout, double pollingTime) {
        List<WebElement> elements = new ArrayList<>();
        long startTime = Now();
        while (((Now() - startTime) / 1000) < timeout) {
            try {
                elements = Environment.getDriverService().getDriver().findElements(By.xpath(XPATH));
            } catch (InvalidSelectorException e) {
                log.error(NOT_FOUND_ELEMENT_ERROR_MESSAGE);
                throw e;
            }
            if ((!elements.isEmpty()) && (elements.get(0).isEnabled())) {
                return elements;
            }
            waitPollingTime(pollingTime);
        }
        return elements;
    }

    public static void waitNotElementsLite(String xpath, int timeout, double pollingTime, double startWaitForPresent) {
        long startTimeLite = Now();
        log.trace((Now() - startTimeLite));
        try {
            List<WebElement> elements = null;
            List<WebElement> invisibleElements = null;
            if (waitAndGetElements(xpath, startWaitForPresent, pollingTime).isEmpty()) {
                log.trace("elements " + xpath + " are not displayed");
                return;
            }
            log.trace("waiting of element disappearing :" +(Now() - startTimeLite));
            while (!(((Now() - startTimeLite) / 1000) > timeout)) {
                if((elements== null) || ((Now() - startTimeLite) / 1000> timeout))
                {
                    return;
                }
                waitPollingTime(pollingTime);
                elements = Environment.getDriverService().getDriver().findElements(By.xpath(xpath));
                log.trace("waiting of element disappearing :" + (Now() - startTimeLite));

                if((elements== null) || ((Now() - startTimeLite) / 1000> timeout))
                {
                    return;
                }
                invisibleElements = elements.stream().filter(elem -> !elem.isDisplayed()).collect(Collectors.toList());
                if (elements.isEmpty() || (elements.size() == invisibleElements.size())) {
                    break;
                }
                if((elements== null) || ((Now() - startTimeLite) / 1000> timeout))
                {
                    return;
                }
            }


            if (elements.isEmpty() || (elements.size() == invisibleElements.size())) {
                log.trace("elements " + xpath + " appeared and disappeared");
            } else {
                log.trace("elements " + xpath + " appeared and not disappeared");
            }
        } catch (org.openqa.selenium.StaleElementReferenceException stale) {
            log.error("Couldn't wait for an item to disappear due to a page change or the appearance of another item");
        }
    }

    public static void waitJSfinished() {
        try {
            InitTimeout(60000);
            while (!isTimedOut()) {
                JavascriptExecutor jsExec = Environment.getDriverService().getDriver();
                if (jsExec.executeScript("return window.requestCount").toString().equals("0")) {
                    break;
                }
            }
        } catch (NullPointerException e)
        {
            Waits.waitPollingTime(3);
            System.out.println("loading of loader and counter can't get - this effect during documents uploading");
            Allure.addAttachment("waitsjs", "didn't work - no counter");
        }
    }

    public static void waitJSfinishedIC() {
        try {
            InitTimeout(60000);
            while (!isTimedOut()) {
                JavascriptExecutor jsExec = Environment.getDriverService().getDriver();
                if (jsExec.executeScript("return window.$requestsCount").toString().equals("0")) {
                    break;
                }
            }
        } catch (NullPointerException e)
        {
            Waits.waitPollingTime(3);
            Allure.addAttachment("waitsjs", "didn't work - no counter");
        }
    }


    private static void InitTimeout(long delta) {
        timeoutPeriod = delta;
        startTime = Now();
    }

    private static boolean isTimedOut() {
        return (Now() - startTime) > timeoutPeriod;
    }

    private static boolean isEnabled(WebElement webElement) {
        boolean result;
        try {
            result = webElement.isDisplayed() && webElement.isEnabled();
        } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
            return false;
        }
        return result;
    }
}
