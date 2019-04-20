package com.zhbit.market.config;

import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeetlConf {
	@Value("templates")
	String templatesPath;
	@Bean(name="beetlConfig")
	public BeetlGroupUtilConfiguration getBeetlGroupUtilCongiguration() {
		BeetlGroupUtilConfiguration beetlGroupUtilConfiguration=new BeetlGroupUtilConfiguration();
		ClassLoader loader=Thread.currentThread().getContextClassLoader();
		if(loader==null) {
			loader=BeetlConf.class.getClassLoader();
		}
		ClasspathResourceLoader cploder=new ClasspathResourceLoader(loader,templatesPath);
		beetlGroupUtilConfiguration.setResourceLoader(cploder);
		beetlGroupUtilConfiguration.init();
		beetlGroupUtilConfiguration.getGroupTemplate().setClassLoader(loader);
		return beetlGroupUtilConfiguration;
	}
	@Bean(name="beetlViewResolver")
	public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
		BeetlSpringViewResolver beetlSpringViewResolver=new BeetlSpringViewResolver();
		beetlSpringViewResolver.setContentType("application/json;charset=UTF-8");
		beetlSpringViewResolver.setOrder(0);
		beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
		beetlSpringViewResolver.setSuffix(".html");
		return beetlSpringViewResolver;
	}
}
