package com.ib.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ib.poc.model.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

	
	
	@Query("SELECT count(cube) from Message where message like :query group by cube")
	public List<Long> findCube(@Param("query") String query);

	@Query("SELECT count(truth) from Message where message like :query group by truth")
	public List<Long> findTruth(@Param("query") String query);

	@Query("SELECT count(google), avg(googleNotSpam), avg(googleSpam) from Message where message like :query group by google")
	public List<Object[]> findGoogle(@Param("query") String query);

	@Query("SELECT count(ibm), avg(ibmNotSpam), avg(ibmSpam) from Message where message like :query group by ibm")
	public List<Object[]> findIbm(@Param("query") String query);
}
