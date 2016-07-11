package be.cegeka.core.peoplesoftfinance;

import com.codeborne.selenide.Selenide;

public class PeoplesoftFinanceProcessor {

    public void process() {
        openStartPagina()
                //TODO: vul hier uw credentials in
            .vulCredentialsIn("NJANI", "")
            .klikAanmelden()
            .navigeerNaarCentrumProjectmedewerkers()
            .klikUrenformulierMakenWijzigen()
            .klikNieuweWaardeToevoegen()
                //TODO: niet hardcoden
            .vulEinddatumPeriodeIn("08/07/2016")
            .klikToev()
            .klikDoorgaan()
            .openProjectPopup()
            .kiesProject("Partnerbeheersysteem");
    }

    private PeoplesoftFinanceLoginPagina openStartPagina() {
        Selenide.open(startUrl());
        return new PeoplesoftFinanceLoginPagina();
    }

    public String startUrl() {
        return "http://fin.vdab.be/psp/prdfin/?cmd=login&languageCd=DUT";
    }
}
