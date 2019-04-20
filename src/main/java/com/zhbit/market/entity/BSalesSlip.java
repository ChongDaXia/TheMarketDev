package com.zhbit.market.entity;
import java.io.Serializable;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/*
* 
* gen by beetlsql 2019-03-23
*/
public class BSalesSlip   implements Serializable{
	//销售单id
	private Integer salesSlipId ;
	//会员id
	private Integer memberId ;
	//销售员id
	private Integer staffId ;
	//销售总额
	private BigDecimal totalPrice ;
	//销售时间
	private Date createTime ;
	
	public BSalesSlip() {
	}
	
	public Integer getSalesSlipId(){
		return  salesSlipId;
	}
	public void setSalesSlipId(Integer salesSlipId ){
		this.salesSlipId = salesSlipId;
	}
	
	public Integer getMemberId(){
		return  memberId;
	}
	public void setMemberId(Integer memberId ){
		this.memberId = memberId;
	}
	
	public Integer getStaffId(){
		return  staffId;
	}
	public void setStaffId(Integer staffId ){
		this.staffId = staffId;
	}
	
	public BigDecimal getTotalPrice(){
		return  totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice ){
		this.totalPrice = totalPrice;
	}
	
	public Date getCreateTime(){
		return  createTime;
	}
	public void setCreateTime(Date createTime ){
		this.createTime = createTime;
	}
	
	
	

}
