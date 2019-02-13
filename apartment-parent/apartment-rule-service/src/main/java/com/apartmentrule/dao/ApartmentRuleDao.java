package com.apartmentrule.dao;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apartmentrule.exception.ApartmentRuleCustomException;
import com.apartmentrule.model.RuleDetailsEntity;
import com.apartmentrule.repository.ApartmentRuleRepository;

@Component
public class ApartmentRuleDao {
	
	@Autowired
	private ApartmentRuleRepository repo;
	
	/**
	 * Method to get all rules for the given apartment-id
	 * @param String apptId
	 * @return List<ApartmentRuleDtls> List<ApartmentRuleDtls>
	 */
	public List<RuleDetailsEntity> findRuleDetails(String apartmentId){
		return repo.findRuleDetails(apartmentId);
	}

	/**
	 * Method to soft delete rule for given rule-id
	 * @param long ruleId
	 * @throws ApartmentRuleCustomException 
	 */
	public int updateDeleteFlag(long ruleId){
		return repo.updateDeleteFlag(ruleId);
	}

	/**
	 * Method to get  apartment rule for given rule-id
	 * @param long ruleId
	 * @return ApartmentRuleDtls ApartmentRuleDtls
	 */
	public RuleDetailsEntity findById(long ruleId){
		return repo.findById(ruleId);
	}
	/**
	 * Method to get all rules present in Database 
	 * @return List<ApartmentRuleDtls> List<ApartmentRuleDtls>
	 * @throws ParseException 
	 */
	public List<RuleDetailsEntity> findAll(){
		return repo.findAll();
	}
	/**
	 * Method to get all rules for the given UnitType 
	 *  @param String unitType
	 * @return List<ApartmentRuleDtls> List<ApartmentRuleDtls>
	 */

	public List<RuleDetailsEntity> getAllRulesByUnitType(String unitType){
		return repo.getAllRulesByUnitType(unitType);
	}
	
	/**
	 * Method to create new apartment rule 
	 * @param ApartmentRuleDtls ruleDetails
	 * @return ApartmentRuleDtls apartmentRuleDtls
	 */
	public RuleDetailsEntity saveRule(RuleDetailsEntity ruleDetailsEntity){
		return repo.save(ruleDetailsEntity);
	}

	/**
	 * Method to get all rules for the given apartmentID and UnitType  
	 * @param String apartmentId 
	 * @param String unitType
	 * @return RuleDetailsEntity ruleDetailsEntity
	 */
	public RuleDetailsEntity findByApptIdAndUnitType(String apartmentId, String unitType) {
		return repo.findByApptIdAndUnitType(apartmentId,unitType);
	}
	/**
	 * Method to get all rules Current in Database 
	 * @return List<ApartmentRuleDtls> List<ApartmentRuleDtls>
	 * @throws ParseException 
	 */
	public List<RuleDetailsEntity> findAllCurrentRule() {
		return repo.findAllCurrentRule();
	}
	/**
	 * Method to get all rules future in Database 
	 * @return List<ApartmentRuleDtls> List<ApartmentRuleDtls>
	 * @throws ParseException 
	 */
	public List<RuleDetailsEntity> findAllFutureRules() {
		return repo.findAllFutureRules();
	}

	/**
	 * Method to get all rules Current in for given ApptId 
	 * @return List<ApartmentRuleDtls> List<ApartmentRuleDtls>
	 * @throws ParseException 
	 */
	
	public List<RuleDetailsEntity> findAllCurrentRuleByApptId(String apartmentId) {
		return repo.findAllCurrentRuleByApptId(apartmentId);
	}
	
	/**
	 * Method to get all rules future in for given ApptId 
	 * @return List<ApartmentRuleDtls> List<ApartmentRuleDtls>
	 * @throws ParseException 
	 */
	public List<RuleDetailsEntity> findAllFutureRulesByApptId(String apartmentId) {
		return repo.findAllFutureRulesByApptId(apartmentId);
	}

}
