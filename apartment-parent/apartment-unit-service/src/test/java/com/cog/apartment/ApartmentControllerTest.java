package com.cog.apartment;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cog.apartment.controller.ApartmentController;
import com.cog.apartment.entity.UnitType;
import com.cog.apartment.repository.ApartmentRepository;
import com.cog.apartment.service.ApartmentService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApartmentControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private ApartmentController apartmentController;
	
	@Mock
	private ApartmentService apartmentService;
	
	@MockBean
	private ApartmentRepository apartmentRepository;
	
	
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		mockMvc=MockMvcBuilders.standaloneSetup(apartmentController)				
				.build();
	}

	@Test
	public void testSaveUnitType() throws Exception{
		
		//Apartment apartment = new Apartment(1l,"Sweet Apartment","Road no 1",8,32,"Mitta",new Date(),"N",1l,new Date());
		UnitType unitType=new UnitType(1l,"1 BHK",'N',1l,new Date());
		when(apartmentService.saveUnitType(unitType)).thenReturn("Unit Type is saved successfully");
		when(apartmentService.getUnitType(1l)).thenReturn(unitType);
		mockMvc.perform(post("/addUnitType")
			   .contentType(MediaType.APPLICATION_JSON)
			   .content(asJsonString(unitType)))
			   .andExpect(status().isCreated());
		
		verify(apartmentService,times(1)).getUnitType(1l);
		//verifyNoMoreInteractions(apartmentService);
			//   .andExpect(header().string("location", containsString("")));
		

	}
	
	public static String asJsonString(final Object obj){
		try{
			return new ObjectMapper().writeValueAsString(obj);
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
