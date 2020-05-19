package com.jorgejy.fristmvc.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource("classpath:titles.properties")
})
// classpath = src/man/resources
public class TitlePropertiesConfig {

}
