package com.springs.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Bank {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bank_name")
    private String bankName;

    @OneToMany(mappedBy = "bank")
    private List<Branch> branches;

    @OneToMany(mappedBy = "bank")
    private List<Service> services;

    // Getters and Setters
    public Bank() {
		// TODO Auto-generated constructor stub
	}

	public Bank(Long id, String bankName, List<Branch> branches, List<Service> services) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.branches = branches;
		this.services = services;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}
    
    
}
