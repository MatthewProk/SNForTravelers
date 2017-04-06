package DAO;

import model.Friendship;
import model.User;
import java.util.List;

public interface FriendshipDAO {

    void saveFriendship(Friendship friendship);

    List<User> getAllFriendsOfUser(User user);

    void deleteFriend(User init, User friend);
}
