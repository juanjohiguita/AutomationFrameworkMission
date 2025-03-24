package core.utils;

import core.pages.basePage.BaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Locale;

public abstract class ElementFetch {

    public WebElement getWebElement(String identifierType, String identifierValue) {
        switch (identifierType.toUpperCase(Locale.ROOT)) {
            case "xpath":
                return BaseScreen.getDriver().findElement(By.xpath(identifierValue));
            case "css":
                return BaseScreen.getDriver().findElement(By.cssSelector(identifierValue));
            case "id":
                return BaseScreen.getDriver().findElement(By.id(identifierValue));
            case "name":
                return BaseScreen.getDriver().findElement(By.name(identifierValue));
            case "tagname":
                return BaseScreen.getDriver().findElement(By.tagName(identifierValue));
            case "classname":
                return BaseScreen.getDriver().findElement(By.className(identifierValue));
            case "linkText":
                return BaseScreen.getDriver().findElement(By.linkText(identifierValue));
            case "partialLinkText":
                return BaseScreen.getDriver().findElement(By.partialLinkText(identifierValue));
            default:
                return null;
        }
    }

    public List<WebElement> getWebElements(String identifierType, String identifierValue) {
        switch (identifierType.toUpperCase(Locale.ROOT)) {
            case "xpath":
                return BaseScreen.getDriver().findElements(By.xpath(identifierValue));
            case "css":
                return BaseScreen.getDriver().findElements(By.cssSelector(identifierValue));
            case "id":
                return BaseScreen.getDriver().findElements(By.id(identifierValue));
            case "name":
                return BaseScreen.getDriver().findElements(By.name(identifierValue));
            case "tagname":
                return BaseScreen.getDriver().findElements(By.tagName(identifierValue));
            case "classname":
                return BaseScreen.getDriver().findElements(By.className(identifierValue));
            case "linkText":
                return BaseScreen.getDriver().findElements(By.linkText(identifierValue));
            case "partialLinkText":
                return BaseScreen.getDriver().findElements(By.partialLinkText(identifierValue));
            default:
                return null;
        }
    }
}
