package be.cegeka.core;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class TimeCheatPagina {

    public TimeCheatPagina() {
        pageIdentifier().shouldBe(visible);
    }

    protected void switchFocusToInnerIframe(String frameName) {
        $(By.tagName("body")).getWrappedDriver().switchTo().defaultContent();
        $(By.tagName("body")).getWrappedDriver().switchTo().frame(frameName);
    }

    protected void switchFocusToInnerIframeVoorMijnPersoneelsDossier(String frameName) {
        $(By.tagName("frameset")).getWrappedDriver().switchTo().defaultContent();
        $(By.tagName("frameset")).getWrappedDriver().switchTo().frame(frameName);
    }

    protected abstract SelenideElement pageIdentifier();
}
