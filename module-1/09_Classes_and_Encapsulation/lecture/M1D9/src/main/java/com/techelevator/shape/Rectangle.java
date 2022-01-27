package com.techelevator.shape;

public class Rectangle {
    //static implies this is shared across all instances.
    private static int numOfInstances; //First rectangle creates an int called numOfInstances. It will be shared by every instance of Rectangle()

    //Instance variables.(created for each unique instance of object.)

    private int width;
    private int height;

    //Constructors

    public Rectangle() { //this is an initializer.
        numOfInstances++;
    }

    public Rectangle(int width, int height) {
        numOfInstances++;
        this.width = width;
        this.height = height;
    }

    //Derived* properties

    public void setWidth(int width) { //a setter
        this.width = width;
    }

    public int getWidth() { // a getter
        return this.width; // "this" is not required.(unless it shares the same name as arg)
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    public int getArea() {
        return width * height; // or this.width, this.height;
    }

    public int getPerimeter() {
        return 2 * width + 2 * height;
    }

    public static int getNumOfInstances() {
        return numOfInstances;
    }

    //This will execute code without the necessity to create an instance of object.
    public static int getArea(int width, int height) {
        return width * height;
    }
}
