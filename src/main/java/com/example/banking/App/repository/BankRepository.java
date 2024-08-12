package com.example.banking.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.banking.App.modal.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer> {

}
