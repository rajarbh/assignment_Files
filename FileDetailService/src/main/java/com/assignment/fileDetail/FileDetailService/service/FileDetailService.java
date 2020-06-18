package com.assignment.fileDetail.FileDetailService.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.fileDetail.FileDetailService.exception.FileDetailException;
import com.assignment.fileDetail.FileDetailService.model.FileDetail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FileDetailService {
	
	@Autowired
	ObjectMapper objectMapper;
	
	Logger logger = LogManager.getLogger(FileDetail.class);

	public String getFileAndDirectory(String path) throws FileDetailException{
		try {
			List<FileDetail> list = new ArrayList<FileDetail>();
			list.addAll(addDirectories(path));
			list.addAll(addFiles(path));
			logger.info("In the getFileAndDirectory method", list);
			return objectMapper.writeValueAsString(list);
		}catch(IOException ie) {
			throw new FileDetailException(ie.getMessage());
		}
		
	}

	public String getFileDetails(String absolutepath) throws FileDetailException {
		FileDetail fileDetail = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			fileDetail = Files.walk(Paths.get(absolutepath)).filter(Files::isRegularFile).map(f -> {
				try {
					return new FileDetail(String.valueOf(f), String.valueOf(Files.size(f)),
							String.valueOf((Files.isRegularFile(f)) ? "File" : null),
							String.valueOf(Files.isReadable(f)), String.valueOf(Files.isWritable(f)),
							String.valueOf(Files.isExecutable(f)), String.valueOf(Files.isRegularFile(f)));
					
				} catch (IOException e) {
					logger.error("In the Files iteration in getFileDetials: ",e.getMessage());
				}
				return null;
			}).findAny().get();
			return objectMapper.writeValueAsString(fileDetail);
		}
		catch(IOException ie) {
			throw new FileDetailException(ie.getMessage());
		}

	}



	private List<FileDetail> addDirectories(String path) throws IOException {
		List<FileDetail> list = Files.walk(Paths.get(path)).filter(Files::isDirectory).map(f -> {
			logger.info("In the addDirectories");
			try {
				return new FileDetail(String.valueOf(f), String.valueOf(Files.size(f)),
						(String.valueOf(Files.isDirectory(f) ? "Directory" : null)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("In the Files iteration in addDirectories method: ",e.getMessage());
			}
			return null;
		}).collect(Collectors.toList());
		return list;

	}

	private List<FileDetail> addFiles(String path) throws FileDetailException {
		logger.info("In the addFiles");
		List<FileDetail> list=null;
		try {
		 list = Files.walk(Paths.get(path)).filter(Files::isRegularFile).map(f -> {
			try {
				return new FileDetail(String.valueOf(f), String.valueOf(Files.size(f)),
						String.valueOf((Files.isRegularFile(f)) ? "File" : null));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("In the Files iteration in addFiles method: ",e.getMessage());
			}
			return null;
		}).collect(Collectors.toList());
		}catch(IOException ie) {
			throw new FileDetailException(ie.getMessage());
		}
		return list;

	}
}
