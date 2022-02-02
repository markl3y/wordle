package com.techelevator;

public class TriangleWall extends Wall {
    private int base = 0;
    private int height = 0;

    public TriangleWall(String name, String color, int base, int height) {
        super(name, color);
        this.base = base;
        this.height = height;
    }

    public int getArea() {
        return (base * height) / 2;
    }

    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return super.getName() + " (" + this.getBase() + "x" + this.getHeight() + ") triangle";
    }
}
