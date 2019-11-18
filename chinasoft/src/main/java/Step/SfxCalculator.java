package Step;

import Flow.SfxCalculatorFlow;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SfxCalculator {


    public SfxCalculatorFlow sfxCalculatorFlow= new SfxCalculatorFlow();

    @When("^navigate to sfx-calculator page$")
    public void navigate_to_sfx_calculator_page() {
        sfxCalculatorFlow.navigateToCalculatorPage();
    }

    @When("^input value to initial deposit amount filed as below$")
    public void input_value_to_initial_deposit_amount_filed_as_below(DataTable arg1) throws Throwable {
        List<Map<String, String>> maps = arg1.asMaps(String.class, String.class);
        this.sfxCalculatorFlow.inputAmount(maps.get(0).get("initial deposit amount"));

    }

    @Then("^customer can see the info as below$")
    public void customer_can_see_the_info_as_below(DataTable arg1) throws Throwable {
        List<Map<String, String>> maps = arg1.asMaps(String.class, String.class);
        this.sfxCalculatorFlow.validateInitialAmountInfo(maps.get(0).get("tip message"), maps.get(0).get("input amount"));
    }


}
