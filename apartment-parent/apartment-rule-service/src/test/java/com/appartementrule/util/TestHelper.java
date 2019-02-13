package com.appartementrule.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.apartmentrule.bean.ApartmentRuleDtls;
import com.apartmentrule.model.RuleDetailsEntity;

public class TestHelper {

	public static RuleDetailsEntity prepareRuleDetailsEntityObj() throws ParseException {
		RuleDetailsEntity rdEntity = new RuleDetailsEntity(1L, "App1", "2BHK", "200",
				"0", "0", sampleDateGetter("2019-01-01"), "No");
		return rdEntity;
	}

	public static ApartmentRuleDtls prepareApptRuleDetailsEntityObj() {
		ApartmentRuleDtls apptRuleDtls=new ApartmentRuleDtls(1L, "App1", "2BHK", "200",
				"0", "0", "2019-01-01");
		return apptRuleDtls;
	}

	static Date sampleDateGetter(String tempDate) throws ParseException{
		Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(tempDate);
		return date1;
	}
	
	public static List<RuleDetailsEntity> prepareRuleDetailsEntityList() throws ParseException {
		RuleDetailsEntity rdEntity = new RuleDetailsEntity(1L, "App1", "2BHK", "200",
				"0", "0", sampleDateGetter("2019-01-01"), "No");
		List<RuleDetailsEntity> list= new ArrayList<>(Arrays.asList(rdEntity));
		return list;
	}
	
	public static List<ApartmentRuleDtls> prepareApptRuleDetailsEntityLsitObj() {
		ApartmentRuleDtls apptRuleDtls=new ApartmentRuleDtls(1L, "App1", "2BHK", "200",
				"0", "0", "2019-01-01");
		List<ApartmentRuleDtls> list= new ArrayList<>(Arrays.asList(apptRuleDtls));
		return list;
	}
	
}