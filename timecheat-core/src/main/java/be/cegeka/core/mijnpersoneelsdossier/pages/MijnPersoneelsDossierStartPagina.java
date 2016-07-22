package be.cegeka.core.mijnpersoneelsdossier.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MijnPersoneelsDossierStartPagina extends MijnPersoneelsDossierIngelogdPagina{
    @Override
    protected SelenideElement pageIdentifier() {
        return $(By.className("bomen"));
    }
}
