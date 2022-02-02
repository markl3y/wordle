package com.techelevator;

public class RectangleWall extends Wall {

    private int length = 0;
    private int height = 0;

    public RectangleWall(String name, String color, int length, int height) {
        super(name, color);
        this.length = length;
        this.height = height;
    }

    //GETS
    public int getLength() {
        return this.length;
    }

    public int getHeight() {
        return this.height;
    }

    public int getArea() {
        return length * height;
    }

    //Add a toString() method that returns a String in the following format:
    //name (lengthxheight) rectangle
    @Override
    public String toString() {
        return super.getName() + " (" + this.getLength() + "x" + this.getHeight() + ") rectangle";
    }
}


