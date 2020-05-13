package org.wesoft.spring.observer.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@Component
public class SpringMailListener implements ApplicationListener<SpringMailEvent> {

	@Override
	public void onApplicationEvent(SpringMailEvent event) {
		System.out.println("event.getContent() = " + event.getContent());
	}
}
