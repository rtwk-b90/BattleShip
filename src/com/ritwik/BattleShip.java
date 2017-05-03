/**
 * 
 */
package com.ritwik;

import java.util.ArrayList;

/**
 * @author Ritwik
 *
 */
public class BattleShip {
	// declaring ship type..
	
	public String getShipType() {
		return shipType;
	}
	public void setShipType(String shipType) {
		this.shipType = shipType;
	}
	
	public ArrayList<ShipStats> getShipPosition() {
		return shipPosition;
	}
	public void setShipPosition(ArrayList<ShipStats> shipPosition) {
		this.shipPosition = shipPosition;
	}

	private ArrayList<ShipStats> shipPosition;
	


	

	private String shipType;
}
