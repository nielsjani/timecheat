package be.cegeka.core;

import be.cegeka.core.configuration.SelenideConfiguration;

public abstract class TimeCheatProcessor {

    private String startUrl;

    public TimeCheatProcessor(String startUrl) {
        this.startUrl = startUrl;
        SelenideConfiguration.configure();
    }

    public String getStartUrl() {
        return startUrl;
    }

    public abstract void process();
}
