package com.springboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置文件已经在MyConfig4Other中的@PropertySources(value = { @PropertySource(value = { "classpath:/jdbc.properties" }),
 * @author Administrator
 *
 */
@Component
@ConfigurationProperties(prefix="redis")
public class RedisConfig {
	
	/**
	 * 集合属性的读取
	 */
	private List<String> hosts;
	/**
	 * 数组属性的读取
	 */
	private String slaves[];

	@Override
	public String toString() {
		return "RedisConfig [hosts=" + hosts + ", slaves="
				+ Arrays.toString(slaves) + "]";
	}

	public List<String> getHosts() {
		return hosts;
	}

	public void setHosts(List<String> hosts) {
		this.hosts = hosts;
	}

	public String[] getSlaves() {
		return slaves;
	}

	public void setSlaves(String[] slaves) {
		this.slaves = slaves;
	}
	
	

}
