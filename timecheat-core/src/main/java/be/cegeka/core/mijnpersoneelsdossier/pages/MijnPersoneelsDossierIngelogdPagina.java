package be.cegeka.core.mijnpersoneelsdossier.pages;

import be.cegeka.core.TimeCheatPagina;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public abstract class MijnPersoneelsDossierIngelogdPagina<S extends MijnPersoneelsDossierIngelogdPagina<S>> extends TimeCheatPagina{

    public MijnPersoneelsDossierPriktijdenOverzichtPagina navigeerNaarPriktijdenOverzichtVoorMaand(String maand){
        $(By.className("MenUit01")).click();
        $(By.className("MenAan02")).click();
        $(By.className("MenAan03")).click();
        $("#MenItem021104012008").click();
        $(By.tagName("body")).getWrappedDriver().switchTo().parentFrame();
        $(By.tagName("frameset")).getWrappedDriver().switchTo().frame("frmeasyright");
        $(By.name("DecOvRegMaand")).selectOption(maand);
        $(By.className("pushbutton_footer")).click();
        return new MijnPersoneelsDossierPriktijdenOverzichtPagina();
    }

}
