package kr.board.entity;

import lombok.Data;

@Data
public class BookmarkGroup {
	private int bkidx; 
	private String bookmarkNm ;
	private int orderTurn ; 
	private String applyDate;
	private String upddate;
}
