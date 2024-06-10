package web.repositories;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext()
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<User> getListUsers() {

        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    @Override
    public void removeUserById(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }


    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }


    @Override
    public User getUser(int id) {

        return entityManager.find(User.class, id);
    }

    @Override
    public void editUser(int id, User updateUser) {
        User edit = getUser(id);
        edit.setName(updateUser.getName());
        edit.setLastName(updateUser.getLastName());
    }
}