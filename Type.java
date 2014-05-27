/**
 * This is the Type class. It creates an object that is used to return the
 * weaknesses of the defending Pokemon.
 * 
 * @author Kerry Zhao
 */

public class Type {

	// the 18 types
	private String normal;
	private String fighting;
	private String flying;
	private String poison;
	private String ground;
	private String rock;
	private String bug;
	private String ghost;
	private String steel;
	private String fire;
	private String water;
	private String grass;
	private String electric;
	private String psychic;
	private String ice;
	private String dragon;
	private String dark;
	private String fairy;

	/**
	 * constructor
	 * 
	 * @param normal
	 * @param fighting
	 * @param flying
	 * @param poison
	 * @param ground
	 * @param rock
	 * @param bug
	 * @param ghost
	 * @param steel
	 * @param fire
	 * @param water
	 * @param grass
	 * @param electric
	 * @param psychic
	 * @param ice
	 * @param dragon
	 * @param dark
	 * @param fairy
	 */
	public Type(String normal, String fighting, String flying, String poison,
			String ground, String rock, String bug, String ghost, String steel,
			String fire, String water, String grass, String electric,
			String psychic, String ice, String dragon, String dark, String fairy) {
		this.normal = normal;
		this.fighting = fighting;
		this.flying = flying;
		this.poison = poison;
		this.ground = ground;
		this.rock = rock;
		this.bug = bug;
		this.ghost = ghost;
		this.steel = steel;
		this.fire = fire;
		this.water = water;
		this.grass = grass;
		this.electric = electric;
		this.psychic = psychic;
		this.ice = ice;
		this.dragon = dragon;
		this.dark = dark;
		this.fairy = fairy;
	}

	// the getters
	public String getNormal() {
		return normal;
	}

	public String getFighting() {
		return fighting;
	}

	public String getFlying() {
		return flying;
	}

	public String getPoison() {
		return poison;
	}

	public String getGround() {
		return ground;
	}

	public String getRock() {
		return rock;
	}

	public String getBug() {
		return bug;
	}

	public String getGhost() {
		return ghost;
	}

	public String getSteel() {
		return steel;
	}

	public String getFire() {
		return fire;
	}

	public String getWater() {
		return water;
	}

	public String getGrass() {
		return grass;
	}

	public String getElectric() {
		return electric;
	}

	public String getPsychic() {
		return psychic;
	}

	public String getIce() {
		return ice;
	}

	public String getDragon() {
		return dragon;
	}

	public String getDark() {
		return dark;
	}

	public String getFairy() {
		return fairy;
	}

}
