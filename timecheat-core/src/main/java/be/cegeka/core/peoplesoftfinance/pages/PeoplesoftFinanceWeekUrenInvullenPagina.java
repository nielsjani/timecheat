package be.cegeka.core.peoplesoftfinance.pages;


import be.cegeka.core.TimeCheatPagina;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;

public class PeoplesoftFinanceWeekUrenInvullenPagina extends TimeCheatPagina {

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
        switchFocusToInnerIframe("ptModFrame_0");
        return this;
    }

    public PeoplesoftFinanceWeekUrenInvullenPagina openProjectPopupNaarFrame(String frameId) {
        $(By.id("PROJECT_DESC$prompt$0")).click();
        switchFocusToInnerIframe(frameId);
//        $(By.tagName("iframe"));
        return this;
    }

    public PeoplesoftFinanceWeekUrenInvullenPagina kiesProject(String naam) {
        $(By.linkText(naam)).click();
        switchFocusToInnerIframe("ptifrmtgtframe");
        return this;
    }

    public PeoplesoftFinanceWeekUrenInvullenPagina openActiviteitPopup() {
        $(By.id("ACTIVITY_DESC$prompt$0")).click();
        switchFocusToInnerIframe("ptModFrame_1");
        return this;
    }

    public PeoplesoftFinanceWeekUrenInvullenPagina openActiviteitPopupNaarFrame(String frameId) {
        $(By.id("ACTIVITY_DESC$prompt$0")).click();
        switchFocusToInnerIframe(frameId);
        return this;
    }

    public PeoplesoftFinanceWeekUrenInvullenPagina kiesActiviteit(String naam) {
        $(By.linkText(naam)).click();
        switchFocusToInnerIframe("ptifrmtgtframe");
        return this;
    }

    public PeoplesoftFinanceWeekUrenInvullenPagina vulMaandagIn(String uren) {
        maandag().clear();
        maandag().sendKeys(uren);
        return this;
    }

    public PeoplesoftFinanceWeekUrenInvullenPagina vulDinsdagIn(String uren) {
        dinsdag().clear();
        dinsdag().sendKeys(uren);
        return this;
    }

    public PeoplesoftFinanceWeekUrenInvullenPagina vulWoensdagIn(String uren) {
        woensdag().clear();
        woensdag().sendKeys(uren);
        return this;
    }

    public PeoplesoftFinanceWeekUrenInvullenPagina vulDonderdagIn(String uren) {
        donderdag().clear();
        donderdag().sendKeys(uren);
        return this;
    }

    public PeoplesoftFinanceWeekUrenInvullenPagina vulVrijdagIn(String uren) {
        vrijdag().clear();
        vrijdag().sendKeys(uren);
        return this;
    }

    public PeoplesoftFinanceWeekUrenInvullenPagina klikTotalenBijwerken() {
        $("#EX_ICLIENT_WRK_PB_UPDATE").click();
        return this;
    }

    public PeoplesoftFinanceWeekUrenInvullenPagina klikOpslaanVoorLater() {
        $("#EX_ICLIENT_WRK_SAVE_PB").click();
        //TODO: automatisch bericht wegklikken als totaal week > 40
        return this;
    }

    private SelenideElement maandag() {
        return $(By.id("TIME3$0"));
    }

    private SelenideElement dinsdag() {
        return $(By.id("TIME4$0"));
    }

    private SelenideElement woensdag() {
        return $(By.id("TIME5$0"));
    }

    private SelenideElement donderdag() {
        return $(By.id("TIME6$0"));
    }

    private SelenideElement vrijdag() {
        return $(By.id("TIME7$0"));
    }

    public PeoplesoftFinanceWeekUrenInvullenPagina sluitProjectPopup() {
        $(By.id("#ICCancel")).click();
        switchFocusToInnerIframe("ptifrmtgtframe");
        return this;
    }

    public List<String> getProjectOptiesEnSluitProjectPopup(){
        ElementsCollection optiesTabel = $("#PTSRCHRESULTS").$("tbody").$$("tr");
        List<String> opties = optiesTabel.stream()
                .map(this::getOptie)
                .filter(optie -> optie != null)
                .collect(Collectors.toList());
        sluitProjectPopup();
        return opties;
    }

    private String getOptie(SelenideElement element) {
        if(element.$$("td").size() == 0){
            return null;
        }
        return element.$$("td").get(0).$("a").getText();
    }

    public List<String> getActiviteitenVoorProjectoptie(String projectOptie, int magicIframeCounter) {
        return openProjectPopupNaarFrame("ptModFrame_"+magicIframeCounter)
                .kiesProject(projectOptie)
                .openActiviteitPopupNaarFrame("ptModFrame_"+(magicIframeCounter+1))
                .getActiviteitOpties()
                ;
    }

    private List<String> getActiviteitOpties() {
        return getProjectOptiesEnSluitProjectPopup();
    }
}
