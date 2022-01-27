package com.techelevator;

public class Airplane {
    private String planeNumber; //The six-character plane number.
    private int totalFirstClassSeats;//The total number of first class seats.
    private int bookedFirstClassSeats;//The number of already booked first class seats.
    private int availableFirstClassSeats;//The number of available first class seats.
    private int totalCoachSeats;	//The total number of coach seats.
    private int bookedCoachSeats; //The number of already booked coach seats.
    private int availableCoachSeats; //(derived)The number of available coach seats.

    public Airplane() {}

    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
        this.availableFirstClassSeats = totalFirstClassSeats;
        this.availableCoachSeats = totalCoachSeats;
    }

    //availableFirstClassSeats is a derived value calculated by subtracting bookedFirstClassSeats from totalFirstClassSeats.
    //availableCoachSeats is a derived value calculated by subtracting bookedCoachSeats from totalCoachSeats.

    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getAvailableFirstClassSeats() {
        return totalFirstClassSeats - bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    public int getAvailableCoachSeats() {
        return totalCoachSeats - bookedCoachSeats;
    }

    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
        //If forFirstClass is true, add totalNumberOfSeats to the value for BookedFirstClassSeats.
        //If forFirstClass is false, add totalNumberOfSeats to the value for BookedCoachSeats.
        //It returns true if there were enough seats to make the reservation, otherwise it returns false.
        if (forFirstClass) {
            if (totalNumberOfSeats <= availableFirstClassSeats) {
                bookedFirstClassSeats += totalNumberOfSeats;
                availableFirstClassSeats -= totalNumberOfSeats;
                return true;
            } else return false;
        } else {
            if (totalNumberOfSeats <= availableCoachSeats) {
                bookedCoachSeats += totalNumberOfSeats;
                availableCoachSeats -= totalNumberOfSeats;
                return true;
            } else return false;
        }
    }

    //No sets, all gets.

}
