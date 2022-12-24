package com.uploader.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.uploader.model.ImageDB;
import com.uploader.reposetory.ImageReposetory;

@Service
public class ImageService {
	@Autowired
	private ImageReposetory imageReposetory;

	
	//storeing image in database
	public ImageDB store(MultipartFile file) throws IOException {

		String fileName = file.getOriginalFilename();
		ImageDB imageDB = new ImageDB(UUID.randomUUID().toString(), fileName, file.getContentType(), file.getBytes());

		return imageReposetory.save(imageDB);

	}
	
	
	//find image by id
	public ImageDB getImageById(String id) {

		Optional<ImageDB> imageoptional = imageReposetory.findById(id);

		if (imageoptional.isPresent()) {
			return imageoptional.get();
		}

		return null;

	}
	
	
	//get all image list

	public List<ImageDB> getImagelist() {

		return imageReposetory.findAll();
	}
	
	public void decodeingImage () {
		
		
		/*  byte[] decode = Base64.getDecoder().decode(msg.getBytes());
	       File file = new File("c:\\demo2.jpeg");
	       try {
	           OutputStream os = new FileOutputStream(file);
	           os.write(decode);
	           System.out.println("Write bytes to file."); 
	           os.close();
	       } catch (Exception e) {
	           e.printStackTrace();
	       }*/

		
	}
	
	
	
}
