package com.test.dev.board.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardDTO {
	private String rnum;					//게시물 
    private String board_num;				//게시물 번호
    private String board_cgy_num;			//게시물 카테고리 번호
    private String board_cgy_txt;			//게시물 카테고리 번호
    private String user_id;					//게시물 게시자(id)
    private String user_name;				//게시물 게시자(이름)
    private String board_title;				//게시물 제목
    private String board_txt;				//게시물 내용
    private String board_tag;				//게시물 태그
    private String comment_yn;				//댓글여부
    private String board_viewcnt;			//게시물 조회수
    private Date board_date;				//게시물 날짜
    private String fileIdxs;				//파일
    private String delete_files;			//삭제할 파일리스트
    private String board_file_cnt;			//파일리스트
    
}    

	