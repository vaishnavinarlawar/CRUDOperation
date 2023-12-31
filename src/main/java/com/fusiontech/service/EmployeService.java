package com.fusiontech.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fusiontech.dao.EmployeRepository;
import com.fusiontech.dto.Employe;

@Service
public class EmployeService {

	@Autowired
	EmployeRepository employeRepository;
	
	public EmployeService()
	{
		System.out.println("inside EmployeService cons");
	}
	
	public Employe createEmploye(Employe emp)
	{
		System.out.println("inside EmployeService.createEmploye");
		
		Employe eee1=employeRepository.save(emp);
		return eee1;
	}
	
	public Iterable<Employe> getAllEmploye()
	{
		System.out.println("inside EmployeService.getAllEmploye");
		Iterable<Employe> emplist=employeRepository.findAll();
		System.out.println("response from dao " +emplist);
		return emplist;
	}

	public Employe getEmployebyId(int id) {
		System.out.println("inside EmployeService.getAllEmploye");
		Optional<Employe> empfromdb=employeRepository.findById(id);
		if(empfromdb.isPresent())
		{
			System.out.println("emp present for id " +id);
			Employe emp1=empfromdb.get();
			System.out.println(emp1);
			return emp1;
		}else {
			System.out.println("emp not present for id " +id);
			return new Employe();
		}
		
	}

	public Iterable<Employe> deleteEmploye(int id) {

		employeRepository.deleteById(id);
		Iterable<Employe> emplist=employeRepository.findAll();
		System.out.println("response from dao " +emplist);
		return emplist;
		
	}

	public Employe updateEmploye(Employe empin) {
		//find empl from db 
		// take the missing values from db (already values in table)
		
		Employe emptoUpdate= new Employe();
		Optional<Employe> emp111=employeRepository.findById(empin.getId());
		
		if(emp111.isPresent())
		{
			Employe empFromDB=emp111.get();
			System.out.println("emp from db --->" +empFromDB);
			
			emptoUpdate.setId(empFromDB.getId());
			
			if(empin.getName()==null)
			{
				System.out.println("no name from UI");
				emptoUpdate.setName(empFromDB.getName());
				}
				else {
				System.out.println(" name received from UI");
				emptoUpdate.setName(empin.getName());
			}
			
			if(empin.getEmail()==null)
			{
				System.out.println("no email from UI");
				emptoUpdate.setEmail(empFromDB.getEmail());
				}
				else {
				System.out.println(" email received from UI");
				emptoUpdate.setEmail(empin.getEmail());
			}
			
			System.out.println("final emp to be updated --->" +emptoUpdate);
			
			Employe eeee=employeRepository.save(emptoUpdate);
			return eeee;
			
		}else {
			System.out.println("emp not present for id -->" +empin.getId());
		}
		
		
		
		return null;
	}

	
}

