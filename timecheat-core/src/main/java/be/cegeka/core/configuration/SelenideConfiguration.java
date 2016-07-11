package be.cegeka.core.configuration;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.WebDriverRunner.CHROME;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;
import static org.springframework.util.SystemPropertyUtils.resolvePlaceholders;

public class SelenideConfiguration {

    public static final int SELENIDE_TIMEOUT = 10000;

    public static void configure() {
        Configuration.browser = CHROME;
        System.setProperty("selenide.browser", CHROME);
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation());
        WebDriverRunner.getAndCheckWebDriver().manage().window().maximize();

        Configuration.timeout = SELENIDE_TIMEOUT;
        Configuration.collectionsTimeout = SELENIDE_TIMEOUT;
    }

    private static String chromeDriverLocation() {
        return ofNullable(System.getenv("webdriver.chrome.driver"))
            .orElse(chromeDriverDirectory() + chromeDriverExecutable());
    }

    private static String chromeDriverDirectory() {
        return resolvePlaceholders("${java.io.tmpdir}/chromedriver/");
    }

    private static String chromeDriverExecutable() {
        if(onLinux32Bit()){
            return "chromedriver-linux";
        } else if(onLinux64Bit()){
            return "chromedriver-linux64";
        } else if(onMac()){
            return "chromedriver-mac";
        } else {
            return "chromedriver.exe";
        }
    }

    private static boolean onMac() {
        String os = System.getProperty("os.name");
        return containsIgnoreCase(os, "mac");
    }

    private static boolean onLinux32Bit() {
        String os = System.getProperty("os.name");
        String sunArchDataModel = System.getProperty("sun.arch.data.model");
        return containsIgnoreCase(os, "nux") && sunArchDataModel.equals("32");
    }

    private static boolean onLinux64Bit() {
        String os = System.getProperty("os.name");
        String sunArchDataModel = System.getProperty("sun.arch.data.model");
        return containsIgnoreCase(os, "nux") && sunArchDataModel.equals("64");
    }
}
