package com.springBasic.testPack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InjectionMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		//appContext.scan("net.codejava");
		appContext.refresh();
		
		Client c1 = (Client) appContext.getBean("client_1");
		c1.behaviour();
		Service service2 = (Service) appContext.getBean("service_2");
		service2.getAction();
		
		appContext.close();

	}
/*abr. 20, 2021 10:01:58 P. M. org.springframework.context.support.AbstractApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@7ab2bfe1: startup date [Tue Apr 20 22:01:58 CEST 2021]; root of context hierarchy
Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'client_1' available
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeanDefinition(DefaultListableBeanFactory.java:686)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getMergedLocalBeanDefinition(AbstractBeanFactory.java:1210)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:291)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199)
	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1089)
	at com.springBasic.testPack.InjectionMain.main(InjectionMain.java:11)
 * */
}
