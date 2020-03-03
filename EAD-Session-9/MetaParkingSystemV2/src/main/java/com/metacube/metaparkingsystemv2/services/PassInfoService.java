package com.metacube.metaparkingsystemv2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.metaparkingsystemv2.daoimpl.PassInfoDaoImpl;

@Service
public class PassInfoService {

	@Autowired
	private PassInfoDaoImpl passInfoDao;

	public int getPassId(String vehicleType, String passType) {
		return passInfoDao.getPassId(passType, vehicleType);
	}

	public String getPassType(int passId) {
		return passInfoDao.getPassType(passId);
	}

	public double getPassPrice(int passId) {
		return passInfoDao.getPassPrice(passId);
	}
}
