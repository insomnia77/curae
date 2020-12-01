package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientServiceData.specialOrders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "UrinaryDevicePage")
public class UrinaryDevicePage extends HTMLPage {

    @ElementTitle(value = "pageBody")
    @FindBy(xpath = "//body")
    private WebElement pageBody;

    @ElementTitle(value = "Ordered")
    @FindBy(xpath = "//md-radio-group[@ng-model='vm.charts.foleyCatheter.foleyCatheterOrdered']/md-radio-button[@value=\"YES\"]")
    private WebElement Ordered;

    @ElementTitle(value = "Not Ordered")
    @FindBy(xpath = "//md-radio-group[@ng-model='vm.charts.foleyCatheter.foleyCatheterOrdered']/md-radio-button[@value=\"NO\"]")
    private WebElement NotOrdered;

    @ElementTitle(value = "Edit Urinary Device")
    @FindBy(xpath = "//button[@ng-click=\"vm.openAdmissionSidebar('foleyCatheter-sidenav')\"]")
    private WebElement EditUrinaryDevice;

    @ElementTitle(value = "Type")
    @FindBy(xpath = "//md-select[@ng-model=\"vm.charts.foleyCatheter.catheterType\"]")
    private WebElement Type;

    @ElementTitle(value = "Last Change Date")
    @FindBy(xpath = "//md-datepicker[@ng-model=\"vm.charts.foleyCatheter.lastChange\"]/div[1]/input")
    private WebElement LastChangeDate;

    @ElementTitle(value = "Size")
    @FindBy(xpath = "//input[@ng-model=\"vm.charts.foleyCatheter.size\"]")
    private WebElement Size;

    @ElementTitle(value = "Frequency")
    @FindBy(xpath = "//input[@ng-model=\"vm.charts.foleyCatheter.frequency\"]")
    private WebElement Frequency;

    @ElementTitle(value = "UPDATE")
    @FindBy(xpath = "//md-sidenav[not(contains(@class, 'md-closed'))]//button[(contains(@ng-click, 'foleyCatheterForm'))]")
    private WebElement update;

    public UrinaryDevicePage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
