package PrisonersDilemma;

/**
 * INCOMPLETE
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * main class
 * 
 * @author FILL IN
 * @author FILL IN
 * assignment group FILL IN
 * 
 * assignment copyright Kees Huizing
 */

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JButton;


class PrisonersDilemma /* possible extends... */ {
    //...
    JFrame frame;
    JButton goButton, pauseButton;
    PlayingField playingField;
    int maxX = 450;
    int maxY = 800;
    void buildGUI() {
        SwingUtilities.invokeLater((new Runnable() {
            @Override
            public void run() {
                playingField = new PlayingField();
                frame = new JFrame("Prisoner's Dilemma");
                frame.add(playingField, BorderLayout.CENTER);
                goButton = new JButton("GO");
                frame.add(goButton, BorderLayout.SOUTH);
                pauseButton = new JButton("PAUSE");
                pauseButton.setBounds(maxX/2, maxY, 30, 20);
                frame.add(pauseButton);
                // regenerateButton.addActionListener(painting); // painting provides reaction to buttonclick
                // frame.add(regenerateButton, BorderLayout.SOUTH);
                // shotButton = new JButton("Screenshot");
                // shotButton.addActionListener(painting);
                // frame.add(shotButton, BorderLayout.NORTH);
                frame.pack();
                // painting.regenerate(); // can be done here since painting has a size!
                frame.setVisible(true);
            }
        } ));
    }
    
    //...
    
    public static void main( String[] a ) {
        (new PrisonersDilemma()).buildGUI();
    }
}
