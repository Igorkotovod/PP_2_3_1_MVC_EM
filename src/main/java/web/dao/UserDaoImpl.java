package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    private UserDaoImpl() {
    }
    @Override
    public User getUser(long id) {      // Long or long - What's the difference in this case?
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void editUser(User updatedUser, Long id) {
        entityManager.merge(updatedUser);
    }

    @Override
    public void removeUserById(long id) {
        entityManager.remove(getUser(id));
    }
}
