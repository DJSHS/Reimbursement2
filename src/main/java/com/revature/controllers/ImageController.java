package com.revature.controllers;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.revature.services.ImageService;

@RestController
@RequestMapping("/images")
@CrossOrigin
public class ImageController {
	
	@Autowired
	private ImageService is;
	
	@PostMapping("/receipts")
	public int saveReimImg(@RequestBody File img) {
		System.out.println(img);
		return is.saveReimImg(img);
	}
}
