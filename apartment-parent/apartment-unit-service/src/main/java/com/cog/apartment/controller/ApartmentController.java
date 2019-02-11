package com.cog.apartment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cog.apartment.ApartmentApplication;
import com.cog.apartment.entity.Apartment;
import com.cog.apartment.entity.ApartmentAdminMap;
import com.cog.apartment.entity.Owner;
import com.cog.apartment.entity.UnitType;
import com.cog.apartment.entity.Unit;
import com.cog.apartment.service.IApartmentService;

import io.swagger.annotations.ApiOperation;

//import io.swagger.annotations.ApiOperation;

/**
 * @author 742164
 *
 */
@RestController
public class ApartmentController {
	
	private static final Logger logger =LoggerFactory.getLogger(ApartmentApplication.class);	
	
	private IApartmentService apartmentService;	
	
	@Autowired
	public void setApartmentService(IApartmentService apartmentService) {
		this.apartmentService = apartmentService;
	}


	/**
	 * Method to add unit type into the unit table
	 * @param unitType
	 * @return
	 */
	
	@ApiOperation(value="Add unit type for the apartment")
	@PostMapping("addUnitType")
	public ResponseEntity<String> saveUnitType(@RequestBody UnitType unitType){
		
		logger.info("Entered ApartmentController : saveUnitType method");
		
		String response="Data is not Saved";
		
		response = apartmentService.saveUnitType(unitType);
		
		logger.info("Exited ApartmentController : saveUnitType method");
		
		return new ResponseEntity<String>(response,HttpStatus.CREATED);
	}
	
	
	/**
	 * method for adding apartment 
	 * @param apartment
	 * @return string
	 */
	@PostMapping("addApartment")
	public ResponseEntity<String> saveApartment(@RequestBody Apartment apartment){
		
		logger.info("Entered ApartmentController : saveUnitType method");
		
		String response="Data is not Saved";
		
		response = apartmentService.addApartment(apartment);
		
		logger.info("Exited ApartmentController : saveUnitType method");
		
		return new ResponseEntity<String>(response,HttpStatus.CREATED);
	}
	
	/**
	 * method to get apartment details on basis of apartment id
	 * @param id
	 * @return
	 */
	@GetMapping("/getApartment/{id}")
	public ResponseEntity<Apartment> getApartment(@PathVariable(name = "id") Long id){
		
		logger.info("Entered ApartmentController : getApartment method");
		
		Apartment apartment = apartmentService.getApartment(id);
		
		logger.info("Entered ApartmentController : getApartment method");
		
		return new ResponseEntity<Apartment>(apartment,HttpStatus.OK);
	}
	
	/**Method to add admin for the apartment
	 * @param apartmentAdminMap
	 * @return
	 */
	@PostMapping("addAdminForAprtment")
	public ResponseEntity<String> addAdminForApartment(@RequestBody ApartmentAdminMap apartmentAdminMap){
		
		logger.info("Entered ApartmentController : addadminforappartment method");
		
		String response="Data is not Saved";
		
		response = apartmentService.addadminforappartment(apartmentAdminMap);
		
		logger.info("Exited ApartmentController : addadminforappartment method");
		
		return new ResponseEntity<String>(response,HttpStatus.CREATED);
	}
	
	@PutMapping("updateAdminForApartment")
	public ResponseEntity<String> updateAdminForApartment(@RequestBody ApartmentAdminMap apartmentAdminMap){
		
		logger.info("Entered ApartmentController : updateAdminForApartment method");
				
		String response="Data is not updated Successfully";
		
		response = apartmentService.updateAdmin(apartmentAdminMap);
		
		logger.info("Exited ApartmentController : updateAdminForApartment method");
		
		return new ResponseEntity<String>(response,HttpStatus.OK);
		
	}
	
	/**Method to add unit
	 * @param apartmentAdminMap
	 * @return
	 */
	@PostMapping("addUnitForApartment")
	public ResponseEntity<String> addUnitForApartment(@RequestBody Unit unit){
		
		logger.info("Entered ApartmentController : addUnitForApartment method");
		
		String response="Unit is not added";
		
		response = apartmentService.addUnit(unit);
		
		logger.info("Exited ApartmentController : addUnitForApartment method");
		
		return new ResponseEntity<String>(response,HttpStatus.CREATED);
	}
	
	@GetMapping("getAllApartments")
	public ResponseEntity<List<Apartment>> getAllApartments(){
		
		logger.info("Entered ApartmentController : getAllApartment method");
		
		List<Apartment> apartmentList = apartmentService.getAllApartmentDetails();
		
		logger.info("Exited ApartmentController : getAllApartment method");
		
		return new ResponseEntity<>(apartmentList,HttpStatus.OK);
		
	}
	
	@GetMapping("/getUnitDetails/{id}")
	public ResponseEntity<Unit> geUnitDetials(@PathVariable(name = "id") Long id){
		
		logger.info("Entered ApartmentController : geUnitDetials method");
		
		Unit unit = apartmentService.getUnit(id);
		
		logger.info("Entered ApartmentController : getApartment method");
		
		return new ResponseEntity<Unit>(unit,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("getAparmentsOnAdminId")
	public ResponseEntity<List<Apartment>> getAparmentsOnAdminId(@RequestParam(value="adminId") Long adminId){
		
		logger.info("Entered ApartmentController : getAparmentsOnAdminId method");
		
		List<Apartment> apartmentList = apartmentService.getAparmentsOnAdminId(adminId);
		
		logger.info("Exited ApartmentController : getAparmentsOnAdminId method");
		
		return new ResponseEntity<List<Apartment>>(apartmentList,HttpStatus.OK);
		
	}
	
	/*@PostMapping("addOwner")
	public ResponseEntity<String> addOwner(@RequestBody Owner owner){
		
		logger.info("Entered ApartmentController : addOwner method");
		
		String response="Owner is not added";
		
		response = apartmentService.addOwner(owner);
		
		logger.info("Exited ApartmentController : addOwner method");
		
		return new ResponseEntity<String>(response,HttpStatus.CREATED);
		
	}*/

	/*@PutMapping("updateOwner")
	public ResponseEntity<String> updateOwner(@RequestBody Owner owner){
		
		logger.info("Entered ApartmentController : updateOwner method");
		
		String response="Owner is not updated";
		
		response = apartmentService.addOwner(owner);
		
		logger.info("Exited ApartmentController : updateOwner method");
		
		return new ResponseEntity<String>(response,HttpStatus.OK);		
		
	}*/
	
	/*@PutMapping("deleteOwner")
	public ResponseEntity<String> deleteOwner(@RequestParam(value="ownerId") Long ownerId,@RequestParam(value="userId") Long userId){
		
		logger.info("Entered ApartmentController : deleteOwner method");
		
		String response="Owner is not deleted";
		
		response = apartmentService.deleteOwner(ownerId, userId);
		
		logger.info("Exited ApartmentController : deleteOwner method");
		
		return new ResponseEntity<String>(response,HttpStatus.OK);	
	}*/
	
	/*@GetMapping("getOwner")
	public ResponseEntity<Owner> getOwner(@RequestParam(value="ownerId") Long ownerId){
		
		logger.info("Entered ApartmentController : getOwner method");
		
		Owner ownerResponse = apartmentService.getOwner(ownerId);
		
		logger.info("Exited ApartmentController : getOwner method");
		
		return new ResponseEntity<Owner>(ownerResponse,HttpStatus.OK);			
		
	}*/
	
	/*@GetMapping("getAllOwnerDetails")
	public ResponseEntity<List<Owner>> getAllOwnerDetails(){
		
		logger.info("Entered ApartmentController : getAllOwnerDetails method");
		
		List<Owner> ownerList = apartmentService.getAllOwnerDetails();
		
		logger.info("Exited ApartmentController : getAllOwnerDetails method");
		
		return new ResponseEntity<List<Owner>>(ownerList,HttpStatus.OK);
		
	}*/
	
	
	

}
