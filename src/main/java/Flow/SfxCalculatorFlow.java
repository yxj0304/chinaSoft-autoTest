package Flow;

import Pages.SfxCalculatorPage;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SfxCalculatorFlow {


    public SfxCalculatorPage sfxCalculatorPage = new SfxCalculatorPage();

    public void navigateToCalculatorPage() {
        this.sfxCalculatorPage.navigateToCalculatorPage();
    }


    public void inputAmount(String value) {
        this.sfxCalculatorPage.inputAmount(value);
    }

    public void validateInitialAmountInfo(String tip_message, String input_amount) {
        Assert.assertEquals(tip_message, getInitialAmountTipMessage());
        Assert.assertEquals(input_amount, getInitialAmountValue());
    }

    private String getInitialAmountValue() {
        return this.sfxCalculatorPage.getInitialTipAmountValue();
    }

    public String getInitialAmountTipMessage() {
        return this.sfxCalculatorPage.getInitialTipMessage();
    }
}
