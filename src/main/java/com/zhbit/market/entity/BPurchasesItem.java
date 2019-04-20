package com.zhbit.market.entity;
import java.io.Serializable;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/*
* 
* gen by beetlsql 2019-03-23
*/
public class BPurchasesItem   implements Serializable{
	//采购项id
	private Integer purchasesItemId ;
	//采购数量
	private Integer amount ;
	//商品id
	private Integer goodsId ;
	//采购单id
	private Integer purchaseId ;
	//采购单价
	private BigDecimal price ;
	
	public BPurchasesItem() {
	}
	
	public Integer getPurchasesItemId(){
		return  purchasesItemId;
	}
	public void setPurchasesItemId(Integer purchasesItemId ){
		this.purchasesItemId = purchasesItemId;
	}
	
	public Integer getAmount(){
		return  amount;
	}
	public void setAmount(Integer amount ){
		this.amount = amount;
	}
	
	public Integer getGoodsId(){
		return  goodsId;
	}
	public void setGoodsId(Integer goodsId ){
		this.goodsId = goodsId;
	}
	
	public Integer getPurchaseId(){
		return  purchaseId;
	}
	public void setPurchaseId(Integer purchaseId ){
		this.purchaseId = purchaseId;
	}
	
	public BigDecimal getPrice(){
		return  price;
	}
	public void setPrice(BigDecimal price ){
		this.price = price;
	}
	
	
	

}
