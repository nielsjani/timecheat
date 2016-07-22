package be.cegeka.core.mijnpersoneelsdossier;

import be.cegeka.core.TimeCheatProcessor;
import be.cegeka.core.configuration.Credentials;
import be.cegeka.core.mijnpersoneelsdossier.pages.MijnPersoneelsDossierLoginPagina;
import be.cegeka.core.mijnpersoneelsdossier.pages.Werkdag;
import com.codeborne.selenide.Selenide;

import java.util.List;

import static be.cegeka.core.configuration.Credentials.PASSWORD;
import static be.cegeka.core.configuration.Credentials.USERNAME;

public class MijnPersoneelsDossierProcessor extends TimeCheatProcessor {

    public MijnPersoneelsDossierProcessor() {
        super("https://mijnpersoneelsdossier.vdab.be/");
    }

    @Override
    public void process() {
        openStartPagina()
                .login(USERNAME, PASSWORD)
        //TODO: IE driver nodig om te kunnen navigeren naar rapport
        ;
    }

    public List<Werkdag> getRapport() {
        return openStartPagina()
                .login(USERNAME, PASSWORD)
                //TODO: Ook jaar kunnen meegeven
                .navigeerNaarPriktijdenOverzichtVoorMaand("Juli")
                .getPriktijden()
        ;
    }

    private MijnPersoneelsDossierLoginPagina openStartPagina() {
        Selenide.open(getStartUrl());
        return new MijnPersoneelsDossierLoginPagina();
    }
}
