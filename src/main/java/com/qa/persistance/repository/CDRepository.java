package com.qa.persistance.repository;

public interface CDRepository {
	
	String getAllCDs();
	
	String createCD(String cd);

	String updateCD(Long id, String cdToUpdate);

	String deleteCD(Long id);
	
}
