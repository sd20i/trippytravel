package com.trippy.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="route")
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int routeId;

    @OneToOne
    private City cityOne;

    @OneToOne
    private City cityTwo;


    public int getRouteId() {
        return routeId;
    }

    public City getCityOne() {
        return cityOne;
    }

    public void setCityOne(City cityOne) {
        this.cityOne = cityOne;
    }

    public City getCityTwo() {
        return cityTwo;
    }

    public void setCityTwo(City cityTwo) {
        this.cityTwo = cityTwo;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeId=" + routeId +
                ", cityOne=" + cityOne +
                ", cityTwo=" + cityTwo +
                '}';
    }
}
