package be.cegeka.core.peoplesoftfinance;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PeoplesoftFinanceProcessorTest {

    @Test
    public void test_process(){
        new PeoplesoftFinanceProcessor().process();
    }

    @Test
    public void getPeopleSoftFinanceFacturatieCategorieen_geeftAlleCategorieenTerug(){
        PeopleSoftFinanceFacturatieCategorieen peopleSoftFinanceFacturatieCategorieen = new PeoplesoftFinanceProcessor().getPeopleSoftFinanceFacturatieCategorieen();

        assertThat(peopleSoftFinanceFacturatieCategorieen.projectEnaActiviteitenCategorieen).hasSize(6);
        assertThat(peopleSoftFinanceFacturatieCategorieen.projectEnaActiviteitenCategorieen.get("Partnerbeheersysteem"))
                .containsOnly("Bugfixing", "Features", "Onderhoud", "Raakvlakken", "Technische projecten");
        assertThat(peopleSoftFinanceFacturatieCategorieen.projectEnaActiviteitenCategorieen.get("Team Services"))
                .containsOnly("Bedrijvenbank", "Onderhoud", "Partner platform", "Recommendations", "Stage databank (WELP)", "Takencomponent", "Technische projecten");
    }
}
