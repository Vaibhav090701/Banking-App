package com.example.banking.App.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.banking.App.modal.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer> {
	
    List<Branch> findByBankId(int bankId);

}
