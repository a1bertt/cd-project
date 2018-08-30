package com.qa.persistance.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.CD;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class CDDBRepository implements CDRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	public String getAllCDs()
	{
		Query query = manager.createQuery("Select a FROM CD a");
		Collection<CD> cds = (Collection<CD>) query.getResultList();
		return util.getJSONForObject(cds);
	}

	@Transactional(REQUIRED)
	public String createCD(String cd) 
	{
		CD aCd = util.getObjectForJSON(cd, CD.class);
		manager.persist(aCd);
		return "{\"message\": \"cd has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String updateCD(Long id, String cdToUpdate) 
	{
		CD updatedCd = util.getObjectForJSON(cdToUpdate, CD.class);
		CD cdFromDB = findCd(id);
		if (cdToUpdate != null) 
		{
			cdFromDB = updatedCd;
			manager.merge(cdFromDB);
		}
		return "{\"message\": \"cd sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteCD(Long id) 
	{
		CD cdInDB = findCd(id);
		if(cdInDB != null)
		{
			manager.remove(cdInDB);
		}
		return "{\"message\": \"cd sucessfully deleted\"}";
	}

	private CD findCd(Long id)
	{
		return manager.find(CD.class, id);
	}
	
	public void setManager(EntityManager manager) 
	{
		this.manager = manager;
	}

	public void setUtil(JSONUtil util)
	{
		this.util = util;
	}

}
