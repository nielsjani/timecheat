package be.cegeka.core.mijnpersoneelsdossier;

import be.cegeka.core.mijnpersoneelsdossier.pages.Werkdag;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MijnPersoneelsDossierProcessorTest {

    @Test
    public void test_process(){
      new MijnPersoneelsDossierProcessor().process();
    }

    @Test
    public void getRapport(){
        List<Werkdag> rapport = new MijnPersoneelsDossierProcessor().getRapport();
        assertThat(rapport).hasSize(21)
                .contains(new Werkdag("18/07/2016", "9:15"),new Werkdag("12/07/2016", "8:23"), new Werkdag("21/07/2016", "0:00"));
    }
}