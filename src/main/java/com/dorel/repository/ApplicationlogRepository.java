package com.dorel.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dorel.model.Applicationlog;

@Repository
public interface ApplicationlogRepository extends JpaRepository<Applicationlog, Long>, JpaSpecificationExecutor<Applicationlog>  {

	List<Applicationlog> findAllByOrderByDatecreatedDesc();
	
	List<Applicationlog> findAllByDatecreatedGreaterThanOrderByDatecreatedDesc(Date date);
	
	Page<Applicationlog> findAllByOrderByDatecreatedDesc(Pageable pageable);
	
	@Query(value = " SELECT * FROM ApplicationLog "+
			" WHERE LOWER(COALESCE(platform,'')) LIKE LOWER(CONCAT('%',:platform,'%')) AND "+
			" LOWER(COALESCE(eventtype,'')) LIKE LOWER(CONCAT('%',:eventtype,'%'))  AND "+
			" LOWER(COALESCE(LogType,'')) LIKE LOWER(CONCAT('%',:logtype,'%')) AND "+
			"(LOWER(COALESCE(platform,'')) LIKE LOWER(CONCAT('%',:search1,'%')) OR LOWER(COALESCE(device,'')) LIKE LOWER(CONCAT('%',:search2,'%')) OR "+
			" LOWER(COALESCE(deviceos,'')) LIKE LOWER(CONCAT('%',:search3,'%')) OR LOWER(COALESCE(productcode,'')) LIKE LOWER(CONCAT('%',:search4,'%')) OR "+
			 "LOWER(COALESCE(logtype,'')) LIKE LOWER(CONCAT('%',:search6,'%')) OR "+
			" LOWER(COALESCE(productserialno,'')) LIKE LOWER(CONCAT('%',:search7,'%')) OR LOWER(COALESCE(eventtype,'')) LIKE LOWER(CONCAT('%',:search8,'%')) OR "+
			" LOWER(COALESCE(functionname,'')) LIKE LOWER(CONCAT('%',:search9,'%')) OR LOWER(COALESCE(eventmessage,'')) LIKE LOWER(CONCAT('%',:search10,'%')) OR "+
			" LOWER(COALESCE(eventparameter,'')) LIKE LOWER(CONCAT('%',:search11,'%')) OR LOWER(COALESCE(otherparams,'')) LIKE LOWER(CONCAT('%',:search12,'%')) OR "+
			" LOWER(COALESCE(CAST(djguserid AS character varying),''))LIKE LOWER(CONCAT('%',:search13,'%')) "+
			" ) " +" GROUP BY(id) ORDER BY DATECREATED DESC \n-- #pageable\n ",
	countQuery=" SELECT count(id) FROM ApplicationLog "+
			" WHERE LOWER(COALESCE(platform,'')) LIKE LOWER(CONCAT('%',:platform,'%')) AND "+
			" LOWER(COALESCE(eventtype,'')) LIKE LOWER(CONCAT('%',:eventtype,'%'))  AND "+
			" LOWER(COALESCE(LogType,'')) LIKE LOWER(CONCAT('%',:logtype,'%')) AND "+
			"(LOWER(COALESCE(platform,'')) LIKE LOWER(CONCAT('%',:search1,'%')) OR LOWER(COALESCE(device,'')) LIKE LOWER(CONCAT('%',:search2,'%')) OR "+
			" LOWER(COALESCE(deviceos,'')) LIKE LOWER(CONCAT('%',:search3,'%')) OR LOWER(COALESCE(productcode,'')) LIKE LOWER(CONCAT('%',:search4,'%')) OR "+
			 "LOWER(COALESCE(logtype,'')) LIKE LOWER(CONCAT('%',:search6,'%')) OR "+
			" LOWER(COALESCE(productserialno,'')) LIKE LOWER(CONCAT('%',:search7,'%')) OR LOWER(COALESCE(eventtype,'')) LIKE LOWER(CONCAT('%',:search8,'%')) OR "+
			" LOWER(COALESCE(functionname,'')) LIKE LOWER(CONCAT('%',:search9,'%')) OR LOWER(COALESCE(eventmessage,'')) LIKE LOWER(CONCAT('%',:search10,'%')) OR "+
			" LOWER(COALESCE(eventparameter,'')) LIKE LOWER(CONCAT('%',:search11,'%')) OR LOWER(COALESCE(otherparams,'')) LIKE LOWER(CONCAT('%',:search12,'%')) OR "+
			" LOWER(COALESCE(CAST(djguserid AS character varying),'')) LIKE LOWER(CONCAT('%',:search13,'%')) "+
			" ) " +" GROUP BY(id) ORDER BY DATECREATED DESC \n-- #pageable\n",
			 nativeQuery=true)
 	Page<Applicationlog> findByPlatformAndEventtypeAndLogtypeAndSearchOrderByDatecreatedDesc(@Param("platform") String platform,@Param("eventtype") String eventtype,@Param("logtype") String logtype, 
 			@Param("search1") String search1, @Param("search2") String search2, @Param("search3") String search3, @Param("search4") String search4,  @Param("search6") String search6, 
 			@Param("search7") String search7, @Param("search8") String search8,@Param("search9") String search9, @Param("search10") String search10,@Param("search11") String search11,@Param("search12") String search12,@Param("search13") String search13, Pageable pageable);
	

	@Query(value = " SELECT * FROM ApplicationLog "+
			" WHERE LOWER(COALESCE(platform,'')) LIKE LOWER(CONCAT('%',:platform,'%')) AND "+
			" LOWER(COALESCE(eventtype,'')) LIKE LOWER(CONCAT('%',:eventtype,'%'))  AND "+
			" LOWER(COALESCE(LogType,'')) LIKE LOWER(CONCAT('%',:logtype,'%')) AND "+
			"(LOWER(COALESCE(platform,'')) LIKE LOWER(CONCAT('%',:search1,'%')) OR LOWER(COALESCE(device,'')) LIKE LOWER(CONCAT('%',:search2,'%')) OR "+
			" LOWER(COALESCE(deviceos,'')) LIKE LOWER(CONCAT('%',:search3,'%')) OR LOWER(COALESCE(productcode,'')) LIKE LOWER(CONCAT('%',:search4,'%')) OR "+
			 "LOWER(COALESCE(logtype,'')) LIKE LOWER(CONCAT('%',:search6,'%')) OR "+
			" LOWER(COALESCE(productserialno,'')) LIKE LOWER(CONCAT('%',:search7,'%')) OR LOWER(COALESCE(eventtype,'')) LIKE LOWER(CONCAT('%',:search8,'%')) OR "+
			" LOWER(COALESCE(functionname,'')) LIKE LOWER(CONCAT('%',:search9,'%')) OR LOWER(COALESCE(eventmessage,'')) LIKE LOWER(CONCAT('%',:search10,'%')) OR "+
			" LOWER(COALESCE(eventparameter,'')) LIKE LOWER(CONCAT('%',:search11,'%')) OR LOWER(COALESCE(otherparams,'')) LIKE LOWER(CONCAT('%',:search12,'%')) OR "+
			" LOWER(COALESCE(CAST(djguserid AS character varying),''))LIKE LOWER(CONCAT('%',:search13,'%')) "+
			" ) " +
			" AND COALESCE(DATECREATED) > :fromdate " +
			" GROUP BY(id) ORDER BY DATECREATED DESC \n-- #pageable\n ",
	countQuery=" SELECT count(id) FROM ApplicationLog "+
			" WHERE LOWER(COALESCE(platform,'')) LIKE LOWER(CONCAT('%',:platform,'%')) AND "+
			" LOWER(COALESCE(eventtype,'')) LIKE LOWER(CONCAT('%',:eventtype,'%'))  AND "+
			" LOWER(COALESCE(LogType,'')) LIKE LOWER(CONCAT('%',:logtype,'%')) AND "+
			"(LOWER(COALESCE(platform,'')) LIKE LOWER(CONCAT('%',:search1,'%')) OR LOWER(COALESCE(device,'')) LIKE LOWER(CONCAT('%',:search2,'%')) OR "+
			" LOWER(COALESCE(deviceos,'')) LIKE LOWER(CONCAT('%',:search3,'%')) OR LOWER(COALESCE(productcode,'')) LIKE LOWER(CONCAT('%',:search4,'%')) OR "+
			 "LOWER(COALESCE(logtype,'')) LIKE LOWER(CONCAT('%',:search6,'%')) OR "+
			" LOWER(COALESCE(productserialno,'')) LIKE LOWER(CONCAT('%',:search7,'%')) OR LOWER(COALESCE(eventtype,'')) LIKE LOWER(CONCAT('%',:search8,'%')) OR "+
			" LOWER(COALESCE(functionname,'')) LIKE LOWER(CONCAT('%',:search9,'%')) OR LOWER(COALESCE(eventmessage,'')) LIKE LOWER(CONCAT('%',:search10,'%')) OR "+
			" LOWER(COALESCE(eventparameter,'')) LIKE LOWER(CONCAT('%',:search11,'%')) OR LOWER(COALESCE(otherparams,'')) LIKE LOWER(CONCAT('%',:search12,'%')) OR "+
			" LOWER(COALESCE(CAST(djguserid AS character varying),''))LIKE LOWER(CONCAT('%',:search13,'%')) "+
			" ) " +
		    " AND COALESCE(DATECREATED) > :fromdate " +
			" GROUP BY(id) ORDER BY DATECREATED DESC \n-- #pageable\n ",
			 nativeQuery=true)
 	Page<Applicationlog> findByPlatformAndEventtypeAndLogtypeAndSearchOrderByDatecreatedDesc1(@Param("platform") String platform,@Param("eventtype") String eventtype,@Param("logtype") String logtype, 
 			@Param("search1") String search1, @Param("search2") String search2, @Param("search3") String search3, @Param("search4") String search4,  @Param("search6") String search6, 
 			@Param("search7") String search7, @Param("search8") String search8,@Param("search9") String search9, @Param("search10") String search10,@Param("search11") String search11,@Param("search12") String search12, @Param("search13") String search13, @Param("fromdate") Date fromdate, Pageable pageable);
	
	
	@Query(value = " SELECT * FROM ApplicationLog "+
			" WHERE LOWER(COALESCE(platform,'')) LIKE LOWER(CONCAT('%',:platform,'%')) AND "+
			" LOWER(COALESCE(eventtype,'')) LIKE LOWER(CONCAT('%',:eventtype,'%'))  AND "+
			" LOWER(COALESCE(LogType,'')) LIKE LOWER(CONCAT('%',:logtype,'%')) AND "+
			"(LOWER(COALESCE(platform,'')) LIKE LOWER(CONCAT('%',:search1,'%')) OR LOWER(COALESCE(device,'')) LIKE LOWER(CONCAT('%',:search2,'%')) OR "+
			" LOWER(COALESCE(deviceos,'')) LIKE LOWER(CONCAT('%',:search3,'%')) OR LOWER(COALESCE(productcode,'')) LIKE LOWER(CONCAT('%',:search4,'%')) OR "+
			 "LOWER(COALESCE(logtype,'')) LIKE LOWER(CONCAT('%',:search6,'%')) OR "+
			" LOWER(COALESCE(productserialno,'')) LIKE LOWER(CONCAT('%',:search7,'%')) OR LOWER(COALESCE(eventtype,'')) LIKE LOWER(CONCAT('%',:search8,'%')) OR "+
			" LOWER(COALESCE(functionname,'')) LIKE LOWER(CONCAT('%',:search9,'%')) OR LOWER(COALESCE(eventmessage,'')) LIKE LOWER(CONCAT('%',:search10,'%')) OR "+
			" LOWER(COALESCE(eventparameter,'')) LIKE LOWER(CONCAT('%',:search11,'%')) OR LOWER(COALESCE(otherparams,'')) LIKE LOWER(CONCAT('%',:search12,'%')) OR "+
			" LOWER(COALESCE(CAST(djguserid AS character varying),''))LIKE LOWER(CONCAT('%',:search13,'%')) "+
			" ) " +
			" AND COALESCE(DATECREATED) < :todate GROUP BY(id) ORDER BY DATECREATED DESC \n-- #pageable\n ",
	countQuery=" SELECT count(id) FROM ApplicationLog "+
			" WHERE LOWER(COALESCE(platform,'')) LIKE LOWER(CONCAT('%',:platform,'%')) AND "+
			" LOWER(COALESCE(eventtype,'')) LIKE LOWER(CONCAT('%',:eventtype,'%'))  AND "+
			" LOWER(COALESCE(LogType,'')) LIKE LOWER(CONCAT('%',:logtype,'%')) AND "+
			"(LOWER(COALESCE(platform,'')) LIKE LOWER(CONCAT('%',:search1,'%')) OR LOWER(COALESCE(device,'')) LIKE LOWER(CONCAT('%',:search2,'%')) OR "+
			" LOWER(COALESCE(deviceos,'')) LIKE LOWER(CONCAT('%',:search3,'%')) OR LOWER(COALESCE(productcode,'')) LIKE LOWER(CONCAT('%',:search4,'%')) OR "+
			 "LOWER(COALESCE(logtype,'')) LIKE LOWER(CONCAT('%',:search6,'%')) OR "+
			" LOWER(COALESCE(productserialno,'')) LIKE LOWER(CONCAT('%',:search7,'%')) OR LOWER(COALESCE(eventtype,'')) LIKE LOWER(CONCAT('%',:search8,'%')) OR "+
			" LOWER(COALESCE(functionname,'')) LIKE LOWER(CONCAT('%',:search9,'%')) OR LOWER(COALESCE(eventmessage,'')) LIKE LOWER(CONCAT('%',:search10,'%')) OR "+
			" LOWER(COALESCE(eventparameter,'')) LIKE LOWER(CONCAT('%',:search11,'%')) OR LOWER(COALESCE(otherparams,'')) LIKE LOWER(CONCAT('%',:search12,'%')) OR "+
			" LOWER(COALESCE(CAST(djguserid AS character varying),''))LIKE LOWER(CONCAT('%',:search13,'%')) "+
			" ) " +
		    " AND  COALESCE(DATECREATED) < :todate GROUP BY(id) ORDER BY DATECREATED DESC \n-- #pageable\n ",
			 nativeQuery=true)
 	Page<Applicationlog> findByPlatformAndEventtypeAndLogtypeAndSearchOrderByDatecreatedDesc2(@Param("platform") String platform,@Param("eventtype") String eventtype,@Param("logtype") String logtype, 
 			@Param("search1") String search1, @Param("search2") String search2, @Param("search3") String search3, @Param("search4") String search4,  @Param("search6") String search6, 
 			@Param("search7") String search7, @Param("search8") String search8,@Param("search9") String search9, @Param("search10") String search10,@Param("search11") String search11,@Param("search12") String search12, @Param("search13") String search13, @Param("todate") Date todate, Pageable pageable);
	
	@Query(value = " SELECT * FROM ApplicationLog "+
			" WHERE LOWER(COALESCE(platform,'')) LIKE LOWER(CONCAT('%',:platform,'%')) AND "+
			" LOWER(COALESCE(eventtype,'')) LIKE LOWER(CONCAT('%',:eventtype,'%'))  AND "+
			" LOWER(COALESCE(LogType,'')) LIKE LOWER(CONCAT('%',:logtype,'%')) AND "+
			"(LOWER(COALESCE(platform,'')) LIKE LOWER(CONCAT('%',:search1,'%')) OR LOWER(COALESCE(device,'')) LIKE LOWER(CONCAT('%',:search2,'%')) OR "+
			" LOWER(COALESCE(deviceos,'')) LIKE LOWER(CONCAT('%',:search3,'%')) OR LOWER(COALESCE(productcode,'')) LIKE LOWER(CONCAT('%',:search4,'%')) OR "+
			 "LOWER(COALESCE(logtype,'')) LIKE LOWER(CONCAT('%',:search6,'%')) OR "+
			" LOWER(COALESCE(productserialno,'')) LIKE LOWER(CONCAT('%',:search7,'%')) OR LOWER(COALESCE(eventtype,'')) LIKE LOWER(CONCAT('%',:search8,'%')) OR "+
			" LOWER(COALESCE(functionname,'')) LIKE LOWER(CONCAT('%',:search9,'%')) OR LOWER(COALESCE(eventmessage,'')) LIKE LOWER(CONCAT('%',:search10,'%')) OR "+
			" LOWER(COALESCE(eventparameter,'')) LIKE LOWER(CONCAT('%',:search11,'%')) OR LOWER(COALESCE(otherparams,'')) LIKE LOWER(CONCAT('%',:search12,'%')) OR "+
			" LOWER(COALESCE(CAST(djguserid AS character varying),''))LIKE LOWER(CONCAT('%',:search13,'%')) "+
			" ) " +
			" AND COALESCE(DATECREATED) > :fromdate " +
			" AND COALESCE(DATECREATED) < :todate GROUP BY(id) ORDER BY DATECREATED DESC \n-- #pageable\n ",
	countQuery=" SELECT count(id) FROM ApplicationLog "+
			" WHERE LOWER(COALESCE(platform,'')) LIKE LOWER(CONCAT('%',:platform,'%')) AND "+
			" LOWER(COALESCE(eventtype,'')) LIKE LOWER(CONCAT('%',:eventtype,'%'))  AND "+
			" LOWER(COALESCE(LogType,'')) LIKE LOWER(CONCAT('%',:logtype,'%')) AND "+
			"(LOWER(COALESCE(platform,'')) LIKE LOWER(CONCAT('%',:search1,'%')) OR LOWER(COALESCE(device,'')) LIKE LOWER(CONCAT('%',:search2,'%')) OR "+
			" LOWER(COALESCE(deviceos,'')) LIKE LOWER(CONCAT('%',:search3,'%')) OR LOWER(COALESCE(productcode,'')) LIKE LOWER(CONCAT('%',:search4,'%')) OR "+
			 "LOWER(COALESCE(logtype,'')) LIKE LOWER(CONCAT('%',:search6,'%')) OR "+
			" LOWER(COALESCE(productserialno,'')) LIKE LOWER(CONCAT('%',:search7,'%')) OR LOWER(COALESCE(eventtype,'')) LIKE LOWER(CONCAT('%',:search8,'%')) OR "+
			" LOWER(COALESCE(functionname,'')) LIKE LOWER(CONCAT('%',:search9,'%')) OR LOWER(COALESCE(eventmessage,'')) LIKE LOWER(CONCAT('%',:search10,'%')) OR "+
			" LOWER(COALESCE(eventparameter,'')) LIKE LOWER(CONCAT('%',:search11,'%')) OR LOWER(COALESCE(otherparams,'')) LIKE LOWER(CONCAT('%',:search12,'%')) OR "+
			" LOWER(COALESCE(CAST(djguserid AS character varying),''))LIKE LOWER(CONCAT('%',:search13,'%')) "+
			" ) " +
		    " AND COALESCE(DATECREATED) > :fromdate " +
			" AND  COALESCE(DATECREATED) < :todate GROUP BY(id) ORDER BY DATECREATED DESC \n-- #pageable\n ",
			 nativeQuery=true)
 	Page<Applicationlog> findByPlatformAndEventtypeAndLogtypeAndSearchOrderByDatecreatedDesc3(@Param("platform") String platform,@Param("eventtype") String eventtype,@Param("logtype") String logtype, 
 			@Param("search1") String search1, @Param("search2") String search2, @Param("search3") String search3, @Param("search4") String search4,  @Param("search6") String search6, 
 			@Param("search7") String search7, @Param("search8") String search8,@Param("search9") String search9, @Param("search10") String search10,@Param("search11") String search11,@Param("search12") String search12, @Param("search13") String search13, @Param("fromdate") Date fromdate,@Param("todate") Date todate, Pageable pageable);
	
	@Query(value = "SELECT * FROM applicationlog  WHERE LOWER(platform) LIKE LOWER(CONCAT('%',:platform, '%')) "
			+ " AND  LOWER(eventtype) LIKE LOWER(CONCAT('%',:eventtype, '%')) ORDER BY ?#{#pageable} ",
			countQuery ="SELECT count(*)  FROM applicationlog  WHERE LOWER(platform) LIKE LOWER(CONCAT('%',:platform, '%')) "
					+ " AND  LOWER(eventtype) LIKE LOWER(CONCAT('%',:eventtype, '%'))  ORDER BY ?#{#pageable}",
			nativeQuery=true)
	Page<Applicationlog> findByPlatformAndEventtype(@Param("platform") String platform,@Param("eventtype") String eventtype,Pageable pageable);

	
	public static final String getByLivesteamlog = "select * from  applicationlog where CAST(djguserid AS character varying)=:djguserid and productserialno =:productserialno and eventtype like '%Live%' order by datecreated desc limit 10";  
	@Query(value = getByLivesteamlog, nativeQuery = true)
	List<Applicationlog> findByLivestreamlog(@Param("djguserid") String djguserid, @Param("productserialno") String productserialno);

}
