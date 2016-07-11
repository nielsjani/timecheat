package be.cegeka.core;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;

public abstract class TimeCheatPagina {

    public TimeCheatPagina() {
//        pageIdentifier().shouldBe(visible);
    }

    protected abstract SelenideElement pageIdentifier();
}
