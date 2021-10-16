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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.*;



class PrisonersDilemma /* possible extends... */ {
    //...
    JFrame frame;
    JButton goButton, pauseButton;
    JPanel buttons;
    JSlider slider;
    PlayingField playingField;
    int maxX = 450;
    int maxY = 800;
    void buildGUI() {
        SwingUtilities.invokeLater((new Runnable() {
            @Override
            public void run() {
                // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // FlowLayout test = new FlowLayout();
                // buttons.setLayout(test);
                // buttons.add(new JButton("GO"));
                // buttons.add(new JButton("Pause"));
                // buttons.add(new JButton("Reset"));
            //     buttons.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

                playingField = new PlayingField();
                frame = new JFrame("Prisoner's Dilemma");
                frame.add(playingField, BorderLayout.CENTER);
                slider = new JSlider(0, 3, 0);
                frame.add(slider, BorderLayout.SOUTH);
            //     frame.add(buttons, BorderLayout.SOUTH);
                frame.pack();
                frame.setVisible(true);
                }
        } ));
    }
    
    //...
    
    public static void main( String[] a ) {
        (new PrisonersDilemma()).buildGUI();
    }
}
