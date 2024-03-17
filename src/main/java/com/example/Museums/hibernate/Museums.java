package com.example.Museums.hibernate;

import jakarta.persistence.*;

/**
 * Класс сущности, нужен для соединения с базой данных
 */
@Entity
@Table(name = "museums")
public class Museums {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Lob
    @Column(name = "photo")
    private byte[] photo;

    @Column(name = "city")
    private String city;

    public Museums() {}
    public Museums(String name, String description, byte[] photo, String city) {
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
