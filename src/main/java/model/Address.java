package model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String country;
    private String street;
    private String city;
    private String house;
    private Integer flat;

    public Address(Long id){
        this.id = id;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "id = " + id + "\n"
                + "country = " + country + "\n"
                + "city = " + city + "\n"
                + "street = " + street + "\n"
                + "house = " + house + "\n"
                + "flat = " + flat + "\n" + "\n";
    }
}
