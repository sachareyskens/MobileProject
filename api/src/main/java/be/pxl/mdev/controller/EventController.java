package be.pxl.mdev.controller;

import be.pxl.mdev.entity.Event;
import be.pxl.mdev.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 11400982 on 9/11/2017.
 */
@RestController
@RequestMapping(EventController.BASE_URL)
public class EventController {

    @Autowired
    private IEventService service;

    public static final String BASE_URL = "/events";

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public ResponseEntity<Event> getEventById(@PathVariable("id") int id) {
        HttpStatus status = HttpStatus.OK;

        Event event = service.find(id);

        if (event == null)
            status = HttpStatus.NOT_FOUND;

        return new ResponseEntity<Event>(event, status);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public List<Event> getAllEvents() {
        return service.findAll();
    }

}
