package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "friendship")
public class Friendship implements Serializable {

    @Id
    @ManyToOne
    private User initiator;
    @Id
    @ManyToOne
    private User friend;

    public Friendship(User initiator, User friend) {
    }

    public Friendship() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Friendship)) return false;

        Friendship that = (Friendship) o;

        return getInitiator().equals(that.getInitiator()) && getFriend().equals(that.getFriend());
    }
    @Override
    public int hashCode() {
        int result = getInitiator().hashCode();
        result = 31 * result + getFriend().hashCode();
        return result;
    }
}
