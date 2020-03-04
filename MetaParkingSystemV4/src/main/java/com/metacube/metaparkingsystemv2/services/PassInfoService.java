package com.metacube.metaparkingsystemv2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.metaparkingsystemv2.daoimpl.PassInfoDaoImpl;
import com.metacube.metaparkingsystemv2.models.PassInfo;

@Service
public class PassInfoService {

	@Autowired
	private PassInfoDaoImpl passInfoDao;

	public PassInfo getPassInfo(String vehicleType, String passType) {
		return passInfoDao.getPassInfo(passType, vehicleType);
	}

	public String getPassType(int passId) {
		return passInfoDao.getPassType(passId);
	}

	public double getPassPrice(int passId) {
		return passInfoDao.getPassPrice(passId);
	}
}
