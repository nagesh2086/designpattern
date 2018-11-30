package org.me.design.pattern.adapter;

/**
 * Structural design pattern:
 * 
 * Convert the interface of a class into another interface clients expect.
 * Adapter lets classes work together that couldn't otherwise because of
 * incompatible interfaces.
 * 
 * @author kekannag
 *
 */
public class AdapterDemo {

	public static void main(String[] args) {
		System.out.println("Structural design pattern - Match interfaces of different classes\r \n"
				+ "* Convert the interface of a class into another interface clients expect.\r\n"
				+ "* Adapter lets classes work together that couldn't otherwise because of\r\n"
				+ "* incompatible interfaces.");
		System.out.println("-------------------------------------------------------------------\n");

		Compound c = new Compound("unknown");
		c.display();

		Compound w = new RichCompound("water");
		w.display();

		Compound b = new RichCompound("benzene");
		b.display();

		Compound e = new RichCompound("ethanol");
		e.display();
	}

}

/// The 'Adaptee' class
class ChemicalDatabank {
	// The databank 'legacy API'
	public float GetCriticalPoint(String compound, String point) {
		// Melting Point

		if (point == "M") {
			switch (compound.toLowerCase()) {
			case "water":
				return 0.0f;
			case "benzene":
				return 5.5f;
			case "ethanol":
				return -114.1f;
			default:
				return 0f;
			}
		}
		// Boiling Point

		else

		{
			switch (compound.toLowerCase()) {
			case "water":
				return 100.0f;
			case "benzene":
				return 80.1f;
			case "ethanol":
				return 78.3f;
			default:
				return 0f;
			}
		}
	}

	public String GetMolecularStructure(String compound) {
		switch (compound.toLowerCase()) {
		case "water":
			return "H20";
		case "benzene":
			return "C6H6";
		case "ethanol":
			return "C2H5OH";
		default:
			return "";
		}
	}

	public double GetMolecularWeight(String compound) {
		switch (compound.toLowerCase()) {
		case "water":
			return 18.015;
		case "benzene":
			return 78.1134;
		case "ethanol":
			return 46.0688;
		default:
			return 0d;
		}
	}
}

/// The 'Target' class
class Compound {
	protected String _chemical;
	protected float _boilingPoint;
	protected float _meltingPoint;
	protected double _molecularWeight;
	protected String _molecularFormula;

	// Constructor
	public Compound(String chemical) {
		this._chemical = chemical;
	}

	public void display() {
		System.out.printf("\nCompound: {%s} ------ ", _chemical);
	}
}

/// The 'Adapter' class
class RichCompound extends Compound {
	private ChemicalDatabank _bank;

	// Constructor
	public RichCompound(String name) {
		super(name);
	}

	@Override
	public void display() {
		// The Adaptee
		_bank = new ChemicalDatabank();

		_boilingPoint = _bank.GetCriticalPoint(_chemical, "B");
		_meltingPoint = _bank.GetCriticalPoint(_chemical, "M");
		_molecularWeight = _bank.GetMolecularWeight(_chemical);
		_molecularFormula = _bank.GetMolecularStructure(_chemical);

		super.display();
		System.out.printf(" Formula: {%s}", _molecularFormula);
		System.out.printf(" Weight : {%f}", _molecularWeight);
		System.out.printf(" Melting Pt: {%f}", _meltingPoint);
		System.out.printf(" Boiling Pt: {%f}", _boilingPoint);
	}
}
