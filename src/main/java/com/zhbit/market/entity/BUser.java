package com.zhbit.market.entity;
import java.io.Serializable;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/*
* 
* gen by beetlsql 2019-03-26
*/
public class BUser   implements Serializable{
	//用户id
	private Integer userId ;
	//身份证号码
	private String idcardNo ;
	//联系电话
	private String mobileNo ;
	//姓名
	private String name ;
	//密码
	private String password ;
	//角色
	private String role ;
	//用户名
	private String userName ;
	
	public BUser() {
	}
	
	public Integer getUserId(){
		return  userId;
	}
	public void setUserId(Integer userId ){
		this.userId = userId;
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
	
	public String getPassword(){
		return  password;
	}
	public void setPassword(String password ){
		this.password = password;
	}
	
	public String getRole(){
		return  role;
	}
	public void setRole(String role ){
		this.role = role;
	}
	
	public String getUserName(){
		return  userName;
	}
	public void setUserName(String userName ){
		this.userName = userName;
	}
	
	
	

}
