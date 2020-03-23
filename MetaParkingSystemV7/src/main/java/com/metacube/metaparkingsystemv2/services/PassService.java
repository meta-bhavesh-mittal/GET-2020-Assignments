package com.metacube.metaparkingsystemv2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.metaparkingsystemv2.daoimpl.PassDaoImpl;
import com.metacube.metaparkingsystemv2.models.Pass;

@Service
public class PassService {

	@Autowired
	private PassDaoImpl passDao;

	public int generatePass(Pass pass) {
		return passDao.addPass(pass);
	}
}
