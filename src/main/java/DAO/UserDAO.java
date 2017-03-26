package DAO;

import model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

//    void addUser();

    boolean loginFree(String login);
    void deleteUser();


}
