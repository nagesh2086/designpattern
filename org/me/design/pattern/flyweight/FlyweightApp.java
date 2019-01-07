package org.me.design.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightApp {

	public static void main(String[] args) {
		String test = "ASKDJFASDIFEWFNDJNVJKADJFASDJKFKLASDJIFJADSFJADSIOJFI34849898438RASDKFJASKDJF";
		char[] charArray = test.toCharArray();

		CharacterFactory cf = new CharacterFactory();
		for (char c : charArray) {
			System.out.println(cf.getCharacter(c));
		}
	}

}

class CharacterFactory {
	Map<Character, Alphabet> charcterMap = new HashMap<>();

	public Alphabet getCharacter(char key) {
		if (charcterMap.containsKey(key)) {
			return charcterMap.get(key);
		} else {
			Alphabet albhabet = null;

			switch (key) {
			case 'A':
				albhabet = new CharacterA();
				charcterMap.put(key, albhabet);
				break;
			case 'B':
				albhabet = new CharacterB();
				charcterMap.put(key, albhabet);
				break;
			case 'C':
				albhabet = new CharacterC();
				charcterMap.put(key, albhabet);
				break;
			case 'D':
				albhabet = new CharacterD();
				charcterMap.put(key, albhabet);
				break;
			case 'E':
				albhabet = new CharacterE();
				charcterMap.put(key, albhabet);
				break;
			case 'F':
				albhabet = new CharacterF();
				charcterMap.put(key, albhabet);
				break;
			case 'G':
				albhabet = new CharacterG();
				charcterMap.put(key, albhabet);
				break;
			case 'H':
				albhabet = new CharacterH();
				charcterMap.put(key, albhabet);
				break;
			case 'I':
				albhabet = new CharacterI();
				charcterMap.put(key, albhabet);
				break;
			case 'J':
				albhabet = new CharacterJ();
				charcterMap.put(key, albhabet);
				break;
			case 'K':
				albhabet = new CharacterK();
				charcterMap.put(key, albhabet);
				break;
			case 'L':
				albhabet = new CharacterL();
				charcterMap.put(key, albhabet);
				break;
			case 'M':
				albhabet = new CharacterM();
				charcterMap.put(key, albhabet);
				break;
			case 'N':
				albhabet = new CharacterN();
				charcterMap.put(key, albhabet);
				break;
			case 'O':
				albhabet = new CharacterO();
				charcterMap.put(key, albhabet);
				break;
			case 'P':
				albhabet = new CharacterP();
				charcterMap.put(key, albhabet);
				break;
			case 'Q':
				albhabet = new CharacterQ();
				charcterMap.put(key, albhabet);
				break;
			case 'R':
				albhabet = new CharacterR();
				charcterMap.put(key, albhabet);
				break;
			case 'S':
				albhabet = new CharacterS();
				charcterMap.put(key, albhabet);
				break;
			case 'T':
				albhabet = new CharacterT();
				charcterMap.put(key, albhabet);
				break;
			case 'U':
				albhabet = new CharacterU();
				charcterMap.put(key, albhabet);
				break;
			case 'V':
				albhabet = new CharacterV();
				charcterMap.put(key, albhabet);
				break;
			case 'W':
				albhabet = new CharacterW();
				charcterMap.put(key, albhabet);
				break;
			case 'X':
				albhabet = new CharacterX();
				charcterMap.put(key, albhabet);
				break;
			case 'Y':
				albhabet = new CharacterY();
				charcterMap.put(key, albhabet);
				break;
			case 'Z':
				albhabet = new CharacterZ();
				charcterMap.put(key, albhabet);
				break;
			default:
				System.out.println(key + " is not available to create and share it");
				break;
			}
			return albhabet;
		}
	}
}

class Alphabet {

}

class CharacterA extends Alphabet {
	private String symbol = "A";

	public CharacterA() {
		System.out.println("A created");
	}

	@Override
	public String toString() {
		return "CharacterA [symbol=" + symbol + "]";
	}
}

class CharacterB extends Alphabet {
	private String symbol = "B";

	public CharacterB() {
		System.out.println("B created");
	}

	@Override
	public String toString() {
		return "CharacterB [symbol=" + symbol + "]";
	}
}

class CharacterC extends Alphabet {
	private String symbol = "C";

	public CharacterC() {
		System.out.println("C created");
	}

	@Override
	public String toString() {
		return "CharacterC [symbol=" + symbol + "]";
	}
}

class CharacterD extends Alphabet {
	private String symbol = "D";

	public CharacterD() {
		System.out.println("D created");
	}

	@Override
	public String toString() {
		return "CharacterD [symbol=" + symbol + "]";
	}
}

class CharacterE extends Alphabet {
	private String symbol = "E";

	public CharacterE() {
		System.out.println("E created");
	}

	@Override
	public String toString() {
		return "CharacterE [symbol=" + symbol + "]";
	}
}

class CharacterF extends Alphabet {
	private String symbol = "F";

	public CharacterF() {
		System.out.println("F created");
	}

	@Override
	public String toString() {
		return "CharacterF [symbol=" + symbol + "]";
	}
}

class CharacterG extends Alphabet {
	private String symbol = "G";

	public CharacterG() {
		System.out.println("G created");
	}

	@Override
	public String toString() {
		return "CharacterG [symbol=" + symbol + "]";
	}
}

class CharacterH extends Alphabet {
	private String symbol = "H";

	public CharacterH() {
		System.out.println("H created");
	}

	@Override
	public String toString() {
		return "CharacterH [symbol=" + symbol + "]";
	}
}

class CharacterI extends Alphabet {
	private String symbol = "I";

	public CharacterI() {
		System.out.println("I created");
	}

	@Override
	public String toString() {
		return "CharacterI [symbol=" + symbol + "]";
	}
}

class CharacterJ extends Alphabet {
	private String symbol = "J";

	public CharacterJ() {
		System.out.println("J created");
	}

	@Override
	public String toString() {
		return "CharacterJ [symbol=" + symbol + "]";
	}
}

class CharacterK extends Alphabet {
	private String symbol = "K";

	public CharacterK() {
		System.out.println("K created");
	}

	@Override
	public String toString() {
		return "CharacterK [symbol=" + symbol + "]";
	}
}

class CharacterL extends Alphabet {
	private String symbol = "L";

	public CharacterL() {
		System.out.println("L created");
	}

	@Override
	public String toString() {
		return "CharacterL [symbol=" + symbol + "]";
	}
}

class CharacterM extends Alphabet {
	private String symbol = "M";

	public CharacterM() {
		System.out.println("M created");
	}

	@Override
	public String toString() {
		return "CharacterM [symbol=" + symbol + "]";
	}
}

class CharacterN extends Alphabet {
	private String symbol = "N";

	public CharacterN() {
		System.out.println("N created");
	}

	@Override
	public String toString() {
		return "CharacterN [symbol=" + symbol + "]";
	}
}

class CharacterO extends Alphabet {
	private String symbol = "O";

	public CharacterO() {
		System.out.println("O created");
	}

	@Override
	public String toString() {
		return "CharacterO [symbol=" + symbol + "]";
	}
}

class CharacterP extends Alphabet {
	private String symbol = "P";

	public CharacterP() {
		System.out.println("P created");
	}

	@Override
	public String toString() {
		return "CharacterP [symbol=" + symbol + "]";
	}
}

class CharacterQ extends Alphabet {
	private String symbol = "Q";

	public CharacterQ() {
		System.out.println("Q created");
	}

	@Override
	public String toString() {
		return "CharacterQ [symbol=" + symbol + "]";
	}
}

class CharacterR extends Alphabet {
	private String symbol = "R";

	public CharacterR() {
		System.out.println("R created");
	}

	@Override
	public String toString() {
		return "CharacterR [symbol=" + symbol + "]";
	}
}

class CharacterS extends Alphabet {
	private String symbol = "S";

	public CharacterS() {
		System.out.println("S created");
	}

	@Override
	public String toString() {
		return "CharacterS [symbol=" + symbol + "]";
	}
}

class CharacterT extends Alphabet {
	private String symbol = "T";

	public CharacterT() {
		System.out.println("T created");
	}

	@Override
	public String toString() {
		return "CharacterT [symbol=" + symbol + "]";
	}
}

class CharacterU extends Alphabet {
	private String symbol = "U";

	public CharacterU() {
		System.out.println("U created");
	}

	@Override
	public String toString() {
		return "CharacterU [symbol=" + symbol + "]";
	}
}

class CharacterV extends Alphabet {
	private String symbol = "V";

	public CharacterV() {
		System.out.println("V created");
	}

	@Override
	public String toString() {
		return "CharacterV [symbol=" + symbol + "]";
	}
}

class CharacterW extends Alphabet {
	private String symbol = "W";

	public CharacterW() {
		System.out.println("W created");
	}

	@Override
	public String toString() {
		return "CharacterW [symbol=" + symbol + "]";
	}
}

class CharacterX extends Alphabet {
	private String symbol = "X";

	public CharacterX() {
		System.out.println("X created");
	}

	@Override
	public String toString() {
		return "CharacterX [symbol=" + symbol + "]";
	}
}

class CharacterY extends Alphabet {
	private String symbol = "Y";

	public CharacterY() {
		System.out.println("Y created");
	}

	@Override
	public String toString() {
		return "CharacterY [symbol=" + symbol + "]";
	}
}

class CharacterZ extends Alphabet {
	public CharacterZ() {
		System.out.println("Z created");
	}

	private String symbol = "Z";

	@Override
	public String toString() {
		return "CharacterZ [symbol=" + symbol + "]";
	}
}