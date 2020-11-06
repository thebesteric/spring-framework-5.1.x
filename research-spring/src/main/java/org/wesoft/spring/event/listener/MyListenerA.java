package org.wesoft.spring.event.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * MyListenerA
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-06-22 16:20
 * @since 1.0
 */
@Component
public class MyListenerA implements ApplicationListener<AEvent> {
	@Override
	public void onApplicationEvent(AEvent event) {
		System.out.println(Thread.currentThread().getName() + " MyListenerA: " + event);
	}
}
