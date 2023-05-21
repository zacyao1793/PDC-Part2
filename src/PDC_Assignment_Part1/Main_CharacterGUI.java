/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDC_Assignment_Part1;


/**
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

public class Main_CharacterGUI {
    private JFrame frame;
    private JComboBox<String> raceComboBox;
    private JComboBox<String> careerComboBox;
    private JButton createButton;
    private JButton printToFileButton;
    private JTextArea resultTextArea;
    private JLabel backgroundLabel;

    public Main_CharacterGUI() {
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
                new Main_CharacterGUI();
            }
        });
    }
}
**/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class Main_CharacterGUI {
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JButton nextButton;
    private JComboBox<String> raceComboBox;
    private JComboBox<String> careerComboBox;
    private JTextArea resultTextArea;
    private CharacterAttributes character;
    private String url = "jdbc:derby://localhost:1527/characterDB;user=pdc;password=pdc";
    private JTextArea storyTextArea;
    
    
    public Main_CharacterGUI() {
        frame = new JFrame("Elder Ring 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create the CardLayout and the cardPanel.
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Create the panels for each step.
        JPanel racePanel = createRacePanel();
        JPanel careerPanel = createCareerPanel();
        JPanel finalPanel = createFinalPanel();

        // Add the panels to cardPanel.
        cardPanel.add(racePanel, "RacePanel");
        cardPanel.add(careerPanel, "CareerPanel");
        cardPanel.add(finalPanel, "FinalPanel");

        // Add the cardPanel to the frame.
        frame.add(cardPanel);

        frame.setVisible(true);
        
      
    }

    private JPanel createRacePanel() {
        JPanel panel = new JPanel();
        //panel.setBackground(Color.BLACK);
        
        
        
        // Create the race selection components.
        JLabel raceLabel = new JLabel("Race:");
        raceComboBox = new JComboBox<>(new String[]{"Mortal", "Deepkin", "Feymour", "Draconian", "Celestial"});

        // Create a button to go to the next panel.
        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String race = (String) raceComboBox.getSelectedItem();
                character = CharacterCreation.createCharacterAttributes(race, 0, 0, 0, 0);
                character.applyRaceModifiers(race);
                cardLayout.show(cardPanel, "CareerPanel");
            }
        });

        // Add the components to the panel.
        panel.add(raceLabel);
        panel.add(raceComboBox);
        panel.add(nextButton);

        storyTextArea = new JTextArea(10, 40);
        storyTextArea.setText("\"Greetings, traveler. Before we proceed, tell me, which of these forms will your soul inhabit?\n"
                
                + "Will you be a mortal, one of the Deepkin who dwell beneath the waves, \n"
                + "or perhaps a Feymour, touched by the magic of the faerie realms? \n"
                + "Alternatively, will you take on the form of a Draconian, with scales as hard as steel, \n"
                + "or a Celestial, born of the stars themselves?\"");
        storyTextArea.setEditable(false);
       

        panel.add(storyTextArea);

        return panel;
    }

    private JPanel createCareerPanel() {
        JPanel panel = new JPanel();
        //panel.setBackground(Color.BLACK);
        // Create the career selection components.
        JLabel careerLabel = new JLabel("Career:");
        careerComboBox = new JComboBox<>(new String[]{"Vagabond", "Ronin", "Pagan", "Spellblade", "Witch Hunter"});

        // Create a button to go to the next panel.
        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String career = (String) careerComboBox.getSelectedItem();
                character.applyCareerModifiers(career);
                resultTextArea.setText("Race: " + character.getRace() + "\n" +
                        "Career: " + career + "\n" +
                        "Strength: " + character.getStrength() + "\n" +
                        "Dexterity: " + character.getDexterity() + "\n" +
                        "Intelligence: " + character.getIntelligence() + "\n" +
                        "Faith: " + character.getFaith());
                cardLayout.show(cardPanel, "FinalPanel");
                
               
            }
        });

        // Add the components to the panel.
        panel.add(careerLabel);
        panel.add(careerComboBox);
        panel.add(nextButton);
        
        JTextArea storyTextAreaCareer = new JTextArea(10, 40);
        storyTextAreaCareer.setText("\"Your journey begins now, traveler. Before we face the trials ahead, tell me, \n"
                + "what calling has your soul heard? Will you wander as a Vagabond, seeking adventure in every corner of the land? \n"
                + "Will you serve as a Ronin, a masterless samurai seeking redemption? \n"
                + "Perhaps you are a Pagan, attuned to the spirits of the earth and sky. \n"
                + "Or will you harness both magic and steel as a Spellblade? \n"
                + "Maybe you have taken the mantle of a Witch Hunter, sworn to protect the realms from the dark forces that threaten them. \n"
                + "Choose your path wisely, for it will determine your fate.\"");
        
        storyTextAreaCareer.setEditable(false);
      

        panel.add(storyTextAreaCareer);
        
        return panel;
    }

    private JPanel createFinalPanel() {
        JPanel panel = new JPanel();
        //panel.setBackground(Color.BLACK);
        // Create the result text area.
        resultTextArea = new JTextArea(10, 40);
        resultTextArea.setEditable(false);

        
        
        
        JTextArea storyTextAreaFinal = new JTextArea(10, 40);
                storyTextAreaFinal.setText( "Your soul has found its vessel, and your journey has begun, adventurer. \n"
                    + "You have chosen your calling and your fate is now intertwined with the fabric of this world. \n"
                    + "May your footsteps be guided by the light of your convictions, \n"
                    + "and your blade strike true against the darkness that threatens us all. ");
                
                storyTextAreaFinal.setEditable(false);
                
                panel.add(storyTextAreaFinal);
                
        // Create a button to print to file.
        JButton printToFileButton = new JButton("Print to File");
        printToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveCharacterToFile(character);
                saveCharacterToDatabase(character);
            }
        });

        // Add the components to the panel.
        panel.add(resultTextArea);
        panel.add(printToFileButton);
    
       
        
        return panel;
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
    }

    private void saveCharacterToDatabase(CharacterAttributes character) {
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
                new Main_CharacterGUI();
            }
        });
    }
}
