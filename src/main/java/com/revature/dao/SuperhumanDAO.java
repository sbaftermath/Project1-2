package com.revature.dao;

import java.util.List;

import com.revature.pojo.Superhuman;

public interface SuperhumanDAO {
	
	public void createSuperhuman(Superhuman person);
	
	public void removeSuperhuman(Superhuman person);
	
	public void updateSuperhuman(Superhuman person);
	
	public List<Superhuman> viewSuperhumans();

}
