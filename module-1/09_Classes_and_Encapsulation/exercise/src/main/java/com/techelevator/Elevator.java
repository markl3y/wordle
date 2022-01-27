package com.techelevator;

public class Elevator {

    //INSTANCE VARS

    //The current floor that the elevator is on.
    public int currentFloor;

    //The number of floors available to the elevator.
    public int numberOfFloors;

    //Whether the elevator door is open or not.
    public boolean doorOpen;

    //CONSTRUCTORS

    //Init constructor.
    public Elevator(){}

    //The Elevator class has a single constructor that accepts one parameter, int numberOfLevels, which indicates how many floors are available to the elevator.
    public Elevator(int numberOfLevels) {
        numberOfFloors = numberOfLevels;
        currentFloor = 1;
    }

    //GETS

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    //METHODS

    //Opens the elevator door.
    public void openDoor() {
        doorOpen = true;
    }

    //Closes the elevator door.
    public void closeDoor() {
        doorOpen = false;
    }

    //Sends the elevator upward to the desired floor as long as the door isn't open. The elevator can't go past the last floor.
    public void goUp(int desiredFloor) {
        if (!doorOpen && desiredFloor <= numberOfFloors && desiredFloor > currentFloor) {
            currentFloor = desiredFloor;
        }
    }

    //Sends the elevator downward to the desired floor as long as the door isn't open. It can't go past floor one.
    public void goDown(int desiredFloor) {
        if (!doorOpen && desiredFloor >= 1 && desiredFloor < currentFloor) {
            currentFloor = desiredFloor;
        }
    }
}
