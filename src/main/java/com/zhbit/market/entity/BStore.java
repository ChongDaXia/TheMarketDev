package com.zhbit.market.entity;
import java.io.Serializable;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/*
* 
* gen by beetlsql 2019-03-29
*/
public class BStore   implements Serializable{
	//店铺id
	private Integer storeId ;
	//租赁状态
	private Integer rentStatus ;
	//地址
	private String address ;
	//面积
	private BigDecimal area ;
	//编号
	private String storeNo ;
	
	public BStore() {
	}
	
	public Integer getStoreId(){
		return  storeId;
	}
	public void setStoreId(Integer storeId ){
		this.storeId = storeId;
	}
	
	public Integer getRentStatus(){
		return  rentStatus;
	}
	public void setRentStatus(Integer rentStatus ){
		this.rentStatus = rentStatus;
	}
	
	public String getAddress(){
		return  address;
	}
	public void setAddress(String address ){
		this.address = address;
	}
	
	public BigDecimal getArea(){
		return  area;
	}
	public void setArea(BigDecimal area ){
		this.area = area;
	}
	
	public String getStoreNo(){
		return  storeNo;
	}
	public void setStoreNo(String storeNo ){
		this.storeNo = storeNo;
	}
	
	
	

}
