package com.zhbit.market.entity;
import java.io.Serializable;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/*
* 
* gen by beetlsql 2019-04-14
*/
public class BRent   implements Serializable{
	//租赁表id
	private Integer rentId ;
	//店铺id
	private Integer storeId ;
	//用户id
	private Integer userId ;
	//租金
	private BigDecimal rent ;
	//创建时间
	private Date createTime ;
	
	public BRent() {
	}
	
	public Integer getRentId(){
		return  rentId;
	}
	public void setRentId(Integer rentId ){
		this.rentId = rentId;
	}
	
	public Integer getStoreId(){
		return  storeId;
	}
	public void setStoreId(Integer storeId ){
		this.storeId = storeId;
	}
	
	public Integer getUserId(){
		return  userId;
	}
	public void setUserId(Integer userId ){
		this.userId = userId;
	}
	
	public BigDecimal getRent(){
		return  rent;
	}
	public void setRent(BigDecimal rent ){
		this.rent = rent;
	}
	
	public Date getCreateTime(){
		return  createTime;
	}
	public void setCreateTime(Date createTime ){
		this.createTime = createTime;
	}
	
	
	

}
