package com.metacube.metaparkingsystemv2.dao;

import com.metacube.metaparkingsystemv2.models.PassInfo;

public interface PassInfoDao {
	String selectPassId = "SELECT PassId from PassInfo" + " where passType = ? and vehicleType = ?;";
	String selectPassType = "SELECT PassType from PassInfo where passId = ?;";
	String selectPassPrice = "SELECT PassPrice from PassInfo  where passId = ?;";

	PassInfo getPassInfo(String passType, String vehicleType);

	String getPassType(int passId);

	double getPassPrice(int passId);
}
