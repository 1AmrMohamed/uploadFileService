package com.uploader.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.uploader.Service.ImageService;
import com.uploader.model.ImageDB;

@RestController
@RequestMapping("file")
public class ImageDbController {
	@Autowired
	private ImageService imageService;
	
	@PostMapping
	public ImageDB uploadImage(@RequestParam("file") MultipartFile file) throws IOException {

		return imageService.store(file);

	}

	@GetMapping("/id/{id}")
	public ImageDB getImge (@PathVariable String id) {

		return imageService.getImageById(id);

	}

	@GetMapping("/list/{list}")

	public List<ImageDB> getImageList(@PathVariable("list") String listemp) {

		return imageService.getImagelist();
	}

}
