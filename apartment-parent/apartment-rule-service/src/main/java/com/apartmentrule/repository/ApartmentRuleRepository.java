package com.apartmentrule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apartmentrule.constant.ApartmentRuleConstants;
import com.apartmentrule.model.RuleDetailsEntity;

/**
 * This repository interface responsible for all Transaction to database
 * @author 748152
 *
 */
@Repository
public interface ApartmentRuleRepository extends JpaRepository<RuleDetailsEntity, Long>{

	@Query(ApartmentRuleConstants.SELECT_BY_APARTMENT_ID_SQL)
	public List<RuleDetailsEntity> findRuleDetails(@Param("apartmentId") String apartmentId);


	@Modifying
	@Query(ApartmentRuleConstants.DELETE_SQL)
	public int updateDeleteFlag(@Param("ruleId") long ruleId);

	
	@Query(ApartmentRuleConstants.SELECT_BY_RULE_ID_SQL)
	public RuleDetailsEntity findById(@Param("ruleId") long ruleId);

	@Override
	@Query(ApartmentRuleConstants.SELECT_ALL_SQL)
	public List<RuleDetailsEntity> findAll();

	@Query(ApartmentRuleConstants.SELECT_BY_UNIT_TYPE_SQL)
	public List<RuleDetailsEntity> getAllRulesByUnitType(@Param("unitType") String unitType);

	@Query(ApartmentRuleConstants.SELECT_BY_APPTID_AND_UNITTYPE_SQL)
	public RuleDetailsEntity findByApptIdAndUnitType(@Param("apartmentId") String apartmentId, @Param("unitType") String unitType);

	@Query(ApartmentRuleConstants.SELECT_ALL_CURRENT_RULE_SQL)
	public List<RuleDetailsEntity> findAllCurrentRule();

	@Query(ApartmentRuleConstants.SELECT_ALL_FURUTE_RULE_SQL)
	public List<RuleDetailsEntity> findAllFutureRules();

	@Query(ApartmentRuleConstants.SELECT_ALL_CURRENT_RULES_BY_APPTID_SQL)
	public List<RuleDetailsEntity> findAllCurrentRuleByApptId(@Param("apartmentId") String apartmentId);

	@Query(ApartmentRuleConstants.SELECT_ALL_FUTURE_RULES_BY_APPTID_SQL)
	public List<RuleDetailsEntity> findAllFutureRulesByApptId(@Param("apartmentId") String apartmentId);




}
