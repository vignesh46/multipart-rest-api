package com.srv.restmultipart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.srv.restmultipart.service.ICsvService;

@RestController
public class RestmultipartController {
	
	@Autowired
	ICsvService csvService;
	
	@PostMapping("/api/upload")
	public Boolean uploadFile(@RequestParam("file") MultipartFile file) {
		csvService.csvParser(file);
		return true;
	}

}
