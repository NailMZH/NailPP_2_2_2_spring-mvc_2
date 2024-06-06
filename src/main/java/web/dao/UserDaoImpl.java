package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

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
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
        entityManager.close();
    }


    @Override
    public User getUser(int id) {

        return entityManager.find(User.class, id);
    }
}
