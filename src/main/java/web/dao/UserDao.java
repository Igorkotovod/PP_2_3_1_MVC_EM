package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {

    User getUser(long id);

    List<User> getAllUsers();

    void saveUser(User user);

    void editUser(User user, Long id);

    void removeUserById(long id);
}
