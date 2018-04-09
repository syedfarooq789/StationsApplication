package fi.stationapplication.data;


import java.io.Serializable;
import java.util.List;

public class Stations implements Serializable {
    private Integer id;
    private Float latitude;
    private Float longitude;
    private String name;
    private String city;
    private String provider;
    private List<Evse> evses = null;
    private Boolean isRemoved;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public List<Evse> getEvses() {
        return evses;
    }

    public void setEvses(List<Evse> evses) {
        this.evses = evses;
    }

    public Boolean getIsRemoved() {
        return isRemoved;
    }

    public void setIsRemoved(Boolean isRemoved) {
        this.isRemoved = isRemoved;
    }
}
