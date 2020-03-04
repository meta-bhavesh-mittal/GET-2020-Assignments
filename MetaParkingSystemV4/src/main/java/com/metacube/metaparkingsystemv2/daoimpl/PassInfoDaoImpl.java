package com.metacube.metaparkingsystemv2.daoimpl;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.metaparkingsystemv2.dao.PassInfoDao;
import com.metacube.metaparkingsystemv2.models.PassInfo;

@Repository
public class PassInfoDaoImpl implements PassInfoDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public PassInfo getPassInfo(String passType, String vehicleType) {
		Session session = entityManager.unwrap(Session.class);
		Query<PassInfo> query = session.createQuery("From PassInfo where passType = :passType and vehicleType = :vehicleType", PassInfo.class);
		query.setParameter("passType", passType);
		query.setParameter("vehicleType", vehicleType);
		PassInfo passInfo = query.uniqueResult();
		return passInfo;
	}

	@Override
	public String getPassType(int passId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getPassPrice(int passId) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
