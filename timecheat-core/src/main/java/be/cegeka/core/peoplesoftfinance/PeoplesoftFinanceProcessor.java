package be.cegeka.core.peoplesoftfinance;

import be.cegeka.core.configuration.SelenideConfiguration;
import be.cegeka.core.peoplesoftfinance.pages.PeoplesoftFinanceLoginPagina;
import be.cegeka.core.peoplesoftfinance.pages.PeoplesoftFinanceWeekUrenInvullenPagina;
import com.codeborne.selenide.Selenide;

import java.util.List;
import java.util.Map;

import static be.cegeka.core.peoplesoftfinance.PeopleSoftFinanceFacturatieCategorieen.peopleSoftFinanceFacturatieCategorieen;
import static com.google.common.collect.Maps.newHashMap;

public class PeoplesoftFinanceProcessor {

    //TODO: betere oplossing mogelijk?
    private int magicIframeCounter = 1;

    //TODO: Uren per week meegeven
    //TODO: Iets voorzien voor weken die in 2 maanden vallen
    public PeoplesoftFinanceProcessor(){
        SelenideConfiguration.configure();
    }

    public void process() {
        gaNaarUrenInvullenVoorWeek()
                .openProjectPopup()
                .kiesProject("Partnerbeheersysteem")
                .openActiviteitPopup()
                .kiesActiviteit("Features")
                .vulMaandagIn("8.13")
                .vulDinsdagIn("7.89")
                .vulWoensdagIn("8.20")
                .vulDonderdagIn("9")
                .vulVrijdagIn("6.67")
                .klikTotalenBijwerken()
        //TODO: uncomment when doing this 4 realz
//                .klikOpslaanVoorLater()
        ;
    }

    public PeopleSoftFinanceFacturatieCategorieen getPeopleSoftFinanceFacturatieCategorieen(){
        Map<String, List<String>> activiteitenVoorProjecten = newHashMap();
        List<String> projectOpties = gaNaarUrenInvullenVoorWeek()
                .openProjectPopup()
                .getProjectOptiesEnSluitProjectPopup();
        PeoplesoftFinanceWeekUrenInvullenPagina urenInvullenPagina = new PeoplesoftFinanceWeekUrenInvullenPagina();
        projectOpties.forEach(projectOptie -> {
            activiteitenVoorProjecten.put(projectOptie, urenInvullenPagina.getActiviteitenVoorProjectoptie(projectOptie, magicIframeCounter));
            this.magicIframeCounter+=2;
        });

        return peopleSoftFinanceFacturatieCategorieen()
                .withProjectEnActiviteitenCategorieen(activiteitenVoorProjecten);
    }

    private PeoplesoftFinanceWeekUrenInvullenPagina gaNaarUrenInvullenVoorWeek() {
        return openStartPagina()
                //TODO: vul hier uw credentials in
                .vulCredentialsIn("NJANI", "")
                .klikAanmelden()
                .navigeerNaarCentrumProjectmedewerkers()
                .klikUrenformulierMakenWijzigen()
                .klikNieuweWaardeToevoegen()
                //TODO: niet hardcoden. OPGELET AMERIKAANSE NOTATIE, BECAUSE OF COURSE IT IS!
                .vulEinddatumPeriodeIn("07/08/2016")
                .klikToev()
                .klikDoorgaan();
    }

    private PeoplesoftFinanceLoginPagina openStartPagina() {
        Selenide.open(startUrl());
        return new PeoplesoftFinanceLoginPagina();
    }

    public String startUrl() {
        return "http://fin.vdab.be/psp/prdfin/?cmd=login&languageCd=DUT";
    }
}
