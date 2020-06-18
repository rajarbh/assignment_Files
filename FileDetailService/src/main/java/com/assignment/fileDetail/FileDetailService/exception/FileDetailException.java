package com.assignment.fileDetail.FileDetailService.exception;

public class FileDetailException extends Exception{
	
	private final String errorMessage;

	public FileDetailException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
}
