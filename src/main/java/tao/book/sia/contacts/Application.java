package tao.book.sia.contacts;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
/*
 Spring Boot的自动配置特性消除了绝大部分或者全部的配置。
 因此，完全可能编写出没有任何配置的Spring应用程序。当然，

自动配置并不能涵盖所有的场景，因此典型的Spring Boot应用程序依
然会需要一点配置。

具体到Contacts应用，我们不需要任何的配置。Spring的自动配置功能
已经将所有的事情都做好了。
但是，我们需要有个特殊的类来启动Spring Boot应用。Spring本身并
不知道自动配置的任何信息。

Application类就是Spring Boot启动类的典型例子：初始化Spring Boot配置的简单启动类

 */
/*
 用@ComponentScan注解来启用组件扫描，
 用@EnableAutoConfiguration，这会启用Spring Boot的自动配置特性。
 */
@ComponentScan
@EnableAutoConfiguration
public class Application {
	/*
	 在main()方法中，这行代码会告诉Spring Boot（通过SpringApplication类）根据Application中的配置以及命令行中的参数来运行。
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	} 
}