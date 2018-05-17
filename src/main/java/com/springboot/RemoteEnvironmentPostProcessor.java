package com.springboot;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.ResourcePropertySource;

/**
 * 这个例子主要是用于展示：对于公司中会有很多的项目，对于每个项目都会有很多的配置文件，那么为了部署的方便性，会把所有项目
 * 中用到的配置文件，放在一个统一的地方（比如配置服务器），然后每个项目在自己内部通过此种方式进行读取，那么就可以做”统一配置“，而不用到每个
 * 项目内部分别进行配置
 * @author Administrator
 * ******
 * 此类需要在META-INF中的spring.factories中进行配置,此处无需配置@Component，配置也没用
 * 如果只配置@Component，但是不在META-INF中的spring.factories中进行配置配置，将报错
 * ******
 *
 */
/*@Component*/
@SuppressWarnings("rawtypes")
public class RemoteEnvironmentPostProcessor implements EnvironmentPostProcessor {
	
	/**
	 * 此处就提供了一个动态的方式加入配置文件，那么这个功能就可以满足从远程获取配置文件，进而做到项目的”统一配置“
	 */
	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		
		try {
			PropertySource propertySource = new ResourcePropertySource("file:/d:/remote.properties");
			environment.getPropertySources().addLast(propertySource);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}

	}

}
