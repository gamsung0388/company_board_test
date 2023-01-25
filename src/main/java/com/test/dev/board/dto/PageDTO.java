package com.test.dev.board.dto;

import lombok.Data;

@Data
public class PageDTO {
	private int page = 1;			//현재 페이지 번호
	private int recordSize = 10;	//페이지당 출력할 데이터의 갯수
	private int pageSize = 10;		//하단에 표현할 페이지의 수
	private int startPage;			//첫번째
	private int endPage;			//마지막
}
