package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.utils.Waits;

import static ru.sbtqa.tag.pagefactory.web.utils.Waits.Now;

@PageEntry(title = "LoginPage")
public class LoginPage extends HTMLPage {

    @ElementTitle(value = "User Name")
    @FindBy(xpath = "//*[@id='email']")
    private WebElement userName;

    @ElementTitle(value = "Password")
    @FindBy(xpath = "//*[@id='password']")
    private WebElement password;

    @ElementTitle(value = "Log in")
    @FindBy(xpath = "//button/span[text()='Log in']")
    private WebElement LogIn;

    public LoginPage() {
        long startTime = Now();
        Waits.waitForPageToLoad();
        Waits.addPageLoadTimeToAllure(startTime);
    }

    @ActionTitle("selects first item with home team")
    public void checksTickets(String HomeTeam) {
        Waits.waitAndGetElements("//table[@id='MainContent_ShoppingCartGridView']//td[text() = '"+HomeTeam+"']/parent::tr//input", Waits.medium_wait, Waits.pollingTime, true)
                .get(0).click();
    }
}
