package org.wesoft.spring.observer.example;

import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Eric implements Observer {

	List<Integer> days = Arrays.asList(1, 2, 3, 4, 5, 7);

	@Override
	public void update(Observable observable, Object o) {
		ClockEvent event = (ClockEvent) o;
		if (days.contains(event.getDay())) {
			System.out.println(this.getClass().getSimpleName() + " wake up to work...");
		} else {
			System.out.println("continue sleep...");
		}
	}
}
