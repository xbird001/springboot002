package com.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component
/*@PropertySource(value = { "classpath:/jdbc.properties" })
@PropertySource(value = { "classpath:/login.properties" })*/
//PropertySource[] value();
@PropertySources(value = { @PropertySource(value = { "classpath:/jdbc.properties" }),
						   @PropertySource(value = { "classpath:/login.properties" }) })
public class MyConfig4Other {

	//这里的属性，全部都可以放在其他的类中，只要这个类被spring容器管理到了，用spring el就可以获取到
	@Value("${db.name}")
	private String name;
	@Value("${da.password}")
	private String password;
	@Value("${login.userName}")
	private String loingUserName;
	@Value("${loing.password}")
	private String loingPassword;
	/**
	 * 模拟从远程获取的配置文件属性：在这里主要是通过实现EnvironmentPostProcessor的实现类动态的加入配置文件并获取属性，
	 * 具体参见：com.springboot.RemoteEnvironmentPostProcessor
	 */
	@Value("${springboot.name}")
	private String springBootName;
	
	
	@Override
	public String toString() {
		return "MyConfig4Other [name=" + name + ", password=" + password
				+ ", loingUserName=" + loingUserName + ", loingPassword="
				+ loingPassword + ", springBootName=" + springBootName + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoingUserName() {
		return loingUserName;
	}
	public void setLoingUserName(String loingUserName) {
		this.loingUserName = loingUserName;
	}
	public String getLoingPassword() {
		return loingPassword;
	}
	public void setLoingPassword(String loingPassword) {
		this.loingPassword = loingPassword;
	}
	public String getSpringBootName() {
		return springBootName;
	}
	public void setSpringBootName(String springBootName) {
		this.springBootName = springBootName;
	}
	
	
}
