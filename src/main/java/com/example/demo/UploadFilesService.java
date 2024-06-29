package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.modelo.ImagenReclamo;
import com.example.demo.repository.ImagenReclamoRepository;

import jakarta.transaction.Transactional;

@Service
public class UploadFilesService {

	@Autowired
	ImagenReclamoRepository imagenReclamoRepository;

	@Transactional
	public String handleFileUpload(Integer idReclamo, MultipartFile[] files) {
		try {
			String uploadDir = "src/main/resources/static/imagenes";
			Path uploadPath = Paths.get(uploadDir);
			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}

			for (MultipartFile file : files) {
				String fileName = UUID.randomUUID().toString();
				String fileOriginalName = file.getOriginalFilename();
				String newFileName = fileName + getFileExtension(fileOriginalName);
				Path filePath = uploadPath.resolve(newFileName);
				Files.copy(file.getInputStream(), filePath);

				// Guardar la información en la base de datos
				ImagenReclamo imagenReclamo = new ImagenReclamo();
				imagenReclamo.setPath(uploadDir + "/" + newFileName);
				imagenReclamo.setIdReclamo(idReclamo);
				imagenReclamoRepository.save(imagenReclamo);
			}

			return "Guardado exitoso de archivos.";
		} catch (IOException e) {
			e.printStackTrace();
			return "Error al guardar los archivos: " + e.getMessage();
		}
	}

	private String getFileExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}
}