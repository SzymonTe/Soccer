import java.util.*;

import javax.swing.JOptionPane;

public class Player {
	
	String names[] = {"Jan","Boromir","Legolas","Zbyszko","Maæko","Geralt","Artur","Pawe³","Jurand","Harry","Szymon","Kacper","Kordian","Mateusz","Micha³",
						"Jessica","Andrzej","Robert","Mercedes","Maksymilian","Bartek","Krystian","Roman","Maciej"};
	String surnames[] = {"Rozenek","Mikke","Kaczyñski","Duda","z Bogdañca","Komorowski","ze Spychowa","Macierewicz","Kowalski","Romanowicz","z Rivii","Kot",
						"Wojewódzki","Pudzianowski","Kubica","Ma³ysz","Obama","Putin","Putout","Dzong-Um","Dzong-Ill","Kinduk","Bocian","Sroka"};
	

	
	private String name;
	private String surname;
	private int age;
	private int speed;
	private int strenght;
	private int accuracy;
	private int stamina;
	private int form;
	private int agility;
	private int actor;
	private boolean hurt;
	private boolean active;
	private boolean yellow;
	private boolean hasBall;
	private int defense;
	private int offense;
	private int help;
	private int goalkeeper;
	private String role;

	//int age, int speed, int strenght, int accuracy, int stamina, int form, int agility, int actor,
	//boolean hurt, boolean active
	
	public Player() {

		Random rand = new Random();
		
		name = names[rand.nextInt(names.length)];
		surname = surnames[rand.nextInt(surnames.length)];
		this.form = 0;
		this.age = rand.nextInt((40 - 18) + 1) + 18;
		this.speed = rand.nextInt((100 - 1) + 1) + 1;
		this.strenght = rand.nextInt((100 - 1) + 1) + 1;
		this.accuracy = rand.nextInt((100 - 1) + 1) + 1;
		this.stamina = 50 + rand.nextInt((50 - 1) + 1) + 1;
		this.agility = rand.nextInt((100 - 1) + 1) + 1;
		this.actor = rand.nextInt((100 - 1) + 1) + 1;
		this.hurt = false;
		//this.active = false;
		this.yellow = false;
		this.hasBall = false;
		offense = (speed * 2 + strenght + accuracy * 3 + agility + stamina) / 8;
		defense = (speed + strenght * 3 + accuracy + agility * 2 + stamina) / 8;
		help = (speed + strenght * 2 + accuracy * 2 + agility * 2 + stamina) / 8;
		goalkeeper = (strenght + speed + accuracy + agility * 4 + stamina) / 8;
		role = "bezdomny";
	}

	// settery
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public void setHurt(boolean hurt) {
		this.hurt = active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setYellow(boolean yellow) {
		this.yellow = yellow;
	}

	public void setForm(int form) {
		this.form = form;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setStrenght(int strenght) {
		this.strenght = strenght;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public void setHasBall(boolean hasBall) {
		this.hasBall = hasBall;
	}
	// gettery

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public int getAge() {
		return age;
	}

	public int getSpeed() {
		return speed;
	}

	public int getStrenght() {
		return strenght;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public int getStamina() {
		return stamina;
	}

	public int getForm() {
		return form;
	}

	public int getAgility() {
		return agility;
	}

	public int getActor() {
		return actor;
	}

	public boolean getHurt() {
		return hurt;
	}

	public boolean getActive() {
		return active;
	}

	public boolean getYellow() {
		return yellow;
	}

	public boolean getHasBall() {
		return hasBall;
	}

	public int getOffense() {
		return offense;
	}

	public int getDefense() {
		return defense;
	}

	public int getHelp() {
		return help;
	}

	public int getGoalkeeper() {
		return goalkeeper;
	}

	public String printName() {
		String helpful = name + " " + surname;
		return helpful;
	}

	public boolean ballPassed(Player p) {
		hasBall = false;
		Random random = new Random();
		int helpful = speed + strenght * 2 + accuracy * 2 + agility * 2 + stamina;
		int rand = random.nextInt((800 - 1) + 1) + 1;
		if (helpful < rand) {
			if (p.ballTaken()) {
				return true;
			} else
				return false;
		} else {
			rand = random.nextInt((10 - 1) + 1) + 1;
			if (rand >= 5) {
				if (p.ballTaken()) {
					return true;
				} else
					return false;
			} else
				return false;
		}
	}

	public boolean ballShot(Player br) {
		hasBall = false;
		Random random = new Random();
		int helpful = speed * 2 + strenght + accuracy * 3 + agility + stamina;
		int rand = random.nextInt((800 - 1) + 1) + 1;
		if (helpful < rand) {
			if (br.ballDefended()) {
				return false;
			} else
				return true;
		} else
			rand = random.nextInt((10 - 1) + 1) + 1;
		if (rand >= 6) {
			if (br.ballDefended()) {
				return false;
			}
			return true;
		} else
			return false;
	}

	public boolean actorSuccess() {
		Random random = new Random();
		int rand = random.nextInt((100 - 1) + 1) + 1;
		if (actor > rand) {
			return true;
		} else
			return false;
	}

	public boolean isHurt() {
		Random random = new Random();
		int rand = random.nextInt((300 - 1) + 1) + 1;
		int helpful = stamina + strenght + agility;
		if (helpful < rand) {
			return false;
		} else
			return true;
	}

	public boolean ballTaken() {
		Random random = new Random();
		int helpful = speed + strenght * 3 + accuracy + agility * 2 + stamina;
		int rand = random.nextInt((800 - 1) + 1) + 1;
		if (helpful < rand) {
			hasBall = true;
			return true;
		} else
			rand = random.nextInt((10 - 1) + 1) + 1;
		if (rand >= 3) {
			hasBall = true;
			return true;
		} else
			return false;
	}

	public boolean ballDefended() {
		Random random = new Random();
		int helpful = strenght + speed + accuracy + agility * 4 + stamina;
		int rand = random.nextInt((1200 - 1) + 1) + 1;
		if (helpful < rand) {
			hasBall = false;
			return true;
		} else
			rand = random.nextInt((10 - 1) + 1) + 1;
		if (rand >= 8) {
			return true;
		} else
			return false;
	}

	/*
	 * public boolean ballOut(){ hasBall = false; Random random = new Random();
	 * int helpful = strenght *3 + accuracy *3 + agility + stamina; int rand =
	 * random.nextInt((800-1)+1)+1; if (helpful<rand) { return true; } else rand
	 * = random.nextInt((10-1)+1)+1; if(rand >= 5){ return true; } else return
	 * false; }
	 */

	public void setStats() {
		this.speed = speed + form / 10;
		this.strenght = strenght + form / 10;
		this.accuracy = accuracy + form / 10;
		this.stamina = stamina + form / 10;
		this.agility = agility + form / 10;
		offense = (speed * 2 + strenght + accuracy * 3 + agility + stamina) / 8;
		defense = (speed + strenght * 3 + accuracy + agility * 2 + stamina) / 8;
		help = (speed + strenght * 2 + accuracy * 2 + agility * 2 + stamina) / 8;
		goalkeeper = (strenght + speed + accuracy + agility * 4 + stamina) / 8;
		role = "bezdomny";
	}

	public void setRole(String s) {
		role = s;
	}

	public String getRole() {
		return role;
	}

	public boolean bramkarz(Player ob1, Player ob2) {
		Random random = new Random();
		int rand = random.nextInt((2 - 1) + 1) + 1;
		if (rand == 1)
			return ballPassed(ob1);
		else
			return ballPassed(ob2);
	}

	public boolean obronca1(Player br, Player ob2, Player ob3) {
		Random random = new Random();
		int rand = random.nextInt((3 - 1) + 1) + 1;
		if (rand == 1)
			return ballPassed(br);
		else if (rand == 2)
			return ballPassed(ob2);
		else
			return ballPassed(ob3);
	}

	public boolean obronca2(Player br, Player ob1, Player ob4) {
		Random random = new Random();
		int rand = random.nextInt((3 - 1) + 1) + 1;
		if (rand == 1)
			return ballPassed(br);
		else if (rand == 2)
			return ballPassed(ob1);
		else
			return ballPassed(ob4);
	}

	public boolean obronca3(Player ob1, Player ob4, Player pom1, Player pom2) {
		Random random = new Random();
		int rand = random.nextInt((4 - 1) + 1) + 1;
		if (rand == 1)
			return ballPassed(ob1);
		else if (rand == 2)
			return ballPassed(ob4);
		else if (rand == 4)
			return ballPassed(pom1);
		else
			return ballPassed(pom2);
	}

	public boolean obronca4(Player ob2, Player ob3, Player pom3, Player pom4) {
		Random random = new Random();
		int rand = random.nextInt((4 - 1) + 1) + 1;
		if (rand == 1)
			return ballPassed(ob2);
		else if (rand == 2)
			return ballPassed(ob3);
		else if (rand == 4)
			return ballPassed(pom3);
		else
			return ballPassed(pom4);
	}

	public boolean pomocnik1(Player ob3, Player pom2, Player at1) {
		Random random = new Random();
		int rand = random.nextInt((3 - 1) + 1) + 1;
		if (rand == 1)
			return ballPassed(ob3);
		else if (rand == 2)
			return ballPassed(pom2);
		else
			return ballPassed(at1);
	}

	public boolean pomocnik2(Player ob3, Player pom1, Player pom3, Player at1) {
		Random random = new Random();
		int rand = random.nextInt((4 - 1) + 1) + 1;
		if (rand == 1)
			return ballPassed(ob3);
		else if (rand == 2)
			return ballPassed(pom1);
		else if (rand == 4)
			return ballPassed(pom3);
		else
			return ballPassed(at1);
	}

	public boolean pomocnik3(Player ob4, Player pom2, Player pom4, Player at2) {
		Random random = new Random();
		int rand = random.nextInt((4 - 1) + 1) + 1;
		if (rand == 1)
			return ballPassed(ob4);
		else if (rand == 2)
			return ballPassed(pom2);
		else if (rand == 4)
			return ballPassed(pom4);
		else
			return ballPassed(at2);
	}

	public boolean pomocnik4(Player ob4, Player pom3, Player at2) {
		Random random = new Random();
		int rand = random.nextInt((3 - 1) + 1) + 1;
		if (rand == 1)
			return ballPassed(ob4);
		else if (rand == 2)
			return ballPassed(pom3);
		else
			return ballPassed(at2);
	}

	public boolean attacker1(Player br) {
		return ballShot(br);
	}

	public boolean attacker2(Player br) {
		return ballShot(br);
	}
	
	
}
