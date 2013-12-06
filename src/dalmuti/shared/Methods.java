package dalmuti.shared;

public class Methods {

	public static Masterobject mo;
	public static int[] newamount = { 1, 2, 3, 4 };
	public static int[] amountcopy = { 1, 2, 3, 4 };

	public static void main(String[] args) {

		System.out.println(cardclick(3)[3]);

	}

	public static int[] cardclick(int button) {

		// int[] newamount = mo.activeusers.get(0).getAmount();
		if (newamount[button] != amountcopy[button] && newamount[button] >= 1) {
			newamount[button]--;
		} else if (newamount[button] == amountcopy[button]
				&& newamount[button] >= 1) {
			newamount = amountcopy;
			newamount[button]--;
		}

		return newamount;

	}
	
	public static void placecards(){
		mo.activeusers.get(whosactive()).getAmount = newamount;
	}
}
