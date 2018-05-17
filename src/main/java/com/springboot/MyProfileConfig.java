package com.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component//与@Configuration,@SpringBootConfiguration注解一样
public class MyProfileConfig {
	
	@Bean
	public Runnable runnable1() {
		System.out.println("---------default-------------");
		return () -> {};
	}
	
	@Bean
	@Profile({"dev"})//@Profile("dev")效果一样   --spring.profiles.active=dev时输出
	public Runnable runnable2() {
		System.out.println("---------dev-------------");
		return () -> {};
	}
	
	@Bean
	@Profile({"prod"})//--spring.profiles.active=prod时输出
	public Runnable runnable3() {
		System.out.println("---------prod-------------");
		return () -> {};
	}
	
	


}
