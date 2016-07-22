package be.cegeka.core.peoplesoftfinance;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

public class PeopleSoftFinanceFacturatieCategorieen implements Serializable{

    public Map<String, List<String>> projectEnaActiviteitenCategorieen = newHashMap();

    public PeopleSoftFinanceFacturatieCategorieen(){}

    public static PeopleSoftFinanceFacturatieCategorieen peopleSoftFinanceFacturatieCategorieen(){
        return new PeopleSoftFinanceFacturatieCategorieen();
    }

    public PeopleSoftFinanceFacturatieCategorieen withProjectEnActiviteitenCategorieen(Map<String, List<String>> projectEnActiviteitenCategorieen) {
        this.projectEnaActiviteitenCategorieen.putAll(projectEnActiviteitenCategorieen);
        return this;
    }
}
