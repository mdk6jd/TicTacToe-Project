import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Methods {
	private static ArrayList<JButton> listOButtons = new ArrayList<JButton>();
	private static JPanel pan = new JPanel();
	private static JDialog dia = new JDialog();
	protected static int checkforwin = 0;
	private static JButton mainButtons;
	private static JFrame mainFrame;
	private static ArrayList<String> mainChecksX = new ArrayList<String>();
	private static ArrayList<String> mainChecksO = new ArrayList<String>();

	/*
	 * This is where all of the methods will go for the buttons The first method
	 * below decides what the button will do on click in this case it opens a
	 * new window
	 */

	public static void newWindowOnClick(JButton b, JFrame j) {

		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainButtons = b;
				mainFrame = j;

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
				Icon img3 = new ImageIcon("mainexes.png");
				Icon img4 = new ImageIcon("mainos.png");

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
						pan.removeAll();
						pan.updateUI();
						posx.clear();
						poso.clear();
						listOButtons.clear();
						dia.dispose();
						mainButtons.setIcon(img3);
						mainButtons.setDisabledIcon(img3);
						mainButtons.setEnabled(false);
						mainChecksX.add(mainButtons.getName());
						Methods.mainWinStatus();
						posx.clear();
						poso.clear();
						// JDialog dialog = new JDialog();
						// dialog.setSize(160, 160);
						// JLabel winstatus = new JLabel();
						// winstatus.setText("It seems the X's have won!");
						// winstatus.setHorizontalAlignment(SwingConstants.CENTER);
						// dialog.add(winstatus);
						// dialog.addWindowListener(new WindowAdapter() {
						// public void windowClosing(WindowEvent e) {
						// pan.removeAll();
						// pan.updateUI();
						// posx.clear();
						// poso.clear();
						// listOButtons.clear();
						// dia.dispose();
						// mainButtons.setIcon(img3);
						// mainButtons.setDisabledIcon(img3);
						// mainButtons.setEnabled(false);
						// mainChecksX.add(mainButtons.getName());
						// Methods.mainWinStatus();
						// }
						// });
						// posx.clear();
						// poso.clear();
						//
						// dialog.setModal(true);
						// dialog.setVisible(true);
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
						pan.removeAll();
						pan.updateUI();
						posx.clear();
						poso.clear();
						listOButtons.clear();
						dia.dispose();
						mainButtons.setIcon(img4);
						mainButtons.setDisabledIcon(img4);
						mainButtons.setEnabled(false);
						mainChecksO.add(mainButtons.getName());
						Methods.mainWinStatus();
						posx.clear();
						poso.clear();

						// JDialog dialog = new JDialog();
						// dialog.setSize(200, 100);
						// dialog.setLocation(160,160);
						// JLabel winstatus = new JLabel();
						// winstatus.setText("It seems the O's have won!");
						// winstatus.setHorizontalAlignment(SwingConstants.CENTER);
						// dialog.add(winstatus);
						// dialog.addWindowListener(new WindowAdapter() {
						// public void windowClosing(WindowEvent e) {
						// pan.removeAll();
						// pan.updateUI();
						// posx.clear();
						// poso.clear();
						// listOButtons.clear();
						// dia.dispose();
						// mainButtons.setIcon(img4);
						// mainButtons.setDisabledIcon(img4);
						// mainButtons.setEnabled(false);
						// mainChecksO.add(mainButtons.getName());
						// Methods.mainWinStatus();
						//
						// }
						// });
						// posx.clear();
						// poso.clear();
						//
						// dialog.setModal(true);
						// dialog.setVisible(true);

						count = 1;

					} else if (posx.size() == 4 && poso.size() == 5
							|| poso.size() == 4 && posx.size() == 5) {
											JDialog dialog = new JDialog();
							dialog.setLayout(new GridLayout(2, 2));
							JButton replay = new JButton("Replay");
							JButton guess = new JButton("Play Guess the Number");
							dialog.setSize(500, 200);
							dialog.getContentPane().setBackground(Color.green);
							JLabel winstatus = new JLabel();
							JLabel question = new JLabel();
							Font csans = new Font("Helvetica", 15, 15);
							question.setFont(csans);
							question.setText("replay or play my guessing game?");
							question.setHorizontalAlignment(SwingConstants.CENTER);
							winstatus.setFont(csans);
							winstatus.setText("It seems it's a tie! Would you like to:");
							winstatus.setHorizontalAlignment(SwingConstants.CENTER);
							dialog.add(winstatus);
							dialog.add(question);
							dialog.add(replay);
							dialog.add(guess);
							dialog.setLocationRelativeTo(mainFrame);
							replay.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent arg0) {
									dialog.dispose();
									posx.clear();
									poso.clear();
									pan.removeAll();
									pan.updateUI();
									listOButtons.clear();
									dia.dispose();
								}
							});
	
							guess.addActionListener(new ActionListener() {
	
								@Override
								public void actionPerformed(ActionEvent e) {
									dialog.dispose();
									JDialog tieDialog = new JDialog();
									tieDialog.setSize(200, 200);
									tieDialog.setLocation(200, 200);
									JPanel tiePanel = new JPanel();
	
									boolean status = true;
									while (status) {
										String xNumber = (String) JOptionPane
												.showInputDialog("Player X, guess a number 1-10:");
										String oNumber = (String) JOptionPane
												.showInputDialog("Player O, guess a number 1-10:");
	
										Random randomGenerator = new Random();
										int randomInt = randomGenerator.nextInt(100);
										int intXNumber = Integer.parseInt(xNumber);
										int intONumber = Integer.parseInt(oNumber);
										int xDifference = randomInt - intXNumber;
										int oDifference = randomInt - intONumber;
	
										if (Math.abs(xDifference) > Math.abs(oDifference)) {
											pan.removeAll();
											pan.updateUI();
											posx.clear();
											poso.clear();
											listOButtons.clear();
											dia.dispose();
											mainButtons.setIcon(img4);
											mainButtons.setDisabledIcon(img4);
											mainButtons.setEnabled(false);
											mainChecksO.add(mainButtons.getName());
											Methods.mainWinStatus();
											posx.clear();
											poso.clear();
											count = 1;
											status = false;
										} else if (Math.abs(xDifference) < Math.abs(oDifference)) {
											pan.removeAll();
											pan.updateUI();
											posx.clear();
											poso.clear();
											listOButtons.clear();
											dia.dispose();
											mainButtons.setIcon(img3);
											mainButtons.setDisabledIcon(img3);
											mainButtons.setEnabled(false);
											mainChecksX.add(mainButtons.getName());
											Methods.mainWinStatus();
											posx.clear();
											poso.clear();
											count = 0;
											status = false;
										}
	
									}
								}
	
							});
							dialog.setModal(true);
							dialog.setVisible(true);
							count = 1;
						}
	
					}
	
				});
	
			}

					}

				}

			});

		}

	}

	public static void closeDialog4Win(JDialog d) {
		d.dispose();

	}

	public static void mainWinStatus() {
		if (!mainButtons.isEnabled()) {
			if ((mainChecksX.contains("a") && mainChecksX.contains("b") && mainChecksX
					.contains("c"))
					|| (mainChecksX.contains("a") && mainChecksX.contains("e") && mainChecksX
							.contains("i"))
					|| (mainChecksX.contains("a") && mainChecksX.contains("d") && mainChecksX
							.contains("g"))
					|| (mainChecksX.contains("b") && mainChecksX.contains("e") && mainChecksX
							.contains("h"))
					|| (mainChecksX.contains("c") && mainChecksX.contains("e") && mainChecksX
							.contains("g"))
					|| (mainChecksX.contains("c") && mainChecksX.contains("f") && mainChecksX
							.contains("i"))
					|| (mainChecksX.contains("d") && mainChecksX.contains("e") && mainChecksX
							.contains("f"))
					|| (mainChecksX.contains("g") && mainChecksX.contains("h") && mainChecksX
							.contains("i"))) {
				JDialog winDialog = new JDialog();
				winDialog.setSize(200, 100);
				winDialog.setLocation(160, 160);
				JPanel pane = new JPanel();
				pane.setBackground(Color.LIGHT_GRAY);
				JLabel label = new JLabel("X's WIN");
				label.setForeground(Color.DARK_GRAY);

				label.setFont(new Font("Helvetica", Font.PLAIN, 27));

				pane.add(label);
				winDialog.add(pane);

				winDialog.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						// System.out.println("YOOOOO");
						mainChecksX.clear();
						mainChecksO.clear();
						mainFrame.removeAll();
						mainFrame.repaint();
						mainFrame.dispose();
						GUIelement.play();

					}
				});
				winDialog.setModal(true);
				winDialog.setVisible(true);
			} else if ((mainChecksO.contains("a") && mainChecksO.contains("b") && mainChecksO
					.contains("c"))
					|| (mainChecksO.contains("a") && mainChecksO.contains("e") && mainChecksO
							.contains("i"))
					|| (mainChecksO.contains("a") && mainChecksO.contains("d") && mainChecksO
							.contains("g"))
					|| (mainChecksO.contains("b") && mainChecksO.contains("e") && mainChecksO
							.contains("h"))
					|| (mainChecksO.contains("c") && mainChecksO.contains("e") && mainChecksO
							.contains("g"))
					|| (mainChecksO.contains("c") && mainChecksO.contains("f") && mainChecksO
							.contains("i"))
					|| (mainChecksO.contains("d") && mainChecksO.contains("e") && mainChecksO
							.contains("f"))
					|| (mainChecksO.contains("g") && mainChecksO.contains("h") && mainChecksO
							.contains("i"))) {
				JDialog winDialog = new JDialog();
				winDialog.setSize(200, 100);
				winDialog.setLocation(160, 160);
				JPanel pane = new JPanel();
				pane.setBackground(Color.DARK_GRAY);
				JLabel label = new JLabel("O's WIN!");
				label.setFont(new Font("Tahoma", Font.PLAIN, 27));
				label.setForeground(Color.white);
				pane.add(label);
				winDialog.add(pane);

				winDialog.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {

						mainChecksX.clear();
						mainChecksO.clear();
						mainFrame.removeAll();
						mainFrame.repaint();
						mainFrame.dispose();
						GUIelement.play();

					}
				});
				winDialog.setModal(true);
				winDialog.setVisible(true);
			} else if (mainChecksX.size() == 4 && mainChecksO.size() == 5
					|| mainChecksO.size() == 4 && mainChecksX.size() == 5) {
				// tie situation
				
				JDialog tieDialog = new JDialog();
				tieDialog.setSize(200, 200);
				tieDialog.setLocation(200, 200);
				JPanel tiePanel = new JPanel();

				boolean status = true;
				while (status) {
					JOptionPane xGuess = new JOptionPane();
					String xNumber = (String) JOptionPane
							.showInputDialog("It's a Tie! \n X: Pick a number between 1 and 100");
					JOptionPane oGuess = new JOptionPane();
					String oNumber = (String) JOptionPane
							.showInputDialog("O: Pick a number between 1 and 100");

					Random randomGenerator = new Random();
					int randomInt = randomGenerator.nextInt(100);
					int intXNumber = Integer.parseInt(xNumber);
					int intONumber = Integer.parseInt(oNumber);
					int xDifference = randomInt - intXNumber;
					int oDifference = randomInt - intONumber;

					if (Math.abs(xDifference) > Math.abs(oDifference)) {
						ImageIcon img = new ImageIcon("ofinalwin.jpg");
						JLabel winDialog = new JLabel();
						winDialog.setIcon(img);
						winDialog.setVisible(true);
						JFrame f = new JFrame();
						f.add(winDialog);
						f.setSize(400, 500);
						f.setVisible(true);
						status = false;
					} else if (Math.abs(xDifference) < Math.abs(oDifference)) {
						ImageIcon img = new ImageIcon("xfinalwin.jpg");
						JLabel winDialog = new JLabel();
						winDialog.setIcon(img);
						winDialog.setVisible(true);
						JFrame f = new JFrame();
						f.add(winDialog);
						f.setSize(400, 500);
						f.setVisible(true);
						status = false;
					}
				}
			}
		}
	}

	// public static void explosion() throws MalformedURLException {
	//
	// URL url = new
	// URL("https://www.giphy.com/gifs/explosion-nuclear-12KiGLydHEdak8");
	// Icon icon = new ImageIcon(url);
	// JLabel label = new JLabel(icon);
	//
	// JFrame f = new JFrame("Animation");
	// f.getContentPane().add(label);
	// f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// f.pack();
	// f.setLocationRelativeTo(null);
	// f.setVisible(true);
	//
	// }

}
