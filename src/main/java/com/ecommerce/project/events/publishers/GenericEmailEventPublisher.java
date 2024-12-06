package com.ecommerce.project.events.publishers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.ecommerce.project.events.GenericEmailEvent;

@Component
public class GenericEmailEventPublisher {
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	public void publishGenericEmailEvent(String email, String assunto,
			List<String> paragrafos) {
		GenericEmailEvent event = createNewGenericEmailEvent(email, assunto, paragrafos);
		publisher.publishEvent(event);
	}
	
	public GenericEmailEvent createNewGenericEmailEvent(String email, String assunto,
			List<String> paragrafos) {
		return new GenericEmailEvent(this, email, assunto, paragrafos);
	}

}
