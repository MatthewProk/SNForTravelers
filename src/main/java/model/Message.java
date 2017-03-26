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

}
