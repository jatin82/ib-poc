package com.ib.poc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ib.poc.exception.PlatformException;
import com.ib.poc.model.Message;
import com.ib.poc.repository.MessageRepository;
import com.ib.poc.service.FileService;
import com.ib.poc.utils.Constants;
import com.ib.poc.utils.ResponseData;
import com.ib.poc.utils.Utils;


@RestController
public class FileUploadController {

	@Autowired
	private FileService fileService;

	@Autowired
	private MessageRepository messageRepo;

	@PostMapping("/db/init")
	public ResponseEntity<ResponseData> uploadFileController(@RequestParam("file") MultipartFile file)
			throws PlatformException, IOException {
		System.out.println("Uploading starts " + file);
		this.fileService.uploadFile(file);

		File fileSaved = this.fileService.getFile(file.getOriginalFilename());
		if (ObjectUtils.isEmpty(fileSaved)) {
			return new ResponseEntity<ResponseData>(
					new ResponseData<String>("File not found", Constants.FAILED, HttpStatus.NOT_FOUND),
					HttpStatus.NOT_FOUND);
		}

		
		List<Message> messages = Utils.readFromFile(fileSaved);
		messageRepo.save(messages);
		return new ResponseEntity<ResponseData>(
				new ResponseData<String>("Database initialized", Constants.SUCCESS, HttpStatus.OK), HttpStatus.OK);

	}

}

