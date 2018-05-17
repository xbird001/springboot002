package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

@Component
public class MyConfig4SB {
	
	@Autowired
	private ConfigurableEnvironment env;

	/**
	 * 通过spring el表达式可以从springboot的默认配置文件中读取属性
	 */
	@Value("${tomcat.ip}")
	private String ip;
	
	@Value("${tomcat.port}")
	private String port;
	
	/**
	 * 只有当配置文件中没有配置tomcat.x1属性时，默认值1234才会赋值，如果配置文件中方没有tomcat.x1，并且没有给定默认值时，报错
	 */
	@Value("${tomcat.x1:1234}")
	private String x1;
	
	public void show() {
		System.out.println("MyConfig tomcat.ip:" + env.getProperty("tomcat.ip"));
		System.out.println("MyConfig tomcat.port:" + env.getProperty("tomcat.port"));
		
	}
	
	@Override
	public String toString() {
		return "MyConfig [ip=" + ip + ", port=" + port + ", x1=" + x1 + "]";
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
	
}
