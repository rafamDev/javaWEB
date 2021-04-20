package com.springBasic.testPack;

import org.springframework.stereotype.Component;

@Component("service_3")
public class ServiceC implements Service{

	public String getAction() {
	   return "delete the user";
	}

}
