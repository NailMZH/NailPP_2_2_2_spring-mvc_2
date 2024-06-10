package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    void removeUserById(int id);


    void saveUser(User user);
    User getUser(int id);
    void editUser(int id, User updateUser);

}
