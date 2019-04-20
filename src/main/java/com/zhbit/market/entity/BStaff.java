package com.zhbit.market.entity;
import java.io.Serializable;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/*
* 
* gen by beetlsql 2019-03-29
*/
public class BStaff   implements Serializable{
	//员工id
	private Integer staffId ;
	//身份证号码
	private String idcardNo ;
	//联系电话
	private String mobileNo ;
	//姓名
	private String name ;
	//性别
	private String sex ;
	
	public BStaff() {
	}
	
	public Integer getStaffId(){
		return  staffId;
	}
	public void setStaffId(Integer staffId ){
		this.staffId = staffId;
	}
	
	public String getIdcardNo(){
		return  idcardNo;
	}
	public void setIdcardNo(String idcardNo ){
		this.idcardNo = idcardNo;
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
