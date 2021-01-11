package com.qgsstrive.sassecurity.db;

/**
 * @date 2020/12/18 9:52
 */
public class CQUser {
    private int id;
    private Float startX;
    private Float startY;
    private Float stopX;
    private Float stopY;

    public CQUser() {
        super();
    }

    public CQUser(int id, Float startX, Float startY, Float stopX, Float stopY) {
        this.id = id;
        this.startX = startX;
        this.startY = startY;
        this.stopX = stopX;
        this.stopY = stopY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Float getStopX() {
        return stopX;
    }

    public void setStopX(Float stopX) {
        this.stopX = stopX;
    }

    public Float getStopY() {
        return stopY;
    }

    public void setStopY(Float stopY) {
        this.stopY = stopY;
    }
}
