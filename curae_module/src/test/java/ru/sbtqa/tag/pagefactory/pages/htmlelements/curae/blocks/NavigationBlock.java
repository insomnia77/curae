package ru.sbtqa.tag.pagefactory.pages.htmlelements.curae.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = "//*[@id='toorbar']//parent::md-toolbar")
public class NavigationBlock extends HtmlElement {

    @ElementTitle("Home")
    @FindBy(xpath = ".//button/span[text()='Home']")
    private WebElement home;
}
