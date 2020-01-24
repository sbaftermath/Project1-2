package com.revature.service;

import java.util.List;

import com.revature.dao.SuperhumanDAO;
import com.revature.dao.SuperhumanDAOPostgres;
import com.revature.pojo.Superhuman;
import com.revature.util.LoggerUtil;

public class SuperhumanServiceImpl implements SuperhumanService{

	private static SuperhumanDAO sd = new SuperhumanDAOPostgres();
	
	private static LoggerUtil log = new LoggerUtil();
	
	public static void setSd(SuperhumanDAO sd) {
		SuperhumanServiceImpl.sd = sd;
	}

	@Override
	public void createSuperhuman(Superhuman person) {
		// TODO Auto-generated method stub
		sd.createSuperhuman(person);
		log.info("Superhuman created");
	}

	@Override
	public void removeSuperhuman(Superhuman person) {
		// TODO Auto-generated method stub
		sd.removeSuperhuman(person);
		log.info("Superhuman removed");
	}

	@Override
	public void updateSuperhuman(Superhuman person) {
		// TODO Auto-generated method stub
		sd.updateSuperhuman(person);
		log.info("Superhuman updated");
	}

	@Override
	public String viewSuperhumans() {
		// TODO Auto-generated method stub
		List<Superhuman> list = sd.viewSuperhumans();
		StringBuilder sb = new StringBuilder();
		//System.out.println(list);
		sb.append("<table>"
				+ "<col width=200>"
				+ "<col width=200>"
				+ "<col width=200>"
				+ "<col width=200>"
				+ "<style>"
				+ "table, th, td {" 
				+ "  border: 1px solid black;" 
				+ "}" 
				+ "</style>"
				+ "<th>Superhuman Name</th>"
				+ "<th>Superhuman Power</th>"
				+ "<th>Superhuman Weakness</th>"
				+ "<th>Superhuman Alignment</th>");
		
		for (int i = 0; i <list.size(); i++) {
			sb.append("<tr>");
			sb.append("<td>" + list.get(i).getSuperhumanName() + "</td>");
			sb.append("<td>" + list.get(i).getPowers() + "</td>");
			sb.append("<td>" + list.get(i).getWeakness() + "</td>");
			sb.append("<td>" + list.get(i).getAlignment() + "</td>");
			sb.append("</tr>");
		}
		sb.append("</table>");
		return sb.toString();
	}

}
