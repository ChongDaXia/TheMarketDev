package com.zhbit.market.entity;
import java.io.Serializable;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/*
* 
* gen by beetlsql 2019-03-26
*/
public class BSupplier   implements Serializable{
	//供应商id
	private Integer supplierId ;
	//地址
	private String address ;
	//联系人
	private String contacts ;
	//联系电话
	private String mobileNo ;
	//名称
	private String name ;
	
	public BSupplier() {
	}
	
	public Integer getSupplierId(){
		return  supplierId;
	}
	public void setSupplierId(Integer supplierId ){
		this.supplierId = supplierId;
	}
	
	public String getAddress(){
		return  address;
	}
	public void setAddress(String address ){
		this.address = address;
	}
	
	public String getContacts(){
		return  contacts;
	}
	public void setContacts(String contacts ){
		this.contacts = contacts;
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
	
	
	

}
