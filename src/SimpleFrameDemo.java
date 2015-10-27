// Source: docs.oracle.com
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/* SimpleFrameDemo.java requires no other files. */
public class SimpleFrameDemo {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("FrameDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 300, 150);

        JLabel nameLabel = new JLabel("HELLO THERE! THIS IS JUST A SIMPLE DEMO!");
		frame.add(nameLabel);
        
        //Display the window
        frame.pack(); //Despite the frame dimensions (300x150 above), window is tightly packed
        // comment and uncomment the above line to see what "pack()" does!
        frame.setLocationRelativeTo(null); //center it
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}