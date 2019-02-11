package com.cog.apartment.service;

import java.util.List;

import com.cog.apartment.entity.Apartment;
import com.cog.apartment.entity.ApartmentAdminMap;
import com.cog.apartment.entity.Owner;
import com.cog.apartment.entity.UnitType;
import com.cog.apartment.entity.Unit;



public interface IApartmentService {
	
	public String saveUnitType(UnitType unitType);
	
	public UnitType getUnitType(Long unitTypeId);
	
	public String addApartment(Apartment apartment);
	
	public Apartment getApartment(Long id);
	
	public String addadminforappartment(ApartmentAdminMap apartmentAdminMap);
	
	public String updateAdmin(ApartmentAdminMap apartmentAdminMap);
	
	public String addUnit(Unit units);
	
	public Unit getUnit(Long unitId);
	
	public List<Apartment> getAllApartmentDetails();
	
	public String addOwner(Owner owner);

	public String updateOwner(Owner ownerId);
	
	public String deleteOwner(Long ownerId,Long userId);
	
	public Owner getOwner(Long ownerId);
	
	public List<Owner> getAllOwnerDetails();
	
	public List<Apartment> getAparmentsOnAdminId(Long adminId);
	
}
