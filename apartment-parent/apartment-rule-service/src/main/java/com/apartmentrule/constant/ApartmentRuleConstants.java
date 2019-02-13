package com.apartmentrule.constant;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This class is having all constant for this Apartment rule service
 */
public class ApartmentRuleConstants {
	public static final String SUCCESS_CODE = "0";
	public static final String CREATE_RULE_ENDPOINT = "/create/rule";
	public static final String GET_RULES_ENDPOINT = "/get/rules";
	public static final String GET_RULES_BY_APARTMENTID_ENDPOINT = "/get/apartment/rules/{apartmentId}";
	public static final String GET_RULE_BY_RULEID_ENDPOINT = "/get/rule/{ruleId}";
	public static final String GET_RULE_BY_APPTID_AND_UNITTYPE_ENDPOINT = "/get/rule/{apartmentId}/{unitType}";
	public static final String DELETE_RULE_ENDPOINT ="/delete/rule/{ruleId}";
	public static final String GET_RULES_BY_UNIT_TYPE_ENDPOINT = "/get/rules/{unitType}";
	public static final String CREATE_SUCCESS = "Rule has been created Successfuly";
	public static final String GET_SUCCESS_BY_RULID = "Rule has been fetched Successfuly";
	public static final String GET_SUCCESS = "Rules have been fetched Successfuly";
	public static final String DELETE_SUCCESS_BY_RULID = "Rule has been Deleted Successfully";
	public static final String RULE_ID = "ruleId";
	public static final String APARTMENT_ID = "apartmentId";
	public static final String UNIT_TYPE = "unitType";
	
	public static final String APARTMENT_RULE_MASTER = "APARTMENT_RULE_MASTER";
	public static final String RULE_ID_MODEL = "RULE_ID";
	public static final String APARTMENT_ID_MODEL= "APARTMENT_ID";
	public static final String UNIT_TYPE_MODEL = "UNIT_TYPE";
	public static final String FIXED_CHARGE = "FIXED_CHARGE";
	public static final String PER_SQUAREFOOT_CHARGE = "PER_SQUAREFOOT_CHARGE";
	public static final String RENT_CHARGE = "RENT_CHARGE";
	public static final String EFFECTIVE_DATE = "EFFECTIVE_DATE";
	public static final String DELETED = "DELETED";
	public static final String VARCHAR10 = "varchar(10)";
	public static final String TIMESTAMP = "TIMESTAMP";
	public static final String VARCHAR5 ="varchar(5) default 'NO'";
	public static final String NO = "NO";
	public static final boolean FALSE = false;
	
	//Sql Query Costant
	public static final String SELECT_BY_APARTMENT_ID_SQL = "select  r from RuleDetailsEntity r WHERE r.apartmentId = :apartmentId and deleted='NO' and r.effectiveDate in (select Max(r.effectiveDate) from RuleDetailsEntity r group by r.unitType) group by r.unitType";
	public static final String SELECT_ALL_CURRENT_RULE_SQL = "select new RuleDetailsEntity(ruleId,apartmentId ,unitType,fixedCharge,perSquarefootCharge,rentCharge,max(effectiveDate) as effectiveDate, deleted)  from RuleDetailsEntity where deleted='NO' and effectiveDate<=CURDATE() group by  unitType ,apartmentId";
	public static final String SELECT_ALL_CURRENT_RULES_BY_APPTID_SQL = "select new RuleDetailsEntity(ruleId,apartmentId ,unitType,fixedCharge,perSquarefootCharge,rentCharge,max(effectiveDate) as effectiveDate, deleted)  from RuleDetailsEntity where deleted='NO' and effectiveDate<=CURDATE() and apartmentId = :apartmentId group by  unitType ,apartmentId";
	public static final String SELECT_ALL_FUTURE_RULES_BY_APPTID_SQL = "select r  from RuleDetailsEntity r where r.deleted='NO' and r.effectiveDate>CURDATE() and r.apartmentId = :apartmentId";
	public static final String SELECT_ALL_FURUTE_RULE_SQL = "select r from RuleDetailsEntity r where r.deleted='NO' and r.effectiveDate>CURDATE() ";
	public static final String DELETE_SQL = "UPDATE RuleDetailsEntity r SET r.deleted = 'YES' WHERE r.ruleId = :ruleId";
	public static final String SELECT_BY_RULE_ID_SQL = "SELECT r FROM RuleDetailsEntity r WHERE r.ruleId = :ruleId and deleted='NO'";
	public static final String SELECT_BY_APPTID_AND_UNITTYPE_SQL = "SELECT r FROM RuleDetailsEntity r WHERE r.apartmentId = :apartmentId and r.unitType = :unitType and deleted='NO' and r.effectiveDate in (select Max(r.effectiveDate) from RuleDetailsEntity r group by r.unitType)";
	public static final String SELECT_ALL_SQL = "SELECT r FROM RuleDetailsEntity r WHERE deleted='NO'";
	public static final String SELECT_BY_UNIT_TYPE_SQL = "SELECT r FROM RuleDetailsEntity r WHERE r.unitType = :unitType and deleted='NO'";
	public static final String CREATE_ERROR = "Rule Creation failed";
	public static final String ERROR_CODE = "1";
	public static final String GET_ERROR_BY_RULID = "No Rule found for the given Rule-id";
	public static final String GET_ERROR_BY_APARTMENT_ID = "No Rule found for the given APARTMENT_ID";
	public static final String GET_ERROR = "There is no rule available";
	public static final String GET_ERROR_UNIT_TYPE = "No Rule found for the given unit-type";
	public static final String DELETE_ERROR = "this rule is not available for Delete";
	
	public static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json"));
	public static final String BIGINT50 = "bigint(50) default 1 ";
	public static final String CREATE_ERROR_PRIMARY = "Create Rule failed,as combination of apartmentId,unitType and effectiveDate is already present.Please Try again";
	public static final String DATE = "date";
	public static final String GET_ALL_CURRENT_RULES_ENDPOINT = "/get/current/rules";
	public static final String GET_ALL_CURRENT_RULES_BY_APPTID_ENDPOINT = "/get/current/rules/apartment/{apartmentId}";
	public static final String GET_ALL_FUTURE_RULES_ENDPOINT = "/get/future/rules";
	public static final String GET_ALL_FUTURE_RULES_BY_APPTID_ENDPOINT = "/get/future/rules/apartment/{apartmentId}";
	
	
	

	
}


	