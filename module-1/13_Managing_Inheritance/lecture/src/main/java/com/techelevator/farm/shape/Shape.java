package com.techelevator.farm.shape;

public abstract class Shape {

    private String shapeName;

    public Shape(String name) {
        this.shapeName = name;
    }

    public abstract int getArea();

    public String getShapeName() {
        return shapeName;
    }

}
