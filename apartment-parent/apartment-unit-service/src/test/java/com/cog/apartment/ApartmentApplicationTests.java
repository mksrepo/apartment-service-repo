package com.cog.apartment;

import static org.junit.Assert.*;


import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.cog.apartment.entity.Apartment;
import com.cog.apartment.entity.UnitType;
import com.cog.apartment.entity.Unit;
import com.cog.apartment.service.IApartmentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApartmentApplicationTests {
	
private IApartmentService apartmentService;	
	
	@Autowired
	public void setApartmentService(IApartmentService apartmentService) {
		this.apartmentService = apartmentService;
	}

	@Test
	public void testSaveApartment() {
		
		Apartment apartment = new Apartment();
		apartment.setAptNm("Sweet Apartment");
		apartment.setAptAddr("Ramnagar Road No 1");
		apartment.setNoOfFloors(8);
		apartment.setNoOfUnits(16);
		apartment.setBuilderName("Mittal Tower");
		apartment.setDateOfPossession(Calendar.getInstance().getTime());
		apartment.setDelInd("N");
		apartment.setCrtdBy(1l);
		apartment.setCrtdDt(Calendar.getInstance().getTime());
		
		apartmentService.addApartment(apartment);
		
	}
	
	@Test
	public void testGetApartment(){
		
		Apartment apartment = apartmentService.getApartment(1L);
		assertNotNull(apartment);
		assertEquals("Sweet Apartment",apartment.getAptNm());
		assertEquals("Ramnagar Road No 1",apartment.getAptAddr());
		assertEquals((Object)8L,apartment.getNoOfFloors());
		
	}
	
	@Test
	public void testSaveUnitType(){
		
		UnitType unitType = new UnitType();
		unitType.setUnitDesc("1 BHK");
		unitType.setCrtdBy(1L);
		unitType.setCrtdDt(Calendar.getInstance().getTime());
		unitType.setDelInd('N');
		
		apartmentService.saveUnitType(unitType);
		
		
	}
	
	@Test
	public void testGetAllApartments(){
		List<Apartment> apartmentList = apartmentService.getAllApartmentDetails();
		assertNotNull(apartmentList);		
	}
	
	@Test
	public void testAddUnitForApartment(){
		
		Unit unit = new Unit();
		unit.setAptId(1L);
		unit.setUnitTyp(5L);
		unit.setUnitNo("A1");
		unit.setArea(485);
		unit.setOwnerId(1L);
		unit.setDelInd("N");
		unit.setCrtdBy(1L);
		unit.setCrtdDt(Calendar.getInstance().getTime());
		apartmentService.addUnit(unit);
	}
	
	@Test
	public void testGetUnit(){
		Unit unit = apartmentService.getUnit(3L);
		assertNotNull(unit);
		assertEquals((Long)3L, (Long)unit.getUnitId());
	}

}

