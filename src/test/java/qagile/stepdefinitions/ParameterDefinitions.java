package qagile.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import qagile.domain.Stocks;

public class ParameterDefinitions {

    @ParameterType(".*")
    public Stocks stock(String stockName) {
        return Stocks.valueOf(stockName);
    }

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
}
