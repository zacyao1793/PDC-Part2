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
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RPG_Character_Generator RPG_Character_GeneratorMenu = new RPG_Character_Generator(scanner);

        RPG_Character_GeneratorMenu.run();
    }
}
