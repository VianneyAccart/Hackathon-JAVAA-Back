package com.javaa.back.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	private String locationFile = "/back/src/main/resources/static/img";

	private final Path root = Paths.get(locationFile);

	public String uploadFile(MultipartFile file) throws IllegalStateException, IOException {

		String extension = "";
		String fileName = file.getOriginalFilename();
		File fileToTransfer = new File(locationFile + fileName);

		if (fileName != null) {
			int index = fileName.lastIndexOf('.');
			if (index > 0) {
				extension = fileName.substring(index + 1);
			}
			if (!extension.equals("png") && !extension.equals("jpg") && !extension.equals("jpeg")
					&& !extension.equals("svg")) {
				throw new IOException("File extension must be png, jpg, jpeg or svg");
			} else {
				do {
					fileName = UUID.randomUUID().toString().replace("-", "") + "." + fileName.substring(index + 1);
					Files.copy(file.getInputStream(), this.root.resolve(fileName));
					return fileName;
				} while (!fileToTransfer.exists() && !fileToTransfer.isDirectory());
			}
		}
		return fileName;
	}

	public Resource load(String filename) throws IOException {
		if (filename != null) {
			Path file = root.resolve(filename);
			Resource resource = new UrlResource(file.toUri());

			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new IOException("Resource not here");
			}
		} else {
			throw new IOException("Give a name to the file you're searching");
		}
	}

	public void deleteFile(String fileName) throws IOException {
		String fileToDelete = locationFile + fileName;
		File existFile = new File(locationFile + fileName);
		Path path = FileSystems.getDefault().getPath(fileToDelete);
		if (existFile.exists() && !existFile.isDirectory()) {
			Files.delete(path);
		}
	}
}
