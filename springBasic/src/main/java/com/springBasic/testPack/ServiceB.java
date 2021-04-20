package com.springBasic.testPack;

import org.springframework.stereotype.Component;

@Component("service_2")
public class ServiceB implements Service{

	public String getAction() {
		return "find the user";
	}

}
