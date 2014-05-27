/**
 * This is the Attack class. It creates an object that is used to return the
 * attributes of the attack.
 * 
 * @author Kerry Zhao
 */

public class Attack {

	private String type;
	private String spectrum;
	private String base;
	private String specialThings;

	/**
	 * constructor
	 * 
	 * @param type
	 *            - the attack's type
	 * @param spectrum
	 *            - physical or special
	 * @param base
	 *            - base damage
	 * @param specialThings
	 *            - not yet implemented
	 */
	public Attack(String type, String spectrum, String base,
			String specialThings) {
		this.type = type;
		this.spectrum = spectrum;
		this.base = base;
		this.specialThings = specialThings;
	}

	// the getters
	public String getType() {
		return type;
	}

	public String getSpectrum() {
		return spectrum;
	}

	public String getBase() {
		return base;
	}

	public String getSpecialThings() {
		return specialThings;
	}

}
