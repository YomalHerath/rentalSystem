package controller;

import model.User;

import java.util.List;

public interface UserController {
    public void save(User user);
    public void update(User user);
    public void delete(User user);
    public User get(int userId);
    public List<User> list();
}
