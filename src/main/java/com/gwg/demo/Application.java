package com.gwg.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @RestController beans来处理传入的HTTP请求。使用@RequestMapping注解可以将及控制器中的方法映射到相应的HTTP请求，这两个注解是Spring MVC注解
 * 
 *
 */
@RestController
@EnableCaching //启用缓存，这个注解很重要，如果不配置，缓存不会生效
@SpringBootApplication //该@SpringBootApplication注解等价于以默认属性使用@Configuration, @EnableAntoConfiguration 和 @ComponentScan。
public class Application{
	
	/**
	 * @RequestMapping注解提供路由信息。它告诉Spring任何来自"/"路径的请求都应该被映射到home方法。
	 * @RestController注解告诉Spring以字符串的形式渲染结果，并直接返回给调用者 。
	 */
	@RequestMapping("/")
	String home(){
		return "Hello World";
	}
		
	public static void main(String[] args) throws Exception{
		SpringApplication.run(Application.class, args);
	}

}
