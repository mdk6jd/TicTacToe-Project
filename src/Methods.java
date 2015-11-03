import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Methods {
	private static ArrayList<JButton> listOButtons = new ArrayList<JButton>();
	private static JPanel pan = new JPanel();
	private static JDialog dia = new JDialog();
	protected static int checkforwin = 0;

	/*
	 * This is where all of the methods will go for the buttons The first method
	 * below decides what the button will do on click in this case it opens a
	 * new window
	 */

	public static void newWindowOnClick(JButton b) {

		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dia.setLocation(200, 200);
				dia.setModal(true);

				Methods.makeNineButtons(pan, dia);
				pan.setBackground(Color.white);
				pan.setLayout(new GridLayout(3, 3));
				Methods.playGame();

				dia.setSize(400, 400);
				dia.add(pan);

				dia.setVisible(true);
				Methods.closeDialog4Win(dia);

			}

		});

	}

	/*
	 * This method just adds nine buttons to the gridlayout of the jpanel
	 */
	public static void makeNineButtons(JPanel p, JDialog d) {

		for (int x = 0; x < 9; x++) {
			JButton b = new JButton("");
			b.setBackground(Color.white);
			p.add(b);
			listOButtons.add(b);

		}
		d.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				p.removeAll();
				p.updateUI();
				listOButtons.clear();
				posx.clear();
				poso.clear();
			}
		});

	}

	protected static int count = 0;
	protected static ArrayList<Integer> poso = new ArrayList<Integer>();
	protected static ArrayList<Integer> posx = new ArrayList<Integer>();

	/*
	 * This is where i'll change the icons on click for now this is where i will
	 * play the game, but this will probably end up being placed in another
	 * class
	 */
	public static void playGame() {

		for (int x = 0; x < listOButtons.size(); x++) {

			JButton temp = listOButtons.get(x);
			int pos = x;

			temp.addActionListener(new ActionListener() {

				Icon img = new ImageIcon("exes.png");
				Icon img2 = new ImageIcon("os.png");

				@Override
				public void actionPerformed(ActionEvent e) {
					count++;

					if (count > 0 && count % 2 != 0) {

						temp.setIcon(img);
						temp.setDisabledIcon(img);
						temp.setEnabled(false);
						posx.add(pos);

					}
					if (count > 0 && count % 2 == 0) {

						temp.setIcon(img);
						temp.setDisabledIcon(img2);
						temp.setEnabled(false);
						poso.add(pos);

					}
					System.out.print(count);
					System.out.println("Position x: " + posx + "Position o: "
							+ poso);

					if ((posx.contains(1) && posx.contains(2) && posx
							.contains(0))
							|| (posx.contains(0) && posx.contains(3) && posx
									.contains(6))
							|| (posx.contains(0) && posx.contains(4) && posx
									.contains(8))
							|| (posx.contains(1) && posx.contains(4) && posx
									.contains(7))
							|| (posx.contains(2) && posx.contains(4) && posx
									.contains(6))
							|| (posx.contains(2) && posx.contains(5) && posx
									.contains(8))
							|| (posx.contains(3) && posx.contains(4) && posx
									.contains(5))
							|| (posx.contains(6) && posx.contains(7) && posx
									.contains(8))) {
						JDialog dialog = new JDialog();
						dialog.setSize(200, 100);
						JLabel winstatus = new JLabel();
						winstatus.setText("It seems the X's have won!");
						winstatus.setHorizontalAlignment(SwingConstants.CENTER);
						dialog.add(winstatus);
						dialog.addWindowListener(new WindowAdapter() {
							public void windowClosing(WindowEvent e) {
								pan.removeAll();
								pan.updateUI();
								posx.clear();
								poso.clear();
								listOButtons.clear();
								dia.dispose();
							}
						});
						posx.clear();
						poso.clear();

						dialog.setModal(true);
						dialog.setVisible(true);
						count = 0;

					} else if ((poso.contains(1) && poso.contains(2) && poso
							.contains(0))
							|| (poso.contains(0) && poso.contains(3) && poso
									.contains(6))
							|| (poso.contains(0) && poso.contains(4) && poso
									.contains(8))
							|| (poso.contains(1) && poso.contains(4) && poso
									.contains(7))
							|| (poso.contains(2) && poso.contains(4) && poso
									.contains(6))
							|| (poso.contains(2) && poso.contains(5) && poso
									.contains(8))
							|| (poso.contains(3) && poso.contains(4) && poso
									.contains(5))
							|| (poso.contains(6) && poso.contains(7) && poso
									.contains(8))) {
						JDialog dialog = new JDialog();
						dialog.setSize(200, 100);
						JLabel winstatus = new JLabel();
						winstatus.setText("It seems the O's have won!");
						winstatus.setHorizontalAlignment(SwingConstants.CENTER);
						dialog.add(winstatus);
						dialog.addWindowListener(new WindowAdapter() {
							public void windowClosing(WindowEvent e) {
								pan.removeAll();
								pan.updateUI();
								posx.clear();
								poso.clear();
								listOButtons.clear();
								dia.dispose();
							}
						});
						posx.clear();
						poso.clear();

						dialog.setModal(true);
						dialog.setVisible(true);
						count = 1;

					} else if (posx.size()==4 && poso.size() ==5 ||poso.size()==4 && posx.size() ==5){
						JDialog dialog = new JDialog();
						dialog.setSize(200, 100);
						JLabel winstatus = new JLabel();
						winstatus.setText("It seems it's a tie!");
						winstatus.setHorizontalAlignment(SwingConstants.CENTER);
						dialog.add(winstatus);
						dialog.addWindowListener(new WindowAdapter() {
							public void windowClosing(WindowEvent e) {
								pan.removeAll();
								pan.updateUI();
								posx.clear();
								poso.clear();
								listOButtons.clear();
								dia.dispose();
							}
						});
						posx.clear();
						poso.clear();

						dialog.setModal(true);
						dialog.setVisible(true);
						count = 1;
					}

				}

			});

		}

	}

	public static void closeDialog4Win(JDialog d) {
		d.dispose();

	}

}

