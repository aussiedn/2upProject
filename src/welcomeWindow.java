import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;

public class welcomeWindow extends JFrame {
    private JPanel mainPanel;
    private JTextField userNameEntryBox;
    private JLabel userName;
    private JRadioButton boldButton;
    private JRadioButton regularContrastRadioButton;
    private JRadioButton regularTextB;
    private JRadioButton highContrastB;
    private JButton FLIPButton;
    private JLabel resultsLabel;
    private JRadioButton headsTailsButton;
    private JRadioButton tailsHeadsButton;
    private JRadioButton headsHeadsB;
    private JRadioButton tailsTailsB;
    private JLabel randomOutcomeLabel;
    private JButton submitB;
    private JLabel winLossPanel;

    public welcomeWindow()
    {
        ImageIcon coinIcon;
        coinIcon = new ImageIcon("tailsCoin.png");
        FLIPButton.setIcon(coinIcon);

        // Make it so only one button can be selected at a time...
        ButtonGroup myGroup = new ButtonGroup();
        myGroup.add(headsTailsButton);
        myGroup.add(tailsHeadsButton);
        myGroup.add(headsHeadsB);
        myGroup.add(tailsTailsB);

        // Make it so user can't select high contrast and regular contrast at the same time...
        ButtonGroup myGroup2 = new ButtonGroup();
        myGroup2.add(regularTextB);
        myGroup2.add(boldButton);

        // Make it so user can't select bold text and regular text at the same time...
        ButtonGroup myGroup3 = new ButtonGroup();
        myGroup3.add(highContrastB);
        myGroup3.add(regularContrastRadioButton);

        // Set the font for my bold and regular font buttons...
        Font myFontBold = new Font("Arial", Font.BOLD, 20  );
        Font myFontReg = new Font("Arial", Font.BOLD, 12  );

        // Setting the properties for the window and making it visable...
        setTitle("2UP Game");
        setContentPane(mainPanel);
        setSize(800,450);
        setLocationRelativeTo(null);
        setResizable (false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // Declaring my Coin so all my methods can get and set it...
        Coin coinFlip = new Coin();

        // The FlipButton Listener which is all so comparing the results
        FLIPButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                {
                String results1 = Main.numberGen();
                String results2 = Main.numberGen();
                randomOutcomeLabel.setText(results1+ " " + results2);
                coinFlip.setFlip(results1 + " " + results2);


                // Setting Booleans so I can compare the results with the selection...
                Boolean headstails = headsTailsButton.isSelected();
                Boolean tailsheads = tailsHeadsButton.isSelected();
                Boolean headsheads = headsHeadsB.isSelected();
                Boolean tailstails = tailsTailsB.isSelected();

                Boolean flipHeadsHeads = false;
                Boolean flipTailsTails = false;
                Boolean flipHeadsTails = false;
                Boolean flipTailsHeads = false;

                // Comparing the selection with the out come with the Booleans, then printing the results to the GUI...
                if(results1.equals("Heads") && results2.equals("Heads")){
                    flipHeadsHeads = true;
                }
                if(headsheads && flipHeadsHeads)
                    winLossPanel.setText("You Win!!");
                if(headsheads && flipHeadsHeads != headsheads)
                    winLossPanel.setText("You lose");

                if(results1.equals("Tails") && results2.equals("Tails")){
                    flipTailsTails = true;
                }
                if(tailstails && flipTailsTails)
                    winLossPanel.setText("You Win!!");
                if(tailstails && flipTailsTails != tailstails)
                    winLossPanel.setText("You lose");

                if(results1.equals("Heads") && results2.equals("Tails")){
                    flipHeadsTails = true;
                }
                if(headstails && flipHeadsTails)
                    winLossPanel.setText("You Win!!");
                if(headstails && flipHeadsTails != headstails)
                    winLossPanel.setText("You lose");

                if(results1.equals("Tails") && results2.equals("Heads")){
                    flipTailsHeads = true;
                }
                if(tailsheads && flipTailsHeads)
                    winLossPanel.setText("You Win!!");
                if(tailsheads && flipTailsHeads != tailsheads)
                    winLossPanel.setText("You lose");

                //Calling my method for writing the results plus all the user entrys to the file after the game has run...
                writeToFile(coinFlip);
            }
        }});
        // My button listeners looking for the users guess and displaying it within the GUI...
        headsTailsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                resultsLabel.setText("You have selected Heads & Tails");
            }
        });
        tailsHeadsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                resultsLabel.setText("You have selected Tails & Heads");
            }
        });
        headsHeadsB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                resultsLabel.setText("You have selected Heads & Heads");
            }
        });
        tailsTailsB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                resultsLabel.setText("You have selected Tails & Tails");
            }
        });
        boldButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // Setting all the elements within my program to go Bold when button is pressed...
                resultsLabel.setFont(myFontBold);
                randomOutcomeLabel.setFont(myFontBold);
                winLossPanel.setFont(myFontBold);
                userName.setFont(myFontBold);
                userNameEntryBox.setFont(myFontBold);
                boldButton.setFont(myFontBold);
                regularTextB.setFont(myFontBold);
                highContrastB.setFont(myFontBold);
                regularContrastRadioButton.setFont(myFontBold);
                headsHeadsB.setFont(myFontBold);
                headsTailsButton.setFont(myFontBold);
                tailsTailsB.setFont(myFontBold);
                tailsHeadsButton.setFont(myFontBold);
                FLIPButton.setFont(myFontBold);
                submitB.setFont(myFontBold);

            }
        });
        regularTextB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // Setting all the elements within my program to go Regular when button is pressed...
                userName.setFont(myFontReg);
                userNameEntryBox.setFont(myFontReg);
                boldButton.setFont(myFontReg);
                regularTextB.setFont(myFontReg);
                highContrastB.setFont(myFontReg);
                regularContrastRadioButton.setFont(myFontReg);
                headsHeadsB.setFont(myFontReg);
                headsTailsButton.setFont(myFontReg);
                tailsTailsB.setFont(myFontReg);
                tailsHeadsButton.setFont(myFontReg);
                FLIPButton.setFont(myFontReg);
                submitB.setFont(myFontReg);
            }
        });
        highContrastB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // Setting the background colour when the button is pressed to change the contrast...
                mainPanel.setBackground(Color.BLACK);
            }
        });
        regularContrastRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // Setting the background colour when the button is pressed to change the contrast...
                mainPanel.setBackground(Color.white);
            }
        });
        userNameEntryBox.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

            // Linking my entryfield with the submit button so it submits the name once the button is pressed
            if (e.getSource() == submitB) {
                userNameEntryBox.getText();
            }

        }});
        submitB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // Display that the name has been submitted within the Gui
                resultsLabel.setText("Name submitted");
            }
        });
    }

    // The method for writing all the user entry and results to my text file
    public void writeToFile(Coin flip)
    {
        try
        {
            FileWriter writeFile = new FileWriter("results.txt",true);
            writeFile.write("\n" + "User: " + userNameEntryBox.getText() +  " |Flip: " + flip.getFlip() + " |User Selection: " + resultsLabel.getText() + " |Win/Loss: " + winLossPanel.getText() );
            writeFile.close();
        }
        catch (IOException e)
        {
            System.out.println("Another bloody error.");
            e.printStackTrace();
        }
    }
}
