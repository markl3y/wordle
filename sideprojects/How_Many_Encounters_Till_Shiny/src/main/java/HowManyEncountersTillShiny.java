import java.util.Random;
import java.util.Scanner;

public class HowManyEncountersTillShiny {
    public static void main(String[] args) {
        Random rand = new Random();
        Random rand2 = new Random();
        Scanner userInput = new Scanner(System.in);
        System.out.print("Do you have a shiny charm? (Y)es or (N)o : ");
        String yesOrNO = userInput.nextLine();
        int encounterCounter = 1;
        int getRandomIntegerShinyCharm = 0;
        int actualRandomEncounter = 1;
        int shinySquareOrStar = 0;
        if (yesOrNO.equals("Y")) {
            do {
                getRandomIntegerShinyCharm = rand.nextInt(1365);
                actualRandomEncounter = rand2.nextInt(1365);
                shinySquareOrStar = rand.nextInt(16);
                encounterCounter++;
            } while (getRandomIntegerShinyCharm != actualRandomEncounter);
        }
        if (yesOrNO.equals("N")) {
            do {
                getRandomIntegerShinyCharm = rand.nextInt(4096);
                actualRandomEncounter = rand2.nextInt(4096);
                shinySquareOrStar = rand.nextInt(16);
                encounterCounter++;
            } while (getRandomIntegerShinyCharm != actualRandomEncounter);
        }
        System.out.println("This attempt took you " + encounterCounter + " encounters.");
        int totalSecs = encounterCounter * 40;
        int hours = totalSecs / 3600;
        int minutes = (totalSecs % 3600) / 60;
        int seconds = totalSecs % 60;
        String starOrSquare;
        if (shinySquareOrStar == 1) {
            starOrSquare = "Star";
        } else {
            starOrSquare = "Square";
        }
        System.out.println("Assuming it takes 40 seconds to finish an encounter, it took you " + hours + " Hours, " + minutes + " Minutes, and " + seconds + " Seconds.");
        System.out.println("It has a " + starOrSquare + " animation.");

    }
}
