//import scanner
import java.util.Scanner;
public class PirateTreasureHunt
{
    //initialize variables that may be of help later ;)
    public static String name;
    public static int age;
    public static void main(String[] args)
    {
        //initialize scanner
        Scanner input = new Scanner(System.in);
        //start game by printing the title
        printTitle();
        //get name and age
        System.out.println("What is your name?");
        name = input.nextLine();
        System.out.println("\nHello, " + name + ".\nHow old are you?");
        age = input.nextInt();
        //opening of the game
        opening();
        //leave the cabin a go elsewhere
        move();
    }
    
    //prints the title screen
    public static void printTitle() {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("[ Pirate Treasure Hunt ]");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=\n");
    }
    //the game's opening
    public static void opening() {
        char openingChoice;
        System.out.println("\nYou awake to find yourself in a damp wooden cabin.\nThere is a worn, biege piece of paper on a wooden desk.");
        //loops until the player grabs the paper
        while (true) {
            //take decision
            openingChoice = decision("Pick it up.", "Rest some more");
            if (openingChoice == 'a') {
                System.out.println("You get out of bed and unfurl the paper.\nIt appears to be a treasure map, and it seems the treasure is on the beach outside.\n");
                break;
            } else {
                System.out.println("The paper can wait.  But what if it's important?");
            }
        }
    }
    //the player going to the beach
    public static void move() {
        System.out.println("You exit your cabin, shovel in hand, and look out into a large forest.\nThe map would be very clear if whoever wrote it bothered to draw a compass.");
        System.out.println("The trees block any way of knowing where you would be going.");
        //take decision
        char moveChoice = decision("Go left.", "Go right.", "Stay home");
        //sends player on which route they took (left -> graveyard, right -> beach)
        if (moveChoice == 'a') {
            graveyard();
        } else if (moveChoice == 'b') {
            beach();
        } else if (moveChoice == 'c') {
            System.out.println("Maybe it is better to relax and think about this.\nAs far as you know, you are the only one with the map.");
            System.out.println("It is not like the treasure is going anywhere.\nDo you even really need it?");
            theEnd("Relaxing Ending");
        } else { 
            impossible();
        }
    }
    //player goes through the graveyard
    public static void graveyard() {
        System.out.println("You find a large clearing, but this is not the beach.\nIt seems you have stumbled into a graveyard.");
        System.out.println("One headstone in particular seems to call to you.\nYou can feel you spine shake.");
        //take decision
        char graveChoice = decision("Inspect the grave.", "Turn back.");
        if (graveChoice == 'a') { //game ends with player finding their own grave
            tombstone(name, age);
        } else if (graveChoice == 'b') { //game ends with the player's house on fire
            System.out.println("This place is too creepy.\nYou run back as fast as you can.");
            System.out.println("Just before you reach your cabin, you stop to catch your breath.\nWalking forward, just as your hopes are getting up, you witness your cabin being burnt to nothing.");
            theEnd("Fire Ending");
        } else {
            impossible();
        }
    }
    //player goes to the beach
    public static void beach() {
        //initialize search time and scanner
        int searchTime = -1;
        Scanner input = new Scanner(System.in);
        System.out.println("You manage to find the beach.\nThe sand is beautiful, but there is treasure to be found.");
        System.out.println("Suddenly, it dawns on you: the old pirate's treasure might be fake.\nHow long are you willing to search? (in hours)");
        //take how long the player will search and makes sure it is not negative
        while(true) {
            searchTime = input.nextInt();
            if (searchTime < 0) {
                System.out.println("How would you do that? Pick again.");
            } else {
                break;
            }
        }
        //if the player searched at least 10 hours, they get treasure; otherwise, no treasure
        if (searchTime >= 10) {
            System.out.println("After 10 hours of shoveling, you find a worn, old treasure chest.\nGrabbing it out of the sand, you are surprised to find no lock.");
            System.out.println("You open the treasure chest to find ...\nGold beyond your wildest imagination.");
            theEnd("Treasure Ending");
        } else {
            System.out.println("You give up on this hunt.\nPerhaps there was no treasure after all, and the map was there to torment you.");
            System.out.println("You drop your shovel and lie helpless on the beach.\nSlowly, you close your eyes.");
            theEnd("Surrender Ending");
        }
    }
    //lets the player make a decision out of 2 options
    public static char decision(String a, String b) {
        //initialize scanner
        Scanner input = new Scanner(System.in);
        //display what the choice is
        System.out.println("\nWill you:\nA. " + a + "\nB. " + b);
        while(true) {
            String choice = input.nextLine();
            //returns what the player chose or asks again if invalid
            if (choice.equals("a") || choice.equals("A")) {
                return 'a';
            } else if (choice.equals("b") || choice.equals("B")) {
                return 'b';
            } else {
                System.out.println("Please answer with the letter A or B.");
            }
        }
    }
    //lets the player make a decision out of 3 options
    public static char decision(String a, String b, String c) {
        //initialize scanner
        Scanner input = new Scanner(System.in);
        //display what the choice is
        System.out.println("\nWill you:\nA. " + a + "\nB. " + b + "\nC. " + c);
        while(true) {
            String choice = input.nextLine();
            //returns what the player chose or asks again if invalid
            if (choice.equals("a") || choice.equals("A")) {
                return 'a';
            } else if (choice.equals("b") || choice.equals("B")) {
                return 'b';
            } else if (choice.equals("c") || choice.equals("C")) {
                return 'c';
            } else {
                System.out.println("Please answer with the letter A, B, or C.");
            }
        }
    }
    //prints the player's grave engraving (buh dum tiss)
    public static void tombstone(String name, int age) {
        System.out.println("You brush the dust off of the headstone.\nThe engraving reads the following:\n");
            System.out.println("--- Here Lies " + name + " ---");
            System.out.println("--- " + (2026 - age) + " - 2026 ---");
            System.out.println("--- Died just as they lived ---");
            System.out.println("--- Fighting what needs not be fought ---");
            theEnd("Death Ending");
    }
    //prints ending message
    public static void theEnd(String title) {
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("[    T H E     E N D    ]");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("\n    " + title);
    }
    //shouldn't be able to be accessed
    public static void impossible() {
        System.out.println("It appears you broke reality.\n Oh well ...");
        theEnd("Impossible Ending");
    }
}
