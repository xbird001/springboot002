package com.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//此处的配置文件，已经在MyConfig4Other的注解@PropertySources上面读取进来
@ConfigurationProperties(prefix="oracle" )
public class OracleConfigPrefix {
	
	private String userName;
	
	private String password;

	@Override
	public String toString() {
		return "Oracle [userName=" + userName + ", password=" + password + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
