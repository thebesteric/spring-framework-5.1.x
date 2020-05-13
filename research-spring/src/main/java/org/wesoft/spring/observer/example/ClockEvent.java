package org.wesoft.spring.observer.example;

public class ClockEvent {

	private int time;
	private int day;

	public ClockEvent(int day, int time) {
		this.day = day;
		this.time = time;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
}
