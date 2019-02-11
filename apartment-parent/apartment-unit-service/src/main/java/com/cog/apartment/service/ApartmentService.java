package com.cog.apartment.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.cog.apartment.entity.Apartment;
import com.cog.apartment.entity.ApartmentAdminMap;
import com.cog.apartment.entity.Owner;
import com.cog.apartment.entity.UnitType;
import com.cog.apartment.entity.Unit;
import com.cog.apartment.exception.ApartmentException;
import com.cog.apartment.exception.ErrorCode;
import com.cog.apartment.repository.ApartmentAdminMapRepository;
import com.cog.apartment.repository.ApartmentRepository;
import com.cog.apartment.repository.OwnerRepository;
import com.cog.apartment.repository.UnitTypeRepository;
import com.cog.apartment.repository.UnitsRepository;

@Service
public class ApartmentService implements IApartmentService {

	private static final Logger logger = LoggerFactory.getLogger(ApartmentService.class);

	@Autowired
	private ApartmentRepository apartmentRepository;

	@Autowired
	private ApartmentAdminMapRepository apartmentAdminMapRepository;

	@Autowired
	private UnitsRepository unitsRepository;

	@Autowired
	private UnitTypeRepository unitTypeRepository;
	
	private OwnerRepository ownerRepositpory;	
	
	@Autowired
	public void setOwnerRepositpory(OwnerRepository ownerRepositpory) {
		this.ownerRepositpory = ownerRepositpory;
	}

	@Override
	public String saveUnitType(UnitType unitType) {

		logger.info("Entered ApartmentService : saveUnitType");

		UnitType unitTypeResponse = unitTypeRepository.save(unitType);
		if (null != unitTypeResponse) {
			logger.info("Exited ApartmentService : saveUnitType");
			return "Unit Type is saved successfully";
		} else {
			throw new ApartmentException(ErrorCode.UnitTypAddEx.getCode(), ErrorCode.UnitTypAddEx.getMsg());
		}

	}
	
	@Override
	public UnitType getUnitType(Long unitTypeId) {
		
		logger.info("Entered ApartmentService : getUnitType");
		
		UnitType unitType = null;
		
		Optional<UnitType> optionalUnitType = unitTypeRepository.findById(unitTypeId);
		if(optionalUnitType.isPresent()){
			unitType=optionalUnitType.get();
			return unitType;
		}
		
		return null;
	}	

	@Override
	public String addApartment(Apartment apartment) {

		logger.info("Entered ApartmentService : addApartment");

		Apartment apartmentResponse = null;

		try {
			apartmentResponse = apartmentRepository.save(apartment);

			if (null != apartmentResponse) {
				logger.info("Exited ApartmentService : saveUnitType");
				return "Apartment is saved successfully";
			} else {
				throw new ApartmentException(ErrorCode.AptAddEx.getCode(), ErrorCode.AptAddEx.getMsg());
			}
		} catch (Exception exception) {
			throw new ApartmentException(ErrorCode.AptInternalErr.getCode(), exception.getMessage());
		}

	}

	@Override
	public Apartment getApartment(Long id) {

		logger.info("Entered ApartmentService : getApartment");
		
		Optional<Apartment> apartment =null;
		
		try{

		apartment = apartmentRepository.findById(id);

		if (apartment.isPresent()) {
			logger.info("Exited ApartmentService : getApartment");
			return apartment.get();
		} else
			throw new ApartmentException(ErrorCode.AptNotFound.getCode(), ErrorCode.AptNotFound.getMsg());
		}catch(Exception e){
			throw new ApartmentException(ErrorCode.AptInternalErr.getCode(), e.getMessage());
		}
	}

	@Override
	public String addadminforappartment(ApartmentAdminMap apartmentAdminMap) {

		logger.info("Entered ApartmentService : addadminforappartment");
		
		ApartmentAdminMap apartmentAdminMapResponse=null;

		try{
			logger.info("Composite key "+apartmentAdminMap.getAppAdminCompKey().getAptId()+"__"+apartmentAdminMap.getAppAdminCompKey().getAdminId());
//			logger.info("ISNEW"+apartmentAdminMapRepository.existsById(id);
		apartmentAdminMapResponse = apartmentAdminMapRepository.save(apartmentAdminMap);
		logger.info(apartmentAdminMapResponse.getAppAdminCompKey().getAdminId()+"jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
		if (null != apartmentAdminMapResponse) {
			logger.info("Exited ApartmentService : apartmentAdminMap1");
			return "Admin is mapped for the appartment successfully";
		}

		logger.info("Exited ApartmentService : addadminforappartment");
		}catch(Exception e){
			throw new ApartmentException(ErrorCode.AptInternalErr.getCode(), e.getMessage());
		}
		return null;

	}

	@Override
	public String updateAdmin(ApartmentAdminMap apartmentAdminMap) {
		
		logger.info("Entered ApartmentService : updateAdmin");
		
		/*try{
		int i = apartmentAdminMapRepository.updateApartmentAdmin(apartmentAdminMap.getAptId(), apartmentAdminMap.getAdminId(),apartmentAdminMap.getUpdtId(),apartmentAdminMap.getUpdtDt());
		if (i > 0)
			return "Data Updated Successfully";
		}catch(Exception e){
			throw new ApartmentException(ErrorCode.AptInternalErr.getCode(), e.getMessage());
		}*/
		return null;
	}

	@Override
	public String addUnit(Unit unit) {

		logger.info("Entered ApartmentService : addUnit");
		
		try{
		

		Unit unitResponse = unitsRepository.save(unit);
		if (null != unitResponse) {
			logger.info("Exited ApartmentService : addUnit");
			return "Unit is added successfully";
		}

		logger.info("Exited ApartmentService : addUnit");
		}catch(Exception e){
			throw new ApartmentException(ErrorCode.AptInternalErr.getCode(), e.getMessage());
		}
		return null;

	}

	@Override
	public List<Apartment> getAllApartmentDetails() {
		
		logger.info("Entered ApartmentService : getAllApartmentDetails");
		
		try{		
			List<Apartment> apartmentList=null;
		
			apartmentList=apartmentRepository.getAllApartments();
			
			if(null!=apartmentList){
				return apartmentList;
			}else{
				throw new ApartmentException(ErrorCode.AptNotFound.getCode(), ErrorCode.AptNotFound.getMsg());
			}		
		}catch(Exception e){
			throw new ApartmentException(ErrorCode.AptInternalErr.getCode(), e.getMessage());
		}		
		
	}

	@Override
	public String addOwner(Owner owner) {
		logger.info("Entered ApartmentService : addOwner");
		try{
			
			String response = "Owner is not saved successfully";
			
			Owner ownerResponse = ownerRepositpory.save(owner);
			
			if(null!=ownerResponse)
				return "Owner is saved successfully";
			else
				return response;			
			
		}
		catch(Exception e){
			throw new ApartmentException(ErrorCode.AptInternalErr.getCode(), e.getMessage());
		}
		
		finally{
			logger.info("Exited ApartmentService : addOwner");
		}
		
	}

	@Override
	public String updateOwner(Owner owner) {
		logger.info("Entered ApartmentService : updateOwner");
		
		try{
			int i = ownerRepositpory.updateOwner(owner.getOwnerId(), owner.getOwnerName(), owner.getOwnerAddress(), owner.getEmailId(), owner.getPhoneNo(), owner.getDelInd(), owner.getUpdtId(), owner.getUpdtDt());
			
			if(i>0)
				return "Data is saved successfully";
			else
				throw new ApartmentException(ErrorCode.AptNotFound.getCode(), ErrorCode.AptNotFound.getMsg());
				
		}
		catch(Exception e){
			throw new ApartmentException(ErrorCode.UpdtErr.getCode(), e.getMessage());
		}
		
		finally{
			logger.info("Exited ApartmentService : updateOwner");
		}	
		
	}

	@Override
	public String deleteOwner(Long ownerId, Long userId) {
		logger.info("Entered ApartmentService : deleteOwner");
		
		String ownerResponse="User is deleted successfully";		
		try{
			int i=ownerRepositpory.deleteOwner(ownerId,userId, Calendar.getInstance().getTime());
			
			if(i>0)
				return ownerResponse;
			else
				throw new ApartmentException(ErrorCode.UpdtErr.getCode(), ErrorCode.UpdtErr.getMsg());
				
		}
		catch(Exception e){
			throw new ApartmentException(ErrorCode.AptInternalErr.getCode(), e.getMessage());
		}
		finally{
			
		}
		
	}

	@Override
	public Owner getOwner(Long ownerId) {
		logger.info("Entered ApartmentService : getOwner");	
		
		try{
			Optional<Owner> ownerResponse = ownerRepositpory.findById(ownerId);
			if(ownerResponse.isPresent())
				return ownerResponse.get();
		}
		catch(Exception e){
			throw new ApartmentException(ErrorCode.AptInternalErr.getCode(), e.getMessage());
		}
		
		finally{
			logger.info("Exited ApartmentService : getOwner");
		}
		return null;
	}

	@Override
	public List<Owner> getAllOwnerDetails() {
		logger.info("Entered ApartmentService : getAllOwnerDetails");
		
		try{
			List<Owner> ownerList = null;
			
			return ownerList=ownerRepositpory.getAllOwnerDetails();
		}
		catch(Exception e){
			throw new ApartmentException(ErrorCode.AptInternalErr.getCode(), e.getMessage());
		}
		finally{
			logger.info("Exited ApartmentService : getAllOwnerDetails");
		}
		
	}

	@Override
	public Unit getUnit(Long unitId) {
		
		logger.info("Entered ApartmentService : getUnit");
		
		try{
			Unit unit = null;
			unit = unitsRepository.findById(unitId).get();
			
			return unit;
		}
		catch(Exception e){
			throw new ApartmentException(ErrorCode.AptInternalErr.getCode(), e.getMessage());
		}
		finally{
			logger.info("Exited ApartmentService : getUnit");
		}		
		
	}

	@Override
	public List<Apartment> getAparmentsOnAdminId(Long adminId) {
		
		logger.info("Entered ApartmentService : getAparmentsOnAdminId");
		
		try{
			List<Apartment> apartments = null;
			
			apartments = apartmentRepository.getAparmentsOnAdminId(adminId);
			
			return apartments;
		}
		catch(Exception e){
			throw new ApartmentException(ErrorCode.AptInternalErr.getCode(), e.getMessage());
		}
		finally{
			logger.info("Exited ApartmentService : getAparmentsOnAdminId");
		}		
		
	}

	

}
