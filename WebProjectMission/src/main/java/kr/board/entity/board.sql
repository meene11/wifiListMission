delete from HisLocaDao;
delete from wifi_info;

select * from wifi_info;

select *, date_format(now(), '%Y-%m-%d %H:%i:%s') as workDate2 from HisLocaDao order by idx desc

 DROP TABLE bookmarkGroup;

delete from bookmarkGroup;


select * from HisLocaDao;

delete from HisLocaDao;

alter table HisLocaDao CHANGE workDttm workDate varchar(100);

create table HisLocaDao(
	idx int not null auto_increment,
	mainNm varchar(100),
	lat double,
	lnt double,
	workDttm varchar(100),
	primary key(idx)
);

create table bookmarkGroup(
	bkidx int not null auto_increment,
	bookmarkNm varchar(100),
	orderTurn int,
	applyDate varchar(100),
	upddate varchar(100),
	primary key(bkidx)
);

create table favorites (
	favidx int not null auto_increment,
	favBkNm varchar(100),
	favWifiNm varchar(100),
	favAplDate varchar(100),
	primary key(favidx)
);




insert into wifi_info
			(
			distance
			, mgrNo
			, wrdOfc
			, mainNm
			, adres1
			, adres2
			, instlFloor
			, instlTy
			, instlMby
			, svcSe
			, cmcwr
			, cnstcYear
			, inoutDoor
			, remars3
			, lat
			, lnt
			, workDttm
			)
		values
			(
			0.0
			, "---EP000001EP001111"
			, "은평구"
			, "갈현1동주민센터"
			, "갈현동 갈현로 301"
			, "1층"
			, ""
			, "7-1. 공공 - 행정"
			, null
			, null
			, null
			, 2011
			, null
			, null
			, 126.9167
			, 37.62364
			, "2023-06-25 10:58:26.0"
			);





create table wifi_info(
	distance int default 0,
	mgrNo varchar(50) not null,
	wrdOfc varchar(20) not null,  
	mainNm varchar(20) not null,
	adres1 varchar(20),
	adres2 varchar(20),
	instlFloor varchar(20),
	instlTy varchar(20),
	instlMby varchar(20),
	svcSe varchar(20),
	cmcwr varchar(20),
	cnstcYear int,
	inoutDoor varchar(20),
	remars3 varchar(20),
	lat int not null,
	lnt int not null,
	workDttm varchar(100),
	primary key(mgrNo)
);

alter table wifi_info modify lat double;
alter table wifi_info modify lnt double;
alter table wifi_info modify distance double;
alter table wifi_info modify workDttm varchar(100);
alter table wifi_info modify adres1 varchar(100);
alter table wifi_info modify adres2 varchar(100);
alter table wifi_info modify mainNm varchar(100);
alter table wifi_info modify instlTy varchar(100);

alter table wifi_info modify instlMby varchar(100);
alter table wifi_info modify svcSe varchar(100);
alter table wifi_info modify cmcwr varchar(100);
alter table wifi_info modify inoutDoor varchar(100);
alter table wifi_info modify remars3 varchar(100);
alter table wifi_info modify workDttm varchar(100);

select *, ABS((lnt - 37.552128)*(lat - 127.0677504)) AS distance2 from wifi_info order by distance2 ASC limit 20;


select *, round((6371 * acos( cos( radians(37.552128) ) * cos( radians(lnt) ) * cos( radians( 127.0677504 ) - radians(lat) ) + sin( radians(37.552128) ) * sin( radians(lnt) ) ) ), 4) AS distance2 from wifi_info order by distance2 ASC limit 5;

select *, round((6371 * acos( cos( radians(37.585598) ) * cos( radians(lnt) ) * cos( radians( 126.88479) - radians(lat) ) + sin( radians(37.585598) ) * sin( radians(lnt) ) ) ), 4) AS distance2 from wifi_info order by distance2 ASC limit 5;


select * from wifi_info;

select * from wifi_info
  WHERE mgrNo = '서울4차-6916';



SELECT COUNT(*) FROM wifi_info;


