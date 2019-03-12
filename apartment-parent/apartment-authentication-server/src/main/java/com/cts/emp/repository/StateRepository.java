package com.cts.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.emp.model.StateEntity;

@Repository
public interface StateRepository extends JpaRepository<StateEntity,Integer>{

}
