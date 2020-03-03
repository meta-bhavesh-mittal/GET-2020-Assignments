package com.metacube.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.assignment.daoimplement.PassDaoImpl;
import com.metacube.assignment.model.Pass;



@Service
public class PassService {

	@Autowired
	private PassDaoImpl passDao;

	public int generatePass(Pass pass) {
		return passDao.addPass(pass);
	}
}
