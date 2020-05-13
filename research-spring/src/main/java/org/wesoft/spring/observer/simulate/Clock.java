package org.wesoft.spring.observer.simulate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Clock implements Runnable {

	private List<ClockListener> listeners = new ArrayList<>();

	ClockEvent event;

	public Clock(ClockEvent event) {
		this.event = event;
	}

	public void addListener(ClockListener listener) {
		listeners.add(listener);
	}

	public void start() {
		System.out.println("It's " + event.getTime() + " o'clock");
		for (ClockListener listener : listeners) {
			listener.update(event);
		}
	}

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(3);
			start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
