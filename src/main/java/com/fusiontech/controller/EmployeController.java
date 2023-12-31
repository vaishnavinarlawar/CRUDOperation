package com.fusiontech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fusiontech.dto.Employe;
import com.fusiontech.service.EmployeService;

@RestController
public class EmployeController {
	
	@Autowired
	EmployeService employeService;
	public EmployeController() {
		System.out.println("inside EmployeController const ");
	}
	
	@PostMapping("/createEmploye")
	public Employe createEmploye(@RequestBody Employe emp) {
		System.out.println("inside EmployeController.createEmploye");
		Employe emp1=employeService.createEmploye(emp);

		return emp1;
	}
	
	@GetMapping("/getAllEmploye")
	public Iterable<Employe> getEmploye() {
		System.out.println("inside EmployeeController.getEmployee ");
           Iterable<Employe> empList=employeService.getAllEmploye();
           return empList;
	}
	
	@GetMapping("/getEmployeById/{eid}")
	public Employe getEmployebyId(@PathVariable("eid") int id) {
		System.out.println("inside EmployeeController.getEmploye ");
		Employe empfromDb= employeService.getEmployebyId(id);
		return empfromDb;
	}
	@DeleteMapping("/deleteEmploye/{eid}")
	public Iterable<Employe> deleteEmploye(@PathVariable("eid") int id)
	{
		return employeService.deleteEmploye( id);
	}
	@PutMapping("/updateEmploye")
	public Employe updateEmploye(@RequestBody Employe empin)
	{
		Employe employe=employeService.updateEmploye(empin);
		return employe;
	}

}
