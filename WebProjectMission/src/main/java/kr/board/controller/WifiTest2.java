package kr.board.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.RestController;

import kr.board.entity.WifiVo;

@RestController
public class WifiTest2 {
	
//	@Autowired
//	BoardMapper boardMapper;
	
	/*
	 
//          for (int k = 0; k <= pageEnd; k++) {
          if(true) {	
//          	start = 1;
//          	end = 2;		
        	  
          	// 0~ total 23304 
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
              
              System.out.println(" array.size() : " + array.size());
              for(int i = 0; i<3; i++) {
//              for(int i = 0; i<array.size(); i++) {
            	  WifiVo wifivo = new WifiVo();
              
//    test//            for(int i = 0; i<1; i++) {
              	  
//              	wifivo[i] = new WifiVo();
                  tmp = (JSONObject) array.get(i);
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
                  
                  list.add(wifivo);
                  
                  System.out.println("체크 $#%#$%#$%^#$%#$%#$%#$ wifivo : " + wifivo);
                  System.out.println("list : " + list);
                  
                  
                  total++;
              }
          }
	
	public static int AddWifi() throws ParseException{
        int start = 0;
        int end = 0;
        int total = 0;

        TOTALCNT = TotalCnt();
        int pageEnd = TOTALCNT / 1000;
        int pageEndRemain = TOTALCNT % 1000;

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

            for(int i = 0; i<array.size(); i++) {
                tmp = (JSONObject) array.get(i);
                System.out.println((String) jsonObject.get("X_SWIFI_MGR_NO")); // 가져오고자 하는 인자를 작성하면 됨.
                total++;
            }
        }
        return total;
    }

*/    

	public static void main(String[] args) throws Exception {
		String KEY = "716d6a6d44636c6937304958705a5a";
    	int TOTALCNT;
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
        

//        for (int k = 0; k <= pageEnd; k++) {
        if(true) {	
        	
        	start = 1;
        	end = 5;		
        	/*  // 0~ total 23304 
            start = (int) Math.pow(10, 3) * k + 1;

            if(k == pageEnd){
                end = start + pageEndRemain - 1;
            }
            else{
                end = (int) Math.pow(10, 3) * (k+1) ;
            }
            */

//            String baseUrl = "http://openapi.seoul.go.kr:8088/" + KEY + "/" +
//                    "json/TbPublicWifiInfo/";


//            URL url = null;
//            HttpURLConnection con= null;
//            JSONObject result = null;
//            StringBuilder sb = new StringBuilder();

        	StringBuilder sb2 = new StringBuilder();

            try {
                url = new URL(baseUrl);
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("Content-type", "application/json");
                con.setDoOutput(true);


                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                while(br.ready()) {
                    sb2.append(br.readLine());
                }
                con.disconnect();
            }catch(Exception e) {
                e.printStackTrace();
            }

            System.out.println(" sb2 :" + sb2.toString());
            result = (JSONObject) new JSONParser().parse(sb2.toString());
            System.out.println(" result :");

            JSONObject data2 = (JSONObject) result.get("TbPublicWifiInfo");
            JSONArray array = (JSONArray) data2.get("row");

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
                
                String re3 = String.valueOf(tmp.get("X_SWIFI_REMARS3"));
                if(re3.equals("") ) {
                	System.out.println(" 비값");
                }
                
                if(re3 == null ) {
                	System.out.println(" 널");
                }
                
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
                
                if(wifivo != null) {
//                	boardMapper.wifiInfoInsert(wifivo);
                	BoardRestController crl = new BoardRestController();
//                	((BoardMapper) crl).wifiInfoInsert(wifivo);
//                	crl.boardMapper.wifiInfoInsert(wifivo);
//                	crl.wifiInfoInsert(wifivo);
                }
                
            }
		
        }
	}

}
