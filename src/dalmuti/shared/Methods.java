package dalmuti.shared;

public class Methods {

	public static Masterobject mo;
	public static int[] newhand = { 1, 2, 3, 4 };
	public static int[] handcopy = { 1, 2, 3, 4 };
	public static int[] display = new int[2];

	// int[] newhand = mo.activeusers.get(0).getHand();

	public static void cardclick(int button) {
		// in case of button gets clicked again
		if (newhand[button] != handcopy[button] && newhand[button] >= 1) {
			newhand[button]--;
		}
		// in case new button gets clicked
		else if (newhand[button] == handcopy[button] && newhand[button] >= 1) {
			newhand = handcopy;
			newhand[button]--;
		}
		// change display array
		display[0] = button;
		display[1] = handcopy[button] - newhand[button];

	}

	public static void narrclick() {
		// in case no card has been played yet
		if ((display[0] == 0 || display[0] == 13) && newhand[0] >= 1) {
			newhand[0]--;
			display[0] = 13;
			display[1]++;
		}
		// in case another card has been played
		else if (display[0] != 0 && newhand[0] >= 1) {
			newhand[0]--;
			display[1]++;
		}
	}
	
	public static void resetclick(){
		newhand = handcopy;
		display[0] = 0;
		display[1] = 0;
	}

	// place cards
	public static void placecards() {
		int activeplayer = mo.whosactive();
		mo.activeusers.get(activeplayer).setHand(newhand);
		mo.playedcards = display;
		mo.activeusers.get(activeplayer).setActive(false);
		mo.activeusers.get(nextplayer(activeplayer)).setActive(true);
		display[0] = 0;
		display[1] = 0;

	}

	// pass round
	public static void pass() {
		int activeplayer = mo.whosactive();
		mo.activeusers.get(activeplayer).setActive(false);
		mo.activeusers.get(nextplayer(activeplayer)).setActive(true);
		display[0] = 0;
		display[1] = 0;

	}

	// Determine next player
	public static int nextplayer(int currentplayer) {
		int nextplayer = currentplayer + 1;
		if (nextplayer > mo.activeusers.size() - 1) {
			nextplayer = 0;
		}
		return nextplayer;
	}

	public static void main(String[] args) {

	}

}
