package com.apartmentrule.services;

import java.text.ParseException;
import java.util.List;

import com.apartmentrule.bean.ApartmentRuleDtls;
import com.apartmentrule.exception.ApartmentRuleCustomException;

/**
 * This is an abstraction interface for Service implementation class 
 * @author 748152
 *
 */
public interface ApartmentRuleManager {

	/**
	 * Method to create new apartment rule 
	 * @param ApartmentRuleDtls ruleDetails
	 * @return ApartmentRuleDtls apartmentRuleDtls
	 */
	ApartmentRuleDtls createRule(ApartmentRuleDtls ruleDetails);

	/**
	 * Method to get  apartment rule for given rule-id
	 * @param long ruleId
	 * @return ApartmentRuleDtls ApartmentRuleDtls
	 */
	ApartmentRuleDtls getRulesById(long ruleId);

	/**
	 * Method to get all rules for the given apartment-id
	 * @param String apptId
	 * @return List<ApartmentRuleDtls> List<ApartmentRuleDtls>
	 */
	List<ApartmentRuleDtls> getRulesByApptId(String apptId);

	/**
	 * Method to soft delete rule for given rule-id
	 * @param long ruleId
	 * @throws ApartmentRuleCustomException 
	 */
	int updateDeleteFlag(long ruleId) throws ApartmentRuleCustomException;

	/**
	 * Method to get all rules present in Database 
	 * @return List<ApartmentRuleDtls> List<ApartmentRuleDtls>
	 * @throws ParseException 
	 */
	List<ApartmentRuleDtls> getAllRules() throws ParseException;
	
	/**
	 * Method to get all rules for the given UnitType 
	 * @return List<ApartmentRuleDtls> List<ApartmentRuleDtls>
	 */

	List<ApartmentRuleDtls> getRulesByUnitType(String unitType);
	
	/**
	 * Method to get all rules for the given apartmentID and UnitType  
	 * @param String apartmentId 
	 * @param String unitType
	 * @return ApartmentRuleDtls apartmentRuleDtls
	 */
	ApartmentRuleDtls getRuleByApptIdAndUnitType(String apartmentId, String unitType);
	
	/**
	 * Method to get all current rules 
	 * @return List<ApartmentRuleDtls> List<ApartmentRuleDtls>
	 * @throws ParseException 
	 */

	List<ApartmentRuleDtls> getAllCurrentRules();
	

	/**
	 * Method to get all future rules 
	 * @return List<ApartmentRuleDtls> List<ApartmentRuleDtls>
	 * @throws ParseException 
	 */

	List<ApartmentRuleDtls> getAllFutureRules();
	
	/**
	 * Method to get all current rules for given Apartment Id
	 * @param apartmentId 
	 * @return List<ApartmentRuleDtls> List<ApartmentRuleDtls>
	 * @throws ParseException 
	 */
	List<ApartmentRuleDtls> getAllCurrentRulesByApptId(String apartmentId);
	
	/**
	 * Method to get all future rules for given Apartment Id
	 * @param apartmentId 
	 * @return List<ApartmentRuleDtls> List<ApartmentRuleDtls>
	 * @throws ParseException 
	 */

	List<ApartmentRuleDtls> getAllFutureRulesByApptId(String apartmentId);

}
