package ita3.jparelations.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(mappedBy = "adress", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    List<Citizen> citizens = new ArrayList<>();
    private String street;
    private long zip;
    private String city;

    public Adress() {
    }

    public Adress(String street, long zip, String city) {

        this.street = street;
        this.zip = zip;
        this.city = city;
    }
    public void addCitizen(Citizen citizen){
        citizens.add(citizen);
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public long getZip() {
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Citizen> citizens) {
        this.citizens = citizens;
    }
}
