package be.cegeka.core.mijnpersoneelsdossier.pages;

import be.cegeka.core.TimeCheatPagina;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MijnPersoneelsDossierLoginPagina extends TimeCheatPagina{

    @Override
    protected SelenideElement pageIdentifier() {
        return $("#footer");
    }

    public MijnPersoneelsDossierStartPagina login(String username, String password) {
        outerUsernameInput().clear();
        outerUsernameInput().sendKeys(username);
        outerPasswordInput().clear();
        outerPasswordInput().sendKeys(password);
        $("#loginbutton").click();
        switchFocusToInnerIframeVoorMijnPersoneelsDossier("frmeasyleft");
        $("#LoginScreen").waitUntil(visible, 5000);
        usernameInput().clear();
        usernameInput().sendKeys(username);
        passwordInput().clear();
        passwordInput().sendKeys(password);
        $("#ButOK").click();
        return new MijnPersoneelsDossierStartPagina();
    }

    private SelenideElement outerPasswordInput() {
        return $("#password");
    }

    private SelenideElement outerUsernameInput() {
        return $("#username");
    }

    private SelenideElement passwordInput() {
        return $("#LogPasw");
    }

    private SelenideElement usernameInput() {
        return $("#LogUser");
    }
}
