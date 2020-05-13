package org.wesoft.spring.observer.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MailBean {

	@Autowired
	ApplicationContext applicationContext;

	public void sendMail(String content) {
		SpringMailEvent mailEvent = new SpringMailEvent(applicationContext);
		mailEvent.setContent(content);

		// 触发邮件事件
		applicationContext.publishEvent(mailEvent);
	}

}
