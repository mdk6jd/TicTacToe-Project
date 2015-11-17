import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUIelement {
	public static void main(String[] args) {
		GUIelement.play();
	}


	public static void play() {
		/*
		 * Setting up the jframe and the canvas to put things on
		 */
		JFrame frame = new JFrame();
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(100, 100);
		
		/*
		 * this panel was created to nbe place on top of the j frame and has a
		 * grid layout in a grid of 3 by 3's.
		 */
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		JButton button1 = new JButton("1");
		GridLayout grid = new GridLayout(3, 3, 4, 4);
		panel.setLayout(grid);
		/*
		 * All the buttons were added to the gridnamed and colored to black
		 */
		JButton buttona = new JButton("");
		buttona.setBackground(Color.black);
		buttona.setName("a");
		JButton buttonb = new JButton("");
		buttonb.setBackground(Color.black);
		buttonb.setName("b");
		JButton buttonc = new JButton("");
		buttonc.setBackground(Color.black);
		buttonc.setName("c");
		JButton buttond = new JButton("");
		buttond.setBackground(Color.black);
		buttond.setName("d");
		JButton buttone = new JButton("");
		buttone.setBackground(Color.black);
		buttone.setName("e");
		JButton buttonf = new JButton("");
		buttonf.setBackground(Color.black);
		buttonf.setName("f");
		JButton buttong = new JButton("");
		buttong.setBackground(Color.black);
		buttong.setName("g");
		JButton buttonh = new JButton("");
		buttonh.setBackground(Color.black);
		buttonh.setName("h");
		JButton buttoni = new JButton("");
		JPanel panel2 = new JPanel();
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Methods.reset(frame);
			}
			
		});
		
		JButton close = new JButton("Close");
		panel2.add(reset);
		panel2.add(close);
		close.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		buttoni.setBackground(Color.black);
		buttoni.setName("i");
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
		int count = 0;
		
		Methods.newWindowOnClick(buttona,frame);
		
		
			
		Methods.newWindowOnClick(buttonb,frame);
		Methods.newWindowOnClick(buttonc,frame);
		Methods.newWindowOnClick(buttond,frame);
		Methods.newWindowOnClick(buttone,frame);
		Methods.newWindowOnClick(buttonf,frame);
		Methods.newWindowOnClick(buttong,frame);
		Methods.newWindowOnClick(buttonh,frame);
		Methods.newWindowOnClick(buttoni,frame);

		frame.add(panel);
		frame.add(panel2,BorderLayout.SOUTH);
		frame.setVisible(true);

		
		
	}
		
}
