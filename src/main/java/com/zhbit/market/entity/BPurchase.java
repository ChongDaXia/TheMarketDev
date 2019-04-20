package com.zhbit.market.entity;
import java.io.Serializable;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/*
* 
* gen by beetlsql 2019-04-15
*/
public class BPurchase   implements Serializable{
	//采购单id
	private Integer purchaseId ;
	//采购员id
	private Integer staffId ;
	//供应商id
	private Integer supplierId ;
	//采购总额
	private BigDecimal totalPrice ;
	//采购时间
	private Date createTime ;
	
	public BPurchase() {
	}
	
	public Integer getPurchaseId(){
		return  purchaseId;
	}
	public void setPurchaseId(Integer purchaseId ){
		this.purchaseId = purchaseId;
	}
	
	public Integer getStaffId(){
		return  staffId;
	}
	public void setStaffId(Integer staffId ){
		this.staffId = staffId;
	}
	
	public Integer getSupplierId(){
		return  supplierId;
	}
	public void setSupplierId(Integer supplierId ){
		this.supplierId = supplierId;
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
