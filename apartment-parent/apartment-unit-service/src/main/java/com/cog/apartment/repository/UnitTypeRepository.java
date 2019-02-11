package com.cog.apartment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cog.apartment.entity.UnitType;

@Repository
public interface UnitTypeRepository extends CrudRepository<UnitType, Long> {

}
