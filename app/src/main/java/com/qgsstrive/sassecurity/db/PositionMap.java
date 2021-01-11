package com.qgsstrive.sassecurity.db;

/**
 * @date 2020/12/18 9:53
 */
public class PositionMap {
    private int id;
    private String name;
    private Float startX;
    private Float startY;

    public PositionMap() {
        super();
    }

    @Override
    public String toString() {
        return "PositionMap{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startX=" + startX +
                ", startY=" + startY +
                '}';
    }

    public PositionMap(int id, String name, Float startX, Float startY) {
        this.id = id;
        this.name = name;
        this.startX = startX;
        this.startY = startY;
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

    public Float getStartX() {
        return startX;
    }

    public void setStartX(Float startX) {
        this.startX = startX;
    }

    public Float getStartY() {
        return startY;
    }

    public void setStartY(Float startY) {
        this.startY = startY;
    }
}
