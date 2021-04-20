package com.springBasic.testPack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("client_1")
public class ClientA implements Client {

	private Service service;
	
	@Autowired
	public ClientA(Service service) {
		super();
		this.service = service;
	}

	public void behaviour() {
		String action = this.service.getAction(); 
		System.out.println(action);
	}

}
