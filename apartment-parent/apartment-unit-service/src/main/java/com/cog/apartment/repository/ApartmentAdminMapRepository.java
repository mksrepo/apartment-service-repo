package com.cog.apartment.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cog.apartment.entity.ApartmentAdminMap;

@Repository
public interface ApartmentAdminMapRepository extends CrudRepository<ApartmentAdminMap, Long> {
	
	//@Query("update ApartmentAdminMap aam set aam.adminId=:adminId,aam.delInd='N',aam.updtId=:updtId,aam.updtDt=:updtDt,aam.aptId=:aptId where aam.srno=:srno")
	//int updateApartmentAdmin(@Param("aptId") Long aptId,@Param("adminId") Long adminId,@Param("updtId") Long updtId,@Param("updtDt") Date updtDt);

}
