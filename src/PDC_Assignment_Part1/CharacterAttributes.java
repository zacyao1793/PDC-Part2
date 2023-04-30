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

//Character is a parent class for different character races for the program
public abstract class CharacterAttributes {
//I want these variables can be accessed by any subclass that inherits from the CharacterAttributes class
    String race;
    String career;
    int strength;
    int dexterity;
    int intelligence;
    int faith;
    
//get and set for above attibutes
    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
    public String getCareer() {
        return career;
    }
    public void setCareer(String career) {
        this.career = career;
    }
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getFaith() {
        return faith;
    }

    public void setFaith(int faith) {
        this.faith = faith;
    }

//This function is for displying final result of user's character stats:

    public abstract void display();
    
    public void applyRaceModifiers(String race) {
    switch (race) {
        case "Mortal":
            strength = 7;
            dexterity = 10;
            intelligence = 8;
            faith = 9;
            break;
        case "Deepkin":
            strength = 14;
            dexterity = 4;
            intelligence = 7;
            faith = 5;
            break;
        case "Feymour":
            strength = 4;
            dexterity = 8;
            intelligence = 15;
            faith = 7;
            break;
        case "Draconian":
            strength = 12;
            dexterity = 11;
            intelligence = 4;
            faith = 2;
            break;
        case "Celestial":
            strength = 5;
            dexterity = 6;
            intelligence = 12;
            faith = 14;
            break;
    }
}

    public void applyCareerModifiers(String career) {
    switch (career) {
        case "Vagabond":
            strength += 8;
            dexterity += 3;
            intelligence += 1;
            faith += 3;
            break;
        case "Ronin":
            strength += 3;
            dexterity += 7;
            intelligence += 3;
            faith += 1;
            break;
        case "Pagan":
            strength += 1;
            dexterity += 2;
            intelligence += 4;
            faith += 10;
            break;
        case "Spellblade":
            strength += 6;
            dexterity += 4;
            intelligence += 9;
            faith += 2;
            break;
        case "Witch Hunter":
            strength += 8;
            dexterity += 9;
            intelligence += 7;
            faith += 3;
            break;
    }
}

}
