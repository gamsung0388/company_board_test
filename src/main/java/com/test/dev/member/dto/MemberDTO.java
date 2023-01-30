package com.test.dev.member.dto;

import lombok.Data;

@Data
public class MemberDTO {
	String user_id;
	String user_pw;
	String user_name;
	String user_age;
	String grade;
	String board_cnt;
	String comment_cnt;
}
