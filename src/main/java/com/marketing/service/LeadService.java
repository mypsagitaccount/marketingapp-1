package com.marketing.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.marketing.entities.Lead;

@Service
public interface LeadService {

	
	public void saveLead(Lead lead);
	
	public List<Lead> listLeads();

	public void deleteLeadById(long id);

	public Lead getOneId(long id);
}
