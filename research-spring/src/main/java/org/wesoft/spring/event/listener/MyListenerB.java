package org.wesoft.spring.event.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * MyListenerB
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-06-22 16:53
 * @since 1.0
 */
@Component
public class MyListenerB {

	@Async
	@EventListener
	public void listen(AEvent event) {
		System.out.println(Thread.currentThread().getName() + " MyListenerB: " + event);
	}

}
