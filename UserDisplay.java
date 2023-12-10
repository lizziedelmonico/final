import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserDisplay {
    
    JFrame window;
    Container container;
    JPanel titlePanel;
    JLabel titleLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 60);
    JPanel startButtonPanel;
    JButton startButton;
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    JPanel mainTextPanel;
    JLabel mainTextLabel;
    TitleScreenHandler titleScreenHandler = new TitleScreenHandler();
    JButton choice1;
    JPanel choice1Panel;
    JPanel choice2Panel;
    JButton choice2;

    public static void main(String[] args){
        new UserDisplay();
    }

    public UserDisplay(){
        //creates new JFrame 
        window = new JFrame();
        // sets the size of the visual window (the integers represent number of pixels for width and height)
        window.setSize(1000,1000);
        // creates an exit button to close the window (like the "X" button on google chrome)
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //sets the color of the background (already part of the JFrame package but adds the .Color for you)
        window.getContentPane().setBackground(Color.WHITE);
        //JFrame has a default layout and the null allows you to customize the look of your window
        window.setLayout(null);
        //makes the window visible to you (just creating it isn't enough it won't be visible without adding this)
        window.setVisible(true);
        container = window.getContentPane();

        //initializes the title panel (the background behind the words, NOT THE ACTUAL WORDS)
        titlePanel = new JPanel();
        //sets the size of the panel and the placement (the first two integers show where the words start in comparison to the x and y axes while the last two are how wide and tall the words will be.)
        titlePanel.setBounds(75, 200, 1250, 100);
        //sets the color of the panel (behind the words)
        titlePanel.setBackground(Color.WHITE);

        //initializes the words of the title (INCLUDES THE STRING OF TEXT)
        titleLabel = new JLabel("Welcome to the 74th Annual Hunger Games");
        //sets the color of the words
        titleLabel.setBackground(Color.BLACK);
        //adds the previously defined font to the words
        titleLabel.setFont(titleFont);

        //puts the words onto the panel
        titlePanel.add(titleLabel);


        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(600, 350, 200, 100);
        startButtonPanel.setBackground(Color.WHITE);

        //initializes button (INCLUDES STRING/TEXT)
        startButton = new JButton("START");
        //sets the color of the button
        startButton.setBackground(Color.white);
        //sets the color of the words on the button
        startButton.setForeground(Color.black);
        startButton.setFont(normalFont);
        startButton.addActionListener(titleScreenHandler);

        startButtonPanel.add(startButton);
       
        //container is like a base where you can add a bunch of different things onto it (buttons, panels, text, etc.) 
        container.add(titlePanel);
        container.add(startButtonPanel);


    }

    public void createGameScreen(){

        //makes the title screen's panels invisible (without this the title screen will block the game screen so you can't see it)
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);


        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(75, 200, 1250, 100);
        mainTextPanel.setBackground(Color.WHITE);
        container.add(mainTextPanel);

        mainTextLabel = new JLabel("WHAT WOULD YOU LIKE TO DO FIRST?");
        mainTextLabel.setBackground(Color.WHITE);
        mainTextLabel.setForeground(Color.BLACK);
        mainTextLabel.setFont(normalFont);
        mainTextPanel.add(mainTextLabel);

        choice1Panel = new JPanel();
        choice1Panel.setBounds(50, 400, 500, 100);
        choice1Panel.setBackground(Color.WHITE);

        //initializes button (INCLUDES STRING/TEXT)
        choice1 = new JButton("VIEW TRIBUTE SCORES");
        //sets the color of the button
        choice1.setBackground(Color.white);
        //sets the color of the words on the button
        choice1.setForeground(Color.black);
        choice1.setFont(normalFont);
        choice1.addActionListener(titleScreenHandler);

        choice1Panel.add(choice1);
       
        //container is like a base where you can add a bunch of different things onto it (buttons, panels, text, etc.) 
        container.add(mainTextPanel);
        container.add(choice1Panel);


        

    }

    public class TitleScreenHandler implements ActionListener{
    
        public void actionPerformed(ActionEvent event){
            createGameScreen();
        }
    }

}
