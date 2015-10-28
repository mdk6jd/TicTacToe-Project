import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Methods { 
	/*
	 * This is where all of the methods will go for the buttons
	 * The first method below decides what the button will do on click
	 * in this case it opens a new window
	 * 
	 */
	
	public static void newWindowOnClick(JButton b){
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame window = new JFrame();
				JPanel panel = new JPanel();
				panel.setLayout(new GridLayout(3,3,1,1));
				panel.setBackground(Color.black);
				Methods.makeNineButtons(panel);
				window.add(panel);
				window.setSize(400,400);
				window.setLocation(200,200);
				window.setVisible(true);
				
				
			}
			
		});
		
	}
	/*
	 * This method just adds nine buttons to the gridlayout of the jpanel
	 */
	public static void makeNineButtons(JPanel p){
		for(int x =0; x<9; x++){
			JButton b = new JButton("");
			b.setBackground(Color.white);
			p.add(b);
			}
	}

}
