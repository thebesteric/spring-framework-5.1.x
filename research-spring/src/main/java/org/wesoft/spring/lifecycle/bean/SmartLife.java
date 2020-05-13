package org.wesoft.spring.lifecycle.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-11 22:53
 */
@Component
public class SmartLife implements SmartLifecycle {

	// 是否自动调用
	@Override
	public boolean isAutoStartup() {
		return true;
	}

	@Override
	public void stop(Runnable callback) {
		System.out.println("smart callback stop");
	}

	// 优先级，如果有多个生命周期监控
	// 启动时，值越小，优先级越高
	// 停止时，值越大，优先级越高
	@Override
	public int getPhase() {
		return 0;
	}

	@Override
	public void start() {
		System.out.println("smart start");
	}

	@Override
	public void stop() {
		System.out.println("smart stop");
	}

	@Override
	public boolean isRunning() {
		return false;
	}
}
