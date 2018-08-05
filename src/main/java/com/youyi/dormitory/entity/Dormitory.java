package com.youyi.dormitory.entity;

public class Dormitory {
    private int did;
    private Building building;
    private String num;
    private int maxMan;

    public Dormitory() {
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getMaxMan() {
        return maxMan;
    }

    public void setMaxMan(int maxMan) {
        this.maxMan = maxMan;
    }
}
