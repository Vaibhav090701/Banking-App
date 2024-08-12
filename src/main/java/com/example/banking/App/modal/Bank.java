package com.example.banking.App.modal;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bank {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
	 	private String name;
	 	
	 	@OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
	 	@JsonManagedReference
	    private List<Branch> branches;
	 	
	 	@OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
	 	@JsonManagedReference
	    private List<Services> services;


}
