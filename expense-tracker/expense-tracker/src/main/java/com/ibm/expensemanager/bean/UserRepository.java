package com.ibm.expensemanager.bean;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;
import com.ibm.expensemanager.bean.UserTransaction;

@Repository
public interface UserRepository extends CrudRepository<UserTransaction, Integer> {
	
	
	
	@Query(value = "SELECT * FROM user_transaction WHERE date Like %?1%", nativeQuery = true)
	List<Match> findByMatchMonthAndMatchDay(@Param ("date") Date date);	
}
