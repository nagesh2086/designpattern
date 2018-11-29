package org.me.design.pattern.abstractfactory;

/**
 * Provide an interface for creating families of related or dependent objects
 * without specifying their concrete classes.
 * 
 * @author kekannag
 *
 */
public class AbstractFactoryDemo {

	public static void main(String[] args) {
		System.out.println("Provide an interface for creating families of related or dependent objects\r\n"
				+ "without specifying their concrete classes.");
		System.out.println("-----------------------------------------------------------------------------\n");

		// see from africa
		ContinentFactory africaFactory = new AfricaFactory();
		Carnivore af_carnivore = africaFactory.createCarnivore();
		af_carnivore.eat();
		Herbivore af_herbivore = africaFactory.createHerbivore();
		af_herbivore.eat();

		// see from africa
		ContinentFactory americaFactory = new AmericaFactory();
		Carnivore amer_Carnivore = americaFactory.createCarnivore();
		amer_Carnivore.eat();
		Herbivore amer_herbivore = americaFactory.createHerbivore();
		amer_herbivore.eat();
	}

}

abstract class ContinentFactory {
	abstract Herbivore createHerbivore();

	abstract Carnivore createCarnivore();
}

class AfricaFactory extends ContinentFactory {

	@Override
	Herbivore createHerbivore() {
		return new Wildebeest();
	}

	@Override
	Carnivore createCarnivore() {
		return new Lion();
	}

}

class AmericaFactory extends ContinentFactory {

	@Override
	Herbivore createHerbivore() {
		return new Bison();
	}

	@Override
	Carnivore createCarnivore() {
		return new Wolf();
	}

}

abstract class Herbivore {
	abstract void eat();
}

class Bison extends Herbivore {

	@Override
	void eat() {
		System.out.println("Bison is eating... (grasses, fruits, leaves)");
	}

}

//Wildebeest 
class Wildebeest extends Herbivore {

	@Override
	void eat() {
		System.out.println("Wildebeest is eating... (grasses, fruits, leaves)");
	}

}

abstract class Carnivore {
	abstract void eat();
}

class Wolf extends Carnivore {

	@Override
	void eat() {
		System.out.println("Wolf is eating...(Meat eater)");
	}

}

class Lion extends Carnivore {

	@Override
	void eat() {
		System.out.println("Lion is eating...(Meat eater)");
	}

}
