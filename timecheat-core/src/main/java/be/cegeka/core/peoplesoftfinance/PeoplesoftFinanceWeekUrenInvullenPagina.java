package be.cegeka.core.peoplesoftfinance;


import be.cegeka.core.TimeCheatPagina;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PeoplesoftFinanceWeekUrenInvullenPagina extends TimeCheatPagina{
    @Override
    protected SelenideElement pageIdentifier() {
        return $(By.className("PAPAGETITLE"));
    }

    public PeoplesoftFinanceWeekUrenInvullenPagina klikDoorgaan() {
        $("#EX_ICLIENT_WRK_OK_PB").click();
        return this;
    }

    public PeoplesoftFinanceWeekUrenInvullenPagina openProjectPopup() {
        $(By.id("PROJECT_DESC$prompt$0")).click();
        return this;
    }

    public PeoplesoftFinanceWeekUrenInvullenPagina kiesProject(String naam) {
        switchFocusToInnerIframe("ptModFrame_0");
        $(By.linkText(naam)).click();
        return this;
    }
}
