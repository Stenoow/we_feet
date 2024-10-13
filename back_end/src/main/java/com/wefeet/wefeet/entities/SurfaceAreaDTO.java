package com.wefeet.wefeet.entities;


public class SurfaceAreaDTO {

    private String name;
    private int disciplineId;

    public SurfaceAreaDTO(String name, int disciplineId) {
        this.name = name;
        this.disciplineId = disciplineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(int disciplineId) {
        this.disciplineId = disciplineId;
    }
}
