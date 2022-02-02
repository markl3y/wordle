package com.techelevator.farm.shape;

public class Rectangle extends Shape {
    private int width;
    private int length;

    public Rectangle(int width, int length) {
        super("Rectangle");
        this.width = width;
        this.length = length;
    }

    public int getArea() {
    return width * length;
    }
}
