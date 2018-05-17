0、默认配置文件只要放在默认的地方，springboot就会自动读取；对于其他外部的配置文件，则需要告诉springboot在哪里，通过注解@PropertySource 或者 @PropertySources来告诉

1、springboot默认配置文件、以及默认配置文件属性的读取
	1.1、application.properties，此文件默认放在类路径根目录下或者/config目录下
	1.2、读取方式
		1.2.1、通过SpringApplication.run(App.class, args).getEnvironment().getProperty("tomcat.ip"));
		1.2.2、通过spring EL @Value("${tomcat.ip}")

2、外部配置文件的读取
	2.1、@PropertySources(value = { @PropertySource(value = { "classpath:/jdbc.properties" }),@PropertySource(value = { "classpath:/login.properties" }) } )
	2.2、@ConfigurationProperties(prefix="oracle")这个配置主要是在spring容器中去匹配相对应的属性值
	
3、注解@profile的使用
	3.1、通过启动参数spring.profiles.active=xx会有两个作用：（此时默认的配置文件application.properties不受影响，同样会读取）
		3.1.1、读取application-xx.properties配置文件
		3.1.2、管理注解@Profile("xx")的类或者方法：通过注解@Profile来自动区分开发环境、测试环境、生产环境，此时需要启动参数的配合
	
