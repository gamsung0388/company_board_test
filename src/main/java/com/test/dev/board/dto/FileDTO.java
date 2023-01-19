package com.test.dev.board.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class FileDTO {
	private int file_id;
	private String orig_nm;
	private String logi_nm;
	private String logi_path;
	private String ext;
	private int size;
	private Date regDt;
}
