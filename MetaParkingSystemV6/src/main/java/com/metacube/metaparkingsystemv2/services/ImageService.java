package com.metacube.metaparkingsystemv2.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {
	
	public void saveImage(MultipartFile imageFile, int empId) throws Exception {
		String folder = "/MetaParkingSystemV2/src/main/resources/static/images";
		byte[] bytes = imageFile.getBytes();
		Path path = Paths.get(folder + empId + ".png");
		Files.write(path, bytes);
	}
}
