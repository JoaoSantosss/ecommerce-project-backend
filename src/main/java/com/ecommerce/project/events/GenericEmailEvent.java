package com.ecommerce.project.events;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GenericEmailEvent extends ApplicationEvent{

	private static final long serialVersionUID = 1L;
	
	private String email;
    private String subject;
    private String paragraph;
    
	public GenericEmailEvent(Object source) {
		super(source);
	}

	public GenericEmailEvent(Object source, String email, String subject,
			String paragraph) {
		super(source);
		this.email = email;
		this.subject = subject;
		this.paragraph = paragraph;
	}



}
