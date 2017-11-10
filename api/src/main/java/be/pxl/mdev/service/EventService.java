package be.pxl.mdev.service;
import be.pxl.mdev.entity.City;
import be.pxl.mdev.entity.Event;
import be.pxl.mdev.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by 11400982 on 9/11/2017.
 */
@Service
@Transactional
public class EventService implements IEventService {
    @Autowired
    private EventRepository repo;

    @Override
    public Event find (int id) { return repo.findOne(id);}

    @Override
    public List<Event> findAll() { return repo.findAll();}

    @Override
    public List<Event> findByCity(City city) {
        return repo.findByCity(city);
    }
}
