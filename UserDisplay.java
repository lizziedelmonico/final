import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

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
    GameScreenHandler gameScreenHandler = new GameScreenHandler();
    JFrame mainFrame;
    JFrame tributeFrame;
    JButton exitButton;
    JPanel exitPanel;
    JLabel displayField;
    ImageIcon image;
    JPanel choice3Panel;
    JButton choice3;
    JPanel tributePanel;
    JLabel imageLab;
    JFrame killFrame;
    JPanel killPanel;
    JLabel killLabel;


    public static void main(String[] args){
        new UserDisplay();
    }

    public UserDisplay(){
        //creates new JFrame 
        window = new JFrame();
        // sets the size of the visual window (the integers represent number of pixels for width and height)
        window.setSize(2000,2000);
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

        //creates new JFrame 
        mainFrame = new JFrame();
        // sets the size of the visual window (the integers represent number of pixels for width and height)
        mainFrame.setSize(2000,2000);
        // creates an exit button to close the window (like the "X" button on google chrome)
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //sets the color of the background (already part of the JFrame package but adds the .Color for you)
        mainFrame.getContentPane().setBackground(Color.WHITE);
        //JFrame has a default layout and the null allows you to customize the look of your window
        mainFrame.setLayout(null);
        //makes the window visible to you (just creating it isn't enough it won't be visible without adding this)
        mainFrame.setVisible(true);
        container = mainFrame.getContentPane();

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(75, 200, 1250, 100);
        mainTextPanel.setBackground(Color.WHITE);
        container.add(mainTextPanel);

        mainTextLabel = new JLabel("WHAT WOULD YOU LIKE TO DO?");
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


        choice1.addActionListener(gameScreenHandler);
        choice1Panel.add(choice1);
       
        choice2Panel = new JPanel();
        choice2Panel.setBounds(800,400,500,100);
        choice2Panel.setBackground(Color.WHITE);

        choice2 = new JButton("ASSESS A SPECIFIC TRIBUTE");
        choice2.setBackground(Color.white);
        choice2.setForeground(Color.black);
        choice2.setFont(normalFont);

        choice2.addActionListener(gameScreenHandler);
        choice2Panel.add(choice2);

        choice3Panel = new JPanel();
        choice3Panel.setBounds(400,600,500,100);
        choice3Panel.setBackground(Color.WHITE);
        choice3 = new JButton("VIEW GAME RESULTS");
        choice3.setBackground(Color.white);
        choice2.setForeground(Color.black);
        choice3.setFont(normalFont);

        choice3.addActionListener(gameScreenHandler);
        choice3Panel.add(choice3);


        //container is like a base where you can add a bunch of different things onto it (buttons, panels, text, etc.) 
        container.add(mainTextPanel);
        container.add(choice1Panel);
        container.add(choice2Panel);
        container.add(choice3Panel);

    }

    public class killScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){
            Main.degree(null);
        }
    }

    public class GameScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){
            tributeScores();
        }
    }

    public class TitleScreenHandler implements ActionListener{
    
        public void actionPerformed(ActionEvent event){
            createGameScreen();
        }
    }

    public void tributeScores() {
        //makes the title screen's panels invisible (without this the title screen will block the game screen so you can't see it)
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        mainTextPanel.setVisible(false);
        choice1Panel.setVisible(false);
        choice2Panel.setVisible(false);

        tributeFrame = new JFrame();
        // sets the size of the visual window (the integers represent number of pixels for width and height)
        tributeFrame.setSize(2000,2000);
        // creates an exit button to close the window (like the "X" button on google chrome)
        tributeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //sets the color of the background (already part of the JFrame package but adds the .Color for you)
        tributeFrame.getContentPane().setBackground(Color.WHITE);

        //JFrame has a default layout and the null allows you to customize the look of your window
        tributeFrame.setLayout(null);
        //makes the window visible to you (just creating it isn't enough it won't be visible without adding this)
        tributeFrame.setVisible(true);

        tributePanel = new JPanel();
        tributePanel.setBounds(50, 50, 1250, 900);
        tributePanel.setBackground(Color.WHITE);
        ImageIcon image = new ImageIcon(getClass().getResource("image.png"));
        JLabel imageLab = new JLabel(image);
        tributePanel.add(imageLab);

        container = tributeFrame.getContentPane();
        exitPanel = new JPanel();
        exitPanel.setBounds(450, 700, 500, 100);
        exitPanel.setBackground(Color.WHITE);

        //initializes button (INCLUDES STRING/TEXT)
        exitButton = new JButton("EXIT");
        //sets the color of the button
        exitButton.setBackground(Color.white);
        //sets the color of the words on the button
        exitButton.setForeground(Color.black);
        exitButton.setFont(normalFont);


        exitPanel.add(exitButton);
        exitButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                createGameScreen();
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }

        });

    
        container.add(tributePanel);
        container.add(exitPanel);
        
    }

    public void killCount(){
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        mainTextPanel.setVisible(false);
        choice1Panel.setVisible(false);
        choice2Panel.setVisible(false);
        tributePanel.setVisible(false);
        exitPanel.setVisible(true);

        killFrame = new JFrame();
        killFrame.setSize(2000,2000);
        killFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        killFrame.getContentPane().setBackground(Color.WHITE);

        killFrame.setLayout(null);
        killFrame.setVisible(true);

        killPanel = new JPanel();
        killPanel.setBounds(50, 50, 1250, 900);
        killPanel.setBackground(Color.WHITE);

        killLabel = new JLabel();

    }


}
