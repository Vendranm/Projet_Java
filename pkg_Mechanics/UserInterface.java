package pkg_Mechanics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.image.*;

/**
 * This class implements a simple graphical user interface with a text entry
 * area, a text output area and an optional image.
 * 
 * @author Michael Kolling
 * @version 1.0 (Jan 2003)
 */
public class UserInterface implements ActionListener
{
    private GameEngine engine;
    private JFrame myFrame;
    private JTextField entryField;
    private JTextArea log, timer;
    private JLabel image;
    private JButton boutton1;
    private JButton boutton2;
    private JButton boutton3;
 
    /**
     * Construct a UserInterface. As a parameter, a Game Engine
     * (an object processing and executing the game commands) is
     * needed.
     * 
     * @param gameEngine  The GameEngine object implementing the game logic.
     */
    public UserInterface(GameEngine gameEngine)
    {
        engine = gameEngine;
        createGUI();
    }//UserInterface(GameEngine gameEngine)

    /**
     * Print out some text into the text area.
     */
    public void print(String text)
    {
        log.append(text);
        log.setCaretPosition(log.getDocument().getLength());
    }//print(String text)
    
    public void setTimer(final String pText)
    {
        timer.setText(pText);
    }
    
    /**
     * Print out some text into the text area, followed by a line break.
     */
    public void println(String text)
    {
        log.append(text + "\n");
        log.setCaretPosition(log.getDocument().getLength());
    }//println(String text)

    /**
     * Show an image file in the interface.
     */
    public void showImage(String imageName)
    {
        URL imageURL = this.getClass().getClassLoader().getResource(imageName);
        if(imageURL == null)
            System.out.println("image not found");
        else {
            ImageIcon icon = new ImageIcon(imageURL);
            image.setIcon(icon);
            myFrame.pack();
        }
    }//showImage(String imageName)

    /**
     * Enable or disable input in the input field.
     */
    public void enable(boolean on)
    {
        entryField.setEditable(on);
        if(!on) entryField.getCaret().setBlinkRate(0);
    }//enable(boolean on)

    /**
     * Set up graphical user interface.
     */
    private void createGUI()
    {
        myFrame = new JFrame("Zuul-Bar");
        entryField = new JTextField(34);

        timer = new JTextArea();
        timer.setEditable(false);
        
        log = new JTextArea();
        log.setEditable(false);
        JScrollPane listScroller = new JScrollPane(log);
        listScroller.setPreferredSize(new Dimension(500, 500));
        listScroller.setMinimumSize(new Dimension(200,200));

        JPanel panel = new JPanel();
        image = new JLabel();
        
        panel.setLayout(new BorderLayout());
        panel.add(image, BorderLayout.NORTH);
        panel.add(listScroller, BorderLayout.EAST);
        panel.add(entryField, BorderLayout.SOUTH);
        
        JPanel panelBoutton = new JPanel();
        panelBoutton.setLayout(new GridLayout(4,1));
        
        panelBoutton.add(timer);
                
        boutton1 = new JButton("aide");
        boutton1.addActionListener(this);
        panelBoutton.add(boutton1);
        
        
        boutton2 = new JButton("☝");
        boutton2.addActionListener(this);
        panelBoutton.add(boutton2);

        
        boutton3 = new JButton("boire");
        boutton3.addActionListener(this);
        panelBoutton.add(boutton3);
        
        
        panel.add(panelBoutton, BorderLayout.WEST);
        myFrame.getContentPane().add(panel, BorderLayout.CENTER);

        // add some event listeners to some components
        myFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });

        entryField.addActionListener(this);

        myFrame.pack();
        myFrame.setVisible(true);
        entryField.requestFocus();
    }//createGUI()

    /**
     * Actionlistener interface for entry textfield.
     */
    public void actionPerformed(ActionEvent e) 
    {
        // no need to check the type of action at the moment.
        // there is only one possible action: text entry
        if (e.getActionCommand().equals("aide")) engine.interpretCommand("aide");
        if(e.getActionCommand().equals("soif")) engine.interpretCommand("soif"); 
        else processCommand();
    }//actionPerformed(ActionEvent e)

    /**
     * A command has been entered. Read the command and do whatever is 
     * necessary to process it.
     */
    private void processCommand()
    {
        boolean finished = false;
        String input = entryField.getText();
        entryField.setText("");
        engine.interpretCommand(input);
    }//processCommand()
}//class class UserInterface 
