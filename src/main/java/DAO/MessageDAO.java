package DAO;

import model.Message;
import model.User;

import java.util.List;

public interface MessageDAO {

    void sendMessage(Message message);

    List<Message> getMessageList(User sender, User receiver);


}
