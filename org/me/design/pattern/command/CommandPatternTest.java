package org.me.design.pattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Encapsulate a request as an object, thereby letting you parameterize clients
 * with different requests, queue or log requests, and support undoable
 * operations.
 * 
 * @author kekannag
 *
 */
public class CommandPatternTest {

	public static void main(String[] args) {
		
		System.out.println("* Encapsulate a request as an object, thereby letting you parameterize clients\r\n" + 
				" * with different requests, queue or log requests, and support undoable\r\n" + 
				" * operations.");
		System.out.println("-----------------------------------------------------------------------------------");
		
		User user = new User();
		List<Command> list = user.getList();
		list.add(new CalculatorCommand("addition"));
		list.add(new CalculatorCommand("multiplication"));
		list.add(new CalculatorCommand("substraction"));
		list.add(new CalculatorCommand("division"));

		user.compute();
	}

}

// Invoker user
class User {
	private List<Command> list = new ArrayList<>();

	public List<Command> getList() {
		return list;
	}

	public void compute() {
		for (Command command : list) {
			command.execute();
		}
	}
}

//receiver
class Calculator {

	void operation(Command command) {
		System.out.println(command);
	}
}

//command
interface Command {
	void execute();
}

//concrete command impl
class CalculatorCommand implements Command {
	private Calculator calculator = new Calculator();
	private String ops;

	CalculatorCommand(String ops) {
		this.ops = ops;
	}

	@Override
	public void execute() {
		calculator.operation(this);
	}

	@Override
	public String toString() {
		return "CalculatorCommand [calculator executed " + ", ops=" + ops + "]";
	}

}
