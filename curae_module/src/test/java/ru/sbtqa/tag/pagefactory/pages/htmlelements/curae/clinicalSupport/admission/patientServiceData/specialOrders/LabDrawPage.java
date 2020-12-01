package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientServiceData.specialOrders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "LabDrawPage")
public class LabDrawPage extends HTMLPage {

    @ElementTitle(value = "pageBody")
    @FindBy(xpath = "//body")
    private WebElement pageBody;

    @ElementTitle(value = "Ordered")
    @FindBy(xpath = "//md-radio-group[@ng-model='vm.charts.labDraw.labDrawOrdered']/md-radio-button[@value=\"YES\"]")
    private WebElement Ordered;

    @ElementTitle(value = "Not Ordered")
    @FindBy(xpath = "//md-radio-group[@ng-model='vm.charts.labDraw.labDrawOrdered']/md-radio-button[@value=\"NO\"]")
    private WebElement NotOrdered;

    @ElementTitle(value = "Edit Lab Draw")
    @FindBy(xpath = "//button[@ng-click=\"vm.openAdmissionSidebar('labDraw-sidenav')\"]")
    private WebElement EditLabDraw;

    @ElementTitle(value = "PT/INR")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"PT/INR\"]")
    private WebElement PTINR;

    @ElementTitle(value = "BMP")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"BMP\"]")
    private WebElement BMP;

    @ElementTitle(value = "CMP")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"CMP\"]")
    private WebElement CMP;

    @ElementTitle(value = "CBC")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"CBC\"]")
    private WebElement CBC;

    @ElementTitle(value = "H&H")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"H&H\"]")
    private WebElement HandH;

    @ElementTitle(value = "ESR")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"ESR\"]")
    private WebElement ESR;

    @ElementTitle(value = "CRP")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"CRP\"]")
    private WebElement CRP;

    @ElementTitle(value = "HA1C")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"HA1C\"]")
    private WebElement HA1C;

    @ElementTitle(value = "UA")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"UA\"]")
    private WebElement UA;

    @ElementTitle(value = "C&S")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"C&S\"]")
    private WebElement CandS;

    @ElementTitle(value = "Others")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Others\"]")
    private WebElement Others;

    @ElementTitle(value = "Special Instructions")
    @FindBy(xpath = "//textarea[@ng-model=\"vm.charts.labDraw.specialInstructions\"]")
    private WebElement SpecialInstructions;

    @ElementTitle(value = "UPDATE")
    @FindBy(xpath = "//md-sidenav[not(contains(@class, 'md-closed'))]//button[(contains(@ng-click, 'labDrawForm'))]")
    private WebElement update;

    public LabDrawPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
