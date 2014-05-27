/**
 * This is the Pokemon class. It creates a Pokemon with its base stats and
 * typings.
 * 
 * @author Kerry Zhao
 * 
 */

public class Pokemon {

	private String HP;
	private String Atk;
	private String Def;
	private String SpAtk;
	private String SpDef;
	private String Spe;
	private String type1;
	private String type2;

	/**
	 * constructor
	 * 
	 * @param HP
	 * @param Atk
	 * @param Def
	 * @param SpAtk
	 * @param SpDef
	 * @param Spe
	 * @param type1
	 * @param type2
	 */
	public Pokemon(String HP, String Atk, String Def, String SpAtk,
			String SpDef, String Spe, String type1, String type2) {
		this.HP = HP;
		this.Atk = Atk;
		this.Def = Def;
		this.SpAtk = SpAtk;
		this.SpDef = SpDef;
		this.Spe = Spe;
		this.type1 = type1;
		this.type2 = type2;
	}

	// the getters
	public String getHP() {
		return HP;
	}

	public String getAtk() {
		return Atk;
	}

	public String getDef() {
		return Def;
	}

	public String getSpAtk() {
		return SpAtk;
	}

	public String getSpDef() {
		return SpDef;
	}

	public String getSpe() {
		return Spe;
	}

	public String getType1() {
		return type1;
	}

	public String getType2() {
		return type2;
	}
}
