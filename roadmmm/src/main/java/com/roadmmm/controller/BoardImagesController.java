package com.roadmmm.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.roadmmm.domain.BoardImages;
import com.roadmmm.service.BoardImagesService;

//@MultipartConfig(
//			fileSizeThreshold = 1024*1024,
//			maxFileSize = 1024*1024*5,
//			maxRequestSize = 1024*1024*5*5
//)

@Controller
public class BoardImagesController {
	
	@Autowired
	BoardImagesService boardImagesService;
	
	@PostMapping(value="/boardimagesupload", produces = "application/json")
	@ResponseBody
	public JsonObject boardImagesUpload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
		
		JsonObject jsonObject = new JsonObject();
		
		String realPath = request.getServletContext().getRealPath("");
		
		String temp = "";
		
		for(int i=0; i < realPath.indexOf("webapp"); i++) {
			temp += realPath.charAt(i);
		}
		
		String publicRealPath = temp + "resources" + File.separator + "static" + File.separator + "img" + File.separator;
		
//		String publicRealPath = temp + "resources" + File.separator + "public" + File.separator + "img" + File.separator;
	
		
		System.out.println("publicRealPath" + publicRealPath);
		
		String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자
		
		String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명
		
		File targetFile = new File(publicRealPath + savedFileName);	
		
		try {
			String clientPath = File.separator + "static" + File.separator + "img" + File.separator + savedFileName;
			
			BoardImages boardImages = new BoardImages(clientPath);
			
			boardImagesService.saveBoardImage(boardImages);
			
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
			jsonObject.addProperty("url", clientPath);
			jsonObject.addProperty("responseCode", "success");
				
		} catch (IOException e) {
			FileUtils.deleteQuietly(targetFile);	//저장된 파일 삭제
			jsonObject.addProperty("responseCode", "error");
			e.printStackTrace();
		}
		
		return jsonObject;
	}
}
