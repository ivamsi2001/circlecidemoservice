package com.dorel.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorel.model.ErrorLogs;


@Repository
public interface ErrorLogsRepository extends JpaRepository<ErrorLogs, Long> {
//public interface ErrorLogsRepository extends PagingAndSortingRepository <ErrorLogs, Long> {

	List<ErrorLogs>  findAllByOrderByDateaddedDesc();
	
	List<ErrorLogs>  findAllByDateaddedGreaterThanOrderByDateaddedDesc(Date date);
	
	 Page<ErrorLogs> findAllByOrderByDateaddedDesc(Pageable pageable);
}
