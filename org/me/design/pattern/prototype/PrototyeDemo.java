package org.me.design.pattern.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Specify the kind of objects to create using a prototypical instance, and
 * create new objects by copying this prototype.
 * 
 * @author kekannag
 *
 */
public class PrototyeDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		System.out.println(" * Specify the kind of objects to create using a prototypical instance, and\r\n"
				+ " * create new objects by copying this prototype.");
		System.out.println("----------------------------------------------------------------\n");

		ColorManager cm = new ColorManager();

		cm.getCs().get("red").cclone();
		cm.getCs().get("green").cclone();
		cm.getCs().get("blue").cclone();
		cm.getCs().get("angry").cclone();
		cm.getCs().get("peace").cclone();

		System.out.println("\n----------------------------------------------------------------\n"
				+ "super.clone() intent test \n");
		final Color flamePrototype = cm.getCs().get("flame");
		final Color clonedPrototype = flamePrototype.cclone();

		if (clonedPrototype != flamePrototype) {
			System.out.println("x.clone() != x");
		}

		if (clonedPrototype.getClass().getName() == flamePrototype.getClass().getName()) {
			System.out.println("x.clone().getClass() == x.getClass()");
		}

		if (clonedPrototype.equals(flamePrototype)) {
			System.out.println("x.clone().equals(x)");
		}
	}

}

class ColorManager {

	public ColorManager() {
		init();
	}

	private Map<String, Color> cs = new HashMap<String, Color>();

	public Map<String, Color> getCs() {
		return cs;
	}

	private void init() {
		cs.put("red", new Color("red", 255, 0, 0));
		cs.put("green", new Color("green", 0, 255, 0));
		cs.put("blue", new Color("blue", 0, 0, 255));

		cs.put("angry", new Color("angry", 255, 54, 0));
		cs.put("peace", new Color("peace", 128, 211, 128));
		cs.put("flame", new Color("flame", 211, 34, 20));
	}
}

abstract class ColorPrototype {
	abstract Color cclone() throws CloneNotSupportedException;
}

class Color extends ColorPrototype implements Cloneable {
	private String name;
	private int red;
	private int green;
	private int blue;

	public Color(String name, int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.name = name;
	}

	@Override
	public String toString() {
		String txt = "Color: [ " + name + ", " + red + ", " + green + ", " + blue + " ]";
		System.out.println(txt);
		return txt;
	}

	@Override
	Color cclone() throws CloneNotSupportedException {
		String txt = "Cloning color: [ " + name + ", " + red + ", " + green + ", " + blue + " ]";
		System.out.println(txt);
		return (Color) super.clone();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + blue;
		result = prime * result + green;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + red;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Color)) {
			return false;
		}
		Color other = (Color) obj;
		if (blue != other.blue) {
			return false;
		}
		if (green != other.green) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (red != other.red) {
			return false;
		}
		return true;
	}

}