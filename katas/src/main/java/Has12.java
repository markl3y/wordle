import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
//Create a boolean method called Has12 that takes in an integer array "nums". Given an array of
//ints, return true if there is a 1 in the array with a 2 somewhere later in the array.
//For example:
//has12([1, 3, 2]) → true
//has12([3, 1, 2]) → true
//has12([3, 1, 4, 5, 2]) → true

public class Has12 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Please enter an array of integers, separated by commas.\nEx: [1, 2, 3, 4] : ");
        String userNums = userInput.nextLine();                                                                         //Store input into a String.
        userNums = userNums.substring(1, userNums.length() - 1);                                                        //Remove the input brackets.
        String[] noCommaNums = userNums.split(", ");                                                              //Create a string array to hold each value, ignoring the commas and spaces.
        Integer[] parseNumArray = new Integer[noCommaNums.length];                                                       //Create a new Integer array of the same size as the users input array.
        for (int i = 0; i < noCommaNums.length; i++) {                                                                  //Populate the Integer array with parsed Integer values from the input array.
            parseNumArray[i] = Integer.parseInt(noCommaNums[i]);                                                         //...
        }
        boolean contains1Then2 = has1Then2(parseNumArray);
        if (contains1Then2) {
            System.out.println("\nYour array contains a 1, followed somewhere by a 2!");
        } else {
            System.out.println("\nYour array does not contain a 1, followed somewhere by a 2.");
        }
    }
    public static boolean has1Then2(Integer[] nums) {
        boolean contains1 = false;
        boolean contains2 = false;
        boolean containsLater2 = false;
        List<Integer> listNums = new ArrayList<Integer>();
        List<Integer> twoPlacements = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            listNums.add(nums[i]);
            if (i == 1) {
                contains1 = true;
            }
            if (i == 2) {
                contains2 = true;
            }
        }
        if (listNums.indexOf(1) < listNums.lastIndexOf(2)) {
            containsLater2 = true;
        }
        return (contains1 && contains2) && containsLater2;
    }
}
