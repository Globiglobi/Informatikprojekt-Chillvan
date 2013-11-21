package dalmuti.testing;

public class Table {
	// Definition der Attribute
	public String tablename;
	public int table_ID;
	public int anzahlUser;

	// Definition der Methode getAnzahlUser
	public int anzahlUser() {
		return anzahlUser;
	}

	// Definition Konstruktor
	public Table(int table_ID) {
		this.table_ID = table_ID;
		
		//Deklarien der Maximalen Objekte
		int MAX_OBJ = 2;
		
		// Anlegen des Arrays des Objekts einUser
		Table[] eintable = new Table[MAX_OBJ];
		
		//Anlegen der Objekte
		for (int i = 0; i < MAX_OBJ; i++) {
			eintable[i] = new Table();
			}

	}


	public Table() {
		// TODO Auto-generated constructor stub
	}
}
