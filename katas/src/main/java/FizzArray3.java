import java.util.*;

//Exercise 5: FizzArray3
//Create an integer array method called FizzArray3 that takes in two integers "start" and "end"
//Given start and end numbers, return a new array containing the sequence of integers from start
//up to but not including end, so start=5 and end=10 yields {5, 6, 7, 8, 9}. The end number will be
//greater or equal to the start number. Note that a length-0 array is valid.
//fizzArray3(5, 10) → [5, 6, 7, 8, 9]
//fizzArray3(11, 18) → [11, 12, 13, 14, 15, 16, 17]
//fizzArray3(1, 3) → [1, 2]

public class FizzArray3 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        while (num1 >= num2) {
            promptUserNum();
            num1 = userInput.nextInt();
            promptUserNum();
            num2 = userInput.nextInt();
            if (num1 > num2) {
                errorMessage();
            } else break;
        }
        int[] fizzedArray = fizzArray(num1, num2);
        System.out.print("Your array is: [");
        if (fizzedArray.length == 0) {
            System.out.print("]");
        } else {
            for (int i = 0; i < fizzedArray.length; i++) {
                if (i == fizzedArray.length - 1) {
                    System.out.print(fizzedArray[i] + "]");
                } else System.out.print(fizzedArray[i] + ", ");
            }
        }
    }

    static int[] fizzArray(int start, int end) {
        int totalNums = end - start;
        if (totalNums == 0) {
            return new int[]{};
        }
        int[] fizz = new int[totalNums];
        fizz[0] = start;
        for (int i = 1; i < totalNums; i++) {
            fizz[i] = start + i;
        }
        return fizz;
    }

    static void promptUserNum() {
        System.out.print("Please enter a number: ");
    }

    static void errorMessage() {
        System.out.println("\nSorry, your first number cannot be larger than your second number.\n");
    }
}
