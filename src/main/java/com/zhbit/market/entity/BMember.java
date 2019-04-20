package com.zhbit.market.entity;
import java.io.Serializable;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/*
* 
* gen by beetlsql 2019-04-14
*/
public class BMember   implements Serializable{
	//会员id
	private Integer memberId ;
	//积分
	private Integer integration ;
	private Integer storeId ;
	//联系电话
	private String mobileNo ;
	//姓名
	private String name ;
	//性别
	private String sex ;
	
	public BMember() {
	}
	
	public Integer getMemberId(){
		return  memberId;
	}
	public void setMemberId(Integer memberId ){
		this.memberId = memberId;
	}
	
	public Integer getIntegration(){
		return  integration;
	}
	public void setIntegration(Integer integration ){
		this.integration = integration;
	}
	
	public Integer getStoreId(){
		return  storeId;
	}
	public void setStoreId(Integer storeId ){
		this.storeId = storeId;
	}
	
	public String getMobileNo(){
		return  mobileNo;
	}
	public void setMobileNo(String mobileNo ){
		this.mobileNo = mobileNo;
	}
	
	public String getName(){
		return  name;
	}
	public void setName(String name ){
		this.name = name;
	}
	
	public String getSex(){
		return  sex;
	}
	public void setSex(String sex ){
		this.sex = sex;
	}
	
	
	

}
