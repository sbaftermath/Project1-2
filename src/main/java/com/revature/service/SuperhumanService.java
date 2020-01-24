package com.revature.service;

import com.revature.pojo.Superhuman;

public interface SuperhumanService {
	
	public void createSuperhuman(Superhuman person);
	
	public void removeSuperhuman(Superhuman person);
	
	public void updateSuperhuman(Superhuman person);
	
	public String viewSuperhumans();

}
