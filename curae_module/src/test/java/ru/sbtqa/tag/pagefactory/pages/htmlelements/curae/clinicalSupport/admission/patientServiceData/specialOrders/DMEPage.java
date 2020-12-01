package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientServiceData.specialOrders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "DMEPage")
public class DMEPage extends HTMLPage {

    @ElementTitle(value = "pageBody")
    @FindBy(xpath = "//body")
    private WebElement pageBody;

    @ElementTitle(value = "Ordered")
    @FindBy(xpath = "//md-radio-group[@ng-model='vm.charts.dme.dmeOrdered']/md-radio-button[@value=\"YES\"]")
    private WebElement Ordered;

    @ElementTitle(value = "Not Ordered")
    @FindBy(xpath = "//md-radio-group[@ng-model='vm.charts.dme.dmeOrdered']/md-radio-button[@value=\"NO\"]")
    private WebElement NotOrdered;

    @ElementTitle(value = "Edit DME")
    @FindBy(xpath = "//button[@ng-click=\"vm.openAdmissionSidebar('dme-sidenav')\"]")
    private WebElement EditDME;

    @ElementTitle(value = "Cane")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Cane\"]")
    private WebElement Cane;

    @ElementTitle(value = "Font Wheel Walker")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Front Wheel Walker\"]")
    private WebElement FontWheelWalker;

    @ElementTitle(value = "Four Wheel Walker")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Four Wheel Walker\"]")
    private WebElement FourWheelWalker;

    @ElementTitle(value = "Crutches")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Crutches\"]")
    private WebElement Crutches;

    @ElementTitle(value = "Bedside Commode")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Bedside Commode\"]")
    private WebElement BedsideCommode;

    @ElementTitle(value = "Shower Chair")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Shower Chair\"]")
    private WebElement ShowerChair;

    @ElementTitle(value = "Tub/Transfer Bench")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Tub/Transfer Bench\"]")
    private WebElement TubTransferBench;

    @ElementTitle(value = "Wheelchair")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Wheelchair\"]")
    private WebElement Wheelchair;

    @ElementTitle(value = "Hospital Bed")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Hospital Bed\"]")
    private WebElement HospitalBed;

    @ElementTitle(value = "Wheelchair Cushion")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Wheelchair Cushion\"]")
    private WebElement WheelchairCushion;

    @ElementTitle(value = "Trapeze")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Trapeze\"]")
    private WebElement Trapeze;

    @ElementTitle(value = "Elevated Toilet Seat")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Elevated Toilet Seat\"]")
    private WebElement ElevatedToiletSeat;

    @ElementTitle(value = "Grab Bars")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Grab Bars\"]")
    private WebElement GrabBars;

    @ElementTitle(value = "Nebulizer")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Nebulizer\"]")
    private WebElement Nebulizer;

    @ElementTitle(value = "Oxygen")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Oxygen\"]")
    private WebElement Oxygen;

    @ElementTitle(value = "Hoyer Lift")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Hoyer Lift\"]")
    private WebElement HoyerLift;

    @ElementTitle(value = "Others")
    @FindBy(xpath = "//textarea[@ng-model=\"vm.charts.dme.available.other\"]")
    private WebElement Others;

    @ElementTitle(value = "UPDATE")
    @FindBy(xpath = "//md-sidenav[not(contains(@class, 'md-closed'))]//button[@ng-click=\"vm.checkUpdate('dmeForm' )\"]")
    private WebElement update;

    public DMEPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
