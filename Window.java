import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import java.awt.Dimension;
import java.util.Collection;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Window extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private Team P1;
	private Team P2;
	private Player CurrentPlayer;

	static public Random random = new Random();

	TeamView view = new TeamView(Match.arrayList1, 1200, 300, "Dru¿yna");

	JButton buttonStart = new JButton("Rozpocznij mecz");
	// JButton buttonChangePlayer = new JButton("Zmieñ zawodnika");
	JButton buttonChooseTeam = new JButton("Wybierz dru¿ynê");

	// JLabel labelTime = new JLabel("Czas trwania meczu: 0");

	static JTextArea areaGame = new JTextArea(20, 80);
	JScrollPane textArea = new JScrollPane(areaGame);

	Choice choiceSelectTeam = new Choice();

	Window() {
		super("SoccerSim");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1500, 850);

		JPanel panel = new JPanel();

		choiceSelectTeam.add("AC Materace");
		choiceSelectTeam.add("Pogoñ Kamyk");
		choiceSelectTeam.add("Wicher K³odzino");
		choiceSelectTeam.add("Huragan Pobiedziska");
		panel.add(choiceSelectTeam);

		buttonChooseTeam.addActionListener(this);
		panel.add(buttonChooseTeam);

		buttonStart.addActionListener(this);
		panel.add(buttonStart);

		// buttonChangePlayer.addActionListener(this);
		// panel.add(buttonChangePlayer);

		panel.add(textArea);
		// panel.add(labelTime);

		panel.add(view);

		textArea.setVisible(true);
		areaGame.setEditable(false);
		textArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		textArea.setAutoscrolls(true);
		areaGame.setAutoscrolls(true);
		setContentPane(panel);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();

		if (source == buttonChooseTeam) {
			String whatWasSelected = choiceSelectTeam.getSelectedItem();
			if (whatWasSelected.equals("AC Materace")) {
				view.setCollection(Match.arrayList1);
				P1 = new Team(Match.arrayList1, "AC Materace");
				P2 = new Team(Match.arrayList2, "Pogoñ Kamyk");
			} else if (whatWasSelected.equals("Pogoñ Kamyk")) {
				view.setCollection(Match.arrayList2);
				P1 = new Team(Match.arrayList2, "Pogoñ Kamyk");
				P2 = new Team(Match.arrayList3, "Wicher K³odzino");
			} else if (whatWasSelected.equals("Wicher K³odzino")) {
				view.setCollection(Match.arrayList3);
				P1 = new Team(Match.arrayList3, "Wicher K³odzino");
				P2 = new Team(Match.arrayList4, "Huragan Pobiedziska");
			} else if (whatWasSelected.equals("Huragan Pobiedziska")) {
				view.setCollection(Match.arrayList4);
				P1 = new Team(Match.arrayList4, "Huragan Pobiedziska");
				P2 = new Team(Match.arrayList1, "AC Materace");
			}

			view.refresh();

		} else if (source == buttonStart) {
			int time = 0;
			int wynik1 = 0;
			int wynik2 = 0;

			P1.playersList.get(7).setHasBall(true);

			areaGame.setText(null);

			int r = 0;
			boolean ktoryTeam = true;
			Random rand = new Random();
			while (time < 60) {
				time++;

				for (int g = 0; g < 11; g++) {
					if (P1.playersList.get(g).getHasBall())
						CurrentPlayer = P1.getPlayer(g);

				}
				areaGame.append("Zawodnik " + CurrentPlayer.printName() + " przyjmuje pi³kê.\n");
				try {
					Thread.sleep(200);
					areaGame.update(areaGame.getGraphics());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (CurrentPlayer.getRole() == "bramkarz") {
					if (!CurrentPlayer.bramkarz(P1.getPlayer(1), P1.getPlayer(2))) {
						CurrentPlayer.setHasBall(false);
						areaGame.append("Bramkarz " + " poda³ niecelnie.\n");
						r = rand.nextInt(21);
						if (r > 10) {
							r -= 11; if(r==10) r--;
							P2.playersList.get(r).setHasBall(true);
						} else {
							P1.playersList.get(r).setHasBall(true);
						}
					} else
					{
						areaGame.append("Bramkarz " + CurrentPlayer.printName() + " wznawia rozgrywkê.\n");
					}
				} else if (CurrentPlayer.getRole() == "obronca pierwszy") {
					if (!CurrentPlayer.obronca1(P1.getPlayer(0), P1.getPlayer(2), P1.getPlayer(3))) {
						CurrentPlayer.setHasBall(false);
						areaGame.append("Obroñca " + CurrentPlayer.printName() + " wyprowadza niecelne podanie.\n");
						r = rand.nextInt(21);
						if (r > 10) {
							r -= 11;if(r==10) r--;
							P2.playersList.get(r).setHasBall(true);
						} else {
							P1.playersList.get(r).setHasBall(true);
						}
					} else {
						areaGame.append("Obroñca " + CurrentPlayer.printName() + " wyprowadza podanie.\n");
					}
				} else if (CurrentPlayer.getRole() == "obronca drugi") {
					if (!CurrentPlayer.obronca2(P1.getPlayer(0), P1.getPlayer(1), P1.getPlayer(4))) {
						CurrentPlayer.setHasBall(false);
						areaGame.append("Obroñca " + CurrentPlayer.printName() + " wyprowadza niecelne podanie.\n");
						r = rand.nextInt(21);
						if (r > 10) {
							r -= 11;if(r==10) r--;
							P2.playersList.get(r).setHasBall(true);
						} else {
							P1.playersList.get(r).setHasBall(true);
						}
					} else
					{
						areaGame.append("Obroñca " + CurrentPlayer.printName() + " wyprowadza podanie.\n");
					}
				} else if (CurrentPlayer.getRole() == "obronca trzeci") {
					if (!CurrentPlayer.obronca3(P1.getPlayer(1), P1.getPlayer(4), P1.getPlayer(5), P1.getPlayer(6))) {
						CurrentPlayer.setHasBall(false);
						areaGame.append("Obroñca " + CurrentPlayer.printName() + " wyprowadza niecelne podanie.\n");
						r = rand.nextInt(21);
						if (r > 10) {
							r -= 11;if(r==10) r--;
							P2.playersList.get(r).setHasBall(true);
						} else {
							P1.playersList.get(r).setHasBall(true);
						}
					} else
					{
						areaGame.append("Obroñca " + CurrentPlayer.printName() + " wyprowadza podanie.\n");
					}
				} else if (CurrentPlayer.getRole() == "obronca czwarty") {
					if (!CurrentPlayer.obronca4(P1.getPlayer(2), P1.getPlayer(3), P1.getPlayer(7), P1.getPlayer(8))) {
						CurrentPlayer.setHasBall(false);
						areaGame.append("Obroñca " + CurrentPlayer.printName() + " wyprowadza niecelne podanie.\n");
						r = rand.nextInt(21);
						if (r > 10) {
							r -= 11;if(r==10) r--;
							P2.playersList.get(r).setHasBall(true);
						} else {
							P1.playersList.get(r).setHasBall(true);
						}
					} else
					{
						areaGame.append("Obroñca " + CurrentPlayer.printName() + " wyprowadza podanie.\n");
					}
				} else if (CurrentPlayer.getRole() == "pomocnik pierwszy") {
					if (!CurrentPlayer.pomocnik1(P1.getPlayer(3), P1.getPlayer(6), P1.getPlayer(9))) {
						CurrentPlayer.setHasBall(false);
						areaGame.append("Pomocnik " + CurrentPlayer.printName() + " poda³ niecelnie.\n");
						r = rand.nextInt(21);
						if (r > 10) {
							r -= 11;if(r==10) r--;
							P2.playersList.get(r).setHasBall(true);
						} else {
							P1.playersList.get(r).setHasBall(true);
						}
					} else
					{
						areaGame.append("Pomocnik " + CurrentPlayer.printName() + " wyprowadza podanie.\n");
					}
				} else if (CurrentPlayer.getRole() == "pomocnik drugi") {
					if (!CurrentPlayer.pomocnik2(P1.getPlayer(3), P1.getPlayer(5), P1.getPlayer(7), P1.getPlayer(9))) {
						CurrentPlayer.setHasBall(false);
						areaGame.append("Pomocnik " + CurrentPlayer.printName() + " poda³ niecelnie.\n");
						r = rand.nextInt(21);
						if (r > 10) {
							r -= 11;if(r==10) r--;
							P2.playersList.get(r).setHasBall(true);
						} else {
							P1.playersList.get(r).setHasBall(true);
						}
					} else
					{
						areaGame.append("Pomocnik " + CurrentPlayer.printName() + " wyprowadza podanie.\n");
					}
				} else if (CurrentPlayer.getRole() == "pomocnik trzeci") {
					if (!CurrentPlayer.pomocnik3(P1.getPlayer(4), P1.getPlayer(6), P1.getPlayer(8), P1.getPlayer(9))) {
						CurrentPlayer.setHasBall(false);
						areaGame.append("Pomocnik " + CurrentPlayer.printName() + " poda³ niecelnie.\n");
						r = rand.nextInt(21);
						if (r > 10) {
							r -= 11;if(r==10) r--;
							P2.playersList.get(r).setHasBall(true);
						} else {
							P1.playersList.get(r).setHasBall(true);
						}
					}else
						{
							areaGame.append("Pomocnik " + CurrentPlayer.printName() + " wyprowadza podanie.\n");
						}
					} else if (CurrentPlayer.getRole() == "pomocnik czwarty") {
						if (!CurrentPlayer.pomocnik1(P1.getPlayer(4), P1.getPlayer(7), /*P1.getPlayer(10)*/P1.getPlayer(9))) {
							CurrentPlayer.setHasBall(false);
							areaGame.append("Pomocnik " + CurrentPlayer.printName() + " poda³ nicelnie.\n");
							r = rand.nextInt(21);
							if (r > 10) {
								r -= 11;if(r==10) r--;
								P2.playersList.get(r).setHasBall(true);
							} else {
								P1.playersList.get(r).setHasBall(true);
							} 
						} else
							{
								areaGame.append("Pomocnik " + CurrentPlayer.printName() + " wyprowadza podanie.\n");
							}
						} else if (CurrentPlayer.getRole() == "napastnik pierwszy") {
							if (!CurrentPlayer.attacker1(P2.getPlayer(0))) {
								CurrentPlayer.setHasBall(false);
								areaGame.append("Napastnik " + CurrentPlayer.printName() + " odda³ niecelny strza³.\n");
								r = rand.nextInt(21);
								if (r > 10) {
									r -= 11;if(r==10) r--;
									P2.playersList.get(r).setHasBall(true);
								} else {
									P1.playersList.get(r).setHasBall(true);
									areaGame.append("Napastnik " + CurrentPlayer.printName() + " strzeli³ gola!\n");
									wynik1 += 1;
								}
								
							/*} else if (CurrentPlayer.getRole() == "napastnik drugi") {
								if (!CurrentPlayer.attacker2(P2.getPlayer(0))) {
									CurrentPlayer.setHasBall(false);
									areaGame.append("Napastnik " + CurrentPlayer.printName() + " odda³ niecelny strza³.\n");
									r = rand.nextInt(21);
									if (r > 10) {
										r -= 11;
										P2.playersList.get(r).setHasBall(true);
									} else {
										P1.playersList.get(r).setHasBall(true);
										areaGame.append("Napastnik " + CurrentPlayer.printName() + " strzeli³ gola!\n");
										wynik1 += 1;
									}
									
								}*/

							try {
								Thread.sleep(200);
								areaGame.update(areaGame.getGraphics());
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					
					}}
					areaGame.append("Wynik: " + wynik1 + " do " + wynik2 + "\n");
				}

			}

		
	}


class TeamView extends JScrollPane {

	private static final long serialVersionUID = 1L;

	private JTable table;
	private DefaultTableModel tableModel;
	public Collection<Player> collection;

	public void setCollection(Collection<Player> collection) {
		this.collection = collection;
	}

	public TeamView(Collection<Player> collection, int width, int high, String description) {
		String[] column = { "Imiê", "Nazwisko", "Wiek", "Pozycja", "Szybkoœæ", "Kondycja", "Si³a strza³u", "Celnoœæ" };
		tableModel = new DefaultTableModel(column, 0);
		table = new JTable(tableModel);
		table.setRowSelectionAllowed(false);
		this.collection = collection;
		setViewportView(table);
		setPreferredSize(new Dimension(width, high));
		setBorder(BorderFactory.createTitledBorder(description));
	}

	void refresh() {
		tableModel.setRowCount(0);
		for (Player player : collection) {
			String[] column = { player.getName(), player.getSurname(), Integer.toString(player.getAge()),
					player.getRole(), Integer.toString(player.getSpeed()), Integer.toString(player.getStamina()),
					Integer.toString(player.getStrenght()), Integer.toString(player.getAccuracy()) };
			tableModel.addRow(column);
		}
	}
}
