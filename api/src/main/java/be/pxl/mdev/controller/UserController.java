package be.pxl.mdev.controller;

import be.pxl.mdev.entity.User;
import be.pxl.mdev.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 11400982 on 9/11/2017.
 */
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    @Autowired
    private IUserService service;

    public static final String BASE_URL = "/users";

    @RequestMapping(value = "/get/{username}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public ResponseEntity<User> getUserByEmail(@PathVariable("username") String email) {
        HttpStatus status = HttpStatus.OK;

        User user = service.find(email);

        if (user == null)
            status = HttpStatus.NOT_FOUND;

        return new ResponseEntity<User>(user, status);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public List<User> getAllUsers() {
        return service.all();
    }

    @RequestMapping(value = "/add", method=RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addUser(@RequestBody User user) {
        service.persist(user);
    }

    @RequestMapping(value = "/update", method=RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {
        service.update(user);
    }

}
