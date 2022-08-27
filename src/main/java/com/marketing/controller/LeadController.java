package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.LeadData;
import com.marketing.entities.Lead;
import com.marketing.service.LeadService;

@Controller								//URL:-http://localhost:8080/createLead
public class LeadController {
	
	@Autowired
	private LeadService leadService;    //bean(object) is created. this is how we connect to service layer.
	
	//handler methods
	@RequestMapping("/createLead")   	//This annotation will call the created method here. Acts like @WebServlet.
	public String viewCreateLeadPage() {   //This is not an ordinary method. this is a special method developed in controller layer.
		return "create_lead";			// Whatever I write inside return keyword in double quotes it will load to create lead page.
	}									//return keyword here acts like requestDispatcher.
										//To run project i require tomcat. because this is web content.
	
	@RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute("Lead")Lead lead, ModelMap model ) {
		leadService.saveLead(lead);
		model.addAttribute("msg", "Lead is Saved!!");
		return "create_lead";
	}
	    
	    @RequestMapping("/listAll")
		public String listAllLeads(ModelMap model) {
			List<Lead> leads = leadService.listLeads();
			model.addAttribute("leads", leads);
			return "search_lead_result";
		}
	    
	    @RequestMapping("/delete")
	    public String deleteOneLead(@RequestParam("id")long id,ModelMap model) {
	    	leadService.deleteLeadById(id);
	    	
	    	List<Lead> leads = leadService.listLeads();
			model.addAttribute("leads", leads);
			return "search_lead_result";
	    }
	    
	    @RequestMapping("/update")
	    public String updateOneLead(@RequestParam("id")long id,ModelMap model) {
	    	Lead lead = leadService.getOneId(id);
	    	model.addAttribute("lead", lead);
	    	return "update_lead";
	    }
	    
	    @RequestMapping("/updateLead")
	    public String updateLeadById(LeadData data, ModelMap model) {
	    	Lead lead=new Lead();
	    	lead.setId(data.getId());
	    	lead.setFirstName(data.getFirstName());
	    	lead.setLastName(data.getLastName());
	    	lead.setEmail(data.getEmail());
	    	lead.setMobile(data.getMobile());
	    	leadService.saveLead(lead);
	    	
	    	List<Lead> leads = leadService.listLeads();
			model.addAttribute("leads", leads);
			return "search_lead_result";
	    }
}
