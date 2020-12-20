package com.interfaces;

import com.trippy.entity.City;

import java.util.List;

public interface ICity {
    List<City> listCities();
    City pickOrigin(City origin);
    City pickDestination(City destination);
    City getCityById(int cityId);
}
