package be.pxl.mdev.service;

import be.pxl.mdev.entity.City;

import java.util.List;

/**
 * Created by 11400982 on 9/11/2017.
 */
public interface ICityService {

    public City find(String postalCode);
    public List<City> all();
}
