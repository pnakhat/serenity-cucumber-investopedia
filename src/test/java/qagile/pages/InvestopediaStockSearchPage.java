package qagile.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class InvestopediaStockSearchPage extends PageObject {

    public static final By searchField = By.cssSelector(".market-search__input");
    private static final By displayedName =  By.cssSelector(".tv-symbol-header__first-line");;
    private static final By stockPrice = By.cssSelector(".tv-symbol-price-quote__value");;
    public static final By acceptCookie = By.id("onetrust-accept-btn-handler");

    @Step("Open page")
    public void launch() {
        openUrl("https://www.investopedia.com/markets/quote");
        clickOn(find(acceptCookie));
    }


    @Step("look for stock {0}")
    public void searchForStock(String stock) {
        typeInto(find(searchField), stock);
        find(searchField).sendKeys(Keys.RETURN);
    }

    @Step("find the stock name is")
    public String getDisplayedStockName() {
        switchToSymbolFrame();
        return find(displayedName).getText();
    }

    @Step("Get Stock price")
    public double getStockPrice() {
        switchToSymbolFrame();
        return Double.parseDouble(find(stockPrice).getText());
    }

    private void switchToSymbolFrame() {
        WebElement frame = find(By.cssSelector("#tradingview-symbol-info_1-0 > div > iframe"));
        getDriver().switchTo().frame(frame);
    }
}
