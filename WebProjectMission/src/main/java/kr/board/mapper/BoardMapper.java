package kr.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.board.entity.BookmarkGroup;
import kr.board.entity.HisLocaDao;
import kr.board.entity.LocationDao;
import kr.board.entity.WifiDao;
import kr.board.entity.WifiVo;
import kr.board.entity.favoritesDao;

@Mapper // Mybatis API 
public interface BoardMapper { 
	
	
	public void wifiInfoInsert(WifiDao dao);
	public List<WifiDao> getNearbyWifi(LocationDao loca); // 근저wifi정보보기
	
	public List<WifiVo> getWifiInfo();
	
	public void hisWifiListInsert(HisLocaDao his);
	public List<HisLocaDao> getHisWifiList();
	public void hisWifiDelete(int idx);
	public WifiVo wifiDetail(String mgrNo);
	
	public List<BookmarkGroup> getbookmarkGroup();
	public int bookmarkGroupInsert(BookmarkGroup bkmkGroup);
	public int bookmarkGroupUpdate(BookmarkGroup bkmkGroup);
	public int bookmarkGroupDelete(int bkidx);
	public BookmarkGroup bookmarkGroupDetail(int bkidx);
	
	public List<favoritesDao> favoritesList();
	public int favoritesInsert(favoritesDao favoritesDao);
	public int favoritesDelete(int favidx);
	public favoritesDao favoritesDetail(int favidx);
}
