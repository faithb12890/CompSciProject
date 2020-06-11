
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MainGUI
{
    //the actual thing you see
    static JFrame mainFrame;
    
    //panels for organization(and color)
    static JPanel mainPanel;
    static JPanel buttonPanel;
    static JPanel centerPanel;
    
    //buttons! clickyclicky
    static JButton toStart;
    static JButton toPt1;
    static JButton toScrn3;
    static JButton toPt2;
    static JButton toScrn5;
    static JButton toPzzl;
    static JButton checkAnswers;
    
    //text boxes for the puzzle/end screen entering part
    static JTextField fieldPt1;
    static JTextField fieldPt2;
    
    //label for info
    static JLabel mainLabel;
    
    //background color
    final Color BGCOLOR = new Color(164, 168, 222);

    public static void main(String args[])
    {
        MainGUI guiTime = new MainGUI();
    }
    
    /**
     * So I'm going to note here how the screens work/how the map lays out.
     * 
     * Each screen can lead to those it borders.
     * 
     * Puzzle Part 2             Screen 5           Puzzle Screen
     *  (Screen 4)                                   (Screen 6)
     * 
     * 
     *   Screen 3              Start Screen         Puzzle Part 1
     *                          (Screen 1)           (Screen 2)
     */
    public MainGUI()
    {
        mainFrame = new JFrame();
        mainFrame.setVisible(true);
        mainFrame.setSize(new Dimension(700, 600));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //main panel time- mostly to add a background color, but also for layout
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BGCOLOR);
        mainFrame.add(mainPanel);
        mainFrame.setResizable(false);

        //center panel since that's the only way I can think of to make
        //the text fields at the end not take the whole screen. oh well
        centerPanel = new JPanel(new GridLayout(3,1));
        centerPanel.setBackground(BGCOLOR);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
        //button panel to make the buttons not on top of each other
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(BGCOLOR);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        //gettin that label set up
        mainLabel = new JLabel();
        mainLabel.setBorder(BorderFactory.createEmptyBorder(0,30,0,30));

        //now for the buttons
        toStart = new JButton();
        toPt1 = new JButton();
        toScrn3 = new JButton();
        toPt2 = new JButton();
        toScrn5 = new JButton();
        toPzzl = new JButton();
        checkAnswers = new JButton();
        
        //aaaaaand here's where im adding the ActionListeners to each button
        toStart.addActionListener(new SetScreen1());
        toPt1.addActionListener(new SetScreen2());
        toScrn3.addActionListener(new SetScreen3());
        toPt2.addActionListener(new SetScreen4());
        toScrn5.addActionListener(new SetScreen5());
        toPzzl.addActionListener(new SetScreen6());
        checkAnswers.addActionListener(new SetEndScreen());
        
        //text boxes
        fieldPt1 = new JTextField("part 1 (erase this before typing your answer)");
        fieldPt2 = new JTextField("part 2 (this too)");
        
        //adding all this stuff to the GUI
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        centerPanel.add(mainLabel);
        
        //let's get it started
        startScreen();
    }

    public static void startScreen()
    {
        mainLabel.setText("<html>you enter a clearing surrounded by trees. it's getting dark, and you know that like beasts<br>or something will be here soon. maybe werewolves. oooooo or maybe vampires. that'd be neat.<br>anyway the point is you wanna get out so like, go find a way out. go.</html>");
        toScrn3.setText("go left");
        toScrn5.setText("go forward");
        toPt1.setText("go right");
        buttonPanel.add(toScrn3);
        buttonPanel.add(toScrn5);
        buttonPanel.add(toPt1);
    }

    public static void screen1()
    {
        buttonPanel.removeAll();
        centerPanel.removeAll();
        
        mainLabel.setText("<html>you're back in the first clearing.</html>");
        
        toScrn3.setText("go left");
        toScrn5.setText("go forward");
        toPt1.setText("go right");
        
        centerPanel.add(mainLabel);
        
        buttonPanel.add(toScrn3);
        buttonPanel.add(toScrn5);
        buttonPanel.add(toPt1);
        
        buttonPanel.repaint();
        buttonPanel.revalidate();
        centerPanel.repaint();
        centerPanel.revalidate();
    }

    public static void screen2()
    {
        buttonPanel.removeAll();
        centerPanel.removeAll();
        
        mainLabel.setText("<html>you enter a wooded area with a pedestal in the center. you see this engraved on top:<br><br>part 1<br><br>a->26 z->1<br><br>7 19 18 8<br>18 8<br>26<br>23 9 26 11 11 2<br>20 26 14 22</html>");
        
        toStart.setText("go left");
        toPzzl.setText("go forward");
        
        centerPanel.add(mainLabel);
        
        buttonPanel.add(toStart);
        buttonPanel.add(toPzzl);
        
        buttonPanel.repaint();
        buttonPanel.revalidate();
        centerPanel.repaint();
        centerPanel.revalidate();
    }
    
    public static void screen3()
    {
        buttonPanel.removeAll();
        centerPanel.removeAll();
        
        mainLabel.setText("<html>you enter a fairly densely wooded area. how densely? i mean, maybe like one tree every 5 feet or so idk.<br><br>wait that's really dense. maybe one every 10-15 feet. yeah that sounds better.<br><br><br><br>there's some bushes too.</html>");
        
        toPt2.setText("go forward");
        toStart.setText("go right");
        
        centerPanel.add(mainLabel);
        
        buttonPanel.add(toPt2);
        buttonPanel.add(toStart);
        
        buttonPanel.repaint();
        buttonPanel.revalidate();
        centerPanel.repaint();
        centerPanel.revalidate();
    }
    
    public static void screen4()
    {
        buttonPanel.removeAll();
        centerPanel.removeAll();
        
        mainLabel.setText("<html>you enter a clearing with a pedestal in the center. and by clearing i mean like, clear clear. like you can see the sky because there's a hole in the canopy.<br>anyway, this pedestal is engraved with the following:<br><br>part 2<br>a->m b->n<br>ngf<br>uf'e<br>efuxx<br>m<br>smyq</html>");
        
        toScrn3.setText("go backward");
        toScrn5.setText("go right");
        
        centerPanel.add(mainLabel);
        
        buttonPanel.add(toScrn3);
        buttonPanel.add(toScrn5);
        
        buttonPanel.repaint();
        buttonPanel.revalidate();
        centerPanel.repaint();
        centerPanel.revalidate();
    }
    
     public static void screen5()
    {
        buttonPanel.removeAll();
        centerPanel.removeAll();
        
        mainLabel.setText("<html>it's another wooded area. don't have much to say about it other than that.</html>");
        
        toPt2.setText("go left");
        toStart.setText("go backward");
        toPzzl.setText("go right");
        
        centerPanel.add(mainLabel);
        
        buttonPanel.add(toPt2);
        buttonPanel.add(toStart);
        buttonPanel.add(toPzzl);
        
        buttonPanel.repaint();
        buttonPanel.revalidate();
        centerPanel.repaint();
        centerPanel.revalidate();
    }
    
     public static void screen6()
    {
       buttonPanel.removeAll();
       centerPanel.removeAll();
       
       mainLabel.setText("<html>hey look. a puzzle entry door thingy. enter the things you may or may not have found<br>and you escape or win or whatever</html>");
       
       toScrn5.setText("go left");
       toPt1.setText("go backward");
       checkAnswers.setText("open puzzle entry door");
       
       centerPanel.add(mainLabel);
       centerPanel.add(fieldPt1);
       centerPanel.add(fieldPt2);
       
       buttonPanel.add(toScrn5);
       buttonPanel.add(toPt1);
       buttonPanel.add(checkAnswers);
       
       buttonPanel.repaint();
       buttonPanel.revalidate();
       centerPanel.repaint();
       centerPanel.revalidate();
    }
    
     public static void endScreen()
    {
        String pt1 = fieldPt1.getText();
        String pt2 = fieldPt2.getText();
        if(pt1.equalsIgnoreCase("this is a crappy game") &&
            pt2.equalsIgnoreCase("but it's still a game"))
            {
                buttonPanel.removeAll();
                mainLabel.setText("<html>hey look at you! you did it! i don't have anything else to say. congrats.<br><br><br><br>you can close this window now</html>");
                
            }
        else
            {
                mainLabel.setText("<html>the puzzle entry door thingy doesn't budge. try again. <br><br>(make sure you have apostrophes and spaces where needed)</html>");
            }
    }
}
