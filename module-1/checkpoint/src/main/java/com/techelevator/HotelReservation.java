package com.techelevator;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class HotelReservation {
    //INSTANCE VARS
    public final static BigDecimal dailyRate = new BigDecimal("59.99");
    public final static BigDecimal cleaningCost = new BigDecimal("34.99");
    public final static BigDecimal minibarCost = new BigDecimal("12.99");
    private String name;
    private int numberOfNights;
    private BigDecimal estimatedTotal = new BigDecimal(0);
    private BigDecimal actualTotal = new BigDecimal(0);

    //CONST
    public HotelReservation(String name, int numberOfNights) {
        this.name = name;
        this.numberOfNights = numberOfNights;
        this.estimatedTotal = BigDecimal.valueOf(this.numberOfNights).multiply(dailyRate);
    }


    //GETS
    public String getName() {
        return name;
    }
    public int getNumberOfNights() {
        return numberOfNights;
    }
    public BigDecimal getEstimatedTotal(){return estimatedTotal;}
    public BigDecimal getActualTotal(){return actualTotal;}

    //SETS
    public void setName(String name) {
        this.name = name;
    }
    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }
    public void setEstimatedTotal(BigDecimal estimatedTotal) {
        this.estimatedTotal = estimatedTotal;
    }
    public void setActualTotal(boolean requiresCleaning, boolean usedMinibar) {
        actualTotal = estimatedTotal;
        if (usedMinibar && requiresCleaning) {
            actualTotal = actualTotal.add(minibarCost);
            actualTotal = actualTotal.add(BigDecimal.valueOf(2).multiply(cleaningCost));
        } else if (usedMinibar) {
            actualTotal = actualTotal.add(minibarCost);
        } else if (requiresCleaning) {
            actualTotal = actualTotal.add(cleaningCost);
        }
    }

    //METHODS
    @Override
    public String toString() {
        return "RESERVATION - " + name + "- " + NumberFormat.getCurrencyInstance().format(estimatedTotal);
    }

}
