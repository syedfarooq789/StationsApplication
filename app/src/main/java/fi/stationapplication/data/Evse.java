package fi.stationapplication.data;


import java.io.Serializable;
import java.util.List;

public class Evse implements Serializable {
    private Integer id;
    private List<Connector> connectors = null;
    private String groupName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Connector> getConnectors() {
        return connectors;
    }

    public void setConnectors(List<Connector> connectors) {
        this.connectors = connectors;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
