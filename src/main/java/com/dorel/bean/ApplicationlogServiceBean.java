package com.dorel.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dorel.model.Applicationlog;
import com.dorel.repository.ApplicationlogRepository;
import com.dorel.service.ApplicationlogService;

@Service
public class ApplicationlogServiceBean implements ApplicationlogService{

	@Autowired
	private  ApplicationlogRepository applogRepository;
	
	@PersistenceContext	
	private EntityManager em;
	
	@Override
	public List<Applicationlog> getAllLogs() {
		int noOfDays = 14; //i.e one weeks
		Calendar dt = Calendar.getInstance();
		dt.setTime(new Date());            
		dt.add(Calendar.DAY_OF_YEAR, -noOfDays);
		Date date = dt.getTime();
		return applogRepository.findAllByDatecreatedGreaterThanOrderByDatecreatedDesc(date);
	}

	@Override
	public Page<Applicationlog> getAllLogsBypage(Pageable pageable) {
		// TODO Auto-generated method stub
		return applogRepository.findAllByOrderByDatecreatedDesc(pageable);
	}
	
	

	@Override
	public void saveAppinfo(Applicationlog applog) {
		applogRepository.save(applog);
		
	}

	@Override
	public Page<Applicationlog> findAllByApplicationlog(Pageable pageable, String platform,String eventtype,String logtype, String search, String fromdate, String todate) {
		System.out.println("searchbean-"+search+" | platform-"+platform+" | eventtype-"+eventtype+" | logtype-"+logtype+" | fromdate- "+fromdate+" | todate- "+todate);
		//2017-09-30 --09/15/2017
	/*	UserSpecification spec1 = null;
		UserSpecification spec2 = null;
		UserSpecification spec3 = null;
		UserSpecification spec4 = null;
		SearchCriteria criteria;
		Specification<Applicationlog> spec = Specifications.where(spec1);
		
		if(platform != null){
			spec1 = new UserSpecification(new SearchCriteria("platform", ":", platform.toLowerCase()));
		}
		if(eventtype != null){
			spec2 = new UserSpecification(new SearchCriteria("eventtype", ":", eventtype.toLowerCase()));
		}
		if(logtype != null){
			spec3 = new UserSpecification(new SearchCriteria("logtype", ":", logtype.toLowerCase()));
		}
		if(search != null){
			
			spec4 = new UserSpecification(new SearchCriteria("search", ":", search.toLowerCase()));
		}
				
		
		System.out.println("spec1---"+spec1.toString());
		Page<Applicationlog> results = applogRepository.findAll(Specifications.where(spec1).and(spec2).and(spec3), pageable);

		System.out.println(" results--"+results.getSize());
		return results;*/
		Date fromdate1=null;
		Date todate1=null;
	//	fromdate="09-28-2017";
	//	todate="09-30-2017";
		if(fromdate != null && fromdate.length() >9){
			SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
			try {
				fromdate1 = formatter.parse(fromdate);
				System.out.println("--fromdate1--"+fromdate1);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if(todate != null && todate.length() >9){
			SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
			try {
				todate1 = formatter.parse(todate);
				System.out.println("--todate1--"+todate1);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(fromdate1 != null && todate1==null){
			System.out.println(" fromdate "+fromdate1 + " | todate -"+todate1 );
			return applogRepository.findByPlatformAndEventtypeAndLogtypeAndSearchOrderByDatecreatedDesc1(platform, eventtype, logtype, search,search,search,search,search,search,search,search,search,search,search,search,fromdate1,pageable);
		}else if(fromdate1 == null && todate1 != null){
			System.out.println(" fromdate "+fromdate1 + " | todate -"+todate1 );
			return applogRepository.findByPlatformAndEventtypeAndLogtypeAndSearchOrderByDatecreatedDesc2(platform, eventtype, logtype, search,search,search,search,search,search,search,search,search,search,search,search,todate1, pageable);
		}else if (fromdate1 != null && todate1 != null){
			System.out.println(" fromdate "+fromdate1 + " | todate -"+todate1 );
			return applogRepository.findByPlatformAndEventtypeAndLogtypeAndSearchOrderByDatecreatedDesc3(platform, eventtype, logtype, search,search,search,search,search,search,search,search,search,search,search,search,fromdate1,todate1, pageable);
		}else{
			System.out.println(" fromdate "+fromdate1 + " | todate -"+todate1 );
			return applogRepository.findByPlatformAndEventtypeAndLogtypeAndSearchOrderByDatecreatedDesc(platform, eventtype, logtype,search,search,search,search,search,search,search,search,search,search,search,search, pageable);		
		}
		
	
	}

	@Override
	public List<Applicationlog> getByLivestreamlog(String djguserid, String productserialno) {
		return applogRepository.findByLivestreamlog(djguserid, productserialno);
	}

}
