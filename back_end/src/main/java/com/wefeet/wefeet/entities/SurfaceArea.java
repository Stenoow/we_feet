package com.wefeet.wefeet.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SurfaceArea")
public class SurfaceArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false, length = 25)
    private String name;
    @ManyToMany(mappedBy = "surfaceAreas") // Mapped by le champ surfaceAreas de la classe Discipline
    private Set<Discipline> disciplines = new HashSet<>();


    public SurfaceArea() { }

    public SurfaceArea(String name) {
        this.name = name;
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

    public Set<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Set<Discipline> disciplines) {
        this.disciplines = disciplines;
    }
}
