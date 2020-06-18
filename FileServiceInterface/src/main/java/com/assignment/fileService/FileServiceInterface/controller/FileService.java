package com.assignment.fileService.FileServiceInterface.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import com.assignment.fileDetail.FileDetailService.exception.FileDetailException;
import com.assignment.fileDetail.FileDetailService.service.FileDetailService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/service")
public class FileService {
	
	@Autowired
	FileDetailService fileDetailService;
	
	private final String pathToDirectory= "/service/fileDetail/path/";
	
	private final String pathToFiles = "/service/fileDetails/filepath/";
	
	
	@GetMapping(value="fileDetail/{path}/**")
	public ResponseEntity<String> fileAndDirectory(@PathVariable("path") String path, HttpServletRequest request) {
		String fileDetails =null;
		try {
			fileDetails = fileDetailService.getFileAndDirectory(extractUrl(request,pathToDirectory));
		} catch (FileDetailException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(fileDetails, HttpStatus.OK);
	}
	
	@GetMapping(value="fileDetails/{filepath}/**")
	public ResponseEntity<String> file(@PathVariable("filepath") String filepath, HttpServletRequest request){
		String fileDetails = null;
		try {
			fileDetails= fileDetailService.getFileDetails(extractUrl(request,pathToFiles));
		} catch (FileDetailException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(fileDetails, HttpStatus.OK);
	}
	
	
	private String extractUrl(HttpServletRequest request, String pathToReplace) {
		String url = (String) request.getAttribute(
		        HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		String absPath = url.replaceAll(pathToReplace, "");
		return absPath;
	}
	
}
