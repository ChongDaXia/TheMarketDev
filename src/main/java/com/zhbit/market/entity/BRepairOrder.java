package com.zhbit.market.entity;
import java.io.Serializable;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/*
* 
* gen by beetlsql 2019-04-10
*/
public class BRepairOrder   implements Serializable{
	//维修单id
	private Integer repairOrderId ;
	//维修id
	private Integer repairId ;
	//发送者id
	private Integer sentUserId ;
	//接收者id
	private Integer userId ;
	//创建时间
	private Date createTime ;
	
	public BRepairOrder() {
	}
	
	public Integer getRepairOrderId(){
		return  repairOrderId;
	}
	public void setRepairOrderId(Integer repairOrderId ){
		this.repairOrderId = repairOrderId;
	}
	
	public Integer getRepairId(){
		return  repairId;
	}
	public void setRepairId(Integer repairId ){
		this.repairId = repairId;
	}
	
	public Integer getSentUserId(){
		return  sentUserId;
	}
	public void setSentUserId(Integer sentUserId ){
		this.sentUserId = sentUserId;
	}
	
	public Integer getUserId(){
		return  userId;
	}
	public void setUserId(Integer userId ){
		this.userId = userId;
	}
	
	public Date getCreateTime(){
		return  createTime;
	}
	public void setCreateTime(Date createTime ){
		this.createTime = createTime;
	}
	
	
	

}
