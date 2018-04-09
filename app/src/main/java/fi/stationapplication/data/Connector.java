package fi.stationapplication.data;


import java.io.Serializable;

public class Connector implements Serializable {
    private String type;
    private Float maxKw;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getMaxKw() {
        return maxKw;
    }

    public void setMaxKw(Float maxKw) {
        this.maxKw = maxKw;
    }
}
