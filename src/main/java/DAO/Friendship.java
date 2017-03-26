package DAO;

import model.User;

public interface Friendship {

    void deleteFriend(User init, User friend);

    void addFriend();

}
