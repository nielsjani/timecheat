package be.cegeka.core.peoplesoftfinance;

import be.cegeka.core.configuration.SelenideConfigurationRule;
import be.cegeka.core.peoplesoftfinance.PeoplesoftFinanceProcessor;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;

public class PeoplesoftFinanceTest {

    @Rule
    public RuleChain chain = RuleChain
            .outerRule(new SelenideConfigurationRule())
            .around(ScreenShooter.failedTests().to("target/screenshots/"));

    @Test
    public void test(){
        new PeoplesoftFinanceProcessor().process();
    }
}
