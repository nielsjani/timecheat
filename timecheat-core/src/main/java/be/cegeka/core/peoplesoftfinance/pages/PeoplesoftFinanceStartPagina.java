package be.cegeka.core.peoplesoftfinance.pages;

import be.cegeka.core.TimeCheatPagina;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PeoplesoftFinanceStartPagina extends TimeCheatPagina {

    @Override
    protected SelenideElement pageIdentifier() {
        return $("#ptpgltlbl_PT_MENU_NEW_FEATURES");
    }

    public PeoplesoftFinanceCentrumProjectmedewerkersPagina navigeerNaarCentrumProjectmedewerkers() {
        hoofdMenuMenuItem().click();
        selfServiceWerknemerMenuItem().click();
        centrumProjectmedewerkersMenuItem().get(0).click();
        return new PeoplesoftFinanceCentrumProjectmedewerkersPagina();
    }

    private SelenideElement selfServiceWerknemerMenuItem() {
        return $("#fldra_CO_EMPLOYEE_SELF_SERVICE");
    }

    private SelenideElement hoofdMenuMenuItem() {
        return $("#pthnavbca_PORTAL_ROOT_OBJECT");
    }

    private ElementsCollection centrumProjectmedewerkersMenuItem() {
        return $("#crefli_EP_SC_SP_EMPLOYEE_PROJECT_CENT").$$("a");
    }
}
