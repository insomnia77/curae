package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.clinicalSupport.admission.patientServiceData.specialOrders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "OstomyPage")
public class OstomyPage extends HTMLPage {

    @ElementTitle(value = "pageBody")
    @FindBy(xpath = "//body")
    private WebElement pageBody;

    @ElementTitle(value = "Ordered")
    @FindBy(xpath = "//md-radio-group[@ng-model='vm.charts.ostomy.ostomyOrdered']/md-radio-button[@value=\"YES\"]")
    private WebElement Ordered;

    @ElementTitle(value = "Not Ordered")
    @FindBy(xpath = "//md-radio-group[@ng-model='vm.charts.ostomy.ostomyOrdered']/md-radio-button[@value=\"NO\"]")
    private WebElement NotOrdered;

    @ElementTitle(value = "Edit Ostomy")
    @FindBy(xpath = "//button[@ng-click=\"vm.openAdmissionSidebar('ostomy-sidenav')\"]")
    private WebElement EditOstomy;

    @ElementTitle(value = "Colostomy")
    @FindBy(xpath = "//md-radio-button[@aria-label=\"Colostomy\"]")
    private WebElement Colostomy;

    @ElementTitle(value = "Ileostomy")
    @FindBy(xpath = "//md-radio-button[@aria-label=\"Ileostomy\"]")
    private WebElement Ileostomy;

    @ElementTitle(value = "Urostomy")
    @FindBy(xpath = "//md-radio-button[@aria-label=\"Urostomy\"]")
    private WebElement Urostomy;

    @ElementTitle(value = "Stoma : Red")
    @FindBy(xpath = "//md-checkbox[@ng-model=\"vm.charts.ostomy.stomaAppearance.red\"]")
    private WebElement StomaRed;

    @ElementTitle(value = "Stoma : Pink")
    @FindBy(xpath = "//md-checkbox[@ng-model=\"vm.charts.ostomy.stomaAppearance.pink\"]")
    private WebElement StomaPink;

    @ElementTitle(value = "Stoma : Moist")
    @FindBy(xpath = "//md-checkbox[@ng-model=\"vm.charts.ostomy.stomaAppearance.moist\"]")
    private WebElement StomaMoist;

    @ElementTitle(value = "Stoma : Dry")
    @FindBy(xpath = "//md-checkbox[@ng-model=\"vm.charts.ostomy.stomaAppearance.dry\"]")
    private WebElement StomaDry;

    @ElementTitle(value = "Stoma : Pale")
    @FindBy(xpath = "//md-checkbox[@ng-model=\"vm.charts.ostomy.stomaAppearance.pale\"]")
    private WebElement StomaPale;

    @ElementTitle(value = "Stoma : Swollen")
    @FindBy(xpath = "//md-checkbox[@ng-model=\"vm.charts.ostomy.stomaAppearance.swollen\"]")
    private WebElement StomaSwollen;

    @ElementTitle(value = "Skin : Intact")
    @FindBy(xpath = "//md-checkbox[@ng-model=\"vm.charts.ostomy.surroundingSkin.intact\"]")
    private WebElement SkinIntact;

    @ElementTitle(value = "Skin : Red")
    @FindBy(xpath = "//md-checkbox[@ng-model=\"vm.charts.ostomy.surroundingSkin.red\"]")
    private WebElement SkinRed;

    @ElementTitle(value = "Skin : Pale")
    @FindBy(xpath = "//md-checkbox[@ng-model=\"vm.charts.ostomy.surroundingSkin.pale\"]")
    private WebElement SkinPale;

    @ElementTitle(value = "Skin : Swollen")
    @FindBy(xpath = "//md-checkbox[@ng-model=\"vm.charts.ostomy.surroundingSkin.swollen\"]")
    private WebElement SkinSwollen;

    @ElementTitle(value = "Skin : Dry")
    @FindBy(xpath = "//md-checkbox[@ng-model=\"vm.charts.ostomy.surroundingSkin.dry\"]")
    private WebElement SkinDry;

    @ElementTitle(value = "Skin : Mecerated")
    @FindBy(xpath = "//md-checkbox[@ng-model=\"vm.charts.ostomy.surroundingSkin.macerated\"]")
    private WebElement SkinMecerated;

    @ElementTitle(value = "Stool Consistence : Soft")
    @FindBy(xpath = "//md-radio-button[@aria-label=\"Soft\"]")
    private WebElement StoolConsistenceSoft;

    @ElementTitle(value = "Stool Appearance : Yellowish")
    @FindBy(xpath = "//md-radio-button[@aria-label=\"Yellowish\"]")
    private WebElement StoolAppearanceYellowish;

    @ElementTitle(value = "UPDATE")
    @FindBy(xpath = "//button[@ng-click=\"vm.checkUpdate('ostomyform' )\"]")
    private WebElement update;

    public OstomyPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

}
