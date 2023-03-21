package web.service;

import web.model.User;
import java.util.List;

public interface UserService {

    User getUser(long id);

    List<User> getAllUsers();

    void saveUser(User user);

    void editUser(User user, long id);

    void removeUserById(long id);
}
