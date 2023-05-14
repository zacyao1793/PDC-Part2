/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDC_Assignment_Part1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CharacterGUI {
    private JFrame frame;
    private JComboBox<String> raceComboBox;
    private JComboBox<String> careerComboBox;
    private JButton createButton;
    private JButton printToFileButton;
    private JTextArea resultTextArea;
    private JLabel backgroundLabel;

    public CharacterGUI() {
        frame = new JFrame("Elder Ring 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new FlowLayout());

        // Background image
        ImageIcon backgroundIcon = new ImageIcon("your_background_image_path_here");
        backgroundLabel = new JLabel(backgroundIcon);
        frame.setContentPane(backgroundLabel);
        frame.setLayout(new FlowLayout());

        // Font
        Font gameFont = new Font("Serif", Font.BOLD, 16);

        // Race ComboBox
        raceComboBox = new JComboBox<>(new String[]{"Mortal", "Deepkin", "Feymour", "Draconian", "Celestial"});
        raceComboBox.setFont(gameFont);
        frame.add(new JLabel("Race:"));
        frame.add(raceComboBox);

        // Career ComboBox
        careerComboBox = new JComboBox<>(new String[]{"Vagabond", "Ronin", "Pagan", "Spellblade", "Witch Hunter"});
        careerComboBox.setFont(gameFont);
        frame.add(new JLabel("Career:"));
        frame.add(careerComboBox);

        // Create Button
        createButton = new JButton("Create Character");
        createButton.setFont(gameFont);
        frame.add(createButton);

        // Print to File Button
        printToFileButton = new JButton("Print to File");
        printToFileButton.setFont(gameFont);
        frame.add(printToFileButton);

        // Result Text Area
        resultTextArea = new JTextArea(10, 40);
        resultTextArea.setEditable(false);
        resultTextArea.setFont(gameFont);
        frame.add(resultTextArea);

        // Button Listeners
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String race = (String) raceComboBox.getSelectedItem();
                String career = (String) careerComboBox.getSelectedItem();

                CharacterAttributes character = CharacterCreation.createCharacterAttributes(race, 0, 0, 0, 0);
                character.applyRaceModifiers(race);
                character.applyCareerModifiers(career);

                // Set the result text to display the character's attributes
                resultTextArea.setText("Race: " + character.getRace() + "\n" +
                        "Career: " + career + "\n" +
                        "Strength: " + character.getStrength() + "\n" +
                        "Dexterity: " + character.getDexterity() + "\n" +
                        "Intelligence: " + character.getIntelligence() + "\n" +
                        "Faith: " + character.getFaith());
            }
        });

        printToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String race = (String) raceComboBox.getSelectedItem();
                String career = (String) careerComboBox.getSelectedItem();

                CharacterAttributes character = CharacterCreation.createCharacterAttributes(race, 0, 0, 0, 0);
                character.applyRaceModifiers(race);
                character.applyCareerModifiers(career);

                // Save character attributes to a file
                saveCharacterToFile(character);
            }
        });

                frame.setVisible(true);
    }

    private void saveCharacterToFile(CharacterAttributes character) {
        String filename = "CharacterStats.txt";
        File file = new File(filename);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Race: " + character.getRace() + "\n");
            writer.write("Career: " + character.getCareer() + "\n");
            writer.write("Strength: " + character.getStrength() + "\n");
            writer.write("Dexterity: " + character.getDexterity() + "\n");
            writer.write("Intelligence: " + character.getIntelligence() + "\n");
            writer.write("Faith: " + character.getFaith() + "\n");
            JOptionPane.showMessageDialog(frame, "Character attributes have been saved to " + filename, "File Saved", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error saving character attributes to file.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
        
        
        String url = "jdbc:derby://localhost:1527/characterDB;user=pdc;password=pdc";

        
         try {
            Connection conn = DriverManager.getConnection(url);
            String sql = "INSERT INTO CHARACTERS(race, career, strength, dexterity, intelligence, faith) VALUES(?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, character.getRace());
            pstmt.setString(2, character.getCareer());
            pstmt.setInt(3, character.getStrength());
            pstmt.setInt(4, character.getDexterity());
            pstmt.setInt(5, character.getIntelligence());
            pstmt.setInt(6, character.getFaith());

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Character attributes have been saved to database.", "Database Updated", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Error saving character attributes to database.", "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CharacterGUI();
            }
        });
    }
}
