package be.cegeka.core.mijnpersoneelsdossier.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;

public class MijnPersoneelsDossierPriktijdenOverzichtPagina extends MijnPersoneelsDossierIngelogdPagina {

    @Override
    protected SelenideElement pageIdentifier() {
        return $("#DecOvRegTit");
    }

    public List<Werkdag> getPriktijden() {
        return $("#TabDetail").$$("tr").stream()
                .map(this::mapRow)
                .filter(werkdag -> werkdag != null)
                .collect(Collectors.toList());
    }

    private Werkdag mapRow(SelenideElement row) {
        String datum = row.$("#DecOvRegDatum").getText();
        if(datum == null || datum.equals("")  ||datum.equals("Weektotaal")){
            return null;
        }
        String timeWorked = isFeestdag(row) ? "0:00" : row.$("#DecOvRegTotaal").getText();
        return new Werkdag(datum, timeWorked);
    }

    private boolean isFeestdag(SelenideElement row) {
        return row.$("#DecOvRegType").getText().contains("Feestdag");
    }
}
