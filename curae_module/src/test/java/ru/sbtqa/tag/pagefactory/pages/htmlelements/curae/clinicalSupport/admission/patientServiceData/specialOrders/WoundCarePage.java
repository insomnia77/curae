package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientServiceData.specialOrders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "WoundCarePage")
public class WoundCarePage extends HTMLPage {

    @ElementTitle(value = "pageBody")
    @FindBy(xpath = "//body")
    private WebElement pageBody;

    @ElementTitle(value = "Ordered")
    @FindBy(xpath = "//md-radio-group[@ng-model='vm.charts.wound.woundCareOrdered']/md-radio-button[@value=\"YES\"]")
    private WebElement Ordered;

    @ElementTitle(value = "Not Ordered")
    @FindBy(xpath = "//md-radio-group[@ng-model='vm.charts.wound.woundCareOrdered']/md-radio-button[@value=\"NO\"]")
    private WebElement NotOrdered;

    @ElementTitle(value = "Edit Wound Care")
    @FindBy(xpath = "//button[@ng-click=\"vm.openAdmissionSidebar('wound-sidenav')\"]")
    private WebElement EditWoundCare;

    @ElementTitle(value = "Pressure")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Pressure\"]")
    private WebElement Pressure;

    @ElementTitle(value = "Stasis")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Stasis\"]")
    private WebElement Stasis;

    @ElementTitle(value = "Arterial")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Arterial\"]")
    private WebElement Arterial;

    @ElementTitle(value = "Neuropathic")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Neuropathic\"]")
    private WebElement Neuropathic;

    @ElementTitle(value = "Surgical")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Surgical\"]")
    private WebElement Surgical;

    @ElementTitle(value = "Trauma")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Trauma\"]")
    private WebElement Trauma;

    @ElementTitle(value = "Diabetic")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Diabetic\"]")
    private WebElement Diabetic;

    @ElementTitle(value = "Unspecified Wound")
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Unspecified Wound\"]")
    private WebElement UnspecifiedWound;

    @ElementTitle(value = "Wound Care Orders In")
    @FindBy(xpath = "//md-select[@ng-model=\"vm.charts.wound.woundCareOrdersIn\"]")
    private WebElement WoundCareOrdersIn;

    @ElementTitle(value = "Refer to WOCN")
    @FindBy(xpath = "//md-select[@ng-model=\"vm.charts.wound.referToWOCNorWCC\"]")
    private WebElement RefertoWOCN;

    @ElementTitle(value = "Wound Vac Company")
    @FindBy(xpath = "//md-select[@ng-model=\"vm.charts.wound.woundVACCompany\"]")
    private WebElement woundVACCompany;

    @ElementTitle(value = "Wound Description")
    @FindBy(xpath = "//textarea[@ng-model=\"vm.charts.wound.woundDescription\"]")
    private WebElement WoundDescription;

    @ElementTitle(value = "UPDATE")
    @FindBy(xpath = "//button[@ng-click=\"vm.checkUpdate('woundcareForm' )\"]")
    private WebElement update;

    public WoundCarePage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
