package be.cegeka.core.mijnpersoneelsdossier.pages;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WerkdagTest {


    @Test
    public void timeWorkedDecimal_ShouldConvertCorrectly(){
        assertThat(new Werkdag("01/01/2015", "8:30").timeWorkedDecimal()).isEqualTo(8.50f);
        assertThat(new Werkdag("01/01/2015", "8:59").timeWorkedDecimal()).isEqualTo(8.98f);
        assertThat(new Werkdag("01/01/2015", "8:00").timeWorkedDecimal()).isEqualTo(8.00f);
        assertThat(new Werkdag("01/01/2015", "8:01").timeWorkedDecimal()).isEqualTo(8.02f);
    }
}