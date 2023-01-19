package com.test.dev.board.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.test.dev.board.dto.FileDTO;
import com.test.dev.board.service.FileService;
import com.test.dev.page.controller.PageController;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileController {
	
	@Autowired FileService fileService;
	
	private static final Logger log = LoggerFactory.getLogger(PageController.class);
	
	@PostMapping("/file-upload")
	@ResponseBody
	public Map<String,Object> fileupload(
			@RequestParam("article_file") List<MultipartFile> multipartFile,
			HttpServletRequest request)throws IOException{
		
		log.info("파일컨트롤러");
		return fileService.uploadFile(request, multipartFile);
		
	}
	
	@GetMapping("/file-download/{fileId}")
	@ResponseBody
	public void downloadFile(HttpServletResponse res, @PathVariable String fileId) throws Exception{
		
			//파일 조회
			FileDTO fileDto = fileService.selectFile(fileId);
			
			//파일 경로
			Path saveFilePath = Paths.get(fileDto.getLogi_path() + fileDto.getLogi_nm());
			
			//해당경로에 파일이 없으면
			if(!saveFilePath.toFile().exists()) {
				throw new RuntimeException("file not found");
			}
			
			res.setHeader("Content-Disposition", "attachment; filename=\""+ URLEncoder.encode((String)fileDto.getOrig_nm(),"UTF-8")+"\";");
			res.setHeader("Content-Transfer-Encoding", "binary");
			res.setHeader("Content-Type", "application/download; utf-8");			
			res.setHeader("Pragma", "no-cahe;");
			res.setHeader("Expires", "-1");
			FileInputStream fis = null;
			
		try {
			fis= new FileInputStream(saveFilePath.toFile());
			FileCopyUtils.copy(fis,res.getOutputStream());
			res.getOutputStream().flush();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally {
				try {
					fis.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
		}		
	}
}
