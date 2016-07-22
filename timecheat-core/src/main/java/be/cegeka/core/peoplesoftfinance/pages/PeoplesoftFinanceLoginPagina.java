package be.cegeka.core.peoplesoftfinance.pages;

import be.cegeka.core.TimeCheatPagina;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.className;

public class PeoplesoftFinanceLoginPagina extends TimeCheatPagina {

    @Override
    protected SelenideElement pageIdentifier() {
        return $(className("psloginbutton"));
    }

    public PeoplesoftFinanceLoginPagina vulCredentialsIn(String username, String password) {
        username().clear();
        username().sendKeys(username);
        password().clear();
        password().sendKeys(password);
        return this;
    }

    private SelenideElement password() {
        return $("#pwd");
    }

    private SelenideElement username() {
        return $("#userid");
    }

    public PeoplesoftFinanceStartPagina klikAanmelden() {
        $(By.className("psloginbutton")).click();
        return new PeoplesoftFinanceStartPagina();
    }
}
