package com.qa.intergration;

import javax.inject.Inject;
import javax.ws.rs.*;

import com.qa.business.service.CDService;


@Path("/cd")
public class CDEndpoint {

	@Inject
	private CDService service;
	
	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllCDs()
	{
		return service.getAllCDs();
	}
	
	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addCD(String cd)
	{
		return service.addCD(cd);
	}
	
	@Path("/json")
	@PUT
	@Produces({ "application/json" })
	public String updateCD(@PathParam("id") long id, String cd)
	{
		return service.updateCD(id, cd);
	}
	
	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteCD(@PathParam("id") Long id) 
	{
		return service.deleteCD(id);
	}
}
