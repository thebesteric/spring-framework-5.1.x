package org.wesoft.spring.lifecycle.bean;

import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-11 00:42
 */
@Component
public class Life implements Lifecycle {

	private boolean isRunning = false;

	// 容器启动完就会调用：isRunning = true
	@Override
	public void start() {
		System.out.println("start");
		isRunning = true;
	}

	// 容器停止就会调用：isRunning = false
	@Override
	public void stop() {
		System.out.println("stop");
		isRunning = false;
	}

	// start 和 stop 的调用前提
	@Override
	public boolean isRunning() {
		return isRunning;
	}
}
