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

//"CharacterCreation" responsible for creating a character object based on the user's input
//It separates the process of creating characters from "CharacterMenu" class, it is more reusable for further development.
public class CharacterCreation {
//Due to the "CharacterCreation" class does not require any instance variables or functions, 
//instead it creates new instances from "CharacterAttributes" subclasses without requiring instance

    public static CharacterAttributes createCharacterAttributes(String race, int strength, int dexterity, int intelligence, int faith) {
//This function checks the value of the "race" parameter and create a new instance of the appropriate subclass of the "CharactorAttributes" class.
        switch (race) {
//It creates a new instance of the corresponding subclass using the "new" keyword and passes in the "strength", "dexterity", "intelligence", 
//and "faith" parameters. 
            case "Mortal":
//When the input race string matches the value "Mortal", a new Mortal object is created with the given attributes (strength, dexterity, intelligence, faith).
                return new Mortal(strength, dexterity, intelligence, faith);
            case "Deepkin":
                return new Deepkin(strength, dexterity, intelligence, faith);
            case "Feymour":
                return new Feymour(strength, dexterity, intelligence, faith);
            case "Draconian":
                return new Draconian(strength, dexterity, intelligence, faith);
            case "Celestial":
                return new Celestial(strength, dexterity, intelligence, faith);
//Returns null when "race" is not equal to any of the above races
            default:
                return null;
        }
    }
}
    