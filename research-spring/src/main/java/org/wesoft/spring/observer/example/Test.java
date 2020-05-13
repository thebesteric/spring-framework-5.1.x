package org.wesoft.spring.observer.example;


public class Test {

	public static void main(String[] args) {
		Clock clock = new Clock(new ClockEvent(1, 7));
		clock.addObserver(new Gary());
		clock.addObserver(new Eric());
		clock.start();
	}

}
