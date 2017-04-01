package DAO;

import model.User;
import java.util.List;

public interface FriendshipDAO {

    void saveOrUpdateFriendship(User initiator, User friend);

    List<User> getAllFriendsOfUser(User user);

    void deleteFriend(User init, User friend);
}
