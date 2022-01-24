import java.util.Scanner;
//Create an integer array method called SwapEnds that takes in an integer array "nums". Given
//an array of ints, swap the first and last elements in the array. Return the modified array. The
//array length will be at least 1.
//For example:
//swapEnds([1, 2, 3, 4]) → [4, 2, 3, 1]
//swapEnds([1, 2, 3]) → [3, 2, 1]
//swapEnds([8, 6, 7, 9, 5]) → [5, 6, 7, 9, 8]

public class SwapEnds {                                                                                                 //Public class SwapEnds.
    public static void main(String[] args) {                                                                            //Main method.
        Scanner userInput = new Scanner(System.in);                                                                     //New Scanner assigned to user input (System.in).
        System.out.print("Please enter an array of integers, separated by commas.\nEx: [1, 2, 3, 4] : ");               //Ask user for array.
        String userNums = userInput.nextLine();                                                                         //Store input into a String.
        userNums = userNums.substring(1, userNums.length() - 1);                                                        //Remove the input brackets.
        String[] noCommaNums = userNums.split(", ");                                                              //Create a string array to hold each value, ignoring the commas and spaces.
        Integer[] convNumArray = new Integer[noCommaNums.length];                                                       //Create a new Integer array of the same size as the users input array.
        for (int i = 0; i < noCommaNums.length; i++) {                                                                  //Populate the Integer array with parsed Integer values from the input array.
            convNumArray[i] = Integer.parseInt(noCommaNums[i]);                                                         //...
        }                                                                                                               //...
        Integer[] endArray = swappedArray(convNumArray);                                                                //Pass the converted number array to the swap array method, and store it in a new integer array.
        System.out.print("\nYour new array is: [");                                                                     //Open output with a bracket.
        for (int i = 0; i < endArray.length - 1; i++) {                                                                 //Print out each element of the new array, separated by commas and spaces. (Save for the last element.)
            System.out.print(endArray[i] + ", ");                                                                       //...
        }                                                                                                               //...
        System.out.print(endArray[endArray.length - 1] + "]");                                                          //Finish by printing the last element in the array, followed by a close bracket.
    }                                                                                                                   //End main method.
   static Integer[] swappedArray(Integer[] nums) {                                                                      //Swapped array method does as follows:
        int firstInArray = nums[0];                                                                                     //First, it initializes an integer to be the first element in the provided array.
        int lastInArray = nums[nums.length - 1];                                                                        //Secondly, it initializes an integer to be the last element in the provided array.
        nums[0] = lastInArray;                                                                                          //Now, it assigns the previously last element to be the first element.
        nums[nums.length - 1] = firstInArray;                                                                           //And vice-versa.
        return nums;                                                                                                    //It will return an array where the first and last elements are reversed.
    }
}
