package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistance.repository.CDRepository;

public class CDServiceImpl implements CDService
{

	@Inject
	private CDRepository repo;
	
	public String getAllCDs() 
	{
		
		return repo.getAllCDs();
	}

	public String addCD(String cd)
	{
		return repo.createCD(cd);
	}

	public String updateCD(Long id, String cd) 
	{
		return repo.updateCD(id, cd);
	}

	public String deleteCD(Long id)
	{
		return repo.deleteCD(id);
	}

}

