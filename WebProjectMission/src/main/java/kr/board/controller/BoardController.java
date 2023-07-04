package kr.board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.board.entity.BookmarkGroup;
import kr.board.entity.HisLocaDao;
import kr.board.entity.LocationDao;
import kr.board.entity.WifiDao;
import kr.board.entity.WifiVo;
import kr.board.entity.favoritesDao;
import kr.board.mapper.BoardMapper;

@Controller // anotation 으로 역할 규정
public class BoardController {
	
	@Autowired
	BoardMapper boardMapper;
	
	
	@RequestMapping("/home.do")
	public String wifihome() {
		return "board/wifiHome";
	}
	
	@RequestMapping("/getNearbyWifi.do")
	public String getNearbyWifi(HttpServletRequest request, Model model) {
		String y = request.getParameter("yLatGyeong");
		String x = request.getParameter("xLntWi");
		System.out.println("y " +y + "   x "+x);
		
		double yLatGyeong = Double.parseDouble(y); 
		double xLntWi = Double.parseDouble(x);
		
		System.out.println(" 경도:" + yLatGyeong + "   위도:"+xLntWi);
		
		LocationDao loca = new LocationDao();
		loca.setYLatGyeong(yLatGyeong);
		loca.setXLntWi(xLntWi);
		
		List<WifiDao> list = boardMapper.getNearbyWifi(loca);
		
		HisLocaDao his = new HisLocaDao();
		for(int i=0; i<list.size(); i++) {
			his.setLat(list.get(i).getLat());
			his.setLnt(list.get(i).getLnt());
			his.setMainNm(list.get(i).getMainNm());
			boardMapper.hisWifiListInsert(his);
		}
		System.out.println("근처 리스트 뿌려지면 자동 저장 his :" +his);
		
		model.addAttribute("list", list);
		return "board/wifiHome";
	}
	
	@RequestMapping("/getHisList")
	public String getHisList(Model model) {
		List<HisLocaDao> hisWifiList = boardMapper.getHisWifiList();
		System.out.println("체크 ~~~~ hisWifiList : " + hisWifiList );
		model.addAttribute("hisWifiList", hisWifiList);
		
		return "board/wifiHisList";
	}
	
	@RequestMapping("/wifiSave")
	public String wifiList(Model model) {
		int totalCnt = 0;
		WifiTest wt = new WifiTest();
		List<WifiVo> list = new ArrayList<WifiVo>();
		
		
		try {
			totalCnt = wt.TotalCnt();
			System.out.println(" 갯수 : " + totalCnt);
			String cnt = String.valueOf(totalCnt);
			model.addAttribute("cnt", cnt);
			
			list = wt.testList();
		
			if(list.size()>0) {
				for(int i=0; i<list.size(); i++) {
					WifiDao dao = new WifiDao();
					
					double distance = list.get(i).getDistance();
					double lat = list.get(i).getLat();
					double lnt = list.get(i).getLnt();
					
					dao.setDistance(distance);
					dao.setLat(lat);
					dao.setLnt(lnt);
					dao.setAdres1(list.get(i).getAdres1());
					dao.setAdres2(list.get(i).getAdres2());
					dao.setCmcwr(list.get(i).getCmcwr());
					dao.setCnstcYear(list.get(i).getCnstcYear());
					dao.setInoutDoor(list.get(i).getInoutDoor());
					dao.setInstlFloor(list.get(i).getInstlFloor());
					dao.setInstlMby(list.get(i).getInstlMby());
					dao.setInstlTy(list.get(i).getInstlTy());
					dao.setMainNm(list.get(i).getMainNm());
					dao.setMgrNo(list.get(i).getMgrNo());
					dao.setRemars3(list.get(i).getRemars3());
					dao.setSvcSe(list.get(i).getSvcSe());
					dao.setWorkDttm(list.get(i).getWorkDttm());
					dao.setWrdOfc(list.get(i).getWrdOfc());
					
					boardMapper.wifiInfoInsert(dao);
				} // end for
			} //end if
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	
		return "board/wifiSave";
	}
	
	@RequestMapping("/wifiDetail/{mgrNo}")
	public String wifiDetail(@PathVariable("mgrNo") String mgrNo, Model model) {
		WifiVo wifiVo = boardMapper.wifiDetail(mgrNo);
		model.addAttribute("wifiVo", wifiVo);
		
		List<BookmarkGroup> bkmkGrpList =  boardMapper.getbookmarkGroup();
		model.addAttribute("bkmkGrpList", bkmkGrpList);
		
		return "board/wifiDetail";
	}
	
	@RequestMapping("/bookmarkGroup")
	public String bookmarkGroup(Model model) {
		List<BookmarkGroup> bkmkGroupList = boardMapper.getbookmarkGroup();
		model.addAttribute("list", bkmkGroupList);
		
		return "board/bookmarkGroupList";
	}
	
	@RequestMapping("/goBkGroupInsert")
	public String goBkGroupInsert() {
		
		return "board/bookmarkGroupInsert";
	}
	
	
	@RequestMapping("/bkmkGroupInsert")
	public String bookmarkGroupInsert(HttpServletRequest request, Model model) {
		String bookmarkNm = request.getParameter("bookmarkNm");
		String strOrder = request.getParameter("orderTurn");
		int orderTurn = Integer.parseInt(strOrder);
		
		
		BookmarkGroup bkmkGroup = new BookmarkGroup();
		bkmkGroup.setBookmarkNm(bookmarkNm);
		bkmkGroup.setOrderTurn(orderTurn);
		int result = 0;
		result = boardMapper.bookmarkGroupInsert(bkmkGroup);
		
		List<BookmarkGroup> bkmkGroupList = boardMapper.getbookmarkGroup();
		
		if(result > 0 ) {
			System.out.println(" result " + result );
			model.addAttribute("msg", "북마크 그룹 정보를 추가하였습니다.");
    		model.addAttribute("url", "/controller/bookmarkGroup");
		}
		
		model.addAttribute("list", bkmkGroupList);
		return "board/bookmarkGroupInsert";
	}
	
	@RequestMapping("/goBkGrpUpd/{bkidx}")
	public String goBkGrpUpd(@PathVariable("bkidx") int bkidx, Model model) {
		
		BookmarkGroup bkmkgrp = boardMapper.bookmarkGroupDetail(bkidx);
		model.addAttribute("bkmkgrp", bkmkgrp);
		
		return "board/bookmarkGroupUpdate";
	}
	
	@RequestMapping("/bkmkGroupUpdate")
	public String bkmkGroupUpdate(HttpServletRequest request, Model model) {
		
		String bookmarkNm = request.getParameter("bookmarkNm");
		String strOrder = request.getParameter("orderTurn");
		String strIdx = request.getParameter("bkidx");
		int orderTurn = Integer.parseInt(strOrder);
		int bkidx = Integer.parseInt(strIdx);
		
		
		BookmarkGroup bkmkGroup = new BookmarkGroup();
		bkmkGroup.setBookmarkNm(bookmarkNm);
		bkmkGroup.setOrderTurn(orderTurn);
		bkmkGroup.setBkidx(bkidx);
		
		System.out.println(" upd bkidx " + bkmkGroup);
		
		int result = 0;
		result = boardMapper.bookmarkGroupUpdate(bkmkGroup);
		System.out.println(" goBkGrpUpd check~~~~ result: " + result);
		
		List<BookmarkGroup> bkmkGroupList = boardMapper.getbookmarkGroup();
		
		if(result > 0 ) {
			System.out.println(" result " + result );
			model.addAttribute("msg", "북마크 그룹 정보를 수정하였습니다.");
    		model.addAttribute("url", "/controller/bookmarkGroup");
		}
		
		model.addAttribute("list", bkmkGroupList);
		
		
		return "board/bookmarkGroupUpdate";
	}
	
	@RequestMapping("/goBkGrpDel/{bkidx}")
	public String goBkGrpDel(@PathVariable("bkidx") int bkidx, Model model) {
		BookmarkGroup bkmkgrp = boardMapper.bookmarkGroupDetail(bkidx);
		model.addAttribute("bkmkgrp", bkmkgrp);
		
		return "board/bookmarkGroupDelete";
	}
	
	
	@RequestMapping("/bkmkGroupDelete")
	public String bkmkGroupDelete(HttpServletRequest request, Model model) {
		
		String strIdx = request.getParameter("bkidx");
		int bkidx = Integer.parseInt(strIdx);
		
		
		int result = 0;
		result = boardMapper.bookmarkGroupDelete(bkidx);
		System.out.println(" goBkGrpUpd check~~~~ result: " + result);
		
		List<BookmarkGroup> bkmkGroupList = boardMapper.getbookmarkGroup();
		
		if(result > 0 ) {
			System.out.println(" result " + result );
			model.addAttribute("msg", "북마크 그룹 정보를 삭제하였습니다.");
    		model.addAttribute("url", "/controller/bookmarkGroup");
		}
		
		model.addAttribute("list", bkmkGroupList);
		
		
		return "board/bookmarkGroupUpdate";
	}
	
	@RequestMapping("/favoritesList")
	public String favoritesList(Model model) {
		List<favoritesDao> favlist = boardMapper.favoritesList();
		model.addAttribute("favlist", favlist);
		
		return "board/favoritesList";
	}
	
	//addBookmark 
	@RequestMapping("/addBookmark")
	public String addBookmark(HttpServletRequest request, Model model) {
		
		String mgrNo =  request.getParameter("mgrNo");
		System.out.println("mgrNo" + mgrNo);
		
		String mainNm =  request.getParameter("mainNm");
		System.out.println("mainNm" + mainNm);
		
		String inPutbookmarkNm =  request.getParameter("inPutbookmarkNm");
		System.out.println("inPutbookmarkNm 이름 :" + inPutbookmarkNm);
		
		
		favoritesDao favDao = new favoritesDao();
		favDao.setFavBkNm(inPutbookmarkNm);
		favDao.setFavWifiNm(mainNm);
		
		int result = 0;
		result = boardMapper.favoritesInsert(favDao);
		System.out.println("favoritesInsert  check~~~~ result: " + result);
		
		
		List<favoritesDao> favlist = boardMapper.favoritesList();
		model.addAttribute("favlist", favlist);
		
		if(result > 0 ) {
			System.out.println(" result " + result );
			model.addAttribute("msg", "북마크 정보를 추가하였습니다.");
    		model.addAttribute("url", "/controller/favoritesList");
		}
		
		
		return "board/favoritesList";
	}
	
	@RequestMapping("/goFavBkDel/{favidx}")
	public String goFavBkDel(@PathVariable("favidx") int favidx, Model model) {
		favoritesDao favDetail = boardMapper.favoritesDetail(favidx);
		model.addAttribute("favDetail", favDetail);
		
		return "board/favoritesDelete";
	}
	
	@RequestMapping("/favBkmkDelete")
	public String favBkmkDelete(HttpServletRequest request, Model model) {
		
		String strIdx = request.getParameter("favidx");
		int favidx = Integer.parseInt(strIdx);
		
		System.out.println("즐겨찾기 favBkmkDelete :"+ favidx);
		
		int result = 0;
		result = boardMapper.favoritesDelete(favidx);
		System.out.println(" goBkGrpUpd check~~~~ result: " + result);
		
		List<favoritesDao> favlist = boardMapper.favoritesList();
		
		if(result > 0 ) {
			System.out.println(" result " + result );
			model.addAttribute("msg", "북마크 정보를 삭제하였습니다.");
    		model.addAttribute("url", "/controller/favoritesList");
		}
		
		model.addAttribute("favlist", favlist);
		
		return "board/favoritesDelete";
	}
	
	
}
