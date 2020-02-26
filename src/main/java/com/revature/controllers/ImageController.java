package com.revature.controllers;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/images")
@CrossOrigin
public class ImageController {
	
	@PostMapping("/receipts")
	public int handleUploadImg(@RequestParam("image") MultipartFile image) {
		String path = "E:\\ers-image\\";
		
		try {
			image.transferTo(new File(path + image.getOriginalFilename()));
			return 1;
		} catch (IOException e) {
			System.err.println(e);
		}
		
		return 0;
	}
}
