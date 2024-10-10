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
}
