package com.codeprep.rabbitmq;

import java.io.Serializable;

public class MessageDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String message;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
