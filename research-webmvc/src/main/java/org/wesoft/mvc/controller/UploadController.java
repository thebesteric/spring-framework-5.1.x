package org.wesoft.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


@Controller
public class UploadController {

	@RequestMapping("/upload.do")
	@ResponseBody
	public String upload(@RequestPart("file") MultipartFile multipartFile) {
		System.out.println(multipartFile);
		InputStream inputStream = null;
		try {
			inputStream = multipartFile.getInputStream();
			File target = new File("research-webmvc/upload/" + multipartFile.getOriginalFilename());
			System.out.println("upload to " + target.getAbsolutePath());
			FileCopyUtils.copy(inputStream, new FileOutputStream(target));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "ok";
	}

}
