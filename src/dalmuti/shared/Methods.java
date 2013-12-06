package dalmuti.shared;

import java.util.Iterator;

public class Methods {

	public static Masterobject mo;
	public static int[] newamount = { 1, 2, 3, 4 };
	public static int[] amountcopy = { 1, 2, 3, 4 };
	// int[] newamount = mo.activeusers.get(0).getAmount();

	public static void main(String[] args) {

		System.out.println(cardclick(3)[3]);

	}

	public static int[] cardclick(int button) {


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
	public static int whosactive(){
		Iterator<User> i = mo.activeusers.iterator();
		while (i.hasNext()){
			i.next();
			if(i.next().getActive() = true){
				
			}
		}
	}
	
}
