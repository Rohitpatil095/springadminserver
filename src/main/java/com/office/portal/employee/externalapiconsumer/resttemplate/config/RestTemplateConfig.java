package com.office.portal.employee.externalapiconsumer.resttemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	
	@Bean
	public RestTemplate restTemplate() 
	{
		return new RestTemplate();
	}

}

//@Configuration
//public class RestTemplateConfig {
//	
//	UriTemplateHandler uriTemplateHandler =new RootUriTemplateHandler(EmployeeConstants.LEAVE_SERVICE_URL+EmployeeConstants.LEAVE_SERVICE_DEPLOYED_PORT);
//	
//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) 
//	{
//		return builder
//				.uriTemplateHandler(uriTemplateHandler)
//				.setReadTimeout(5000)
//				.build();
//	}
//
//}
