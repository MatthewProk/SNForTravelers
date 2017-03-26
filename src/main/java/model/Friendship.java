package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dataAdded;

}
