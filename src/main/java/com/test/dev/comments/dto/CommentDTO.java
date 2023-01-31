package com.test.dev.comments.dto;

import lombok.Data;

@Data
public class CommentDTO {
	int coment_num;
	String comment_user_id;
	String comment_txt;
	String user_name;
	int board_num;
	int comment_class;
	int comment_order;
	int group_num;
}
