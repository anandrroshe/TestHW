package HW30.Spark;

import java.util.Collection;

public interface UserService {
    void addUser(User user);
    Collection<User> getUsers();
    User getUser(String id);
    void deleteUser(String id);
    boolean userExist(String id);
    User editUser(User user) throws UserException;

}

