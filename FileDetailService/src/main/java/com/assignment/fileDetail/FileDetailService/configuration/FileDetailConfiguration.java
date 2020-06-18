package com.assignment.fileDetail.FileDetailService.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.assignment.fileDetail.FileDetailService.model.FileDetail;
import com.assignment.fileDetail.FileDetailService.service.FileDetailService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class FileDetailConfiguration {

	@Bean 
	ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
	
	@Bean
	FileDetailService fileDetailService() {
		return new FileDetailService();
	}
	
	@Bean
	FileDetail fileDetail() {
		return new FileDetail();
	}
}
