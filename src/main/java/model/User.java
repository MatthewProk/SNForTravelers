package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    private Integer age;
    private String login;
    private String password;
    private String email;
    private String telephone;
    private String genderType;
    private String aboutSelf;
    private String avatar;
    private String country;
    private String city;

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
                + "Age = " + age + "\n"
                + "Login = " + login + "\n"
                + "Password = " + password + "\n"
                + "Email = " + email + "\n"
                + "Phone = " + telephone + "\n"
                + "Country = " + country + "\n"
                + "City = " + city + "\n"
                + "GenderTypeId = " + genderType + "\n"
                + "AboutSelf = " + aboutSelf + "\n"
                + "Avatar = " + avatar + "\n" + "\n";
    }
}
