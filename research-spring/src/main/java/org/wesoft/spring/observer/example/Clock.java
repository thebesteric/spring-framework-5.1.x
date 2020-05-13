package org.wesoft.spring.observer.example;


import java.util.Observable;

public class Clock extends Observable {

	ClockEvent event;

	public Clock(ClockEvent event) {
		this.event = event;
	}

	public void start() {
		System.out.println("It's " + event.getTime() + " o'clock");
		setChanged();
		notifyObservers(event);
	}

}