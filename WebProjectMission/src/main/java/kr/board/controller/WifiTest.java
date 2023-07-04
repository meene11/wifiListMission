package kr.board.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import kr.board.entity.WifiVo;
import kr.board.mapper.BoardMapper;

@RestController
public class WifiTest {
	
	@Autowired
	BoardMapper boardMapper;
	
	static final String KEY = "716d6a6d44636c6937304958705a5a";
    static int TOTALCNT;
    
    
    public static int TotalCnt() throws Exception {	
//      public static int TotalCnt() throws ParseException {	
    	
        URL url = null;
        HttpURLConnection con= null;
        JSONObject result = null;
        StringBuilder sb = new StringBuilder();
        int start = 1;
        int end = 1;
        String baseUrl = "http://openapi.seoul.go.kr:8088/" + KEY + "/" +
                "json/TbPublicWifiInfo/"+ start + "/"+end+"/";

        try {
            url = new URL(baseUrl);
            con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");

            con.setRequestProperty("Content-type", "application/json");

            con.setDoOutput(true);

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            while(br.ready()) {
                sb.append(br.readLine());
            }
            con.disconnect();
        }catch(Exception e) {
            e.printStackTrace();
        }

        result = (JSONObject) new JSONParser().parse(sb.toString());

        StringBuilder out = new StringBuilder();

        JSONObject data = (JSONObject) result.get("TbPublicWifiInfo");
        int totalGet = Integer.parseInt( data.get("list_total_count").toString());

        return totalGet;
    }

      /*
    public static int AddWifi() throws Exception{
//    public static int AddWifi() throws ParseException{	  
        int start = 0;
        int end = 0;
        int total = 0;

//        TOTALCNT = TotalCnt();
//        System.out.println(" TOTALCNT :  " + TOTALCNT);
        int pageEnd = TOTALCNT / 1000;
        int pageEndRemain = TOTALCNT % 1000;
        
        
        System.out.println(" pageEnd : " + pageEnd);
        System.out.println(" pageEndRemain : " + pageEndRemain);

//        for (int k = 0; k <= pageEnd; k++) {
        if(true) {	
        	
        	start = 0;
        	end = 0;		
            start = (int) Math.pow(10, 3) * k + 1;

            if(k == pageEnd){
                end = start + pageEndRemain - 1;
            }
            else{
                end = (int) Math.pow(10, 3) * (k+1) ;
            }

            String baseUrl = "http://openapi.seoul.go.kr:8088/" + KEY + "/" +
                    "json/TbPublicWifiInfo/";

            baseUrl = baseUrl + start + "/" + end + "/";

            URL url = null;
            HttpURLConnection con= null;
            JSONObject result = null;
            StringBuilder sb = new StringBuilder();


            try {
                url = new URL(baseUrl);
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("Content-type", "application/json");
                con.setDoOutput(true);


                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                while(br.ready()) {
                    sb.append(br.readLine());
                }
                con.disconnect();
            }catch(Exception e) {
                e.printStackTrace();
            }

            result = (JSONObject) new JSONParser().parse(sb.toString());

            JSONObject data = (JSONObject) result.get("TbPublicWifiInfo");
            JSONArray array = (JSONArray) data.get("row");

            JSONObject tmp;
            
//            WifiVo wifivo = new WifiVo();
//            WifiVo[] wifivo = new WifiVo[10];
//            for(int i = 0; i<array.size(); i++) {
            
              for(int i = 0; i<1; i++) {
            	  
//            	wifivo[i] = new WifiVo();
            	  WifiVo wifivo = new WifiVo();
                tmp = (JSONObject) array.get(i);
                String stmp = (String) tmp.get("X_SWIFI_MGR_NO");
                String stmpLat = (String) tmp.get("LAT");
                double lat = Double.parseDouble(stmpLat);
                System.out.println("a lat좌표  : " + lat);
                String stmpLnt = (String) tmp.get("LNT");
                double lnt = Double.parseDouble(stmpLnt);
                System.out.println("a lnt좌표  : " + lnt);
                
                String yr = (String) tmp.get("X_SWIFI_CNSTC_YEAR");
                int intYr = Integer.parseInt(yr);
                
                		
                wifivo.setDistance(0.00);
                wifivo.setMgrNo(String.valueOf(tmp.get("X_SWIFI_MGR_NO")));
                wifivo.setWrdOfc(String.valueOf(tmp.get("X_SWIFI_WRDOFC")));
                wifivo.setMainNm(String.valueOf(tmp.get("X_SWIFI_MAIN_NM")));
                wifivo.setAdres1(String.valueOf(tmp.get("X_SWIFI_ADRES1")));
               
                wifivo.setMgrNo(String.valueOf(tmp.get("X_SWIFI_MGR_NO")));
                wifivo.setWrdOfc(String.valueOf(tmp.get("X_SWIFI_WRDOFC")));
                wifivo.setMainNm(String.valueOf(tmp.get("X_SWIFI_MAIN_NM")));
                wifivo.setAdres1(String.valueOf(tmp.get("X_SWIFI_ADRES1")));
                
                
                wifivo.setAdres2( String.valueOf(tmp.get("X_SWIFI_ADRES2")));
                wifivo.setInstlFloor( String.valueOf(tmp.get("X_SWIFI_INSTL_FLOOR")));
                wifivo.setInstlTy( String.valueOf(tmp.get("X_SWIFI_INSTL_TY")));
                wifivo.setInstlMby( String.valueOf(tmp.get("X_SWIFI_INSTL_MBY")));
                wifivo.setSvcSe( String.valueOf(tmp.get("X_SWIFI_SVC_SE")));
                wifivo.setCmcwr( String.valueOf(tmp.get("X_SWIFI_CMCWR")));
                wifivo.setCnstcYear(intYr);
                wifivo.setInoutDoor( String.valueOf(tmp.get("X_SWIFI_INOUT_DOOR")));
                wifivo.setRemars3( String.valueOf(tmp.get("X_SWIFI_REMARS3")));
                wifivo.setLat(lat);
                wifivo.setLnt(lnt);
                wifivo.setWorkDttm(String.valueOf(tmp.get("WORK_DTTM")));
                
                System.out.println("wifivo : " + wifivo);
//                System.out.println(" i :"+i);
//                System.out.println("관리 : "+ stmp);
//                System.out.println("자치구 : "+ stmp1);
//                System.out.println("와이파이명 : "+ stmp2);
//                System.out.println((String) jsonObject.get("X_SWIFI_MGR_NO")); 

//                BoardMapper bmapper = new BoardMapper();
                
               
                
//                BoardRestController bCon = new BoardRestController();
//                System.out.println("  전에 : " + wifivo);
//                bCon.wifiList(wifivo);
                
           	 WifiDao wD = new WifiDao();
           	 wD.wifiSql(wifivo);
                
                
                if(wifivo != null) {
                	
//                	boardMapper.wifiInfoInsert(wifivo);
//                	wiFiInsert(wifivo);
//                	crl.wifiInfoInsert(wifivo);
                	
//                	 WifiDao wD = new WifiDao();
//                     wD.wifiInsert(wifivo);
                }
                
//                total++;
            }
        }
        return total;
    }
    */
    
    public static List<WifiVo> testList() throws ParseException {
    	List<WifiVo> list = new ArrayList<WifiVo>();
    	
    	/* test
    	int start = 0;
         int end = 0;
         int total = ;
         */
    	
    	 int start = 0;
         int end = 0;
         int total = 0;

         try {
			TOTALCNT = TotalCnt();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
         int pageEnd = TOTALCNT / 1000;
         int pageEndRemain = TOTALCNT % 1000;
         
         
//          if(true) {         
          for (int k = 0; k <= pageEnd; k++) {
              start = (int) Math.pow(10, 3) * k + 1;

              if(k == pageEnd){
                  end = start + pageEndRemain - 1;
              }
              else{
                  end = (int) Math.pow(10, 3) * (k+1) ;
              }

              String baseUrl = "http://openapi.seoul.go.kr:8088/" + KEY + "/" +
                      "json/TbPublicWifiInfo/";

              baseUrl = baseUrl + start + "/" + end + "/";

              URL url = null;
              HttpURLConnection con= null;
              JSONObject result = null;
              StringBuilder sb = new StringBuilder();


              try {
                  url = new URL(baseUrl);
                  con = (HttpURLConnection) url.openConnection();
                  con.setRequestMethod("GET");
                  con.setRequestProperty("Content-type", "application/json");
                  con.setDoOutput(true);


                  BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                  while(br.ready()) {
                      sb.append(br.readLine());
                  }
                  con.disconnect();
              }catch(Exception e) {
                  e.printStackTrace();
              }

              result = (JSONObject) new JSONParser().parse(sb.toString());

              JSONObject data = (JSONObject) result.get("TbPublicWifiInfo");
              JSONArray array = (JSONArray) data.get("row");

              JSONObject tmp;
//              System.out.println("체크  array.size() : " + array.size());
              
              for(int i = 0; i<array.size(); i++) {
                  tmp = (JSONObject) array.get(i);
                  tmp = (JSONObject) array.get(i);
                  String stmpLat = (String) tmp.get("LAT");
                  double lat = Double.parseDouble(stmpLat);
//                  System.out.println("a lat좌표  : " + lat);
                  String stmpLnt = (String) tmp.get("LNT");
                  double lnt = Double.parseDouble(stmpLnt);
//                  System.out.println("a lnt좌표  : " + lnt);
                  String yr = (String) tmp.get("X_SWIFI_CNSTC_YEAR");
                  int intYr = Integer.parseInt(yr);
                  
                  WifiVo wifivo = new WifiVo();
                  
                  wifivo.setDistance(0.00);
                  wifivo.setMgrNo(String.valueOf(tmp.get("X_SWIFI_MGR_NO")));
                  wifivo.setWrdOfc(String.valueOf(tmp.get("X_SWIFI_WRDOFC")));
                  wifivo.setMainNm(String.valueOf(tmp.get("X_SWIFI_MAIN_NM")));
                  wifivo.setAdres1(String.valueOf(tmp.get("X_SWIFI_ADRES1")));
                 
                  wifivo.setMgrNo(String.valueOf(tmp.get("X_SWIFI_MGR_NO")));
                  wifivo.setWrdOfc(String.valueOf(tmp.get("X_SWIFI_WRDOFC")));
                  wifivo.setMainNm(String.valueOf(tmp.get("X_SWIFI_MAIN_NM")));
                  wifivo.setAdres1(String.valueOf(tmp.get("X_SWIFI_ADRES1")));
                  
                  
                  wifivo.setAdres2( String.valueOf(tmp.get("X_SWIFI_ADRES2")));
                  wifivo.setInstlFloor( String.valueOf(tmp.get("X_SWIFI_INSTL_FLOOR")));
                  wifivo.setInstlTy( String.valueOf(tmp.get("X_SWIFI_INSTL_TY")));
                  wifivo.setInstlMby( String.valueOf(tmp.get("X_SWIFI_INSTL_MBY")));
                  wifivo.setSvcSe( String.valueOf(tmp.get("X_SWIFI_SVC_SE")));
                  wifivo.setCmcwr( String.valueOf(tmp.get("X_SWIFI_CMCWR")));
                  wifivo.setCnstcYear(intYr);
                  wifivo.setInoutDoor( String.valueOf(tmp.get("X_SWIFI_INOUT_DOOR")));
                  wifivo.setRemars3( String.valueOf(tmp.get("X_SWIFI_REMARS3")));
                  wifivo.setLat(lat);
                  wifivo.setLnt(lnt);
                  wifivo.setWorkDttm(String.valueOf(tmp.get("WORK_DTTM")));
                  
                  list.add(wifivo);
                  
                  total++;
              }
          }
          
//    System.out.println(" list : " + list);      
    	
    	return list;
    }
    

	public static void main(String[] args) throws Exception {
		try {
			System.out.println(TotalCnt()+"갯수");
//			AddWifi();
//			System.out.println(AddWifi());
			
				System.out.println("testList @#$@#$: "+ testList());
				System.out.println("~~~~~~~~~~");
		} catch (ParseException e) {
			System.out.println("오류 : "+ e.getMessage());
			e.printStackTrace();
		}
		
		

	}

}
