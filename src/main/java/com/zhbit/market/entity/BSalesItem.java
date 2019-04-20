package com.zhbit.market.entity;
import java.io.Serializable;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/*
* 
* gen by beetlsql 2019-03-23
*/
public class BSalesItem   implements Serializable{
	//销售项id
	private Integer salesItemId ;
	//销售数量
	private Integer amount ;
	//商品id
	private Integer goodsId ;
	//销售单id
	private Integer salesSlipId ;
	//销售单价
	private BigDecimal price ;
	
	public BSalesItem() {
	}
	
	public Integer getSalesItemId(){
		return  salesItemId;
	}
	public void setSalesItemId(Integer salesItemId ){
		this.salesItemId = salesItemId;
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
	
	public Integer getSalesSlipId(){
		return  salesSlipId;
	}
	public void setSalesSlipId(Integer salesSlipId ){
		this.salesSlipId = salesSlipId;
	}
	
	public BigDecimal getPrice(){
		return  price;
	}
	public void setPrice(BigDecimal price ){
		this.price = price;
	}
	
	
	

}
