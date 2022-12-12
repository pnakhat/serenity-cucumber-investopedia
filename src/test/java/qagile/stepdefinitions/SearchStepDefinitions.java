package qagile.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import qagile.domain.Stocks;
import qagile.pages.InvestopediaStockSearchPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class SearchStepDefinitions {

    @Steps
    private InvestopediaStockSearchPage stockSearchPage;

    private Stocks stock;

    @Given("I open the investopedia home page")
    public void i_do_something() throws InterruptedException {
        stockSearchPage.launch();
    }


    @When("I search for {stock}")
    public void iSearchFor(Stocks stock) {
        this.stock = stock;
        stockSearchPage.searchForStock(stock.getStockCode());
    }

    @Then("I verify correct stock is loaded")
    public void i_verify_correct_stock_is_loaded() {
        assertEquals(stockSearchPage.getDisplayedStockName(), stock.getStockName());
    }


    @Then("I verify stock price doesn't breach the defined value")
    public void i_verify_stock_price() {
        if (stockSearchPage.getStockPrice() > stock.getBasePrice()) {
            fail("Stock price is below " + stock.getBasePrice());
        }
    }


}


