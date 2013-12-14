package dalmuti.server;

import dalmuti.shared.Masterobject;

public class Logic {

	public static Masterobject control(Masterobject mo) {

		System.out.println("Size: " + mo.activeusers.size());

		for (int i = 0; i < mo.activeusers.size(); i++) {
			if (mo.activeusers.get(i).getActive() == true) {
				mo.activeusers.get(i).setActive(false);
				mo.activeusers.get(mo.nextplayer(i)).setActive(true);
				if (mo.activeusers.get(i).getAmount() == 0) {
					mo.passiveusers.add(mo.activeusers.remove(i));
				}
				break;
			}
		}
		if (mo.activeusers.size() == 1) {
			mo.passiveusers.add(mo.activeusers.remove(0));
			mo.activeusers.addAll(mo.passiveusers);
		}
		return mo;
	}
}