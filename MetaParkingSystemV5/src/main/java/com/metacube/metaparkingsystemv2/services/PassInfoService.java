package com.metacube.metaparkingsystemv2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.metaparkingsystemv2.dao.PassInfoDao;
import com.metacube.metaparkingsystemv2.models.PassInfo;

@Service
public class PassInfoService {

	@Autowired
	private PassInfoDao passInfoDao;

	public PassInfo getPassInfo(String vehicleType, String passType) {
		return passInfoDao.findPassInfoByPassTypeAndVehicleType(passType, vehicleType);
	}

	public String getPassType(int passId) {
		return  passInfoDao.findById(passId).orElse(new PassInfo()).getPassType();
	}

	public double getPassPrice(int passId) {
		return passInfoDao.findById(passId).orElse(new PassInfo()).getPassPrice();
	}
}
