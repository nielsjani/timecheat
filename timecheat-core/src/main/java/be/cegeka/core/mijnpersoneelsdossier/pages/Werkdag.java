package be.cegeka.core.mijnpersoneelsdossier.pages;

import be.cegeka.core.ValueObject;
import be.cegeka.core.util.DateUtil;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;

import static java.lang.Float.parseFloat;
import static java.math.BigDecimal.ROUND_HALF_UP;

public class Werkdag extends ValueObject{

    private Date date;
    private String timeWorked;

    public Werkdag(String date, String timeWorked) {
        this.date = DateUtil.toDate(date);
        this.timeWorked = timeWorked;
    }

    public Date getDate() {
        return date;
    }

    public String getTimeWorked() {
        return timeWorked;
    }

    public float timeWorkedDecimal(){
        String[] split = timeWorked.split(":");
        float decimaleWerktijd = parseFloat(split[0]) + (parseFloat(split[1]) / 60);
        return rondAfTotTweeCijfersNaDeKomma(decimaleWerktijd);
    }

    private float rondAfTotTweeCijfersNaDeKomma(float decimaleWerktijd) {
        BigDecimal bigDecimal = new BigDecimal(decimaleWerktijd).setScale(2, ROUND_HALF_UP);
        return bigDecimal.floatValue();
    }
}
