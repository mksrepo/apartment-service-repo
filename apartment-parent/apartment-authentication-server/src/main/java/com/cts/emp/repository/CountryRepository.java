package com.cts.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.emp.model.CountryEntity;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity,Integer>{

}
