package org.wesoft.spring.observer.simulate;

public class Test {

	public static void main(String[] args) {
		Clock clock = new Clock(new ClockEvent(1,7));
		clock.addListener(new Gary());
		clock.addListener(new Eric());
		Thread t1 = new Thread(clock);
		t1.start();
	}
}
