package com.zhbit.market.entity;
import java.io.Serializable;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/*
* 
* gen by beetlsql 2019-04-10
*/
public class BJobOrder   implements Serializable{
	//通知单id
	private Integer jobOrderId ;
	//通知id
	private Integer informId ;
	//发送者id
	private Integer sentUserId ;
	//接收者id
	private Integer userId ;
	//创建时间
	private Date createTime ;
	
	public BJobOrder() {
	}
	
	public Integer getJobOrderId(){
		return  jobOrderId;
	}
	public void setJobOrderId(Integer jobOrderId ){
		this.jobOrderId = jobOrderId;
	}
	
	public Integer getInformId(){
		return  informId;
	}
	public void setInformId(Integer informId ){
		this.informId = informId;
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
