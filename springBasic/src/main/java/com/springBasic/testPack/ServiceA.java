package com.springBasic.testPack;

import org.springframework.stereotype.Component;

@Component("service_1")
public class ServiceA implements Service {

	public String getAction() {
		return "set a list of users";
	}

}
