package com.metacube.metaparkingsystemv2.dao;

import org.springframework.data.repository.CrudRepository;

import com.metacube.metaparkingsystemv2.models.PassInfo;

public interface PassInfoDao extends CrudRepository<PassInfo, Integer>{

	PassInfo findPassInfoByPassTypeAndVehicleType(String passType, String vehicleType);
	/*
	 * PassInfo getPassInfo(String passType, String vehicleType);
	 * 
	 * String getPassType(int passId);
	 * 
	 * double getPassPrice(int passId);
	 */
}
