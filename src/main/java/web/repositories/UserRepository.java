package web.repositories;

import web.model.User;


import java.util.List;

public interface UserRepository {
    List<User> getListUsers();
    void removeUserById(int id);

    void saveUser(User car);

    User getUser(int id);

    void editUser(int id, User updateUser);
}
