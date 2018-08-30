package com.qa.persistance.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.CD;
import com.qa.util.JSONUtil;


@Alternative
public class CDMapRepository implements CDRepository
{
	
    private Map<Long, CD> cdMap = new HashMap<Long, CD>();
    long counter = 1;
    
    @Inject
    private JSONUtil util;

	public String getAllCDs()
	{
		return util.getJSONForObject(cdMap.values());
	}
	
	public String createCD(String cd)
	{
		counter++;
		CD newCD = util.getObjectForJSON(cd, CD.class);
		cdMap.put(counter, newCD);
		return cd;
	}

	public String updateCD(Long id, String cdToUpdate) 
	{
		CD newCd = util.getObjectForJSON(cdToUpdate, CD.class);
		cdMap.put(id, newCd);
		return cdToUpdate;
	}

	public String deleteCD(Long id) 
	{
		cdMap.remove(id);
		return "{\"message\": \"Cd sucessfully deleted!\"}";
	}

}
