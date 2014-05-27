/**
 * The most important class. It does all the calculations.
 * 
 * @author kerry
 * 
 */

public class PokemonDmgCalc {

	// constructor
	public PokemonDmgCalc() {

	}

	/**
	 * This function returns the Pokemon's HP at level 'level' given IV and EV
	 * stats
	 * 
	 * @param HP
	 *            - the base HP stat of the Pokemon
	 * @param IV
	 *            - the individual value of the HP stat
	 * @param EV
	 *            - the effort value of the HP stat
	 * @param level
	 *            - the level of the Pokemon
	 * @return - an int
	 */
	public int calcHP(String HP, int IV, int EV, int level) {
		int base = Integer.parseInt(HP);
		return (((((base * 2) + IV + (EV / 4) + 100) * level) / 100) + 10);
	}

	/**
	 * This function returns the Pokemon's stat that is not HP. Uses a switch
	 * case to account for the 25 possible natures.
	 * 
	 * @param statName
	 *            - the stat that is being calculated
	 * @param stat
	 *            - the base of the stat
	 * @param IV
	 *            - the individual value of the HP stat
	 * @param EV
	 *            - the effort value of the HP stat
	 * @param level
	 *            - the level of the Pokemon
	 * @param nature
	 *            - the nature of the Pokemon
	 * @return - an int
	 */
	public int calcNotHP(String statName, String stat, int IV, int EV,
			int level, String nature) {
		int base = Integer.parseInt(stat);

		double natureMultiplier = 1.0;
		switch (nature) {
		case "hardy":
			natureMultiplier = 1.0;
			break;
		case "lonely":
			if (statName.equals("attack")) {
				natureMultiplier = 1.1;
			}
			if (statName.equals("defense")) {
				natureMultiplier = 0.9;
			}
			break;
		case "brave":
			if (statName.equals("attack")) {
				natureMultiplier = 1.1;
			}
			if (statName.equals("speed")) {
				natureMultiplier = 0.9;
			}
			break;
		case "adamant":
			if (statName.equals("attack")) {
				natureMultiplier = 1.1;
			}
			if (statName.equals("spAtk")) {
				natureMultiplier = 0.9;
			}
			break;
		case "naughty":
			if (statName.equals("attack")) {
				natureMultiplier = 1.1;
			}
			if (statName.equals("spDef")) {
				natureMultiplier = 0.9;
			}
			break;
		case "bold":
			if (statName.equals("defense")) {
				natureMultiplier = 1.1;
			}
			if (statName.equals("attack")) {
				natureMultiplier = 0.9;
			}
			break;
		case "docile":
			natureMultiplier = 1.0;
			break;
		case "relaxed":
			if (statName.equals("defense")) {
				natureMultiplier = 1.1;
			}
			if (statName.equals("speed")) {
				natureMultiplier = 0.9;
			}
			break;
		case "impish":
			if (statName.equals("defense")) {
				natureMultiplier = 1.1;
			}
			if (statName.equals("spAtk")) {
				natureMultiplier = 0.9;
			}
			break;
		case "lax":
			if (statName.equals("defense")) {
				natureMultiplier = 1.1;
			}
			if (statName.equals("spDef")) {
				natureMultiplier = 0.9;
			}
			break;
		case "timid":
			if (statName.equals("speed")) {
				natureMultiplier = 1.1;
			}
			if (statName.equals("attack")) {
				natureMultiplier = 0.9;
			}
			break;
		case "hasty":
			if (statName.equals("speed")) {
				natureMultiplier = 1.1;
			}
			if (statName.equals("defense")) {
				natureMultiplier = 0.9;
			}
			break;
		case "serious":
			natureMultiplier = 1.0;
			break;
		case "jolly":
			if (statName.equals("speed")) {
				natureMultiplier = 1.1;
			}
			if (statName.equals("spAtk")) {
				natureMultiplier = 0.9;
			}
			break;
		case "naive":
			if (statName.equals("attack")) {
				natureMultiplier = 1.1;
			}
			if (statName.equals("spDef")) {
				natureMultiplier = 0.9;
			}
			break;
		case "modest":
			if (statName.equals("spAtk")) {
				natureMultiplier = 1.1;
			}
			if (statName.equals("attack")) {
				natureMultiplier = 0.9;
			}
			break;
		case "mild":
			if (statName.equals("spAtk")) {
				natureMultiplier = 1.1;
			}
			if (statName.equals("defense")) {
				natureMultiplier = 0.9;
			}
			break;
		case "quiet":
			if (statName.equals("spAtk")) {
				natureMultiplier = 1.1;
			}
			if (statName.equals("speed")) {
				natureMultiplier = 0.9;
			}
			break;
		case "bashful":
			natureMultiplier = 1.0;
			break;
		case "rash":
			if (statName.equals("spAtk")) {
				natureMultiplier = 1.1;
			}
			if (statName.equals("spDef")) {
				natureMultiplier = 0.9;
			}
			break;
		case "calm":
			if (statName.equals("spDef")) {
				natureMultiplier = 1.1;
			}
			if (statName.equals("attack")) {
				natureMultiplier = 0.9;
			}
			break;
		case "gentle":
			if (statName.equals("spDef")) {
				natureMultiplier = 1.1;
			}
			if (statName.equals("defense")) {
				natureMultiplier = 0.9;
			}
			break;
		case "sassy":
			if (statName.equals("spDef")) {
				natureMultiplier = 1.1;
			}
			if (statName.equals("speed")) {
				natureMultiplier = 0.9;
			}
			break;
		case "careful":
			if (statName.equals("spDef")) {
				natureMultiplier = 1.1;
			}
			if (statName.equals("spAtk")) {
				natureMultiplier = 0.9;
			}
			break;
		case "quirky":
			natureMultiplier = 1.0;
			break;
		}

		return (int) (((IV + (2 * base) + (EV / 4) * level / 100) + 5) * natureMultiplier);
	}

	/**
	 * This functions returns "yes" if the attacker receives a
	 * "Same Type Attack Bonus" or "no" if not.
	 * 
	 * @param type1
	 *            - the attacker's first typing
	 * @param type2
	 *            - the attacker's second typing
	 * @param attackType
	 *            - the type of the attack
	 * @return - a string
	 */
	public String getSTAB(String type1, String type2, String attackType) {
		String STAB = "no";
		if (type1.equals(attackType)) {
			STAB = "yes";
		}
		if (type2.equals(attackType)) {
			STAB = "yes";
		}
		return STAB;
	}

	/**
	 * This function returns the final multiplier given the attack type and the
	 * defender's weaknesses. Uses switch cases to account for all 18 types
	 * twice.
	 * 
	 * @param type1
	 *            - the defender's first typing
	 * @param type2
	 *            - the defender's second typing
	 * @param typeEffectiveness
	 *            - an object of type "type"
	 * @return - a double
	 */
	public double getTypeMultiplier(String type1, String type2,
			Type typeEffectiveness) {
		double multiplier = 1.0;
		double multiplier1 = 1.0;
		double multiplier2 = 1.0;
		switch (type1) {
		case "normal":
			multiplier1 = Double.parseDouble(typeEffectiveness.getNormal());
			multiplier *= multiplier1;
			break;
		case "fighting":
			multiplier1 = Double.parseDouble(typeEffectiveness.getFighting());
			multiplier *= multiplier1;
			break;
		case "flying":
			multiplier1 = Double.parseDouble(typeEffectiveness.getFlying());
			multiplier *= multiplier1;
			break;
		case "poison":
			multiplier1 = Double.parseDouble(typeEffectiveness.getPoison());
			multiplier *= multiplier1;
			break;
		case "ground":
			multiplier1 = Double.parseDouble(typeEffectiveness.getGround());
			multiplier *= multiplier1;
			break;
		case "rock":
			multiplier1 = Double.parseDouble(typeEffectiveness.getRock());
			multiplier *= multiplier1;
			break;
		case "bug":
			multiplier1 = Double.parseDouble(typeEffectiveness.getBug());
			multiplier *= multiplier1;
			break;
		case "ghost":
			multiplier1 = Double.parseDouble(typeEffectiveness.getGhost());
			multiplier *= multiplier1;
			break;
		case "steel":
			multiplier1 = Double.parseDouble(typeEffectiveness.getSteel());
			multiplier *= multiplier1;
			break;
		case "fire":
			multiplier1 = Double.parseDouble(typeEffectiveness.getFire());
			multiplier *= multiplier1;
			break;
		case "water":
			multiplier1 = Double.parseDouble(typeEffectiveness.getWater());
			multiplier *= multiplier1;
			break;
		case "grass":
			multiplier1 = Double.parseDouble(typeEffectiveness.getGrass());
			multiplier *= multiplier1;
			break;
		case "electric":
			multiplier1 = Double.parseDouble(typeEffectiveness.getElectric());
			multiplier *= multiplier1;
			break;
		case "psychic":
			multiplier1 = Double.parseDouble(typeEffectiveness.getPsychic());
			multiplier *= multiplier1;
			break;
		case "ice":
			multiplier1 = Double.parseDouble(typeEffectiveness.getIce());
			multiplier *= multiplier1;
			break;
		case "dragon":
			multiplier1 = Double.parseDouble(typeEffectiveness.getDragon());
			multiplier *= multiplier1;
			break;
		case "dark":
			multiplier1 = Double.parseDouble(typeEffectiveness.getDark());
			multiplier *= multiplier1;
			break;
		case "fairy":
			multiplier1 = Double.parseDouble(typeEffectiveness.getFairy());
			multiplier *= multiplier1;
			break;
		}
		switch (type2) {
		case "normal":
			multiplier2 = Double.parseDouble(typeEffectiveness.getNormal());
			multiplier *= multiplier2;
			break;
		case "fighting":
			multiplier2 = Double.parseDouble(typeEffectiveness.getFighting());
			multiplier *= multiplier2;
			break;
		case "flying":
			multiplier2 = Double.parseDouble(typeEffectiveness.getFlying());
			multiplier *= multiplier2;
			break;
		case "poison":
			multiplier2 = Double.parseDouble(typeEffectiveness.getPoison());
			multiplier *= multiplier2;
			break;
		case "ground":
			multiplier2 = Double.parseDouble(typeEffectiveness.getGround());
			multiplier *= multiplier2;
			break;
		case "rock":
			multiplier2 = Double.parseDouble(typeEffectiveness.getRock());
			multiplier *= multiplier2;
			break;
		case "bug":
			multiplier2 = Double.parseDouble(typeEffectiveness.getBug());
			multiplier *= multiplier2;
			break;
		case "ghost":
			multiplier2 = Double.parseDouble(typeEffectiveness.getGhost());
			multiplier *= multiplier2;
			break;
		case "steel":
			multiplier2 = Double.parseDouble(typeEffectiveness.getSteel());
			multiplier *= multiplier2;
			break;
		case "fire":
			multiplier2 = Double.parseDouble(typeEffectiveness.getFire());
			multiplier *= multiplier2;
			break;
		case "water":
			multiplier2 = Double.parseDouble(typeEffectiveness.getWater());
			multiplier *= multiplier2;
			break;
		case "grass":
			multiplier2 = Double.parseDouble(typeEffectiveness.getGrass());
			multiplier *= multiplier2;
			break;
		case "electric":
			multiplier2 = Double.parseDouble(typeEffectiveness.getElectric());
			multiplier *= multiplier2;
			break;
		case "psychic":
			multiplier2 = Double.parseDouble(typeEffectiveness.getPsychic());
			multiplier *= multiplier2;
			break;
		case "ice":
			multiplier2 = Double.parseDouble(typeEffectiveness.getIce());
			multiplier *= multiplier2;
			break;
		case "dragon":
			multiplier2 = Double.parseDouble(typeEffectiveness.getDragon());
			multiplier *= multiplier2;
			break;
		case "dark":
			multiplier2 = Double.parseDouble(typeEffectiveness.getDark());
			multiplier *= multiplier2;
			break;
		case "fairy":
			multiplier2 = Double.parseDouble(typeEffectiveness.getFairy());
			multiplier *= multiplier2;
			break;
		}
		return multiplier;
	}

	/**
	 * This function returns the minimum damage the attack will do.
	 * 
	 * @param level
	 *            - the level of the attacker
	 * @param basePower
	 *            - the base power of the attack
	 * @param attackStat
	 *            - the attack stat of the attacker
	 * @param defenseStat
	 *            - the defense stat of the defender
	 * @param crit
	 *            - "yes" for crit, "no" for no
	 * @param STAB
	 *            - "yes" for STAB, "no" for no
	 * @param typeMultiplier
	 *            - the multiplier in accordance to the defender's weaknesses
	 * @return - an int
	 */
	public int minDamage(int level, String basePower, int attackStat,
			int defenseStat, String crit, String STAB, double typeMultiplier) {
		int base = Integer.parseInt(basePower);
		double critMultiplier = 1.0;
		if (crit.equals("yes")) {
			critMultiplier = 1.5;
		}
		double STABmultiplier = 1.0;
		if (STAB.equals("yes")) {
			STABmultiplier = 1.5;
		}
		return (int) (((((((level * 2 / 5) + 2) * base * attackStat / 50) / defenseStat) + 2)
				* critMultiplier * 85 / 100)
				* STABmultiplier * typeMultiplier);
	}

	/**
	 * This function returns the maximum damage the attack will do.
	 * 
	 * @param level
	 *            - the level of the attacker
	 * @param basePower
	 *            - the base power of the attack
	 * @param attackStat
	 *            - the attack stat of the attacker
	 * @param defenseStat
	 *            - the defense stat of the defender
	 * @param crit
	 *            - "yes" for crit, "no" for no
	 * @param STAB
	 *            - "yes" for STAB, "no" for no
	 * @param typeMultiplier
	 *            - the multiplier in accordance to the defender's weaknesses
	 * @return - an int
	 */
	public int maxDamage(int level, String basePower, int attackStat,
			int defenseStat, String crit, String STAB, double typeMultiplier) {
		int base = Integer.parseInt(basePower);
		double critMultiplier = 1.0;
		if (crit.equals("yes")) {
			critMultiplier = 1.5;
		}
		double STABmultiplier = 1.0;
		if (STAB.equals("yes")) {
			STABmultiplier = 1.5;
		}
		return (int) (((((((level * 2 / 5) + 2) * base * attackStat / 50) / defenseStat) + 2)
				* critMultiplier * 100 / 100)
				* STABmultiplier * typeMultiplier);
	}
}
