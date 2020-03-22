package com.ibm.expensemanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;
import com.ibm.expensemanager.bean.UserTransaction;
import com.ibm.expensemanager.dao.UserRepository;

@RestController
//@RequestMapping("/user-app")
public class UserController {

	@Autowired
	UserRepository repo;
	
	@RequestMapping("/users")
	Iterable<UserTransaction> getUsers(){
		return repo.findAll();
	}
	
	@RequestMapping("/users/date/{date}")
	List<Match> getDate(@PathVariable String date) {
		return repo.findByMatchMonthAndMatchDay(date);
	}
}
