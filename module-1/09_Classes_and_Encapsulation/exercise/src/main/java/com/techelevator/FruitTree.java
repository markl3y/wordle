package com.techelevator;


public class FruitTree {

    //Instance variables

    private String typeOfFruit;	//The type of fruit on the tree.
    private int piecesOfFruitLeft; //The number of remaining fruit pieces on the tree.

    //Constructors

    public FruitTree() {

    }

    public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = startingPiecesOfFruit;
    }

    //Gets and Sets

    public String getTypeOfFruit() {
        return this.typeOfFruit;
    }

    public int getPiecesOfFruitLeft() {
        return this.piecesOfFruitLeft;
    }

    //Pick fruit method

    public boolean pickFruit(int numberOfPiecesToRemove) {
        if (numberOfPiecesToRemove <= this.piecesOfFruitLeft) {
            this.piecesOfFruitLeft = this.piecesOfFruitLeft - numberOfPiecesToRemove;
            return true;
        } else return false;
    }
}
