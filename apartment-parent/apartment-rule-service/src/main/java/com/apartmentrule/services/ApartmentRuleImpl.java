package com.apartmentrule.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartmentrule.bean.ApartmentRuleDtls;
import com.apartmentrule.constant.ApartmentRuleConstants;
import com.apartmentrule.dao.ApartmentRuleDao;
import com.apartmentrule.exception.ApartmentRuleCustomException;
import com.apartmentrule.model.RuleDetailsEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This is the service class where actual business implementation has been done
 */
@Service
public class ApartmentRuleImpl implements ApartmentRuleManager{
	
	@Autowired
	ApartmentRuleDao apartmentRuleDao;
	
	@Override
	public ApartmentRuleDtls createRule(ApartmentRuleDtls ruleDetails) {
		try{
		ObjectMapper mapper = new ObjectMapper();
		RuleDetailsEntity ruleEntity = mapper.convertValue(ruleDetails, RuleDetailsEntity.class);
		ruleEntity=apartmentRuleDao.saveRule(ruleEntity);
		ruleDetails=mapper.convertValue(ruleEntity,ApartmentRuleDtls.class);
		ruleDetails.setEffectiveDate(dateString(Long.valueOf(ruleDetails.getEffectiveDate())));
		}catch(Exception ex){
			throw new ApartmentRuleCustomException(ex.getMessage().contains("PRIMARY")?ApartmentRuleConstants.CREATE_ERROR_PRIMARY:ApartmentRuleConstants.CREATE_ERROR);
		}
		return ruleDetails;
	}

	@Override
	public ApartmentRuleDtls getRulesById(long ruleId) {
		ObjectMapper mapper = new ObjectMapper();
		ApartmentRuleDtls apartmentRuleDtls=new ApartmentRuleDtls();
		try{
		RuleDetailsEntity temp=apartmentRuleDao.findById(ruleId);
		apartmentRuleDtls=mapper.convertValue(temp,ApartmentRuleDtls.class);
		apartmentRuleDtls.setEffectiveDate(dateString(Long.valueOf(apartmentRuleDtls.getEffectiveDate())));
		}catch(Exception ex){
			throw new ApartmentRuleCustomException(ApartmentRuleConstants.GET_ERROR_BY_RULID);
		}
		return apartmentRuleDtls;
	}

	@Override
	public List<ApartmentRuleDtls> getRulesByApptId(String apptId) {
		List<ApartmentRuleDtls> apartmentRuleList= new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		try{
		for(RuleDetailsEntity temp:apartmentRuleDao.findRuleDetails(apptId)){
			ApartmentRuleDtls apartmentRuleDtls = mapper.convertValue(temp, ApartmentRuleDtls.class);
			apartmentRuleDtls.setEffectiveDate(dateString(Long.valueOf(apartmentRuleDtls.getEffectiveDate())));
			apartmentRuleList.add(apartmentRuleDtls);
		}
		}catch(Exception ex){
			throw new ApartmentRuleCustomException(ApartmentRuleConstants.GET_ERROR_BY_APARTMENT_ID);
		}
		return apartmentRuleList;
	}

	@Transactional
	@Override
	public int updateDeleteFlag(long ruleId) throws ApartmentRuleCustomException {
		int updatedRow=0;
		try{
			updatedRow=apartmentRuleDao.updateDeleteFlag(ruleId);
		}catch(Exception ex){
			throw new ApartmentRuleCustomException(ApartmentRuleConstants.DELETE_ERROR);
		}
		return updatedRow;
			
		
	}

	@Override
	public List<ApartmentRuleDtls> getAllRules() throws ParseException {
		List<ApartmentRuleDtls> apartmentRuleList= new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		try{
		for(RuleDetailsEntity temp:apartmentRuleDao.findAll()){
			ApartmentRuleDtls apartmentRuleDtls = mapper.convertValue(temp, ApartmentRuleDtls.class);
			apartmentRuleDtls.setEffectiveDate(dateString(Long.valueOf(apartmentRuleDtls.getEffectiveDate())));
			apartmentRuleList.add(apartmentRuleDtls);
		}
		}catch(Exception ex){
			throw new ApartmentRuleCustomException(ApartmentRuleConstants.GET_ERROR);
		}
		return apartmentRuleList;
	}

	@Override
	public List<ApartmentRuleDtls> getRulesByUnitType(String unitType) {
		List<ApartmentRuleDtls> apartmentRuleList= new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		try{
		for(RuleDetailsEntity temp:apartmentRuleDao.getAllRulesByUnitType(unitType)){
			ApartmentRuleDtls apartmentRuleDtls = mapper.convertValue(temp, ApartmentRuleDtls.class);
			apartmentRuleDtls.setEffectiveDate(dateString(Long.valueOf(apartmentRuleDtls.getEffectiveDate())));
			apartmentRuleList.add(apartmentRuleDtls);
		}
		}catch(Exception ex){
			throw new ApartmentRuleCustomException(ApartmentRuleConstants.GET_ERROR_UNIT_TYPE);
		}
		return apartmentRuleList;
	}

	@Override
	public ApartmentRuleDtls getRuleByApptIdAndUnitType(String apartmentId, String unitType) {
			ObjectMapper mapper = new ObjectMapper();
			ApartmentRuleDtls apartmentRuleDtls=new ApartmentRuleDtls();
			try{
			RuleDetailsEntity temp=apartmentRuleDao.findByApptIdAndUnitType(apartmentId,unitType);
			apartmentRuleDtls=mapper.convertValue(temp,ApartmentRuleDtls.class);
			apartmentRuleDtls.setEffectiveDate(dateString(Long.valueOf(apartmentRuleDtls.getEffectiveDate())));
			}catch(Exception ex){
				throw new ApartmentRuleCustomException(ApartmentRuleConstants.GET_ERROR);
			}
			return apartmentRuleDtls;
	}
		
	String dateString(long longDate){
		Date date=new Date(longDate);
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateText = df2.format(date);
        return dateText;
	}

	@Override
	public List<ApartmentRuleDtls> getAllCurrentRules() {
		List<ApartmentRuleDtls> apartmentRuleList= new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		try{
		for(RuleDetailsEntity temp:apartmentRuleDao.findAllCurrentRule()){
			ApartmentRuleDtls apartmentRuleDtls = mapper.convertValue(temp, ApartmentRuleDtls.class);
			apartmentRuleDtls.setEffectiveDate(dateString(Long.valueOf(apartmentRuleDtls.getEffectiveDate())));
			apartmentRuleList.add(apartmentRuleDtls);
		}
		}catch(Exception ex){
			throw new ApartmentRuleCustomException(ApartmentRuleConstants.GET_ERROR);
		}
		return apartmentRuleList;
	}

	@Override
	public List<ApartmentRuleDtls> getAllFutureRules() {
		List<ApartmentRuleDtls> apartmentRuleList= new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		try{
		for(RuleDetailsEntity temp:apartmentRuleDao.findAllFutureRules()){
			ApartmentRuleDtls apartmentRuleDtls = mapper.convertValue(temp, ApartmentRuleDtls.class);
			apartmentRuleDtls.setEffectiveDate(dateString(Long.valueOf(apartmentRuleDtls.getEffectiveDate())));
			apartmentRuleList.add(apartmentRuleDtls);
		}
		}catch(Exception ex){
			throw new ApartmentRuleCustomException(ApartmentRuleConstants.GET_ERROR);
		}
		return apartmentRuleList;
	}

	@Override
	public List<ApartmentRuleDtls> getAllCurrentRulesByApptId(String apartmentId) {
		List<ApartmentRuleDtls> apartmentRuleList= new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		try{
		for(RuleDetailsEntity temp:apartmentRuleDao.findAllCurrentRuleByApptId(apartmentId)){
			ApartmentRuleDtls apartmentRuleDtls = mapper.convertValue(temp, ApartmentRuleDtls.class);
			apartmentRuleDtls.setEffectiveDate(dateString(Long.valueOf(apartmentRuleDtls.getEffectiveDate())));
			apartmentRuleList.add(apartmentRuleDtls);
		}
		}catch(Exception ex){
			throw new ApartmentRuleCustomException(ApartmentRuleConstants.GET_ERROR);
		}
		return apartmentRuleList;
	}

	@Override
	public List<ApartmentRuleDtls> getAllFutureRulesByApptId(String apartmentId) {
		List<ApartmentRuleDtls> apartmentRuleList= new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		try{
		for(RuleDetailsEntity temp:apartmentRuleDao.findAllFutureRulesByApptId(apartmentId)){
			ApartmentRuleDtls apartmentRuleDtls = mapper.convertValue(temp, ApartmentRuleDtls.class);
			apartmentRuleDtls.setEffectiveDate(dateString(Long.valueOf(apartmentRuleDtls.getEffectiveDate())));
			apartmentRuleList.add(apartmentRuleDtls);
		}
		}catch(Exception ex){
			throw new ApartmentRuleCustomException(ApartmentRuleConstants.GET_ERROR);
		}
		return apartmentRuleList;
	}

}
