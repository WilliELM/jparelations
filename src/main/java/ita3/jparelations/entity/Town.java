package ita3.jparelations.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;

@Entity
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private long zipCode;
    private String mayour;
    private String schools;

    public Town() {
    }

    public Town(String name, long zipCode, String mayour, String schools) {
        this.name = name;
        this.zipCode = zipCode;
        this.mayour = mayour;
        this.schools = schools;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getZipCode() {
        return zipCode;
    }

    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }

    public String getMayour() {
        return mayour;
    }

    public void setMayour(String mayour) {
        this.mayour = mayour;
    }

    public String getSchools() {
        return schools;
    }

    public void setSchools(String schools) {
        this.schools = schools;
    }
}
