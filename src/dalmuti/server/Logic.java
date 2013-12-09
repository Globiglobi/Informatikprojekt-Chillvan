package dalmuti.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import dalmuti.shared.Masterobject;
import dalmuti.shared.User;
import dalmuti.testing.Card;

public class Logic {

	public static Masterobject control(Masterobject mo) {

		if (mo.activeusers.size() == 1) {
			mo.passiveusers.add(mo.activeusers.get(0));
			mo.activeusers = mo.passiveusers;

		}

		else {
			Iterator<User> e = mo.activeusers.iterator();
			while (e.hasNext()) {
				if (e.next().getAmount() == 0) {
					mo.passiveusers.add(e.next());
					e.remove();
				}
			}

		}
		return mo;
	}

	public static void main(String[] args) {

	}

}