package be.cegeka.core.peoplesoftfinance;

import be.cegeka.core.TimeCheatPagina;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PeoplesoftFinanceCentrumProjectmedewerkersPagina extends TimeCheatPagina{


    @Override
    protected SelenideElement pageIdentifier() {
        switchFocusToInnerIframe("ptifrmtgtframe");
        return $$(By.className("EOPP_SCADDITIONALTEXT")).get(3).shouldHave(text("Actuele urengegevens en urenprogno"));
    }

    public PeoplesoftFinanceCentrumProjectmedewerkersPagina klikUrenformulierMakenWijzigen() {
        switchFocusToInnerIframe("ptifrmtgtframe");
        $(By.partialLinkText("Urenformulier maken/wijzigen")).click();
        return this;
    }

    public PeoplesoftFinanceCentrumProjectmedewerkersPagina klikNieuweWaardeToevoegen() {
        switchFocusToInnerIframe("ptifrmtgtframe");
        $$(By.className("PSHYPERLINK")).last().click();
        return this;
    }

    public PeoplesoftFinanceCentrumProjectmedewerkersPagina vulEinddatumPeriodeIn(String datum) {
        datumInput().clear();
        datumInput().sendKeys(datum);
        return this;
    }

    public PeoplesoftFinanceWeekUrenInvullenPagina klikToev() {
        $(By.name("#ICSearch")).click();
        return new PeoplesoftFinanceWeekUrenInvullenPagina();
    }

    private SelenideElement datumInput() {
        return $("#EX_TIME_ADD_VW_PERIOD_END_DT");
    }
}
