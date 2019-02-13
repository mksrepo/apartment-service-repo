package com.apartmentrule.model;

import java.io.Serializable;
import java.util.Date;

/**
 * This class  enables composite primary key
 */
@SuppressWarnings("serial")
public class RuleID implements Serializable{
	String apartmentId;
	String unitType;
	Date effectiveDate;
	

}
