package com.cog.apartment.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cog.apartment.entity.Unit;

@Repository
public interface UnitsRepository extends CrudRepository<Unit,Long> {	

}
