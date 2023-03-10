package com.test.dev.board.service;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.test.dev.board.dao.FileDAO;
import com.test.dev.board.dto.FileDTO;
import com.test.dev.page.controller.PageController;

@Service
public class FileService {

	@Autowired Environment env;
	@Autowired FileDAO fileDao;
	
	private static final Logger log = LoggerFactory.getLogger(PageController.class);
	
	private final String UPLOAD_FILE_PATH = "C:/dev/files";
	
	public Map<String, Object> uploadFile(HttpServletRequest request, List<MultipartFile> multipartFile) {
	
		Map<String, Object> result = new HashMap<String, Object>();
		
		//파일 시퀀스 리스트
		List<String> fileIds = new ArrayList<String>();
		
		result.put("result", "FAIL");
		
		String _filePath = String.valueOf(request.getParameter("filePath")).equals("null")? UPLOAD_FILE_PATH : UPLOAD_FILE_PATH+String.valueOf(request.getParameter("filePath")+"/");
		//String _filePath = String.valueOf(request.getParameter("filePath")).equals("null")? env.getProperty(UPLOAD_FILE_PATH): env.getProperty(UPLOAD_FILE_PATH)+String.valueOf(request.getParameter("filePath")+"/");
		
		System.out.println("_filePath= "+_filePath);
		
		System.out.println("_filePath= "+ UPLOAD_FILE_PATH);
		
		try {
			if(multipartFile.size() > 0 && !multipartFile.get(0).getOriginalFilename().equals("")) {
				
				for (MultipartFile file : multipartFile) {
					
					String originalFileName = file.getOriginalFilename();		//오리지널 파일명
					String extension = originalFileName.substring(originalFileName.lastIndexOf(".")); 	//파일 확장자
					String saveFileName = UUID.randomUUID() + extension; 		//지정할 파일명
					
					File targetFile = new File(_filePath + saveFileName);
					
					//파일저장후 db insert
					
					result.put("pyscPath", _filePath);
					result.put("pyscNm", saveFileName);
					result.put("origNm", originalFileName);
					result.put("fileExt", extension);
					result.put("contentType", file.getContentType());
					result.put("fileSize", file.getSize());
					
					//파일 insert
					insertFile(result);
					log.info("fileId={}",result.get("fileId"));
					
					
					//배열에 담기
					fileIds.add(String.valueOf(result.get("fileId")));
					
					try {
						InputStream fileStream = file.getInputStream();
						FileUtils.copyInputStreamToFile(fileStream, targetFile); //파일 저장
												
					}catch(Exception e){
						FileUtils.deleteQuietly(targetFile);	//저장된 현재파일 삭제
						e.printStackTrace();
						result.put("result", "FAIL");
					}
				}
				
				result.put("fileIdxs", fileIds.toString());
				result.put("result", "OK");
				
			}else {
				result.put("result", "OK");
			}
		}catch(Exception e) {
			e.printStackTrace();
			result.put("result", "FAIL");
		}
		
		return result;
	}

	
	//파일저장 db
	public int insertFile(Map<String, Object> params) {
		return fileDao.insertFile(params);		
	}
	
	//
	public FileDTO selectFile(String fileId) throws Exception{
		
		FileDTO fileDTO = fileDao.getFileInfo(fileId);
		
		return fileDTO;
	}

}
