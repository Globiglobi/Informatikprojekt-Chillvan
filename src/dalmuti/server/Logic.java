package dalmuti.server;

import dalmuti.shared.Masterobject;

public class Logic {

	public static Masterobject control(Masterobject mo) {

		// change active user
		for (int i = 0; i < mo.activeusers.size(); i++) {
			if (mo.activeusers.get(i).getActive() == true) {
				mo.activeusers.get(i).setActive(false);
				mo.activeusers.get(mo.nextplayer(i)).setActive(true);
				break;
			}
		}
		
		// set user with no more cards to passive
		for (int i = 0; i < mo.activeusers.size(); i++) {
			if (mo.activeusers.get(i).getAmount() == 0) {
				mo.passiveusers.add(mo.activeusers.remove(i));
				break;
			}
		}

		// no one can play
		if (mo.pass == mo.activeusers.size() - 1) {
			mo.playedcards[0] = 0;
			mo.playedcards[1] = 0;
		}
		
		// start of new round
		if (mo.activeusers.size() == 1) {
			mo.passiveusers.add(mo.activeusers.remove(0));
			mo.activeusers.addAll(mo.passiveusers);
			// distribute new cards
			int[] deck = Masterobject.createdeck();
			Masterobject.shuffle(deck);
			mo.distribute(deck);
			// set Dalmuti to active
			for (int i = 0; i < mo.activeusers.size(); i++) {
				mo.activeusers.get(i).setActive(false);
			}
			mo.activeusers.get(0).setActive(true);

		}
		return mo;
	}
}