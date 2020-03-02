package com.metacube.assignment.daoimplement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.assignment.dao.PassInfoDao;


@Repository
public class PassInfoDaoImpl implements PassInfoDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public PassInfoDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/*
	 * This is used to get the passId using passType and vehicleType argument.
	 */
	@Override
	public int getPassId(String passType, String vehicleType) {
		int passId = jdbcTemplate.queryForObject(selectPassId, new Object[] {passType, vehicleType}, Integer.class);
		return passId;
	}

	/*
	 * This is used to get the pass type using passId
	 */
	public String getPassType(int passId) {
		String passType = jdbcTemplate.queryForObject(selectPassType, new Object[] {passId}, String.class);
		return passType;
	}

	/*
	 * This is used to get the pass price using passId.
	 */
	public double getPassPrice(int passId) {
		double passPrice = jdbcTemplate.queryForObject(selectPassPrice, new Object[] {passId}, Double.class);
		return passPrice;
	}
}
