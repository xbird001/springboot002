package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {
	
	public static void main(String[] args) {
		
		
		//通过获得环境变量方式获取
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		System.out.println("tomcat.ip:" + context.getEnvironment().getProperty("tomcat.ip"));
		System.out.println("tomcat.port:" + context.getEnvironment().getProperty("tomcat.port"));
		//根据启动时配置的参数spring.profiles.active的不同而输出不同的参数
		System.out.println("jdbc.url:" + context.getEnvironment().getProperty("jdbc.url"));
		/**
		 * 模拟从远程获取的配置文件属性：在这里主要是通过实现EnvironmentPostProcessor的实现类动态的加入配置文件并获取属性，
		 * 具体参见：com.springboot.RemoteEnvironmentPostProcessor
		 */
		System.out.println("springboot.name:" + context.getEnvironment().getProperty("springboot.name"));
		
		MyConfig4SB myConfig = context.getBean(MyConfig4SB.class);
		myConfig.show();
		System.out.println(myConfig);
		
		MyConfig4Other myConfig4Other = context.getBean(MyConfig4Other.class);
		System.out.println(myConfig4Other.toString());
		
		OracleConfigPrefix oracleConfigPrefix = context.getBean(OracleConfigPrefix.class);
		System.out.println(oracleConfigPrefix);
		
		RedisConfig redisConfig = context.getBean(RedisConfig.class);
		System.out.println(redisConfig);
		

	}

}
