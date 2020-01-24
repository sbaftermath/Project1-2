package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Superhuman;
import com.revature.util.ConnectionUtil;

public class SuperhumanDAOPostgres implements SuperhumanDAO {

	Superhuman sh = new Superhuman();
	private Connection conn;

	@Override
	public void createSuperhuman(Superhuman person) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("insert into superhuman"
					+ "(superhuman_name, superhuman_powers, superhuman_weakness, superhuman_alignment) "
					+ "values (?, ?, ?, ?)");
			stmt.setString(1, person.getSuperhumanName());
			stmt.setString(2, person.getPowers());
			stmt.setString(3, person.getWeakness());
			stmt.setString(4, person.getAlignment());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void removeSuperhuman(Superhuman person) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("delete from superhuman where superhuman_name=?");
			stmt.setString(1, person.getSuperhumanName());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateSuperhuman(Superhuman person) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("update superhuman set superhuman_powers=? , superhuman_weakness=? "
					+ ", superhuman_alignment=? where superhuman_name=?");
			stmt.setString(1, person.getPowers());
			stmt.setString(2, person.getWeakness());
			stmt.setString(3, person.getAlignment());
			stmt.setString(4, person.getSuperhumanName());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Superhuman> viewSuperhumans() {
		// TODO Auto-generated method stub
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement stmt = null;
		ArrayList<Superhuman> list = new ArrayList<Superhuman>();
		try {
			stmt = conn.prepareStatement("select * from superhuman");
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				list.add(new Superhuman(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4)));
				// Superhuman s = new Superhuman(resultSet.getString(1), resultSet.getString(2),
				// resultSet.getString(3), resultSet.getString(4));
				// System.out.println(list);
				// System.out.println(list);
				// System.out.println(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// System.out.println(list);
		return list;
	}
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}
}
