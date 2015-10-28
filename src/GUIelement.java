import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class GUIelement {
	
	public static void main(String arg[]){
		/*
		 * Setting up the jframe and the canvas to put things on
		 */
		JFrame frame = new JFrame();
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(100, 100);
		/*
		 * this panel was created to be place on top
		 * of the j frame and has a grid layout in a grid of
		 * 3 by 3's.
		 */
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		JButton button1 = new JButton("1");
		GridLayout grid = new GridLayout(3,3,2,2);
		panel.setLayout(grid);
		/*
		 *All the buttons were added to the grid 
		 *named and colored to black
		 */
		JButton buttona = new JButton("");
		buttona.setBackground(Color.black);
		JButton buttonb = new JButton("");
		buttonb.setBackground(Color.black);
		JButton buttonc = new JButton("");
		buttonc.setBackground(Color.black);
		JButton buttond = new JButton("");
		buttond.setBackground(Color.black);
		JButton buttone = new JButton("");
		buttone.setBackground(Color.black);
		JButton buttonf = new JButton("");
		buttonf.setBackground(Color.black);
		JButton buttong = new JButton("");
		buttong.setBackground(Color.black);
		JButton buttonh = new JButton("");
		buttonh.setBackground(Color.black);
		JButton buttoni = new JButton("");
		buttoni.setBackground(Color.black);
		panel.add(buttona);
		panel.add(buttonb);
		panel.add(buttonc);
		panel.add(buttond);
		panel.add(buttone);
		panel.add(buttonf);
		panel.add(buttong);
		panel.add(buttonh);
		panel.add(buttoni);
		/*
		 * For every button clicked a new window will open
		 */
		Methods.newWindowOnClick(buttona);
		Methods.newWindowOnClick(buttonb);
		Methods.newWindowOnClick(buttonc);
		Methods.newWindowOnClick(buttond);
		Methods.newWindowOnClick(buttone);
		Methods.newWindowOnClick(buttonf);
		Methods.newWindowOnClick(buttong);
		Methods.newWindowOnClick(buttonh);
		Methods.newWindowOnClick(buttoni);
		
		
			
		

		
		frame.add(panel);
		
		frame.setVisible(true);
	}
}
