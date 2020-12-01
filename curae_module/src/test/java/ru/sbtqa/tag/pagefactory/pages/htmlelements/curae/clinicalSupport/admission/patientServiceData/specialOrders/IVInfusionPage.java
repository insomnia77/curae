package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientServiceData.specialOrders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "IVInfusionPage")
public class IVInfusionPage extends HTMLPage {

    @ElementTitle(value = "pageBody")
    @FindBy(xpath = "//body")
    private WebElement pageBody;

    @ElementTitle(value = "Ordered")
    @FindBy(xpath = "//md-radio-group[@ng-model='vm.charts.ivInfusion.ivInfusionordered']/md-radio-button[@value=\"YES\"]")
    private WebElement Ordered;

    @ElementTitle(value = "Not Ordered")
    @FindBy(xpath = "//md-radio-group[@ng-model='vm.charts.ivInfusion.ivInfusionordered']/md-radio-button[@value=\"NO\"]")
    private WebElement NotOrdered;

    @ElementTitle(value = "Edit IV Infusion")
    @FindBy(xpath = "//button[@ng-click=\"vm.openAdmissionSidebar('ivinfusion-sidenav')\" and @aria-label=\"Edit IV Infusion\"]")
    private WebElement EditIVInfusion;

    @ElementTitle(value = "Last Dose 1")
    @FindBy(xpath = "//md-datepicker[@ng-model=\"vm.charts.ivInfusion.medications[0].lastDoes\"]/div[1]/input")
    private WebElement LastDose1;

    @ElementTitle(value = "Medication Order 1")
    @FindBy(xpath = "//input[@ng-model=\"vm.charts.ivInfusion.medications[0].medication\"]")
    private WebElement MedicationOrder1;

    @ElementTitle(value = "Frequency and Duration Med 1")
    @FindBy(xpath = "//input[@ng-model=\"vm.charts.ivInfusion.medications[0].frequencyAndDuration\"]")
    private WebElement FrequencyandDurationMed1;

    @ElementTitle(value = "Last Dose 2")
    @FindBy(xpath = "//md-datepicker[@ng-model=\"vm.charts.ivInfusion.medications[1].lastDoes\"]/div[1]/input")
    private WebElement LastDose2;

    @ElementTitle(value = "Medication Order 2")
    @FindBy(xpath = "//input[@ng-model=\"vm.charts.ivInfusion.medications[1].medication\"]")
    private WebElement MedicationOrder2;

    @ElementTitle(value = "Frequency and Duration Med 2")
    @FindBy(xpath = "//input[@ng-model=\"vm.charts.ivInfusion.medications[1].frequencyAndDuration\"]")
    private WebElement FrequencyandDurationMed2;

    @ElementTitle(value = "None")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"None\"]")
    private WebElement None;

    @ElementTitle(value = "PICC Line")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"PICC Line\"]")
    private WebElement PICCLine;

    @ElementTitle(value = "Mid Line")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Mid Line\"]")
    private WebElement MidLine;

    @ElementTitle(value = "Extra Jugular")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Extra Jugular\"]")
    private WebElement ExtraJugular;

    @ElementTitle(value = "Intra Jugular")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Intra Jugular\"]")
    private WebElement IntraJugular;

    @ElementTitle(value = "Subclavian Line")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Subclavian Line\"]")
    private WebElement SubclavianLine;

    @ElementTitle(value = "Peripheral Line")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Peripheral Line\"]")
    private WebElement PeripheralLine;

    @ElementTitle(value = "X-Ray Confirmation")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"X-Ray Confirmation\"]")
    private WebElement XRayConfirmation;

    @ElementTitle(value = "Fluroscopy Report")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Fluroscopy Report\"]")
    private WebElement FluroscopyReport;

    @ElementTitle(value = "Line Insertion Information")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Line Insertion Information\"]")
    private WebElement LineInsertionInformation;

    @ElementTitle(value = "Gravity")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Gravity\"]")
    private WebElement Gravity;

    @ElementTitle(value = "Dial Flow")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Dial Flow\"]")
    private WebElement DialFlow;

    @ElementTitle(value = "Elastomeric Bulb")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Elastomeric Bulb\"]")
    private WebElement ElastomericBulb;

    @ElementTitle(value = "IV Pump")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"IV Pump\"]")
    private WebElement IVPump;

    @ElementTitle(value = "IV Push")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"IV Push\"]")
    private WebElement IVPush;

    @ElementTitle(value = "Infusion Pharmacy")
    @FindBy(xpath = "//md-select[@ng-model=\"vm.charts.ivInfusion.infusionPharmacy\"]")
    private WebElement InfusionPharmacy;

    @ElementTitle(value = "Delivery of Supplies Information")
    @FindBy(xpath = "//input[@ng-model=\"vm.charts.ivInfusion.deliveryOfSupplyInformaiton\"]")
    private WebElement DeliveryofSuppliesInformation;

    @ElementTitle(value = "UPDATE")
    @FindBy(xpath = "//md-sidenav[not(contains(@class, 'md-closed'))]//button[@ng-click=\"vm.checkUpdate('ivInfusionForm' )\"]")
    private WebElement update;

    public IVInfusionPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
