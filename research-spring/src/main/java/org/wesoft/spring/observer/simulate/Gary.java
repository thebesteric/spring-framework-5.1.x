package org.wesoft.spring.observer.simulate;

import java.util.Arrays;
import java.util.List;

public class Gary implements ClockListener {

	List<Integer> days = Arrays.asList(1, 2, 3, 4, 5, 7);

	@Override
	public void update(ClockEvent event) {
		if (days.contains(event.getDay())) {
			System.out.println(this.getClass().getSimpleName() + " wake up to school...");
		} else {
			System.out.println("continue sleep...");
		}

	}

}
