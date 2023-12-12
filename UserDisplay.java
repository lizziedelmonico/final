import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class UserDisplay {
    
    JFrame window;
    Container container;
    JPanel titlePanel;
    JLabel titleLabel;
    Font titleFont = new Font("Times New Roman", Font.BOLD, 60);
    Font middleFont = new Font("Times New Roman", Font.PLAIN, 45);
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
    JTextArea nameArea;
    KillScreenHandler killScreenHandler = new KillScreenHandler();
    JButton enter;
    JPanel enterPanel;
    ChosenTributeScreenHandler ctScreenHandler = new ChosenTributeScreenHandler();
    JPanel typePanel;
    JPanel resultPanel;
    JLabel resultLabel;
    JFrame resultFrame;
    JPanel returnPanel;
    JButton returnButton;
    ResultsScreenHandler resultsScreenHandler = new ResultsScreenHandler();
    JFrame gameFrame;
    ImageIcon image2;
    JLabel imageLab2;
    JPanel gamePanel;
    JPanel choice4Panel;
    JButton choice4;
    HomeScreenHandler homeScreenHandler = new HomeScreenHandler();
    
    


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
        Image homeImage = Toolkit.getDefaultToolkit().getImage("titlepic.png");;
        window.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
               super.paintComponent(g);
               g.drawImage(homeImage, 0, 0, null);
            }
         });
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


        window.add(titlePanel);



        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(600, 600, 200, 50);
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

        choice2.addActionListener(killScreenHandler);
        choice2Panel.add(choice2);

        choice3Panel = new JPanel();
        choice3Panel.setBounds(50,600,500,100);
        choice3Panel.setBackground(Color.WHITE);
        choice3 = new JButton("VIEW GAME RESULTS");
        choice3.setBackground(Color.white);
        choice2.setForeground(Color.black);
        choice3.setFont(normalFont);

        choice3.addActionListener(resultsScreenHandler);
        choice3Panel.add(choice3);

        choice4Panel = new JPanel();
        choice4Panel.setBounds(800,600,500,100);
        choice4Panel.setBackground(Color.WHITE);
        choice4 = new JButton("START OVER");
        choice4.setBackground(Color.WHITE);
        choice4.setForeground(Color.black);
        choice4.setFont(normalFont);

        choice4.addActionListener(homeScreenHandler);
        choice4Panel.add(choice4);
        


        //container is like a base where you can add a bunch of different things onto it (buttons, panels, text, etc.) 
        container.add(mainTextPanel);
        container.add(choice1Panel);
        container.add(choice2Panel);
        container.add(choice3Panel);
        container.add(choice4Panel);

    }

    public class HomeScreenHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            main(null);
        }
    }

    public class KillScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){
            killCount();
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

    public class ChosenTributeScreenHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            userResults();
        }
    }

    public class ResultsScreenHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            gameResults();
        }
    }

    public void gameResults(){
        //makes the title screen's panels invisible (without this the title screen will block the game screen so you can't see it)
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        mainTextPanel.setVisible(false);
        choice1Panel.setVisible(false);
        choice2Panel.setVisible(false);
        choice3Panel.setVisible(false);

        gameFrame = new JFrame();
        // sets the size of the visual window (the integers represent number of pixels for width and height)
        gameFrame.setSize(2000,2000);
        // creates an exit button to close the window (like the "X" button on google chrome)
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //sets the color of the background (already part of the JFrame package but adds the .Color for you)
        gameFrame.getContentPane().setBackground(Color.WHITE);

        //JFrame has a default layout and the null allows you to customize the look of your window
        gameFrame.setLayout(null);
        //makes the window visible to you (just creating it isn't enough it won't be visible without adding this)
        gameFrame.setVisible(true);

        gamePanel = new JPanel();
        gamePanel.setBounds(0, 0, 1500, 900);
        gamePanel.setBackground(Color.WHITE);
        ImageIcon image2 = new ImageIcon(getClass().getResource("graphpic.png"));
        JLabel imageLab2 = new JLabel(image2);
        gamePanel.add(imageLab2);

        container = gameFrame.getContentPane();
        exitPanel = new JPanel();
        exitPanel.setBounds(475, 700, 500, 100);
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
        gameFrame.add(gamePanel);
        gameFrame.add(exitPanel);
    
        container.add(gamePanel);
        container.add(exitPanel);

    }


    public void userResults(){
        killPanel.setVisible(false);
        enterPanel.setVisible(false);
        exitPanel.setVisible(false);
        resultFrame = new JFrame();
        resultFrame.setSize(2000,2000);
        resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        resultFrame.getContentPane().setBackground(Color.WHITE);
        resultFrame.setLayout(null);
        resultFrame.setVisible(true);
        String name = nameArea.getText();
        System.out.println(name);
        Integer indvidual = Main.degree(name);
        resultPanel = new JPanel();
        resultPanel.setBounds(200,300,1000,500);
        resultPanel.setBackground(Color.WHITE);
        resultLabel = new JLabel("Here is the number of kills your tribute has: " + indvidual);
        resultLabel.setFont(middleFont);
        resultPanel.setVisible(true);
        resultLabel.setVisible(true);
        returnPanel = new JPanel();
        returnPanel.setBounds(450,700,500,100);
        returnPanel.setBackground(Color.WHITE);
        returnButton = new JButton("RETURN");
        returnButton.setBackground(Color.WHITE);
        returnButton.setFont(normalFont);
        returnPanel.setVisible(true);
        returnButton.setVisible(true);
        returnButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                killCount();
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }

        });
        returnPanel.add(returnButton);
        resultPanel.add(resultLabel);
        resultFrame.add(resultPanel);
        resultFrame.add(returnPanel);
    }

    public void tributeScores() {
        //makes the title screen's panels invisible (without this the title screen will block the game screen so you can't see it)
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        mainTextPanel.setVisible(false);
        choice1Panel.setVisible(false);
        choice2Panel.setVisible(false);
        choice3Panel.setVisible(false);

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
        choice3Panel.setVisible(false);

        killFrame = new JFrame();
        // sets the size of the visual window (the integers represent number of pixels for width and height)
        killFrame.setSize(2000,2000);
        // creates an exit button to close the window (like the "X" button on google chrome)
        killFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //sets the color of the background (already part of the JFrame package but adds the .Color for you)
        killFrame.getContentPane().setBackground(Color.WHITE);

        //JFrame has a default layout and the null allows you to customize the look of your window
        killFrame.setLayout(null);
        //makes the window visible to you (just creating it isn't enough it won't be visible without adding this)
        killFrame.setVisible(true);

        killPanel = new JPanel();
        killPanel.setBounds(400,100, 700, 500);
        killPanel.setBackground(Color.WHITE);
        JLabel killLabel = new JLabel("Which tribute would you like to assess?");
        killLabel.setBackground(Color.WHITE);
        killLabel.setForeground(Color.BLACK);
        killLabel.setFont(normalFont);
        killPanel.add(killLabel);

        killFrame.add(killPanel);

        container = killFrame.getContentPane();
        exitPanel = new JPanel();
        exitPanel.setBounds(450, 500, 500, 100);
        exitPanel.setBackground(Color.WHITE);

        //initializes button (INCLUDES STRING/TEXT)
        exitButton = new JButton("EXIT");
        //sets the color of the button
        exitButton.setBackground(Color.WHITE);
        //sets the color of the words on the button
        exitButton.setForeground(Color.BLACK);
        exitButton.setFont(normalFont);


        exitPanel.add(exitButton);
        killFrame.add(exitPanel);
        exitButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                createGameScreen();
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }

        });

        nameArea = new JTextArea();
        nameArea.setBounds(550,300,200,100);
        nameArea.setBackground(Color.PINK);
        nameArea.setForeground(Color.BLACK);
        nameArea.setFont(normalFont);
      
        enterPanel = new JPanel();
        enterPanel.setBounds(700, 300, 500, 100);
        enterPanel.setBackground(Color.WHITE);
 
 
        //initializes button (INCLUDES STRING/TEXT)
        enter = new JButton("ENTER");
        //sets the color of the button
        enter.setBackground(Color.white);
        //sets the color of the words on the button
        enter.setForeground(Color.black);
        enter.setFont(normalFont);
        enterPanel.add(enter);
        enter.addActionListener(ctScreenHandler);

        killFrame.add(nameArea);
        killFrame.add(enterPanel);
        

    }


}
