package com.zhbit.market.entity;
import java.io.Serializable;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/*
* 
* gen by beetlsql 2019-03-23
*/
public class BDiscount   implements Serializable{
	//折扣id
	private Integer discountId ;
	//等级
	private Integer grade ;
	//折扣
	private BigDecimal discount ;
	
	public BDiscount() {
	}
	
	public Integer getDiscountId(){
		return  discountId;
	}
	public void setDiscountId(Integer discountId ){
		this.discountId = discountId;
	}
	
	public Integer getGrade(){
		return  grade;
	}
	public void setGrade(Integer grade ){
		this.grade = grade;
	}
	
	public BigDecimal getDiscount(){
		return  discount;
	}
	public void setDiscount(BigDecimal discount ){
		this.discount = discount;
	}
	
	
	

}
