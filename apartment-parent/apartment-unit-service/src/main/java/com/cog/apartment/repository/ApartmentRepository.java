package com.cog.apartment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cog.apartment.entity.Apartment;
import com.cog.apartment.entity.Unit;

@Repository
public interface ApartmentRepository extends CrudRepository<Apartment, Long> {
	
	@Query("select a from Apartment a")
	List<Apartment> getAllApartments();
	
	@Query("select a from Apartment a where a.aptId in (select aam.appAdminCompKey.aptId from ApartmentAdminMap aam where aam.appAdminCompKey.adminId = :adminId)")
	List<Apartment> getAparmentsOnAdminId(@Param("adminId") Long adminId);

}
