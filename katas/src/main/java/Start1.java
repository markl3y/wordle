import java.util.*;

//Exercise 4: Start1
//Create an integer method called Start1 that takes in two integer arrays "a" and "b". Start with 2
//int arrays, a and b, of any length. Return how many of the arrays have 1 as their first element.
//start1([1, 2, 3], [1, 3]) → 2
//start1([7, 2, 3], [1]) → 1
//start1([1, 2], []) → 1

public class Start1 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        promptUser();
        String[] convertedArrays = convertTwoArrays(userInput.nextLine());
        String convertedArray1 = convertedArrays[0];
        String convertedArray2 = convertedArrays[1];
        char[] charArray1 = new char[convertedArray1.length()];
        char[] charArray2 = new char[convertedArray2.length()];
        for (int i = 0; i < convertedArray1.length(); i++) {
            charArray1[i] = convertedArray1.charAt(i);
        }
        for (int i = 0; i < convertedArray2.length(); i++) {
            charArray2[i] = convertedArray2.charAt(i);
        }
        int[] intArray1 = new int[charArray1.length];
        int[] intArray2 = new int[charArray2.length];
        for (int i = 0; i < charArray1.length; i++) {
            intArray1[i] = Character.getNumericValue(charArray1[i]);            //Converts char to int!
        }
        for (int i = 0; i < charArray2.length; i++) {
            intArray2[i] = Character.getNumericValue(charArray2[i]);
        }
        int numArray1First = startOne(intArray1, intArray2);
        System.out.println(numArray1First + " array(s) have 1 at the beginning of the array.");
    }
    static void promptUser() {
        System.out.print("Please enter two arrays.\nFormat: [x, x, x,], [x, x, x] : ");
    }
    static String[] convertTwoArrays(String inputArrays) {
        String[] arrays = inputArrays.split("]");
        String array1 = arrays[0];
        String array2 = arrays[1];
        array1 = array1.replace(",", "");
        array1 = array1.replace("[", "");
        array1 = array1.replace("]", "");
        array1 = array1.replace(" ","");
        array2 = array2.replace(",", "");
        array2 = array2.replace("[", "");
        array2 = array2.replace("]", "");
        array2 = array2.replace(" ","");
        return new String[]{array1, array2}; //{xxx, xxx}
    }
    static int startOne(int[] array1, int[] array2) { //Required by kata
        int count = 0;
        if(array1[0] == 1) {
            count++;
        }
        if (array2[0] == 1) {
            count++;
        }
        return count;
    }
}
