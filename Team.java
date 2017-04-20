import java.util.ArrayList;

public class Team {

	public ArrayList<Player> playersList;
	private String teamName;
	
	Team(ArrayList<Player> arrayList, String teamName)
	{
		playersList = arrayList;
		this.teamName = teamName;
	}
	
	void changePosition(Player player1, Player player2)
	{
		String position1 = player1.getRole();
		String position2 = player2.getRole();
		player1.setRole(position2);
		player2.setRole(position1);
	}
	
	public Player getPlayer(int t){
		return playersList.get(t);
	}
}
