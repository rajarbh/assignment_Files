package com.assignment.fileService.FileServiceInterface.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.assignment.fileDetail.FileDetailService.exception.FileDetailException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@ControllerAdvice

public class FileServiceErrorAdvice {

	Logger logger = LogManager.getLogger(FileServiceErrorAdvice.class);
	
    @ExceptionHandler({FileDetailException.class})
    public ResponseEntity<String> handleFileDetailException(FileDetailException e){
    	return error(NOT_FOUND, e);
    }
    
    private ResponseEntity<String> error(HttpStatus status, FileDetailException e) {
    	logger.error("Exception : ", e);
        return ResponseEntity.status(status).body(e.getMessage());
    }
}
