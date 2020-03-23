package com.metacube.metaparkingsystemv2.dao;

import com.metacube.metaparkingsystemv2.models.Pass;

public interface PassDao {
	String insertPass = "INSERT INTO Pass values (?, ?, ?, ?);";
	String selectPass = "SELECT * FROM Pass where passId = ?";
	String updatePass = "UPDATE Pass set passType = ?, passPrice = ?" + " where passId = ?";
	String lastRecord = "SELECT AUTO_INCREMENT FROM information_schema.TABLES"
			+ " WHERE TABLE_SCHEMA = 'metaparkingdbv2' AND TABLE_NAME = 'Pass'";

	Pass getPass(int passId);

	boolean updatePass(Pass pass);

	int addPass(Pass pass);
}
