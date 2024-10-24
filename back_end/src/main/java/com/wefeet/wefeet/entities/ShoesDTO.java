package com.wefeet.wefeet.entities;

import com.wefeet.wefeet.enums.TypeSex;
import jakarta.persistence.*;

public class ShoesDTO {

    private String name;
    private String sex;
    private float price;
    private int minSize;
    private int maxSize;
    private String link;
    private int disciplineId;
    private int trademarkId;
    private int surfaceareaId;

    public ShoesDTO(String name, String sex, float price, int minSize, int maxSize, String link, int disciplineId, int trademarkId, int surfaceareaId) {
        this.name = name;
        this.sex = sex;
        this.price = price;
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.link = link;
        this.disciplineId = disciplineId;
        this.trademarkId = trademarkId;
        this.surfaceareaId = surfaceareaId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
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

    public int getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(int disciplineId) {
        this.disciplineId = disciplineId;
    }

    public int getTrademarkId() {
        return trademarkId;
    }

    public void setTrademarkId(int trademarkId) {
        this.trademarkId = trademarkId;
    }

    public int getSurfaceareaId() {
        return surfaceareaId;
    }

    public void setSurfaceareaId(int surfaceareaId) {
        this.surfaceareaId = surfaceareaId;
    }
}
