package com.ritwik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BattleShipGame {

	ArrayList<Player> players = new ArrayList<Player>();
	static String letterArray = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) {
		BattleShipGame obj = new BattleShipGame();

		// TODO Auto-generated method stub
		// create a scanner so we can read the command-line input
		Scanner scanner = new Scanner(System.in);

		// prompt for Enter area boundaries:
		System.out.print("Enter area boundaries: ");
		String area = scanner.nextLine();

		// prompt for Type for battleship 1:
		System.out.print("Type for battleship 1: ");
		String shipType1 = scanner.nextLine();

		// prompt for Dimension for battleship 1::
		System.out.print("Dimension for battleship 1: ");
		String shipDim1 = scanner.nextLine();

		// prompt for Location of battleship 1 for player A:
		System.out.print("Location of battleship 1 for player A: ");
		String locShip1_player1 = scanner.nextLine();

		// prompt for Location of battleship 1 for player B:
		System.out.print("Location of battleship 1 for player B: ");
		String locShip1_player2 = scanner.nextLine();

		// prompt for Type for battleship 2:
		System.out.print("Type for battleship 2: ");
		String shipType2 = scanner.nextLine();

		// prompt for Dimension for battleship 2::
		System.out.print("Dimension for battleship 2: ");
		String shipDim2 = scanner.nextLine();

		// prompt for Location of battleship 2 for player A:
		System.out.print("Location of battleship 2 for player A: ");
		String locShip2_player1 = scanner.nextLine();

		// prompt for Location of battleship 2 for player B:
		System.out.print("Location of battleship 2 for player B: ");
		String locShip2_player2 = scanner.nextLine();

		// prompt for Missile targets for player A:
		System.out.print("Missile targets for player A: ");
		String missilePlayer1 = scanner.nextLine();
		/*
		 * String[] missilePlayer1 = scanner.nextLine().split(" "); List<String>
		 * armourPlayer1= Arrays.asList(missilePlayer1);
		 */

		// prompt for Missile targets for player B:
		System.out.print("Missile targets for player B: ");
		String missilePlayer2 = scanner.nextLine();
		/*
		 * String[] missilePlayer2 = scanner.nextLine().split(" "); List<String>
		 * armourPlayer2= Arrays.asList(missilePlayer2);
		 */
		scanner.close();

		// create BattleShip and Player1

		BattleShip battleShip1Player1 = new BattleShip();
		battleShip1Player1.setShipType(shipType1);
		battleShip1Player1.setShipPosition(obj.createPosition(locShip1_player1, shipDim1));// Create
																							// all
																							// cell
																							// positions
																							// for
																							// ship1-PlayerA

		BattleShip battleShip2Player1 = new BattleShip();
		battleShip2Player1.setShipType(shipType2);
		battleShip2Player1.setShipPosition(obj.createPosition(locShip2_player1, shipDim2));// Create
																							// all
																							// cell
																							// positions
																							// for
																							// ship2-PlayerA

		Player player1 = new Player();
		player1.setPlayerName("Player-1");
		ArrayList<BattleShip> shipsPlayer1 = new ArrayList<BattleShip>();
		shipsPlayer1.add(battleShip1Player1);
		shipsPlayer1.add(battleShip2Player1);
		player1.setArrShip(shipsPlayer1);
		player1.setArmour(missilePlayer1);

		// create BattleShip and Player2

		BattleShip battleShip1Player2 = new BattleShip();
		battleShip1Player2.setShipType(shipType1);
		battleShip1Player2.setShipPosition(obj.createPosition(locShip1_player2, shipDim1));// Create
																							// all
																							// cell
																							// positions
																							// for
																							// ship1-PlayerB

		BattleShip battleShip2Player2 = new BattleShip();
		battleShip2Player2.setShipType(shipType2);
		battleShip2Player2.setShipPosition(obj.createPosition(locShip2_player2, shipDim2));// Create
																							// all
																							// cell
																							// positions
																							// for
																							// ship2-PlayerB

		Player player2 = new Player();
		player2.setPlayerName("Player-2");
		ArrayList<BattleShip> shipsPlayer2 = new ArrayList<BattleShip>();
		shipsPlayer2.add(battleShip1Player2);
		shipsPlayer2.add(battleShip2Player2);
		player2.setArrShip(shipsPlayer2);
		player2.setArmour(missilePlayer2);

		// battle

		battle(player1, player2);

	}

	private static void battle(Player player1, Player player2) {

		/*************************************************
		 * The loop1 will run until the target ships are destroyed{ if the
		 * target's ships missiles and attacker's missiles are finished declare
		 * peace if attacker's missile is not yet finished{ make the missile
		 * ready missiles--; for(iterate through target ships){
		 * 
		 * 
		 * for(iterate through ship positions){
		 * 
		 * if(missile position matches with ship position){ it's a hit check the
		 * ship type if(ship type=Q){
		 * 
		 * count hit for two times if hit count is two destroy the cell
		 * 
		 * 
		 * 
		 * } if(ship type is P){ destroy the cell }
		 * 
		 * if all cells destroyed ship is destroyed } } } }else{
		 * 
		 * no missile is remaining
		 * 
		 * } if hit is false { if attack is true{ this is a miss } swap the
		 * target and attacker } if all target ships are destroyed{ attacker
		 * wins } }
		 *************************************************************/

		Player attacker = null;
		Player target = null;

		attacker = player1;
		target = player2;

		while (true && target.getArrShip().size() != 0) {

			if (target.getArmour().length() == 0 && attacker.getArmour().length() == 0) {

				System.out.println("Peace");
				break;

			}

			boolean hit = false;
			boolean attack = false;
			String missile = "";
			if (attacker.getArmour().length() != 0) {
				attack = true;
				// System.out.println("attacker="+attacker.getArmour());
				int idx = attacker.getArmour().indexOf(" ");
				if (idx == -1) {
					missile = attacker.getArmour();
					attacker.setArmour("");
				} else {
					missile = attacker.getArmour().substring(0, idx);
					attacker.setArmour(attacker.getArmour().substring(idx + 1, attacker.getArmour().length()));
				}
				for (int i = 0; i < target.getArrShip().size() && hit == false
						&& target.getArrShip().size() != 0; i++) { // for loop 1

					BattleShip ship = target.getArrShip().get(i);

					for (int j = 0; j < ship.getShipPosition().size() && hit == false
							&& ship.getShipPosition().size() != 0; j++) { // for
																			// loop2

						ShipStats shipStats = ship.getShipPosition().get(j);

						

						
						if (missile.equalsIgnoreCase(shipStats.getPosition())) {

							System.out.println(
									attacker.getPlayerName() + "fires a missile with target " + missile + " which hit");

							// attacker.getArmour().remove(0);
							if (ship.getShipType().equalsIgnoreCase("Q")) {

								shipStats.setHitCount(shipStats.getHitCount() + 1);

								if (shipStats.getHitCount() == 2) {

									shipStats.setAlive(false);
									ship.getShipPosition().remove(j);

								}
								hit = true;

							} else if (ship.getShipType().equalsIgnoreCase("P")) {

								// shipStats.setHitCount(shipStats.getHitCount()+1);

								shipStats.setAlive(false);
								ship.getShipPosition().remove(j);
								hit = true;

							}

							if (ship.getShipPosition().size() == 0) {

								target.getArrShip().remove(i);
							}

						}
						/*
						 * if(hit==true){ attacker.getArmour().remove(0); }
						 */

					}

				}

			} else {

				System.out.println(attacker.getPlayerName() + " has no more missiles left");

			}
			if (hit == false) {
				if (attack == true) {
					System.out.println(
							attacker.getPlayerName() + "fires a missile with target " + missile + " which missed");
				}
				Player tmp = attacker;
				attacker = target;
				target = tmp;

			}

		}

		if (target.getArrShip().size() == 0) {

			System.out.println(attacker.getPlayerName() + "won the battle");

		}

	}

	private ArrayList<ShipStats> createPosition(String location, String dimension) {

		/***********************************
		 * This method is used to create the exact cell position based on
		 * starting location of the ship and dimension. e.g. if location is B2
		 * and dimension is 3,3 the cell position will be B2, B3, B4, C2, C3,
		 * C4,D2, D3, D4
		 * 
		 * each cell will be accompanied with no of hit count and the ship
		 * health Hit count will be required to get the no of missile hits .
		 * this is necessary if the ship type is Q, because to destroy Q ship 2
		 * missile hits are required.
		 * 
		 * letterArray is a array of all letters which is required to find the
		 * exact cell positions
		 **************************************/
		// B2 3,3 =2,2 3,3
		//
		// System.out.println("location="+location+ " & dimension="+dimension);

		ArrayList<ShipStats> arr = new ArrayList<ShipStats>();
		char locCh1 = location.charAt(0);
		// System.out.println("locCh1="+locCh1);
		char locCh2 = location.charAt(1);

		// int locForCh2=locCh2;
		// System.out.println("locCh2/locForCh2="+locCh2);
		int locForCh1 = letterArray.indexOf(locCh1);
		// System.out.println("index of"+locForCh1);
		String[] dimArr = dimension.split(" ");

		int dim1 = Integer.parseInt(dimArr[0]);
		// System.out.println("dim1="+dim1);
		int dim2 = Integer.parseInt(dimArr[1]);
		// System.out.println("dim2="+dim2);

		// System.out.println("---"+locCh2+"---"+dim1);
		int tmpLoc = Integer.parseInt(String.valueOf(locCh2)) + dim1 - 1;
		// System.out.println("2nd loop="+tmpLoc);
		int tmpLocLetter = Integer.parseInt(String.valueOf(locForCh1)) + dim2 - 1;
		// System.out.println("1st loop="+tmpLocLetter);

		for (int j = Integer.parseInt(String.valueOf(locForCh1)); j <= tmpLocLetter; j++) {

			for (int i = Integer.parseInt(String.valueOf(locCh2)); i <= tmpLoc; i++) {
				ShipStats shipStats = new ShipStats();
				locCh1 = letterArray.charAt(j);
				String pos1 = new Integer(i).toString();
				// System.out.println("pos1="+pos1);
				// System.out.println("locCh1=="+locCh1);
				String pos = locCh1 + pos1;
				shipStats.setPosition(pos);
				shipStats.setAlive(true);
				shipStats.setHitCount(0);
				// arr.add(locCh1+new Integer(i).toString());
				// System.out.println(pos);
				arr.add(shipStats);

			}

		}

		return arr;
	}

}
