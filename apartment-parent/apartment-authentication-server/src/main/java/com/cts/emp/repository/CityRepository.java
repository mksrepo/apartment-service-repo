package com.cts.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.emp.model.CityEntity;


@Repository
public interface CityRepository extends JpaRepository<CityEntity,Integer>{

}
