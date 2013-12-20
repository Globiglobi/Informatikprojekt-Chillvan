/**
 * Copyright (c) 2013 Cornflakes. All rights reserved.
 * 
 * @author Fabio Bally
 * 
 */

package dalmuti.server;

import dalmuti.shared.Masterobject;

public class Logic {
	
	public static Masterobject control(Masterobject mo) {
		
		// no one can play
		if (mo.pass == mo.users.size() - 1 - mo.nextround.size()) {
			mo.playedcards[0] = 0;
			mo.playedcards[1] = 0;
		}
		
		// set user with no more cards to passive
		for (int i = 0; i < mo.users.size(); i++) {
			if (mo.users.get(i).getAmount() == 0) {
				if(mo.users.get(i).isPassive() == true){
					continue;
				}
				mo.pass--;
				mo.users.get(i).setPassive(true);
				mo.nextround.add(mo.users.get(i));
				break;
			}
		}

		// change active user
		for (int i = 0; i < mo.users.size(); i++) {
			if (mo.users.get(i).getActive() == true && mo.users.get(mo.nextplayer(i)).isPassive() == false) {
				mo.users.get(i).setActive(false);
				mo.users.get(mo.nextplayer(i)).setActive(true);
				break;
			}
			else if(mo.users.get(i).getActive() == true && mo.users.get(mo.nextplayer(i)).isPassive() == true){
				mo.users.get(i).setActive(false);
				mo.users.get(mo.nextplayer(i)).setActive(true);
				i = mo.nextplayer(i)-1;
				continue;
			}
		}
		
		// start of new round
		if (mo.nextround.size() == mo.users.size() - 1) {
			for(int i = 0; i < mo.users.size(); i++){
				if(mo.users.get(i).isPassive() == false){
					mo.users.get(i).setHand(new int[13]);
					mo.nextround.add(mo.users.get(i));
					break;
				}
			}
			for (int i = 0; i < mo.nextround.size(); i++) {
				mo.nextround.get(i).setPassive(false);
				mo.nextround.get(i).setActive(false);
				
				// Update Scores
				mo.nextround.get(i).setScore(mo.nextround.get(i).getScore() + (mo.nextround.size() - i - 1));
			}
			mo.users.clear();
			mo.users.addAll(mo.nextround);
			mo.nextround.clear();
			mo.scoreboard.clear();
			mo.scoreboard.addAll(mo.users);
			mo.scoreSort();
			// distribute new cards
			int[] deck = Masterobject.createdeck();
			Masterobject.shuffle(deck);
			mo.distribute(deck);
			
			// set Dalmuti to active
			mo.users.get(0).setActive(true);
			mo.turn = 0;
			mo.playedcards = new int[2];
		}
		return mo;
	}
}