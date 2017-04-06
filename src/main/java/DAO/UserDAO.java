package DAO;

import model.User;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface UserDAO {

    List<User> getAllUsers();

    boolean loginFree(String login);

    default Optional<User> getUserByLogin(String login){
        return getAllUsers().stream()
                .filter(user -> user.getLogin().equals(login))
                .findAny();
    }

    void addUser(String firstName, String lastName, String login,
                 String password, String email, String genderType) throws ParseException;
}
