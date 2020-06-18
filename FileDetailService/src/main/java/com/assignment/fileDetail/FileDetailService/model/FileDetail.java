package com.assignment.fileDetail.FileDetailService.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Component
public class FileDetail {

	private String path;
	
	private String size;
	
	private String flag;
	
	@JsonInclude(Include.NON_NULL)
	private String read;
	
	@JsonInclude(Include.NON_NULL)
	private String write;
	
	@JsonInclude(Include.NON_NULL)
	private String execute;
	
	@JsonInclude(Include.NON_NULL)
	private String regularFile;
	
	

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	public String getWrite() {
		return write;
	}

	public void setWrite(String write) {
		this.write = write;
	}

	public String getExecute() {
		return execute;
	}

	public void setExecute(String execute) {
		this.execute = execute;
	}

	public String getRegularFile() {
		return regularFile;
	}

	public void setRegularFile(String regularFile) {
		this.regularFile = regularFile;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public FileDetail(String path, String size, String flag, String read, String write, String execute,String regularFile){
		this.flag= flag;
		this.path = path;
		this.size = size;
		this.execute= execute;
		this.read= read;
		this.write = write;
		this.regularFile = regularFile;
	}
	
	public FileDetail(String path, String size, String flag){
		this.flag= flag;
		this.path = path;
		this.size = size;
	}
	
	public FileDetail() {
		
	}
		
}
