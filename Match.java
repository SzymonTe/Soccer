import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Match {
	
	//sta³e
	public static final String[] positions = { "bramkarz", "obronca pierwszy", "obronca drugi", "obronca trzeci",
			"obronca czwarty", "pomocnik pierwszy", "pomocnik drugi", "pomocnik trzeci", "pomocnik czwarty",
			"napastnik pierwszy", "napastnik drugi", "rezerwowy pierwszy", "rezerwowy drugi", "rezerwowy trzeci",
			"rezerwowy czwarty" };
	public static final String[] teamNames = {"AC Materace","Pogoñ Kamyk","Wicher K³odzino","Huragan Pobiedziska"}; 
	
	public static ArrayList<Player> arrayList1;
	public static ArrayList<Player> arrayList2;
	public static ArrayList<Player> arrayList3;
	public static ArrayList<Player> arrayList4;
	
	public static void main(String[] args){
		
		//tworzê ArayLisy z graczami
		arrayList1 = new ArrayList<Player>();
		for(int i = 0; i < 15; i++){
			arrayList1.add(new Player());
			arrayList1.get(i).setRole(positions[i]);
		}
		arrayList2 = new ArrayList<Player>();
		for(int i = 0; i < 15; i++){
			arrayList2.add(new Player());
			arrayList2.get(i).setRole(positions[i]);
		}
		arrayList3 = new ArrayList<Player>();
		for(int i = 0; i < 15; i++){
			arrayList3.add(new Player());
			arrayList3.get(i).setRole(positions[i]);
		}
		arrayList4 = new ArrayList<Player>();
		for(int i = 0; i < 15; i++){
			arrayList4.add(new Player());
			arrayList4.get(i).setRole(positions[i]);
		}
		
		//tworzê teamy
		Team team1 = new Team(arrayList1,"AC Materace");
		Team team2 = new Team(arrayList2,"Pogoñ Kamyk");
		Team team3 = new Team(arrayList3,"Wicher K³odzino");
		Team team4 = new Team(arrayList4,"Huragan Pobiedziska");
		
		//tworzê panel
		new Window();
	}
}
