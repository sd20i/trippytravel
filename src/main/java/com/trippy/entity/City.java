package com.trippy.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "city")
public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cityId;

    @Column(name="cityName")
    private String cityName;

    @ManyToOne()
    private Country country;

    public int getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
