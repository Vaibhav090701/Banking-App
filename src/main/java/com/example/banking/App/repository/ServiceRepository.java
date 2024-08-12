package com.example.banking.App.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.banking.App.modal.Services;

public interface ServiceRepository extends JpaRepository<Services, Integer> {
    List<Services> findByBankId(int bankId);


}
