package com.anderson.automation.webboka;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer, ApplicationContextAware {

	private ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

//	@Bean
//	public SpringTemplateEngine templateEngine() {
//		SpringTemplateEngine engine = new SpringTemplateEngine();
//		engine.setEnableSpringELCompiler(true);
//		engine.setTemplateResolver(templateResolver());
//		return engine;
//	}

//	@Bean
//	@Description("Thymeleaf Template Resolver")
//	public ServletContextTemplateResolver templateResolver() {
//		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
//		templateResolver.setPrefix("/WEB-INF/views/");
//		templateResolver.setSuffix(".html");
//		templateResolver.setTemplateMode("HTML5");
//
//		return templateResolver;
//	}

//	private ITemplateResolver templateResolver() {
//		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
//		resolver.setApplicationContext(applicationContext);
//		resolver.setPrefix("/templates/");
//		resolver.setSuffix(".html");
//		resolver.setTemplateMode(TemplateMode.HTML);
//		return resolver;
//	}

	
//	@Bean
//    @Description("Thymeleaf template resolver serving HTML 5")
//    public ITemplateResolver templateResolver() {
//
//		DefaultTemplateResolver templateResolver = new DefaultTemplateResolver();
//
////        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
////        
//////        templateResolver.setPrefix("mytemplates/");
////        templateResolver.setCacheable(false);
////        templateResolver.setSuffix(".html");        
////        templateResolver.setTemplateMode("HTML5");
////        templateResolver.setCharacterEncoding("UTF-8");
//        
//        return templateResolver;
//    }
//
//    @Bean
//    @Description("Thymeleaf template engine with Spring integration")
//    public SpringTemplateEngine templateEngine() {
//        
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//
//        return templateEngine;
//    }

//	@Bean
//	@Description("Thymeleaf view resolver")
//	public ViewResolver viewResolver() {
//
//		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//
//		viewResolver.setTemplateEngine(templateEngine());
//		viewResolver.setCharacterEncoding("UTF-8");
//
//		return viewResolver;
//	}

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/company").setViewName("company");
	}

//	@Bean(name = "templateEngine")
//	private void templateEngine() {
//		SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
//		Set<IDialect> additionalDialects = new HashSet<>();
////		additionalDialects.add(com.thyme)
//		springTemplateEngine.setAdditionalDialects(additionalDialects );
//		
//	}

}