package com.example.banking.App.modal;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Services {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
	 	private String name;
	    private String description;
	    
	    @ManyToOne
	    @JsonBackReference
	    @JoinColumn(name="bank_id")
	    private Bank bank;


}
