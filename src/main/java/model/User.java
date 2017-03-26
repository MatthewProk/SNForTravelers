package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Temporal(value = TemporalType.DATE)
    private Date dateOfBirth;
    private Integer age;
    private String login;
    private String password;
    private String email;
    private String telephone;
    @ManyToOne
    private Address address;
    private String genderType;
    private String aboutSelf;
    private String avatar;

    public User(Long id){
        this.id = id;
    }

    public User() {
    }


    @Override
    public String toString() {
        return "User's id = " + id + "\n"
                + "First Name = " + firstName + "\n"
                + "Last Name = " + lastName + "\n"
                + "DateOfBirth = " + dateOfBirth + "\n"
                + "Age = " + age + "\n"
                + "Login = " + login + "\n"
                + "Password = " + password + "\n"
                + "Email = " + email + "\n"
                + "Phone = " + telephone + "\n"
                + "Address = " + address + "\n"
                + "GenderTypeId = " + genderType + "\n"
                + "AboutSelf = " + aboutSelf + "\n"
                + "Avatar = " + avatar + "\n" + "\n";
    }
}
