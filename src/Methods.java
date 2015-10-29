import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class Methods {
	private static ArrayList<JButton> listOButtons = new ArrayList<JButton>();
	
	/*
	 * This is where all of the methods will go for the buttons The first method
	 * below decides what the button will do on click in this case it opens a
	 * new window
	 */

	public static void newWindowOnClick(JButton b) {
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JDialog dialog = new JDialog();
				

				dialog.setLocation(200, 200);
				dialog.setModal(true);
				JPanel panel = new JPanel();
				Methods.makeNineButtons(panel);
				panel.setBackground(Color.white);
				panel.setLayout(new GridLayout(3, 3));
				Methods.playGame();
				dialog.setSize(400, 400);
				dialog.add(panel);
				dialog.setVisible(true);
				
			}

		});

	}

	/*
	 * This method just adds nine buttons to the gridlayout of the jpanel
	 */
	public static void makeNineButtons(JPanel p) {
		
		for (int x = 0; x < 9; x++) {
			JButton b = new JButton("");
			b.setBackground(Color.white);
			p.add(b);
			listOButtons.add(b);
		}
	}
	/*
	 * This is where i'll change the icons on click
	 * for now this is where i will play the game, but this will probably end up being placed
	 * in another class
	 */
	public static void playGame(){
	
		
		for(int x =0; x<listOButtons.size(); x++){
			
			
			
			JButton temp = listOButtons.get(x);
			
			temp.addActionListener(new ActionListener(){
				
				Icon img = new ImageIcon("exes.png");
				int count = 0;
				
				@Override
				public void actionPerformed(ActionEvent e) {
					count++;
					
					if(count>0){
						
						temp.setIcon(img);
						temp.setDisabledIcon(img);
						temp.setEnabled(false);
						
						
					}
					System.out.print(count);
				
					
				}
				
			});
			
			}
		}
	
	

	}

