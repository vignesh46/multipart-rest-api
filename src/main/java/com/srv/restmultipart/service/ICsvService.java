package com.srv.restmultipart.service;

import org.springframework.web.multipart.MultipartFile;

public interface ICsvService {

	void csvParser(MultipartFile file);
	
}
