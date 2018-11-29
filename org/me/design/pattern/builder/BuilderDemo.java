package org.me.design.pattern.builder;

import java.util.HashMap;
import java.util.Map;

/**
 * Separate the construction of a complex object from its representation so that
 * the same construction process can create different representations.
 * 
 * @author kekannag
 *
 */
public class BuilderDemo {

	public static void main(String[] args) {
		System.out.println(
				"Separate the construction of a complex object from its representation so that \nthe same construction process can create different representations.");
		System.out.println("-----------------------------------------------------------------------------\n");

		VehicleShop s = new VehicleShop();

		Vehicle mcycle = s.shop(new MotorCycleBuilder());
		System.out.println(mcycle + "\n");

		Vehicle car = s.shop(new CarBuilder());
		System.out.println(car);
	}

}

class Vehicle {
	private String _vehicleType;
	private Map<String, String> m = new HashMap<>();

	public Vehicle(String _vehicleType) {
		this._vehicleType = _vehicleType;
	}

	public String getPart(String _part) {
		return m.get(_part);
	}

	public void setPart(String _part, String _details) {
		m.put(_part, _details);
	}

	@Override
	public String toString() {
		return "Vehicle [_vehicleType=" + _vehicleType + ", m=" + m + "]";
	}

}

abstract class VehicleBuilder {
	protected static final String FRAME = "frame";
	protected static final String ENGINE = "engine";
	protected static final String WHEELS = "wheels";
	protected static final String DOORS = "doors";

	protected Vehicle vehicle;

	public Vehicle getVehicle() {
		return vehicle;
	}

	abstract void buildFrame();

	abstract void buildEngine();

	abstract void buildWheels();

	abstract void buildDoors();
}

class MotorCycleBuilder extends VehicleBuilder {

	public MotorCycleBuilder() {
		this.vehicle = new Vehicle("MotorCycle builder");
	}

	@Override
	void buildFrame() {
		vehicle.setPart(FRAME, "Motorcycle Frame");
	}

	@Override
	void buildEngine() {
		vehicle.setPart(ENGINE, "500 cc");
	}

	@Override
	void buildWheels() {
		vehicle.setPart(WHEELS, "2");
	}

	@Override
	void buildDoors() {
		vehicle.setPart(DOORS, "0");
	}

}

class CarBuilder extends VehicleBuilder {

	public CarBuilder() {
		vehicle = new Vehicle("Car builder");
	}

	@Override
	void buildFrame() {
		vehicle.setPart(FRAME, "Car Frame");
	}

	@Override
	void buildEngine() {
		vehicle.setPart(ENGINE, "2000 cc");
	}

	@Override
	void buildWheels() {
		vehicle.setPart(WHEELS, "4");
	}

	@Override
	void buildDoors() {
		vehicle.setPart(DOORS, "4");
	}

}

class VehicleShop {
	Vehicle shop(VehicleBuilder builder) {
		builder.buildFrame();
		builder.buildEngine();
		builder.buildWheels();
		builder.buildDoors();
		return builder.getVehicle();
	}
}
