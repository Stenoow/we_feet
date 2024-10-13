package com.wefeet.wefeet.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Discipline")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "The name can't be blank")
    @Column(nullable = false, unique = true, length = 25)
    private String name;
    @ManyToMany
    @JoinTable(
            name = "discipline_surface_area", // Nom de la table de jointure
            joinColumns = @JoinColumn(name = "discipline_id"), // Colonne de la clé étrangère pour Discipline
            inverseJoinColumns = @JoinColumn(name = "surface_area_id") // Colonne pour SurfaceArea
    )
    private Set<SurfaceArea> surfaceAreas = new HashSet<>();

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

    public Set<SurfaceArea> getSurfaceAreas() {
        return surfaceAreas;
    }

    public void setSurfaceAreas(Set<SurfaceArea> surfaceAreas) {
        this.surfaceAreas = surfaceAreas;
    }
}
