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
public class IndianMobileChargerDemo {

	public static void main(String[] args) {
		System.out.println("Structural design pattern - Match interfaces of different classes\r \n"
				+ "* Convert the interface of a class into another interface clients expect.\r\n"
				+ "* Adapter lets classes work together that couldn't otherwise because of\r\n"
				+ "* incompatible interfaces.");
		System.out.println("-------------------------------------------------------------------\n");

		IndianSocket c = new IndianSocket("XIOMI IND STD NOTE 3");
		c.charge();

		IndianSocket w = new IndianEuropeanSocketAdapter("Apple eur std");
		w.charge();

		IndianSocket e = new IndianEuropeanSocketAdapter("NOKIA eur std");
		e.charge();
	}

}

/// The 'Adaptee' class
class EuropeanSocket {
	// The European socket and cannot charge directly if device is not made for
	// European electrical region standards.
	public void charge() {
		System.out.println("EuropeanSocket: charging...");
	}
}

/// The 'Target' class
class IndianSocket {
	protected String _device;

	// Constructor
	public IndianSocket(String _device) {
		this._device = _device;
	}

	public void charge() {
		System.out.printf("\n\nCharging IND SOCKET: {%s} ------ ", _device);
	}
}

/// The 'Adapter' class
class IndianEuropeanSocketAdapter extends IndianSocket {
	private EuropeanSocket _socket;

	// Constructor
	public IndianEuropeanSocketAdapter(String _device) {
		super(_device);
	}

	@Override
	public void charge() {
		// The Adaptee
		_socket = new EuropeanSocket();

		super.charge();

		System.out.printf("\nCharging through EUR SOCKET : {%s} ------ \n", _device);
	}
}
