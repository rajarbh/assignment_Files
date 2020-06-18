package com.assignment.fileService.FileServiceInterface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.assignment.fileService.FileServiceInterface", "com.assignment.fileDetail.FileDetailService"})
public class Runner {

	public static void main(String[] args) {
		SpringApplication.run(Runner.class, args);
	}
}
