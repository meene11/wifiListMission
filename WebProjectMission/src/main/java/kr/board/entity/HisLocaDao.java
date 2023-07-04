package kr.board.entity;

import lombok.Data;

@Data
public class HisLocaDao {
	private int idx; 
	private String mainNm;
	private double lat; 
	private double lnt; 
	private String workDate;
	private String workDate2;
}
