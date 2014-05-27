/**
 * This is the main class. It returns the minimum and maximum damage that an attack will do. 
 * @author Kerry Zhao
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PokemonDmgSim {

	// the name of the attacking Pokemon
	private String attackerName;
	// the name of the defending Pokemon
	private String defenderName;
	// a Pokemon object for the attacking Pokemon
	private static Pokemon attacker;
	// a Pokemon object for the defending Pokemon
	private static Pokemon defender;
	// an Attack object
	private static Attack attackAttributes;
	// a Type object
	private static Type typeEffectiveness;
	// the minimum damage
	private static int minDamage = 0;
	// the maximum damage
	private static int maxDamage = 0;
	// the calculator
	private static PokemonDmgCalc calc = new PokemonDmgCalc();

	// the main class
	public static void main(String[] args) throws IOException {
		try {
			// files and filereaders
			// currently using text files
			File pDex = new File("Pokedex.txt");
			File aDex = new File("Attackdex.txt");
			File tDex = new File("Typedex.txt");

			// reader for the Pokedex
			HashMap<String, String[]> pMap = new HashMap<String, String[]>();
			BufferedReader br = new BufferedReader(new FileReader(pDex));
			for (String line; (line = br.readLine()) != null;) {
				String[] pokemonName = line.split(" ");
				String[] values = new String[8];
				for (int i = 1; i < pokemonName.length; i++) {
					values[i - 1] = pokemonName[i];
				}
				pMap.put(pokemonName[0], values);
			}

			// reader for the Attackdex
			HashMap<String, String[]> aMap = new HashMap<String, String[]>();
			BufferedReader br2 = new BufferedReader(new FileReader(aDex));
			for (String line; (line = br2.readLine()) != null;) {
				String[] attackName = line.split(" ");
				String[] attackAttributes = new String[4];
				for (int i = 1; i < attackName.length; i++) {
					attackAttributes[i - 1] = attackName[i];
				}
				aMap.put(attackName[0], attackAttributes);
			}

			// reader for the Typedex
			HashMap<String, String[]> tMap = new HashMap<String, String[]>();
			BufferedReader br4 = new BufferedReader(new FileReader(tDex));
			for (String line; (line = br4.readLine()) != null;) {
				String[] typeName = line.split(" ");
				String[] typeEffectiveness = new String[18];
				for (int i = 1; i < typeName.length; i++) {
					typeEffectiveness[i - 1] = typeName[i];
				}
				tMap.put(typeName[0], typeEffectiveness);
			}

			// receive input for attacker
			BufferedReader br3 = new BufferedReader(new InputStreamReader(
					System.in));
			System.out
					.println("Enter Attacking Pokemon's Name (all lowercase): ");
			String thisAttackerName = br3.readLine();
			System.out.println("Enter Attacking Pokemon's Atk/spAtk IV: ");
			int thisAttackerIV = Integer.parseInt(br3.readLine());
			System.out.println("Enter Attacking Pokemon's Atk/spAtk EV: ");
			int thisAttackerEV = Integer.parseInt(br3.readLine());
			System.out.println("Enter Attacking Pokemon's nature: ");
			String thisAttackerNature = br3.readLine();
			System.out.println("Enter Attacking Pokemon's Level: ");
			int thisAttackerLevel = Integer.parseInt(br3.readLine());
			try {
				String[] attackerBase = pMap.get(thisAttackerName);
				attacker = new Pokemon(attackerBase[0], attackerBase[1],
						attackerBase[2], attackerBase[3], attackerBase[4],
						attackerBase[5], attackerBase[6], attackerBase[7]);
			} catch (Exception e) {
				System.err.println("Error: incorrect Pokemon name");
			}

			// receieve input for defender
			System.out
					.println("Enter Defending Pokemon's Name (all lowercase): ");
			String thisDefenderName = br3.readLine();
			System.out.println("Enter Defending Pokemon's HP IV: ");
			int thisDefenderHPIV = Integer.parseInt(br3.readLine());
			System.out.println("Enter Defending Pokemon's HP EV: ");
			int thisDefenderHPEV = Integer.parseInt(br3.readLine());
			System.out.println("Enter Defending Pokemon's Def/spDef IV: ");
			int thisDefenderIV = Integer.parseInt(br3.readLine());
			System.out.println("Enter Defending Pokemon's Def/spDef EV: ");
			int thisDefenderEV = Integer.parseInt(br3.readLine());
			System.out.println("Enter Defending Pokemon's nature: ");
			String thisDefenderNature = br3.readLine();
			System.out.println("Enter Defending Pokemon's Level: ");
			int thisDefenderLevel = Integer.parseInt(br3.readLine());
			try {
				String[] defenderBase = pMap.get(thisDefenderName);
				defender = new Pokemon(defenderBase[0], defenderBase[1],
						defenderBase[2], defenderBase[3], defenderBase[4],
						defenderBase[5], defenderBase[6], defenderBase[7]);
			} catch (Exception e) {
				System.err.println("Error: incorrect Pokemon name");
			}

			// receive input for attack
			System.out
					.println("Enter Attack Name (no spaces | i.e. aquaTail): ");
			String attackName = br3.readLine();
			System.out.println("Is this attack a critical hit? (yes/no): ");
			String crit = br3.readLine();

			try {
				String[] attack = aMap.get(attackName);
				attackAttributes = new Attack(attack[0], attack[1], attack[2],
						attack[3]);
				String thisType = attackAttributes.getType();
				String[] type = tMap.get(thisType);
				typeEffectiveness = new Type(type[0], type[1], type[2],
						type[3], type[4], type[5], type[6], type[7], type[8],
						type[9], type[10], type[11], type[12], type[13],
						type[14], type[15], type[16], type[17]);
				String STAB = calc.getSTAB(attacker.getType1(),
						attacker.getType2(), attackAttributes.getType());
				double typeMultiplier = calc.getTypeMultiplier(
						defender.getType1(), defender.getType2(),
						typeEffectiveness);

				if (attackAttributes.getSpectrum().equals("physical")) {
					int attackStat = calc.calcNotHP("attack",
							attacker.getAtk(), thisAttackerIV, thisAttackerEV,
							thisAttackerLevel, thisAttackerNature);
					int defenseStat = calc.calcNotHP("defense",
							defender.getDef(), thisDefenderIV, thisDefenderEV,
							thisDefenderLevel, thisDefenderNature);
					minDamage = calc.minDamage(thisAttackerLevel,
							attackAttributes.getBase(), attackStat,
							defenseStat, crit, STAB, typeMultiplier);
					maxDamage = calc.maxDamage(thisAttackerLevel,
							attackAttributes.getBase(), attackStat,
							defenseStat, crit, STAB, typeMultiplier);
				}
				if (attackAttributes.getSpectrum().equals("special")) {
					int attackStat = calc.calcNotHP("spAtk",
							attacker.getSpAtk(), thisAttackerIV,
							thisAttackerEV, thisAttackerLevel,
							thisAttackerNature);
					int defenseStat = calc.calcNotHP("spDef",
							defender.getSpDef(), thisDefenderIV,
							thisDefenderEV, thisDefenderLevel,
							thisDefenderNature);
					minDamage = calc.minDamage(thisAttackerLevel,
							attackAttributes.getBase(), attackStat,
							defenseStat, crit, STAB, typeMultiplier);
					maxDamage = calc.maxDamage(thisAttackerLevel,
							attackAttributes.getBase(), attackStat,
							defenseStat, crit, STAB, typeMultiplier);
				}

				// print out damage dealt
				double minPercentage = (double) minDamage
						/ (double) (calc.calcHP(defender.getHP(),
								thisDefenderIV, thisDefenderEV,
								thisDefenderLevel));
				double maxPercentage = (double) maxDamage
						/ (double) (calc.calcHP(defender.getHP(),
								thisDefenderIV, thisDefenderEV,
								thisDefenderLevel));
				System.out.println("Minimum Damage: " + minDamage + " ("
						+ minPercentage + "%)");
				System.out.println("Maximum Damage: " + maxDamage + " ("
						+ maxPercentage + "%)");

			} catch (Exception e) {
				System.err.println("Error: incorrect attack name");
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
