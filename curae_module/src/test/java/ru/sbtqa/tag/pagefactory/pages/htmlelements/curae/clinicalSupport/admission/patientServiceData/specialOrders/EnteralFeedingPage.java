package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientServiceData.specialOrders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "EnteralFeedingPage")
public class EnteralFeedingPage extends HTMLPage {

    @ElementTitle(value = "pageBody")
    @FindBy(xpath = "//body")
    private WebElement pageBody;

    @ElementTitle(value = "Ordered")
    @FindBy(xpath = "//md-radio-group[@ng-model='vm.charts.tubeFeeding.enternalFeedingOrdered']/md-radio-button[@value=\"YES\"]")
    private WebElement Ordered;

    @ElementTitle(value = "Not Ordered")
    @FindBy(xpath = "//md-radio-group[@ng-model='vm.charts.tubeFeeding.enternalFeedingOrdered']/md-radio-button[@value=\"NO\"]")
    private WebElement NotOrdered;

    @ElementTitle(value = "Edit Enteral Feeding")
    @FindBy(xpath = "//button[@ng-click=\"vm.openAdmissionSidebar('enteralfeeding-sidenav')\"]")
    private WebElement EditEnteralFeeding;

    @ElementTitle(value = "NG Tube")
    @FindBy(xpath = "//md-radio-button[@aria-label=\"NG Tube\"]")
    private WebElement NGTube;

    @ElementTitle(value = "J Tube")
    @FindBy(xpath = "//md-radio-button[@aria-label=\"J Tube\"]")
    private WebElement JTube;

    @ElementTitle(value = "G Tube")
    @FindBy(xpath = "//md-radio-button[@aria-label=\"G Tube\"]")
    private WebElement GTube;

    @ElementTitle(value = "Formula Change")
    @FindBy(xpath = "//md-checkbox[@ng-model=\"vm.charts.tubeFeeding.formula.value\"]")
    private WebElement FormulaChange;

    @ElementTitle(value = "Detail")
    @FindBy(xpath = "//input[@ng-model=\"vm.charts.tubeFeeding.formula.detail\"]")
    private WebElement Detail;

    @ElementTitle(value = "Bolus")
    @FindBy(xpath = "//md-checkbox[@ng-model=\"vm.charts.tubeFeeding.bolus.value\"]")
    private WebElement Bolus;

    @ElementTitle(value = "cc")
    @FindBy(xpath = "//input[@ng-model=\"vm.charts.tubeFeeding.bolus.cc\"]")
    private WebElement cc;

    @ElementTitle(value = "hours")
    @FindBy(xpath = "//input[@ng-model=\"vm.charts.tubeFeeding.bolus.duration\"]")
    private WebElement hours;

    @ElementTitle(value = "Continuous @")
    @FindBy(xpath = "//md-checkbox[@ng-model=\"vm.charts.tubeFeeding.continuous.value\"]")
    private WebElement Continuous;

    @ElementTitle(value = "cc/hours")
    @FindBy(xpath = "//input[@ng-model=\"vm.charts.tubeFeeding.continuous.cc\"]")
    private WebElement ccORhours;

    @ElementTitle(value = "type")
    @FindBy(xpath = "//md-select[@ng-model=\"vm.charts.tubeFeeding.continuous.type\"]")
    private WebElement type;

    @ElementTitle(value = "UPDATE")
    @FindBy(xpath = "//button[@ng-click=\"vm.checkUpdate('tubeFeedingForm' )\"]")
    private WebElement update;

    public EnteralFeedingPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
