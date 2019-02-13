package com.apartmentrule.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apartmentrule.bean.ApartmentRuleDtls;
import com.apartmentrule.bean.ApartmentRuleResponseBean;
import com.apartmentrule.constant.ApartmentRuleConstants;
import com.apartmentrule.exception.ApartmentRuleCustomException;
import com.apartmentrule.services.ApartmentRuleManager;


/**
 * ApartmentRuleController is responsible for all end-point related to rule management 
 */
@RestController
@RequestMapping("apptruleservice")
public class ApartmentRuleController {
	
	private static final Logger logger = LoggerFactory.getLogger(ApartmentRuleController.class);

	@Autowired
	private ApartmentRuleManager apartmentRuleManager;
	
	
	/**
	 * End-point to create new Rule
	 * @param ApartmentRuleDtls ruleDetails
	 * @return ApartmentRuleResponseBean
	 */
	
	@PostMapping(ApartmentRuleConstants.CREATE_RULE_ENDPOINT)
	ResponseEntity<ApartmentRuleResponseBean> createRule(@Valid @RequestBody ApartmentRuleDtls ruleDetails){
		ApartmentRuleResponseBean responseBean = new ApartmentRuleResponseBean();
		List<ApartmentRuleDtls> ruleList= new ArrayList<>();

		ruleDetails=apartmentRuleManager.createRule(ruleDetails);
		if(ruleDetails!=null){
		ruleList.add(ruleDetails);
		responseBean.setMessage(ApartmentRuleConstants.CREATE_SUCCESS);
		responseBean.setStatus_code(ApartmentRuleConstants.SUCCESS_CODE);
		responseBean.setRuleList(ruleList);
		logger.info(ApartmentRuleConstants.CREATE_SUCCESS);
		}else{
			logger.error(ApartmentRuleConstants.CREATE_ERROR);
			throw new ApartmentRuleCustomException(ApartmentRuleConstants.CREATE_ERROR);
		}
		return new ResponseEntity<ApartmentRuleResponseBean>(responseBean, HttpStatus.OK);

	}

	/**
	 * End-point to get rule by given rule-id
	 * @param long ruleId
	 * @return ResponseEntity  ApartmentRuleResponseBean
	 * @throws ApartmentRuleCustomException 
	 */
	@GetMapping(ApartmentRuleConstants.GET_RULE_BY_RULEID_ENDPOINT)
	ResponseEntity<ApartmentRuleResponseBean>  getRuleByRuleId(@PathVariable(ApartmentRuleConstants.RULE_ID) long ruleId) throws ApartmentRuleCustomException{
		ApartmentRuleResponseBean responseBean = new ApartmentRuleResponseBean();
		ApartmentRuleDtls RuleDetailsRes  = new ApartmentRuleDtls();
		List<ApartmentRuleDtls> ruleList= new ArrayList<>();

		RuleDetailsRes=apartmentRuleManager.getRulesById(ruleId);
		if(RuleDetailsRes!=null){
			ruleList.add(RuleDetailsRes);
			responseBean.setMessage(ApartmentRuleConstants.GET_SUCCESS_BY_RULID);
			responseBean.setStatus_code(ApartmentRuleConstants.SUCCESS_CODE);
			responseBean.setRuleList(ruleList);
			logger.info(ApartmentRuleConstants.GET_SUCCESS_BY_RULID);
		}else{
			logger.error(ApartmentRuleConstants.GET_ERROR_BY_RULID);
			throw new ApartmentRuleCustomException(ApartmentRuleConstants.GET_ERROR_BY_RULID);
		}
			
		return new ResponseEntity<ApartmentRuleResponseBean>(responseBean, HttpStatus.OK);

	}

	/**
	 * End-point to get rules by given apartmentId
	 * @param String  apartmentId
	 * @return ResponseEntity ApartmentRuleResponseBean
	 */
	@GetMapping(ApartmentRuleConstants.GET_RULES_BY_APARTMENTID_ENDPOINT)
	ResponseEntity<ApartmentRuleResponseBean> getRulesByApptId(@PathVariable(ApartmentRuleConstants.APARTMENT_ID) String apartmentId){

		ApartmentRuleResponseBean responseBean = new ApartmentRuleResponseBean();
		List<ApartmentRuleDtls> ruleDetailsRes =apartmentRuleManager.getRulesByApptId(apartmentId);
		if(!ruleDetailsRes.isEmpty()){
			responseBean.setMessage(ApartmentRuleConstants.GET_SUCCESS);
			responseBean.setStatus_code(ApartmentRuleConstants.SUCCESS_CODE);
			responseBean.setRuleList(ruleDetailsRes);
			logger.info(ApartmentRuleConstants.GET_SUCCESS);
		}else{
			logger.error(ApartmentRuleConstants.GET_ERROR_BY_APARTMENT_ID);
			throw new ApartmentRuleCustomException(ApartmentRuleConstants.GET_ERROR_BY_APARTMENT_ID);
		}
		return new ResponseEntity<ApartmentRuleResponseBean>(responseBean, HttpStatus.OK);


	}
	
	/**
	 * End-point to get rules by given apartmentId
	 * @param String  apartmentId
	 * @return ResponseEntity ApartmentRuleResponseBean
	 * @throws ParseException 
	 */
	@GetMapping(ApartmentRuleConstants.GET_RULES_ENDPOINT)
	ResponseEntity<ApartmentRuleResponseBean>  getAllRules() throws ParseException{
		ApartmentRuleResponseBean responseBean = new ApartmentRuleResponseBean();
		List<ApartmentRuleDtls> ruleDetailsList =apartmentRuleManager.getAllRules();
		if(!ruleDetailsList.isEmpty()){
			responseBean.setMessage(ApartmentRuleConstants.GET_SUCCESS);
			responseBean.setStatus_code(ApartmentRuleConstants.SUCCESS_CODE);
			responseBean.setRuleList(ruleDetailsList);
			logger.info(ApartmentRuleConstants.GET_SUCCESS);
		}else{
			logger.error(ApartmentRuleConstants.GET_ERROR);
			throw new ApartmentRuleCustomException(ApartmentRuleConstants.GET_ERROR);
		}
		return new ResponseEntity<ApartmentRuleResponseBean>(responseBean, HttpStatus.OK);


	}

	/**
	 * End-point to get rules by given unit-type
	 * @param String  apartmentId
	 * @return ResponseEntity ApartmentRuleResponseBean
	 */
	@GetMapping(ApartmentRuleConstants.GET_RULES_BY_UNIT_TYPE_ENDPOINT)
	ResponseEntity<ApartmentRuleResponseBean> getRulesByUnitType(@PathVariable(ApartmentRuleConstants.UNIT_TYPE) String unitType){
		ApartmentRuleResponseBean responseBean = new ApartmentRuleResponseBean();
		List<ApartmentRuleDtls> ruleDetailsList =apartmentRuleManager.getRulesByUnitType(unitType);
		if(!ruleDetailsList.isEmpty()){
			responseBean.setMessage(ApartmentRuleConstants.GET_SUCCESS);
			responseBean.setStatus_code(ApartmentRuleConstants.SUCCESS_CODE);
			responseBean.setRuleList(ruleDetailsList);
			logger.info(ApartmentRuleConstants.GET_SUCCESS);
			
		}else{
			logger.error(ApartmentRuleConstants.GET_ERROR_UNIT_TYPE);
			throw new ApartmentRuleCustomException(ApartmentRuleConstants.GET_ERROR_UNIT_TYPE);
		}
		return new ResponseEntity<ApartmentRuleResponseBean>(responseBean, HttpStatus.OK);
		
	}
	/**
	 * End-point to delete rule by rule-id
	 * @param  long ruleId
	 * @return ResponseEntity  ApartmentRuleResponseBean
	 * @throws ApartmentRuleCustomException 
	 */
	@PutMapping(ApartmentRuleConstants.DELETE_RULE_ENDPOINT)
	ResponseEntity<ApartmentRuleResponseBean> updateDeleteFlag(@PathVariable(ApartmentRuleConstants.RULE_ID) long ruleId) throws ApartmentRuleCustomException{
		ApartmentRuleResponseBean responseBean = new ApartmentRuleResponseBean();
		if(apartmentRuleManager.updateDeleteFlag(ruleId)>0){
			responseBean.setMessage(ApartmentRuleConstants.DELETE_SUCCESS_BY_RULID);
			responseBean.setStatus_code(ApartmentRuleConstants.SUCCESS_CODE);
			logger.info(ApartmentRuleConstants.DELETE_SUCCESS_BY_RULID);
		}
		else{
			logger.error(ApartmentRuleConstants.DELETE_ERROR);
			throw new ApartmentRuleCustomException(ApartmentRuleConstants.DELETE_ERROR);
		}
		return new ResponseEntity<ApartmentRuleResponseBean>(responseBean,HttpStatus.OK);

	}
	
	/**
	 * End-point to get rule by given apartment_id and unit_type
	 * @param long ruleId
	 * @return ResponseEntity  ApartmentRuleResponseBean
	 * @throws ApartmentRuleCustomException 
	 */
	@GetMapping(ApartmentRuleConstants.GET_RULE_BY_APPTID_AND_UNITTYPE_ENDPOINT)
	ResponseEntity<ApartmentRuleResponseBean>  getRuleByApptIdAndUnitType(@PathVariable(ApartmentRuleConstants.APARTMENT_ID) String apartmentId,@PathVariable(ApartmentRuleConstants.UNIT_TYPE) String unitType) throws ApartmentRuleCustomException{
		ApartmentRuleResponseBean responseBean = new ApartmentRuleResponseBean();
		ApartmentRuleDtls RuleDetailsRes  = new ApartmentRuleDtls();
		List<ApartmentRuleDtls> ruleList= new ArrayList<>();

		RuleDetailsRes=apartmentRuleManager.getRuleByApptIdAndUnitType(apartmentId,unitType);
		if(RuleDetailsRes!=null){
			ruleList.add(RuleDetailsRes);
			responseBean.setMessage(ApartmentRuleConstants.GET_SUCCESS_BY_RULID);
			responseBean.setStatus_code(ApartmentRuleConstants.SUCCESS_CODE);
			responseBean.setRuleList(ruleList);
			logger.info(ApartmentRuleConstants.GET_SUCCESS_BY_RULID);
		}else{
			logger.error(ApartmentRuleConstants.GET_ERROR_BY_RULID);
			throw new ApartmentRuleCustomException(ApartmentRuleConstants.GET_ERROR_BY_RULID);
		}
			
		return new ResponseEntity<ApartmentRuleResponseBean>(responseBean, HttpStatus.OK);

	}
	
	/**
	 * End-point to get all current rules
	 * @param String  apartmentId
	 * @return ResponseEntity ApartmentRuleResponseBean
	 * @throws ParseException 
	 */
	@GetMapping(ApartmentRuleConstants.GET_ALL_CURRENT_RULES_ENDPOINT)
	ResponseEntity<ApartmentRuleResponseBean>  getAllCurrentRules() throws ParseException{
		ApartmentRuleResponseBean responseBean = new ApartmentRuleResponseBean();
		List<ApartmentRuleDtls> ruleDetailsList =apartmentRuleManager.getAllCurrentRules();
		if(!ruleDetailsList.isEmpty()){
			responseBean.setMessage(ApartmentRuleConstants.GET_SUCCESS);
			responseBean.setStatus_code(ApartmentRuleConstants.SUCCESS_CODE);
			responseBean.setRuleList(ruleDetailsList);
			logger.info(ApartmentRuleConstants.GET_SUCCESS);
		}else{
			logger.error(ApartmentRuleConstants.GET_ERROR);
			throw new ApartmentRuleCustomException(ApartmentRuleConstants.GET_ERROR);
		}
		return new ResponseEntity<ApartmentRuleResponseBean>(responseBean, HttpStatus.OK);
	}
	
	/**
	 * End-point to get all current rules for given ApartmentId
	 * @param String  apartmentId
	 * @return ResponseEntity ApartmentRuleResponseBean
	 * @throws ParseException 
	 */
	@GetMapping(ApartmentRuleConstants.GET_ALL_CURRENT_RULES_BY_APPTID_ENDPOINT)
	ResponseEntity<ApartmentRuleResponseBean>  getAllCurrentRulesByApptId(@PathVariable(ApartmentRuleConstants.APARTMENT_ID) String apartmentId) throws ParseException{
		ApartmentRuleResponseBean responseBean = new ApartmentRuleResponseBean();
		List<ApartmentRuleDtls> ruleDetailsList =apartmentRuleManager.getAllCurrentRulesByApptId(apartmentId);
		if(!ruleDetailsList.isEmpty()){
			responseBean.setMessage(ApartmentRuleConstants.GET_SUCCESS);
			responseBean.setStatus_code(ApartmentRuleConstants.SUCCESS_CODE);
			responseBean.setRuleList(ruleDetailsList);
			logger.info(ApartmentRuleConstants.GET_SUCCESS);
		}else{
			logger.error(ApartmentRuleConstants.GET_ERROR);
			throw new ApartmentRuleCustomException(ApartmentRuleConstants.GET_ERROR);
		}
		return new ResponseEntity<ApartmentRuleResponseBean>(responseBean, HttpStatus.OK);
	}
	
	/**
	 * End-point to get all current rules
	 * @param String  apartmentId
	 * @return ResponseEntity ApartmentRuleResponseBean
	 * @throws ParseException 
	 */
	@GetMapping(ApartmentRuleConstants.GET_ALL_FUTURE_RULES_ENDPOINT)
	ResponseEntity<ApartmentRuleResponseBean>  getAllFutureRules() throws ParseException{
		ApartmentRuleResponseBean responseBean = new ApartmentRuleResponseBean();
		List<ApartmentRuleDtls> ruleDetailsList =apartmentRuleManager.getAllFutureRules();
		if(!ruleDetailsList.isEmpty()){
			responseBean.setMessage(ApartmentRuleConstants.GET_SUCCESS);
			responseBean.setStatus_code(ApartmentRuleConstants.SUCCESS_CODE);
			responseBean.setRuleList(ruleDetailsList);
			logger.info(ApartmentRuleConstants.GET_SUCCESS);
		}else{
			logger.error(ApartmentRuleConstants.GET_ERROR);
			throw new ApartmentRuleCustomException(ApartmentRuleConstants.GET_ERROR);
		}
		return new ResponseEntity<ApartmentRuleResponseBean>(responseBean, HttpStatus.OK);
	}
	
	/**
	 * End-point to get all current rules for given ApartmentId
	 * @param String  apartmentId
	 * @return ResponseEntity ApartmentRuleResponseBean
	 * @throws ParseException 
	 */
	@GetMapping(ApartmentRuleConstants.GET_ALL_FUTURE_RULES_BY_APPTID_ENDPOINT)
	ResponseEntity<ApartmentRuleResponseBean>  getAllFutureRulesByApptId(@PathVariable(ApartmentRuleConstants.APARTMENT_ID) String apartmentId) throws ParseException{
		ApartmentRuleResponseBean responseBean = new ApartmentRuleResponseBean();
		List<ApartmentRuleDtls> ruleDetailsList =apartmentRuleManager.getAllFutureRulesByApptId(apartmentId);
		if(!ruleDetailsList.isEmpty()){
			responseBean.setMessage(ApartmentRuleConstants.GET_SUCCESS);
			responseBean.setStatus_code(ApartmentRuleConstants.SUCCESS_CODE);
			responseBean.setRuleList(ruleDetailsList);
			logger.info(ApartmentRuleConstants.GET_SUCCESS);
		}else{
			logger.error(ApartmentRuleConstants.GET_ERROR);
			throw new ApartmentRuleCustomException(ApartmentRuleConstants.GET_ERROR);
		}
		return new ResponseEntity<ApartmentRuleResponseBean>(responseBean, HttpStatus.OK);
	}
	
}


