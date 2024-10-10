package com.wefeet.wefeet.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "SurfaceArea")
public class SurfaceArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false, length = 25)
    private String name;

    public SurfaceArea() { }

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
}
