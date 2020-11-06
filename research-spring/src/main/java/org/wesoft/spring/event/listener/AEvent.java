package org.wesoft.spring.event.listener;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * AEvent
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-06-22 16:21
 * @since 1.0
 */
public class AEvent extends ApplicationEvent {

	private String name;
	private int age;

	public AEvent(Object source) {
		super(source);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "AEvent{" +
				"name='" + name + '\'' +
				", age='" + age + '\'' +
				'}';
	}
}
