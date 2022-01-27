package com.techelevator;

public class HomeworkAssignment {

    //Instance variables.

    private int earnedMarks; //	int	X	X	The total number of correct marks submitter received on the assignment.
    private int possibleMarks; //	int	X		The number of possible marks on the assignment.
    private String submitterName; //	String	X		The submitter's name for the assignment.
    private String letterGrade; // (derived)	String	X		The letter grade for the assignment.

    //Initializer.

    public HomeworkAssignment() {

    }

    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    //Sets and gets.
    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public int getEarnedMarks() {
        return this.earnedMarks;
    }

    public int getPossibleMarks() {
        return this.possibleMarks;
    }

    public String getSubmitterName() {
        return this.submitterName;
    }

    //letterGrade is a derived attribute that's calculated using earnedMarks and possibleMarks:
    //For 90% or greater, it returns "A"
    //For 80-89%, it returns "B"
    //For 70-79%, it returns "C"
    //For 60-69%, it returns "D"
    //Otherwise, it returns "F"
    //hint: possibleMarks and earnedMarks are ints. What happens when a smaller integer is divided by a larger integer?

    public String getLetterGrade() {
        double earnedMarks = this.earnedMarks;
        double possibleMarks = this.possibleMarks;
        double percent = (earnedMarks / possibleMarks) * 100;
        int intPercent = (int)percent;
        if (intPercent >= 90) {
            letterGrade = "A";
        } else if (intPercent >= 80) {
            letterGrade = "B";
        } else if (intPercent >= 70) {
            letterGrade = "C";
        } else if (intPercent >= 60) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }
        return letterGrade;
    }
}
