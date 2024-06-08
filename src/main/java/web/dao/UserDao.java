package web.dao;

import web.model.User;


import java.util.List;

public interface UserDao {
    List<User> getListUsers();
    void removeUserById(int id);

    void saveUser(User car);

    User getUser(int id);

    void editUser(int id, User updateUser);
}
