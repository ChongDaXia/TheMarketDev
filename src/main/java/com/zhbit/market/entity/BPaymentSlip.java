package com.zhbit.market.entity;
import java.io.Serializable;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/*
* 
* gen by beetlsql 2019-03-23
*/
public class BPaymentSlip   implements Serializable{
	//缴费单id
	private Integer paymentSlipId ;
	//费用id
	private Integer paymentId ;
	//缴费状态
	private Integer paymentSlipStatus ;
	//缴费用户id
	private Integer userId ;
	//创建时间
	private Date createTime ;
	//更新时间
	private Date updateTime ;
	
	public BPaymentSlip() {
	}
	
	public Integer getPaymentSlipId(){
		return  paymentSlipId;
	}
	public void setPaymentSlipId(Integer paymentSlipId ){
		this.paymentSlipId = paymentSlipId;
	}
	
	public Integer getPaymentId(){
		return  paymentId;
	}
	public void setPaymentId(Integer paymentId ){
		this.paymentId = paymentId;
	}
	
	public Integer getPaymentSlipStatus(){
		return  paymentSlipStatus;
	}
	public void setPaymentSlipStatus(Integer paymentSlipStatus ){
		this.paymentSlipStatus = paymentSlipStatus;
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
	
	public Date getUpdateTime(){
		return  updateTime;
	}
	public void setUpdateTime(Date updateTime ){
		this.updateTime = updateTime;
	}
	
	
	

}
