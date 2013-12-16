package dalmuti.server;

import dalmuti.shared.Masterobject;

public class Logic {
	
	static int j = 0;

	public static Masterobject control(Masterobject mo) {
		
		// no one can play
		if (mo.pass == mo.users.size() - 1 - mo.nextround.size()) {
			mo.playedcards[0] = 0;
			mo.playedcards[1] = 0;
		}
		
		// set user with no more cards to passive
		for (int i = 0; i < mo.users.size(); i++) {
			System.out.println("loop # " + i);
			if (mo.users.get(i).getAmount() == 0) {
				if(mo.users.get(i).isPassive() == true){
					continue;
				}
				mo.pass--;
				mo.users.get(i).setPassive(true);
				System.out.println(mo.users.get(i).getNickname() + " set to passive");
				mo.nextround.add(mo.users.get(i));
				System.out.println("Jetzt in nextround " + mo.nextround.get(j).getNickname());
				j++;
				break;
			}
		}

		// change active user
		for (int i = 0; i < mo.users.size(); i++) {
//			System.out.println("Re-enter loop at: " + i);
			if (mo.users.get(i).getActive() == true && mo.users.get(mo.nextplayer(i)).isPassive() == false) {
				mo.users.get(i).setActive(false);
//				System.out.println(mo.users.get(i).getNickname() + " deactivated");
				mo.users.get(mo.nextplayer(i)).setActive(true);
//				System.out.println(mo.users.get(mo.nextplayer(i)).getNickname() + " activated");
				break;
			}
			else if(mo.users.get(i).getActive() == true && mo.users.get(mo.nextplayer(i)).isPassive() == true){
//				System.out.println("2nd loop");
				mo.users.get(i).setActive(false);
//				System.out.println(mo.users.get(i).getNickname() + " is still active: " + mo.users.get(i).getActive());
				mo.users.get(mo.nextplayer(i)).setActive(true);
//				System.out.println(mo.users.get(mo.nextplayer(i)).getNickname() + " is now active: " + mo.users.get(mo.nextplayer(i)).getActive());
				i = mo.nextplayer(i)-1;
				continue;
			}
		}
		
		// start of new round
		if (mo.nextround.size() == mo.users.size() - 1) {
			System.out.println("only one left");
			for(int i = 0; i < mo.users.size(); i++){
				if(mo.users.get(i).isPassive() == false){
					mo.users.get(i).setHand(new int[13]);
					mo.nextround.add(mo.users.get(i));
					break;
				}
			}
			mo.users.clear();
			mo.users.addAll(mo.nextround);
			for (int i = 0; i < mo.users.size(); i++) {
				mo.users.get(i).setPassive(false);
				mo.users.get(i).setActive(false);
			}
			// distribute new cards
			int[] deck = Masterobject.createdeck();
			Masterobject.shuffle(deck);
			mo.distribute(deck);
			// set Dalmuti to active
			mo.users.get(0).setActive(true);
			mo.firstRound = true;
			mo.round = 0;
			mo.playedcards = new int[2];
		}
		return mo;
	}
}