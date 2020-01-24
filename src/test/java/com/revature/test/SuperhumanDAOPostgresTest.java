package com.revature.test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.postgresql.core.BaseStatement;

import com.revature.dao.SuperhumanDAOPostgres;
import com.revature.pojo.Superhuman;
import com.revature.util.ConnectionUtil;

@RunWith(MockitoJUnitRunner.class)
public class SuperhumanDAOPostgresTest {
	
	private SuperhumanDAOPostgres cityDao = new SuperhumanDAOPostgres();
	
	private Superhuman city;
	
	@Mock
	private Connection conn;
	
	@Spy
	private Statement stmt = ConnectionUtil.getConnection().createStatement();

	@Spy
	private PreparedStatement findStmt = ConnectionUtil.getConnection().prepareStatement("select * from city where city_id = ?");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		when(conn.createStatement()).thenReturn(stmt);
		
		cityDao.setConn(conn);
		
		city = new Superhuman();
		
	}

	@After
	public void tearDown() throws Exception {
		
		ConnectionUtil.getConnection().createStatement().executeUpdate("truncate table city");
		
	}

	@Test
	public void createCity() throws SQLException {
		city.setSuperhumanName("qwop");
		city.setPowers("powers");
		city.setWeakness("weakness");
		city.setAlignment("hero");
		cityDao.createSuperhuman(city);
		
		verify(stmt).executeUpdate("insert into superhuman"
				+ "(superhuman_name, superhuman_powers, superhuman_weakness, superhuman_alignment) "
				+ "values (qwop, powers, weakness, hero)");
	}
	
	@Test
	public void testGetCityById() throws SQLException{
		when(conn.createStatement()).thenReturn(findStmt);
		
	}
	
	public SuperhumanDAOPostgresTest() throws SQLException {
		super();
	}

}