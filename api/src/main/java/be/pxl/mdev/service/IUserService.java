package be.pxl.mdev.service;

import be.pxl.mdev.entity.User;

import java.util.List;

/**
 * Created by 11400982 on 9/11/2017.
 */
public interface IUserService {

    public User find(String username);
    public List<User> all();
    public void persist(User user);
    public void update(User user);
}
