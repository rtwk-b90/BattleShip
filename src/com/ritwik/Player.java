package com.ritwik;

import java.util.ArrayList;
import java.util.List;

public class Player {

	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public ArrayList<BattleShip> getArrShip() {
		return arrShip;
	}
	public void setArrShip(ArrayList<BattleShip> arrShip) {
		this.arrShip = arrShip;
	}
	
	
	
	
	
	private String playerName;
	private String armour;
	





	public String getArmour() {
		return armour;
	}
	public void setArmour(String armour) {
		this.armour = armour;
	}





	private ArrayList<BattleShip> arrShip;
}
