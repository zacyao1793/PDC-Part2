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

//Mortal class recive all the variables and functions from the "CharacterAttributes" class
public class Mortal extends CharacterAttributes {
//Constructor
    public Mortal(int strength, int dexterity, int intelligence, int faith) {
//I would like to modify instance variables instead of local variables
        this.race = "Mortal";
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.faith = faith;
    }

//This function override the display() function declared in the "CharacterAttributes" class, it displays the stats of the 
//variables "race", "strength", "dexterity", "intelligence" and "faith"
    public void display() {
        System.out.println("Race: " + race);
        switch (career) {
        case "Vagabond":
            System.out.println("Career: Vagabond");
            break;
        case "Ronin":
            System.out.println("Career: Ronin");
            break;
        case "Pagan":
            System.out.println("Career: Pagan");
            break;
        case "Spellblade":
            System.out.println("Career: Spellblade");
            break;
        case "Witch Hunter":
            System.out.println("Career: Witch Hunter");
            break;
    }
        //System.out.println("Career: " + career);
        System.out.println("Strength: " + strength);
        System.out.println("Dexterity: " + dexterity);
        System.out.println("Intelligence: " + intelligence);
        System.out.println("Faith: " + faith);
    }
}

