package Step;

import Flow.GoogleFlow;
import Flow.SfxCalculatorFlow;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class GoogleStep {

    public GoogleFlow googleFlow = new GoogleFlow();

    @When("^navigate to google home page$")
    public void navigate_to_google_homepage() {
        googleFlow.navigateToGoogleHomePage();
    }

    @When("^input below text to search$")
    public void input_below_text_to_search(DataTable arg1) {
        List<Map<String, String>> maps = arg1.asMaps(String.class, String.class);
        googleFlow.inputSearchContent(maps.get(0).get("text"));

    }

    @When("^press enter to search$")
    public void press_enter_to_search() throws Throwable {
        googleFlow.pressEnterToSearch();

    }

    @Then("^can see the search result as below$")
    public void can_see_the_search_result_as_below(DataTable arg1) {
        List<Map<String, String>> maps = arg1.asMaps(String.class, String.class);
        googleFlow.validateSearchResult(maps.get(0).get("first message contains"));
    }

    @When("^customer click the first search result$")
    public void customer_click_the_first_search_result() {
        googleFlow.clickFirstSearchResult();
    }

    @Then("^can see the page navigate to link$")
    public void can_see_the_page_navigate_to_link(DataTable arg1) {
        List<Map<String, String>> maps = arg1.asMaps(String.class, String.class);
        googleFlow.validateNavigatedLink(maps.get(0).get("page title"));
    }

}
