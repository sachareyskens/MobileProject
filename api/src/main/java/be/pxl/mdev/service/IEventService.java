package be.pxl.mdev.service;

import be.pxl.mdev.entity.City;
import be.pxl.mdev.entity.Event;

import java.util.List;

/**
 * Created by 11400982 on 9/11/2017.
 */
public interface IEventService {
    public Event find(int id);
    public List<Event> findAll();
    public List<Event> findByCity(City city);
}
