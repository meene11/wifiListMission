package kr.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.board.entity.HisLocaDao;
import kr.board.mapper.BoardMapper;

@RequestMapping("/board")
@RestController // ajax 사용시 쓰는 어노테이션 : @ResponseBody(json)응답 제거가능. 
public class BoardRestController {
	
	@Autowired
	BoardMapper boardMapper;
	
	@RequestMapping("/hisWifiDel/{idx}")
	public void hisWifiDelete(@PathVariable("idx") int idx) {
		System.out.println(" 삭제  " + idx);
		boardMapper.hisWifiDelete(idx);
	}
	
	@RequestMapping("/AjxGetHisList")
	public List<HisLocaDao> ajxGetHisList() {
		List<HisLocaDao> hisWifiList = boardMapper.getHisWifiList();
		System.out.println("AjxGetHisList  : " + hisWifiList );
		
		return hisWifiList;
	}
	
	
	
	
	
}
