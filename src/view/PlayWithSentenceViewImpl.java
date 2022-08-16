package view;

import controller.Features;

import javax.swing.*;
import java.awt.*;
import java.util.NoSuchElementException;


/**
 * A class that implement the PlayWithSentenceView
 */
public class PlayWithSentenceViewImpl extends JFrame implements PlayWithSentenceView {

    private JLabel topLabel,display;
    private JTextField input;
    private JButton submitButton, pigLatinButton, exitButton;
    private JPanel panel1,panel2;
    private JPanel insidePanel1,insidePanel2;
    private JTextField pigLatinOutput;
    private JLabel countLabel, longestLabel, popularLabel,countOutput, longestOutput, popularOutput;

    /**
     * Initialize a PlayWithSentenceViewImpl object
     * @param caption
     */
    public PlayWithSentenceViewImpl(String caption){
        super(caption);
    }

    @Override
    public void start(){
        initializeWindow();
    }

    /**
     * A helper method to set and initialize the window.
     * It sets all the panels, labels, text field and layout of the frame.
     * The frame is a GridLayout. It is seperated by three parts:
     * The first part is the title label-->showing the title of the game
     * The second part is the input and show the result part when user clicks "submit"
     * The third part is the textField that show the result of pigLatin
     */
    private void initializeWindow(){
        this.setSize(800,800);
        this.setLocation(400,400);
        this.setMinimumSize(new Dimension(600,600));
        this.getContentPane().setBackground(Color.pink);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3,1));

        //Top area--->the title
        topLabel = new JLabel("Let's play with Sentence!");
        topLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topLabel.setFont(new java.awt.Font(Font.DIALOG,1,36));
        topLabel.setForeground(Color.GRAY);
        this.add(topLabel);

        //middle area-->a panel contains buttons, text fields and labels
        panel1 = new JPanel(new GridLayout(3,1));
        this.add(panel1);
        insidePanel1 = new JPanel(new FlowLayout());
        display = new JLabel("Enter a sentence:");
        display.setHorizontalAlignment(SwingConstants.CENTER);
        display.setFont(new java.awt.Font(Font.DIALOG,1,18));
        panel1.add(display);
        panel1.add(insidePanel1);

        //the textfield
        input = new JTextField(20);
        input.setFont(new Font("Serif",Font.BOLD,26));
        insidePanel1.add(input);

        //submitButton
        submitButton = new JButton("Submit");
        submitButton.setActionCommand("Submit");
        submitButton.setBackground(Color.white);
        submitButton.setForeground(Color.decode("#865858"));
        insidePanel1.add(submitButton);

        insidePanel2 = new JPanel(new GridLayout(2,3));
        panel1.add(insidePanel2);
        countLabel = new JLabel("The count of words:");
        countLabel.setHorizontalAlignment(SwingConstants.CENTER);
        countOutput = new JLabel();
        countOutput.setHorizontalAlignment(SwingConstants.CENTER);
        longestLabel = new JLabel("The longest word:");
        longestLabel.setHorizontalAlignment(SwingConstants.CENTER);
        longestOutput = new JLabel();
        longestOutput.setHorizontalAlignment(SwingConstants.CENTER);
        popularLabel = new JLabel("The most popular letter:");
        popularLabel.setHorizontalAlignment(SwingConstants.CENTER);
        popularOutput = new JLabel();
        popularOutput.setHorizontalAlignment(SwingConstants.CENTER);
        insidePanel2.add(countLabel);
        insidePanel2.add(longestLabel);
        insidePanel2.add(popularLabel);
        insidePanel2.add(countOutput);
        insidePanel2.add(longestOutput);
        insidePanel2.add(popularOutput);


        //the third part of the frame
        panel2 = new JPanel(new GridLayout(2,1));
        this.add(panel2);

        //pigLatinbButton
        pigLatinButton = new JButton("Convert to PigLatin");
        pigLatinButton.setActionCommand("pig Latin");
        pigLatinButton.setBackground(Color.PINK);
        insidePanel1.add(pigLatinButton);

        pigLatinOutput = new JTextField(20);
        pigLatinOutput.setFont(new Font("Serif",Font.BOLD,26));
        panel2.add(pigLatinOutput);


        pack();
        setVisible(true);
    }

    @Override
    public void addFeatures(Features features) throws NoSuchElementException {
        if(input.getText() == null){
            throw new NoSuchElementException("Please enter a sentence!");
        }
        submitButton.addActionListener(evt->features.playSentence(input.getText()));
        pigLatinButton.addActionListener(evt->features.convertPigLatin(input.getText()));
    }

    @Override
    public void setCountOutput(String s){
        countOutput.setText(s);
    }

    @Override
    public void setLongestOutput(String s){
        longestOutput.setText(s);
    }

    @Override
    public void setPopularOutput(String s){
        popularOutput.setText(s);
    }


    @Override
    public void setPigLatinResult(String s){
        pigLatinOutput.setText(s);
    }

}
