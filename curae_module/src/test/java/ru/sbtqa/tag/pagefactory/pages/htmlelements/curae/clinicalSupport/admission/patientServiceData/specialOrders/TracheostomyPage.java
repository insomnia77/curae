package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientServiceData.specialOrders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "TracheostomyPage")
public class TracheostomyPage extends HTMLPage {

    @ElementTitle(value = "pageBody")
    @FindBy(xpath = "//body")
    private WebElement pageBody;

    @ElementTitle(value = "Ordered")
    @FindBy(xpath = "//md-radio-group[@ng-model='vm.charts.tracheostomy.tracheostomyOrdered']/md-radio-button[@value=\"YES\"]")
    private WebElement Ordered;

    @ElementTitle(value = "Not Ordered")
    @FindBy(xpath = "//md-radio-group[@ng-model='vm.charts.tracheostomy.tracheostomyOrdered']/md-radio-button[@value=\"NO\"]")
    private WebElement NotOrdered;

    @ElementTitle(value = "Edit Tracheostomy")
    @FindBy(xpath = "//button[@ng-click=\"vm.openAdmissionSidebar('tracheostomy-sidenav')\"]")
    private WebElement EditOstomy;

    @ElementTitle(value = "Date of Tracheostomy")
    @FindBy(xpath = "//md-datepicker[@ng-model=\"vm.charts.tracheostomy.date\"]//input")
    private WebElement DateofTracheostomy;

    @ElementTitle(value = "Size")
    @FindBy(xpath = "//input[@ng-model='vm.charts.tracheostomy.size']")
    private WebElement Size;

    @ElementTitle(value = "DME and Supply Company Name")
    @FindBy(xpath = "//input[@name='dmeAndSupplyCompanyName']")
    private WebElement DMEandSupplyCompanyName;

    @ElementTitle(value = "DME Contact Person")
    @FindBy(xpath = "//input[@name='dmeContactPerson']")
    private WebElement DMEContactPerson;

    @ElementTitle(value = "Supplies DME Contact Number")
    @FindBy(xpath = "//input[@name='suppliesDMEContactNumber']")
    private WebElement SuppliesDMEContactNumber;

    @ElementTitle(value = "Billing Clearance")
    @FindBy(xpath = "//md-select[@ng-model='vm.charts.tracheostomy.billingClearanceCompleted']")
    private WebElement BillingClearance;

    @ElementTitle(value = "Hospital Bed")
    @FindBy(xpath = "(//md-checkbox[@aria-label='Hospital Bed'])[2]")
    private WebElement HospitalBed;

    @ElementTitle(value = "Oxygen Concentrator")
    @FindBy(xpath = "//md-checkbox[@aria-label='Oxygen Concentrator']")
    private WebElement OxygenConcentrator;

    @ElementTitle(value = "Oxygen Tank")
    @FindBy(xpath = "//md-checkbox[@aria-label='Oxygen Tank']")
    private WebElement OxygenTank;

    @ElementTitle(value = "Trach Humidifier")
    @FindBy(xpath = "//md-checkbox[@aria-label='Trach Humidifier']")
    private WebElement TrachHumidifier;

    @ElementTitle(value = "Trach Collar")
    @FindBy(xpath = "//md-checkbox[@aria-label='Trach Collar']")
    private WebElement TrachCollar;

    @ElementTitle(value = "Corrugated Tubing")
    @FindBy(xpath = "//md-checkbox[@aria-label='Corrugated Tubing']")
    private WebElement CorrugatedTubing;

    @ElementTitle(value = "Distilled Water")
    @FindBy(xpath = "//md-checkbox[@aria-label='Distilled Water']")
    private WebElement DistilledWater;

    @ElementTitle(value = "Condensation Drain")
    @FindBy(xpath = "//md-checkbox[@aria-label='Condensation Drain']")
    private WebElement CondensationDrain;

    @ElementTitle(value = "Trach Dressing Kits")
    @FindBy(xpath = "//md-checkbox[@aria-label='Trach Dressing Kits']")
    private WebElement TrachDressingKits;

    @ElementTitle(value = "Drain Sponges")
    @FindBy(xpath = "//md-checkbox[@aria-label='Drain Sponges']")
    private WebElement DrainSponges;

    @ElementTitle(value = "Hydrogen Peroxide")
    @FindBy(xpath = "//md-checkbox[@aria-label='Hydrogen Peroxide']")
    private WebElement HydrogenPeroxide;

    @ElementTitle(value = "Normal Saline")
    @FindBy(xpath = "//md-checkbox[@aria-label='Normal Saline']")
    private WebElement NormalSaline;

    @ElementTitle(value = "Suction Machine")
    @FindBy(xpath = "//md-checkbox[@aria-label='Suction Machine']")
    private WebElement SuctionMachine;

    @ElementTitle(value = "Inline Suction")
    @FindBy(xpath = "//md-checkbox[@aria-label='Inline Suction']")
    private WebElement InlineSuction;

    @ElementTitle(value = "Suction Tip Kit")
    @FindBy(xpath = "//md-checkbox[@aria-label='Suction Tip Kit']")
    private WebElement SuctionTipKit;

    @ElementTitle(value = "UPDATE")
    @FindBy(xpath = "//button[@ng-click=\"vm.checkUpdate('TRACHEOSTOMYForm' )\"]")
    private WebElement update;

    public TracheostomyPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
