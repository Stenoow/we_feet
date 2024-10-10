package com.wefeet.wefeet.entities;

import com.wefeet.wefeet.enums.TypeSex;
import jakarta.persistence.*;

@Entity
@Table(name = "Shoes")
public class Shoes  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private TypeSex sex;
    @Column(nullable = false)
    private float price;
    @Column(nullable = false)
    private int minSize;
    @Column(nullable = false)
    private int maxSize;
    @Column
    private String link;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "discipline_id", nullable = false)
    private Discipline discipline;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "trademark_id")
    private Trademark trademark;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "surfacearea_id")
    private SurfaceArea surfacearea;

    public Shoes() {
        this.sex = TypeSex.UNISEX;
        this.link = "";
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

    public TypeSex getSex() {
        return sex;
    }

    public void setSex(TypeSex sex) {
        this.sex = sex;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Trademark getTrademark() {
        return trademark;
    }

    public void setTrademark(Trademark trademark) {
        this.trademark = trademark;
    }

    public SurfaceArea getSurfacearea() {
        return surfacearea;
    }

    public void setSurfaceArea(SurfaceArea surfacearea) {
        this.surfacearea = surfacearea;
    }
}
