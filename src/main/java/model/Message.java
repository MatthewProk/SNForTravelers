package model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User receiver;
    @ManyToOne
    private User sender;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date sendingTime;
    private String textMessage;
    private Boolean viewed;
    private Boolean deleted;

    public Message(User sender, User receiver){

    }

    public Message(User sender, User receiver, String textMessage, Date sendingTime) {
        this.sender = sender;
        this.receiver = receiver;
        this.textMessage = textMessage;
        this.sendingTime = sendingTime;
    }

    public Message() {
    }

    public void setSendingTime(Date sendingTime) {
        if (sendingTime != null) {
            this.sendingTime = new Date(sendingTime.getTime());
        } else {
            this.sendingTime = null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;

        Message message = (Message) o;

        return getSender().equals(message.getSender())
                && getReceiver().equals(message.getReceiver())
                && getTextMessage().equals(message.getTextMessage());
    }

    @Override
    public int hashCode() {
        int result = getSender().hashCode();
        result = 31 * result + getReceiver().hashCode();
        result = 31 * result + getTextMessage().hashCode();
        return result;
    }
}
