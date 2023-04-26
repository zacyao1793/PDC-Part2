/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDC_Assignment_Part1;

/**
 *
 * @author Zac Yao
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RPG_Character_Generator {
//The variable cannot be reassigned once it is initialized
    private final Scanner scanner;
//Get user input
    public RPG_Character_Generator(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        System.out.println("------------------Elder Ring 2-----------------");
        System.out.println("\"Greetings, traveler. Before we proceed, tell me, \n"
                + "which of these forms will your soul inhabit? \n"
                + "Will you be a mortal, one of the Deepkin who dwell beneath the waves, \n"
                + "or perhaps a Feymour, touched by the magic of the faerie realms? \n"
                + "Alternatively, will you take on the form of a Draconian, with scales as hard as steel, \n"
                + "or a Celestial, born of the stars themselves?\"");
        
//raceChoice
        System.out.println("1. Mortal");
        System.out.println("2. Deepkin");
        System.out.println("3. Feymour");
        System.out.println("4. Draconian");
        System.out.println("5. Celestial");

//Make sure variables are initialized to null and 0 
        String race = null;
        int strength = 0;
        int dexterity = 0;
        int intelligence = 0;
        int faith = 0;
        int raceChoice;
//The do-while loop is from Chatgpt, I wasn't sure how to run the loop again if user's input is not between 1-5
        
        boolean validInput;

        do {
              validInput = true;
//Where recieve user input between 1-5
              raceChoice = scanner.nextInt();
              scanner.nextLine();

//If input is 1, the raceChoice will be "Mortal" ; 2 will be Deepkin and so on
              switch (raceChoice) {
                  case 1:
//These are the default attributes value for each race
                      race = "Mortal";
                      strength = 7;
                      dexterity = 10;
                      intelligence = 8;
                      faith = 9;
                      break;
                  case 2:
                      race = "Deepkin";
                      strength = 14;
                      dexterity = 4;
                      intelligence = 7;
                      faith = 5;
                      break;
                  case 3:
                      race = "Feymour";
                      strength = 4;
                      dexterity = 8;
                      intelligence = 15;
                      faith = 7;
                      break;
                  case 4:
                      race = "Draconian";
                      strength = 12;
                      dexterity = 11;
                      intelligence = 4;
                      faith = 2;
                      break;
                  case 5:
                      race = "Celestial";
                      strength = 5;
                      dexterity = 6;
                      intelligence = 12;
                      faith = 14;
                      break;
                  default:
//If user input something other than 1-5, it will rerun the loop untill user input between 1-5
                      System.out.println("Your will does not align with the essence of your soul. Choose wisely, traveler.");
                      validInput = false;
                      break;
    }
} while (!validInput);
//Below is my original code
/*
//Where recieve user input (1-5)
        int raceChoice = scanner.nextInt();
        
        scanner.nextLine();
//If input is 1, the raceChoice will be "Mortal"2 will be Deepkin and so on
        switch (raceChoice) {
            case 1:
                race = "Mortal";
//These are the default attributes value for each race
                strength = 7;
                dexterity = 10;
                intelligence = 8;
                faith = 9;
                break;
            case 2:
                race = "Deepkin";
                strength = 14;
                dexterity = 4;
                intelligence = 7;
                faith = 5;
                break;
            case 3:
                race = "Feymour";
                strength = 4;
                dexterity = 8;
                intelligence = 15;
                faith = 7;
                break;
            case 4:
                race = "Draconian";
                strength = 12;
                dexterity = 11;
                intelligence = 4;
                faith = 2;
                break;
             case 5:
                race = "Celestial";
                strength = 5;
                dexterity = 6;
                intelligence = 12;
                faith = 14;
                break;
//If user input something other than 1-5
            default:
                System.out.println("Your will does not align with the essence of your soul. Choose wisely, traveler.");
                break;
        }*/

//careerChoice, similar logic and functions as raceChoice
        System.out.println("\"Your journey begins now, traveler. Before we face the trials ahead, tell me, \n"
                + "what calling has your soul heard? Will you wander as a Vagabond, seeking adventure in every corner of the land? \n"
                + "Will you serve as a Ronin, a masterless samurai seeking redemption? \n"
                + "Perhaps you are a Pagan, attuned to the spirits of the earth and sky. \n"
                + "Or will you harness both magic and steel as a Spellblade? \n"
                + "Maybe you have taken the mantle of a Witch Hunter, sworn to protect the realms from the dark forces that threaten them. \n"
                + "Choose your path wisely, for it will determine your fate.\"");
        
        System.out.println("1. Vagabond");
        System.out.println("2. Ronin");
        System.out.println("3. Pagan");
        System.out.println("4. Spellblade");
        System.out.println("5. Witch Hunter");
//Initialized to null 
        String career = null;

        int careerChoice;
        
        do {
              validInput = true;
//Where recieve user input (1-5)
              careerChoice = scanner.nextInt();
              scanner.nextLine();
//User input from 1-5
        
        switch (careerChoice) {
            case 1:
//Adding these attributes value to the parameters according to which career the user select
                career = "Vagabond";
                strength += 8;
                dexterity += 3;
                intelligence += 1;
                faith += 3;
                break;
            case 2:
                career = "Ronin";
                strength += 3;
                dexterity += 7;
                intelligence += 3;
                faith += 1;
                break;
            case 3:
                career = "Pagan";
                strength += 1;
                dexterity += 2;
                intelligence += 4;
                faith += 10;
                break;
            case 4:
                career = "Spellblade";
                strength += 6;
                dexterity += 4;
                intelligence += 9;
                faith += 2;
                break;
            case 5:
                career = "Witch Hunter";
                strength += 8;
                dexterity += 9;
                intelligence += 7;
                faith += 3;
                break;
            default:
//If user input something other than 1-5
                System.out.println("Your will does not align with the essence of your soul. Choose wisely, traveler.");
                validInput = false;
                break;
        }
} while (!validInput);

//This function creates a new CharacterAttributes object using the createCharacter() function from the CharacterCreation class. 
//The createCharacter() function takes in five arguments which have been assigned values based on the user input.
        CharacterAttributes character = CharacterCreation.createCharacterAttributes(race, strength, dexterity, intelligence, faith);
        System.out.println("Ahhh "+ race + " " + career + ", "+"what a brilliant choose! \n"
                + "Your soul has found its vessel, and your journey has begun, adventurer. \n"
                + "You have chosen your calling and your fate is now intertwined with the fabric of this world. \n"
                + "May your footsteps be guided by the light of your convictions, \n"
                + "and your blade strike true against the darkness that threatens us all. " );
//Call on the character object to display the character stats
        System.out.println("-----------------------------");
        character.display();
        System.out.println("-----------------------------");



//save the output to file
        System.out.println("Do you want to save your character to a file? (Y/N)");
        
//Convert any uppercase characters in the input to lowercase for easier comparison in later code. Not critical.
        String saveChoice = scanner.nextLine().toLowerCase();
//If user input y
        if (saveChoice.equals("y")) {

            System.out.println("Enter the filename to save:");
//Create file name based on user input
            String filename = scanner.nextLine();


//I asked ChatGpt on how do I implement print to file function, I modified the example given by ChatGpt:
/** try (FileWriter writer = new FileWriter(file)) {
            // write data to the file
            writer.write("Hello, world!\n");
            writer.write("This is an example of writing to a file.");

            System.out.println("Data written to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file.");
            e.printStackTrace();
        }
**/
            try (FileWriter writer = new FileWriter(filename)) {
                writer.write(character.getRace() + "\n" + "Strength: " + character.getStrength() + "\n" + "Dexterity: " + character.getDexterity() + "\n" + "Intelligence: " + character.getIntelligence()+ "\n" + "Faith: " + character.getFaith());

                System.out.println("Character saved to " + filename);
            } catch (IOException e) {
                System.out.println("Failed to save character to " + filename);

            }
        }
    }
}