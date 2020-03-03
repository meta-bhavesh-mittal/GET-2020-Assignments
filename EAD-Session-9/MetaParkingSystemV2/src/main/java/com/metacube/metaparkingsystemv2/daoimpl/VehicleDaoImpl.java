package com.metacube.metaparkingsystemv2.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.metacube.metaparkingsystemv2.dao.VehicleDao;
import com.metacube.metaparkingsystemv2.models.Vehicle;
import com.metacube.metaparkingsystemv2.utils.ConnectionUtility;

@Repository
public class VehicleDaoImpl implements VehicleDao {

	@Override
	public Vehicle getVehicle(int vehicleId) {
		Vehicle vehicle = new Vehicle();
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement st = connection.prepareStatement(selectVehicle);
			st.setInt(1, vehicleId);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				vehicle.setVehicleId(vehicleId);
				vehicle.setEmpId(rs.getInt("empId"));
				vehicle.setVehicleName(rs.getString("vehicleName"));
				vehicle.setType(rs.getString("type"));
				vehicle.setVehicleNumber(rs.getString("vehicleNumber"));
				vehicle.setIdentification(rs.getString("identification"));
				vehicle.setPassId(rs.getInt("passId"));
			}
		} catch (SQLException e) {
			System.out.println("Vehicle could not be fetched...");
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection);
		}
		return vehicle;
	}

	@Override
	public boolean updateVehicle(Vehicle vehicle, int vehicleId) {
		boolean result = false;
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement st = connection.prepareStatement(updateVehicle);
			st.setString(1, vehicle.getVehicleName());
			st.setString(2, vehicle.getType());
			st.setString(3, vehicle.getVehicleNumber());
			st.setString(4, vehicle.getIdentification());
			st.setInt(5, vehicle.getPassId());
			st.setInt(6, vehicleId);
			System.out.println(vehicle);
			int rowsAffected = st.executeUpdate();
			if (rowsAffected != 0) {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("Vehicle could not Added");
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection);
		}
		System.out.println(result);
		return result;
	}

	@Override
	public int addVehicle(Vehicle vehicle) {
		int vehicleId = -1;
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement st = connection.prepareStatement(insertVehicle);
			st.setString(1, vehicle.getVehicleName());
			st.setString(2, vehicle.getType());
			st.setString(3, vehicle.getVehicleNumber());
			st.setString(4, vehicle.getIdentification());
			st.setInt(5, vehicle.getEmpId());
			st.setInt(6, vehicle.getVehicleId());
			st.setInt(7, vehicle.getPassId());
			int rowsAffected = st.executeUpdate();
			if (rowsAffected != 0) {
				st = connection.prepareStatement(lastRecord);
				ResultSet rs = st.executeQuery();
				rs.next();
				vehicleId = rs.getInt(1) - 1;
			}
		} catch (SQLException e) {
			System.out.println("Vehicle Added");
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection);
		}
		return vehicleId;
	}

	public int getVehicleIdByEmpId(int empId) {
		int vehicleId = -1;
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement st = connection.prepareStatement(selectVehicleIdByEmpId);
			st.setInt(1, empId);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				vehicleId = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Vehicle id could not be fetched...");
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection);
		}
		System.out.println(vehicleId);
		return vehicleId;
	}
}
