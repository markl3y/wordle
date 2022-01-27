package com.techelevator.shape;

public class ShapeApp {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        System.out.println(rectangle.getWidth());
        Rectangle rectangle1 = new Rectangle();
        rectangle1.setWidth(20);
        System.out.println(rectangle1.getWidth());
        rectangle.setHeight(5);
        System.out.println("Area of rectangle is: " + rectangle.getArea());
        Rectangle rect3 = new Rectangle(40, 5);
        System.out.println(rect3 + " has an area of " + rect3.getArea());

    }
}
